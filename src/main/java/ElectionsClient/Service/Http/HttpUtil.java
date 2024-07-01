/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service.Http;

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