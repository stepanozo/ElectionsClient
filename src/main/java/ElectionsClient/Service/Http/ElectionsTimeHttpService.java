/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service.Http;

import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.InvalidElectionsStartException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.Service.ElectionsTimeClientService;
import ElectionsClient.application.MyJsonConverter;
import ElectionsClient.model.ElectionsTime;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import electionsClient.Exceptions.NoElectionsException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

/**
 *
 * @author чтепоноза
 */
public class ElectionsTimeHttpService implements ElectionsTimeClientService{
    
    @Override
    public boolean electionsHaveRecords() throws RequestException, BadResponseException{
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        String requestUrl = serverUrl + "/electionsTime/check-if-exist";
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.OK:
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    boolean electionsExist = gson.fromJson(response.body(), boolean.class);
                    return electionsExist;
                default:
                    throw new BadResponseException("Некорректный ответ от сервера при проверке наличия выборов: " + response.statusCode(), response.statusCode());
            }
           
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса при попытке получить записи о выборах.");
        }
                
    }
    
    @Override
    public ElectionsTime getLatestElectionsTime() throws RequestException, BadResponseException, NoElectionsException{
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        String requestUrl = serverUrl + "/electionsTime/findLatest";
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.OK:
                    //Тут что-то адское происходит
                    String json = response.body();
                    GsonBuilder builder = new GsonBuilder();
                    JsonDeserializer<LocalDateTime> deserializer = (jsonElement, type, context) -> LocalDateTime.parse(jsonElement.getAsString());
                    builder.registerTypeAdapter(LocalDateTime.class, deserializer);
                    Gson gson = builder.create();

                    // Десериализация JSON в объект ElectionsTime
                    ElectionsTime electionsTime = gson.fromJson(json, ElectionsTime.class);
                    return electionsTime;
                case HttpStatus.NO_CONTENT:
                    throw new NoElectionsException("Не найдены выборы");
                default:
                    throw new BadResponseException("Некорректный ответ от сервера при попытке получить последние выборы: " + response.statusCode(), response.statusCode());
            }
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса на получение последней записи о выборах.");
        }
                
    }
    
    @Override
    public void newElectionsTime(ElectionsTime electionsTime) throws RequestException, BadResponseException, InvalidElectionsStartException{
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        String requestUrl = serverUrl + "/electionsTime";
                
                
        String json = MyJsonConverter.electionsTimeToJson(electionsTime);
        
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
                    throw new InvalidElectionsStartException("Не удалось запустить выборы.");
                default:
            }       throw new BadResponseException("Некорректный ответ от сервера при попытке запустить выборы: " + response.statusCode(), response.statusCode());
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса на создание новых выборов.");
        }
    }
}
