/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service;

import ElectionsClient.Exceptions.WrongLoginOrPasswordException;
import ElectionsClient.application.MyJsonConverter;
import ElectionsClient.model.Candidate;
import ElectionsClient.model.CandidateHashSet;
import ElectionsClient.model.ElectionsTime;
import ElectionsClient.model.User;
import ElectionsClient.model.UserHashSet;
import electionsClient.Exceptions.HTTPException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import electionsClient.Exceptions.NoCandidatesException;
import electionsClient.Exceptions.NoElectionsException;
import electionsClient.Exceptions.NoUsersException;
import electionsClient.security.LoginData;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashSet;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author чтепоноза
 */
public class HttpUtil {
      
    
    @Getter
    static HttpClient client = HttpClient.newHttpClient();
    
    @Getter
    static String serverUrl = "http://localhost:8080";
    
    public static boolean electionsHaveRecords() throws HTTPException {
        
        String requestUrl = serverUrl + "/electionsTime/check-if-exist";
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            boolean electionsExist = gson.fromJson(response.body(), boolean.class);
            return electionsExist;
        } catch(IOException | InterruptedException e){
            throw new HTTPException("Ошибка запроса по адресу " + requestUrl, requestUrl);
        }
                
    }
    
    public static ElectionsTime getLatestElectionsTime() throws HTTPException, NoElectionsException{
        
        String requestUrl = serverUrl + "/electionsTime/findLatest";
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Тут что-то адское происходит
            String json = response.body();
            GsonBuilder builder = new GsonBuilder();
            JsonDeserializer<LocalDateTime> deserializer = (jsonElement, type, context) -> LocalDateTime.parse(jsonElement.getAsString());
            builder.registerTypeAdapter(LocalDateTime.class, deserializer);
            Gson gson = builder.create();

            // Десериализация JSON в объект ElectionsTime
            ElectionsTime electionsTime = gson.fromJson(json, ElectionsTime.class);
            if(electionsTime == null)
                throw new NoElectionsException("Не найдены выборы");
            else return electionsTime;
        } catch(IOException | InterruptedException e){
            throw new HTTPException("Ошибка запроса по адресу " + requestUrl, requestUrl);
        }
                
    }
    
    public static HttpResponse<String> newElectionsTime(ElectionsTime electionsTime) throws HTTPException{
        
        String requestUrl = serverUrl + "/electionsTime";
        // Создаем JSON тело запроса
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//        
//        String json = gson.toJson(electionsTime);

        String json = MyJsonConverter.electionsTimeToJson(electionsTime);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                header("Content-Type", "application/json").
                POST(BodyPublishers.ofString(json)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch(IOException | InterruptedException e){
            throw new HTTPException("Ошибка запроса по адресу " + requestUrl, requestUrl);
        }
    }
    
    public static HttpResponse<String> newCandidate(Candidate candidate) throws HTTPException{
        
        String requestUrl = serverUrl + "/candidates";
        // Создаем JSON тело запроса
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        String json = gson.toJson(candidate);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                header("Content-Type", "application/json").
                POST(BodyPublishers.ofString(json)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch(IOException | InterruptedException e){
            throw new HTTPException("Ошибка запроса по адресу " + requestUrl, requestUrl);
        }
    }
    
    public static HashSet<Candidate> getCandidates() throws HTTPException {//, NoCandidatesException{
        
        String requestUrl = serverUrl + "/candidates";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
//            CandidateHashSet candidateList = gson.fromJson(response.body(), CandidateHashSet.class);
//            if(!(candidateList.getHashSet() == null || candidateList.getHashSet().isEmpty()))
//                //throw new NoCandidatesException("Не найдено ни одного кандидата");
//                return candidateList.getHashSet();
            Type collectionType = new TypeToken<HashSet<Candidate>>(){}.getType(); //Здесь происходит сатана
            HashSet<Candidate> candidateSet = gson.fromJson(response.body(), collectionType);
            return candidateSet;
            //else return new HashSet<Candidate>();
        } catch(IOException | InterruptedException e){
            throw new HTTPException("Ошибка запроса по адресу " + requestUrl, requestUrl);
        }
                
    }
    
    
    //Тут бы сделать разные статусы и желательно возврат исключения
    public static void deleteAllCandidates() throws HTTPException{
        String requestUrl = serverUrl + "/candidates";
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(requestUrl)).
            DELETE().
            build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            throw new HTTPException("Ошибка удаления кандидатов по адресу " + requestUrl, requestUrl);
        }
        
    }
    

    
    //Возможно добавить кандидату ID, и тогда не придётся возиться с кодировкой имени. Просто голосовать по ID, а не по имени
    public static void voteForCandidate(Candidate candidate) throws HTTPException, UnsupportedEncodingException{
        voteForCandidateById(candidate.getId());
    }
    
    public static void voteForCandidateById(long id) throws HTTPException, UnsupportedEncodingException{
        
        String requestUrl = serverUrl + "/candidates/" + id + ":vote";
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(requestUrl))
            .method("PATCH", HttpRequest.BodyPublishers.noBody())
            .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            throw new HTTPException("Ошибка голосвания за кандитата по запросу" + requestUrl, requestUrl);
        }
    }
    
}


//public class Main {
//    public static void main(String[] args) {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder() //Здесь ещё потом добавится header с авторизацией и токеном
//                .uri(URI.create("https://example.com/data"))
//                .build();
//
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
//    }
//}

//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenApply(json -> new Gson().fromJson(json, new TypeToken<List<User>>(){}.getType()))
//                .thenAccept(users -> {
//                    // Обработка списка пользователей
//                    for (User user : users) {
//                        // Действия с каждым пользователем
//                    }
//                })
//                .join();