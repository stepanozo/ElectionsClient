/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service.Http;

import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.CandidateAlreadyExistsException;
import ElectionsClient.NewExceptions.InvalidCandidateVoteException;
import ElectionsClient.NewExceptions.InvalidDeleteException;
import ElectionsClient.NewExceptions.NoSuchCandidateIdException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.NewExceptions.UserAlreadyExistsException;
import ElectionsClient.Service.CandidateClientService;
import ElectionsClient.model.Candidate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import electionsClient.Exceptions.HTTPException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import org.springframework.http.HttpStatus;

/**
 *
 * @author чтепоноза
 */
public class CandidateHttpService implements CandidateClientService{
    
    public void newCandidate(Candidate candidate) throws BadResponseException, RequestException, CandidateAlreadyExistsException{
        
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/candidates";
        // Создаем JSON тело запроса
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        String json = gson.toJson(candidate);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                header("Content-Type", "application/json").
                POST(HttpRequest.BodyPublishers.ofString(json)).
                build();
        
                try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            switch(HttpStatus.resolve(response.statusCode())){
                        case HttpStatus.CREATED:
                            return;
                        case HttpStatus.CONFLICT:
                            throw new CandidateAlreadyExistsException("Такой кандидат уже существует: " + candidate.getName(), candidate.getName());
                        case HttpStatus.INTERNAL_SERVER_ERROR:
                            throw new BadResponseException("Кандидат не был зарегистрирован: " + response.statusCode(), response.statusCode());
                        default:
                            throw new BadResponseException("Некорректный ответ от сервера при попытке регистрации кандидата: "  + response.statusCode(), response.statusCode());
                    }
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса на регистрацию.");
        }
    }
    
    public HashSet<Candidate> getCandidates() throws BadResponseException, RequestException {//, NoCandidatesException{
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        String requestUrl = serverUrl + "/candidates";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.OK:
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();

                    Type collectionType = new TypeToken<HashSet<Candidate>>(){}.getType(); //Здесь происходит сатана
                    HashSet<Candidate> candidateSet = gson.fromJson(response.body(), collectionType);
                    return candidateSet;
                default:
                    throw new BadResponseException("Некорректный ответ сервера при попытке получить список кандидатов: " + response.statusCode(), response.statusCode());
            }
            
            
            //else return new HashSet<Candidate>();
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса при попытке получить список кандидатов.");
        }
                
    }
    
    
    //Тут бы сделать разные статусы и желательно возврат исключения
    public void deleteAllCandidates() throws BadResponseException, RequestException, InvalidDeleteException{
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        String requestUrl = serverUrl + "/candidates";
        try{
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                DELETE().
                build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.OK:
                    return;
                case HttpStatus.CONFLICT:
                    throw new InvalidDeleteException("Таблица кандидатов не была очищена.");
                default:
                    throw new BadResponseException("Некорректный ответ от сервера при удалении кандидатов: " + response.statusCode(), response.statusCode());
            }
        } catch (IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса при попытке удалить кандидатов.");
        }
        
    }
    

    
    //Возможно добавить кандидату ID, и тогда не придётся возиться с кодировкой имени. Просто голосовать по ID, а не по имени
    public void voteForCandidate(Candidate candidate) throws BadResponseException, RequestException, InvalidCandidateVoteException, NoSuchCandidateIdException {
        voteForCandidateById(candidate.getId());
    }
    
    public void voteForCandidateById(long id) throws BadResponseException, RequestException, InvalidCandidateVoteException, NoSuchCandidateIdException {
        
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        String requestUrl = serverUrl + "/candidates/" + id + ":vote";
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(requestUrl))
            .method("PATCH", HttpRequest.BodyPublishers.noBody())
            .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.OK:
                    return;
                case HttpStatus.CONFLICT:
                    throw new InvalidCandidateVoteException("Не удалось зафиксировать голос за кандидата с id = " + id, id);
                case HttpStatus.NO_CONTENT:
                    throw new NoSuchCandidateIdException("Не нашёлся кандидат с id = " + id, id);
                default:
                    throw new BadResponseException("Некорректный ответ от сервера при попытке голоса за кандидата: " + response.statusCode(), response.statusCode());
            }
        } catch (IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса на голос за кандидата.");
        }
    }
}
