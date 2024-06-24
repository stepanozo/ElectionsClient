/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionsClient.HTTP;

import electionsClient.Exceptions.HTTPException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import electionsClient.security.LoginData;
import java.net.http.HttpRequest.BodyPublishers;

/**
 *
 * @author чтепоноза
 */
public class HTTPUtil {
    static HttpClient client = HttpClient.newHttpClient();
    
    static String serverUrl = "http://localhost:8080";
    
    public static boolean tryLogIn(LoginData loginData) throws HTTPException{
        
        String requestUrl = serverUrl + "/users/login";
        // Создаем JSON тело запроса
        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        String json = gson.toJson(loginData);
        
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                header("Content-Type", "application/json").
                POST(BodyPublishers.ofString(json)).
                build();
        
        try{
            int statusCode = client.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();

            switch (statusCode) {
                case 200:
                    return true;
                case 401:
                    return false;
                default:
                    throw new HTTPException("Ошибка запроса по адресу " + requestUrl, requestUrl);
            }
        } catch(IOException | InterruptedException e){
            throw new HTTPException("Ошибка запроса по адресу " + requestUrl, requestUrl);
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