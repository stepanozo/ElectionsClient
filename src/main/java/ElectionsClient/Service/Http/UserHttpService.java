/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service.Http;

import ElectionsClient.NewExceptions.WrongLoginOrPasswordException;
import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.InvalidAdminRightsException;
import ElectionsClient.NewExceptions.InvalidForgettingVotesException;
import ElectionsClient.NewExceptions.InvalidVoteException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.NewExceptions.UserAlreadyExistsException;
import ElectionsClient.Service.UserClientService;
import ElectionsClient.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ElectionsClient.NewExceptions.NoSuchUserException;
import ElectionsClient.NewExceptions.NoUsersException;
import electionsClient.security.LoginData;
import java.io.IOException;
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

public class UserHttpService implements UserClientService{
    
    @Override
    public User tryLogIn(LoginData loginData) throws WrongLoginOrPasswordException, RequestException, BadResponseException{
        
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/users/login";

        // Создаем JSON тело запроса
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        String json = gson.toJson(loginData);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                header("Content-Type", "application/json").
                POST(HttpRequest.BodyPublishers.ofString(json)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           
            HttpStatus statusCode = HttpStatus.resolve(response.statusCode());
            
            switch (statusCode) {
                case HttpStatus.OK:
                    return gson.fromJson(response.body(), User.class);
                case HttpStatus.UNAUTHORIZED:
                    throw new WrongLoginOrPasswordException("Неверный логин или пароль.");
                default:
                    throw new BadResponseException("Некорректный ответ от сервера при попытке входа: "  + response.statusCode(), response.statusCode());
            }
        } catch(IOException| InterruptedException e){
            throw new RequestException("Ошибка запроса на вход.");
        }         
    }
    
    @Override
    public boolean checkIfAdmin(String login) throws RequestException, NoSuchUserException, BadResponseException {
        
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/users/" + login +":check-if-admin";
        // Создаем JSON тело запроса
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
       
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.OK:
                    boolean adminExists = gson.fromJson(response.body(), boolean.class);
                    return adminExists;
                case HttpStatus.NO_CONTENT:
                    throw new NoSuchUserException("Не найден пользователь " + login, login);
                default:
                    throw new BadResponseException("Некорректный ответ от сервера при попытке проверить админа: " + response.statusCode(), response.statusCode());
                    
            }
            
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса.");
        }        
    }
    
    @Override
    public User getUserByLogin(String login) throws NoSuchUserException, BadResponseException, RequestException {
        
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/users/" + login;
        // Создаем JSON тело запроса
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
       
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.OK:
                    User user = gson.fromJson(response.body(), User.class);
                    return user;
                case HttpStatus.NO_CONTENT:
                    throw new NoSuchUserException("Не найден пользователь " + login, login);
                default:
                    throw new BadResponseException("Некорректный ответ от сервера при попытке найти пользователя: " + response.statusCode(), response.statusCode());
            }
            
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса при попытке найти пользователя");
        }  
    }
    
    @Override
    public boolean tryRegister(LoginData loginData) throws RequestException, BadResponseException, UserAlreadyExistsException{
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/users/register";
        // Создаем JSON тело запроса
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        String json = gson.toJson(loginData);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                header("Content-Type", "application/json").
                POST(HttpRequest.BodyPublishers.ofString(json)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            switch(HttpStatus.resolve(response.statusCode())){
                        case HttpStatus.CREATED:
                            return true;
                        case HttpStatus.CONFLICT:
                            throw new UserAlreadyExistsException("Такой пользователь уже существует: " + loginData.getLogin(), loginData.getLogin());
                        case HttpStatus.INTERNAL_SERVER_ERROR:
                            throw new BadResponseException("Некорректный ответ от сервера при попытке регистрации: " + response.statusCode(), response.statusCode());
                        default:
                            throw new BadResponseException("Некорректный ответ от сервера при попытке регистрации: "  + response.statusCode(), response.statusCode());
                    }
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса на регистрацию.");
        }
    }
    
    @Override
    public HashSet<User> getUsers() throws RequestException, BadResponseException, NoUsersException{
        
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/users";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl)).
                build();
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           
            if (HttpStatus.resolve(response.statusCode()) == HttpStatus.OK){
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Type collectionType = new TypeToken<HashSet<User>>(){}.getType(); //Здесь происходит сатана
                HashSet<User> userSet = gson.fromJson(response.body(), collectionType);
                if(userSet.isEmpty())
                    throw new NoUsersException("Нет ни одного пользователя.");
                return userSet;            
            } else throw new BadResponseException("Некорректный ответ от сервера при попытке получить список пользователей: "  + response.statusCode(), response.statusCode());
        } catch(IOException | InterruptedException e){
            throw new RequestException("Ошибка запроса на получение списка пользователей");
        }
                
    }
    
    //Тут бы сделать разные статусы и желательно возврат исключения
    @Override
    public void markAsVoted(String login) throws NoSuchUserException, InvalidVoteException, RequestException, BadResponseException{
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/users/" + login + "/mark-as-voted";
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(requestUrl))
            .method("PATCH", HttpRequest.BodyPublishers.noBody())
            .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.NO_CONTENT:
                    throw new NoSuchUserException("Попытка проголосовать несуществующим пользователем " + login, login);
                case HttpStatus.CONFLICT:
                    throw new InvalidVoteException("Голос пользователя " + login + " не зафиксирован.", login);
                case HttpStatus.OK:
                    return;
                default:
                    throw new BadResponseException("Неудачный ответ при попытке проголосовать: " + response.statusCode(), response.statusCode());
            }
        } catch (IOException | InterruptedException e){
            throw new RequestException("Ошибка при попытке проголосовать");
        }
        
    }
    
    //Тут бы сделать разные статусы и желательно возврат исключения
    @Override
    public void forgetAllVotes() throws RequestException, BadResponseException, InvalidForgettingVotesException{
        
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/users/forgetVotes";
        
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
                    throw new InvalidForgettingVotesException("Ошибка при удалении голосов пользоватеелй.");
                default:
                    throw new BadResponseException("Неудачный ответ при попытке обнулить голоса: " + response.statusCode(), response.statusCode());
            }
        } catch (IOException | InterruptedException e){
            throw new RequestException("Ошибка обнуления голосов избирателей");
        }
        
    }
    
        //Тут бы сделать разные статусы и желательно возврат исключения
    @Override
    public void markAsAdmin(String login, boolean isAdmin) throws NoSuchUserException, InvalidAdminRightsException, RequestException, BadResponseException{
        String serverUrl = HttpUtil.getServerUrl();
        HttpClient client = HttpUtil.getClient();
        
        String requestUrl = serverUrl + "/users/" + login + "/mark-as-admin/" + isAdmin;
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(requestUrl))
            .method("PATCH", HttpRequest.BodyPublishers.noBody())
            .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            switch(HttpStatus.resolve(response.statusCode())){
                case HttpStatus.NO_CONTENT:
                    throw new NoSuchUserException("Пользователь не существует: " + login, login);
                case HttpStatus.CONFLICT:
                    throw new InvalidAdminRightsException(response.body(), login);
                case HttpStatus.OK:
                    return;
                default:
                    throw new BadResponseException("Неудачный ответ при попытке изменить права: " + response.statusCode(), response.statusCode());
            }
        } catch (IOException | InterruptedException e){
            throw new RequestException("Ошибка при попытке изменить права");
        }
        
    }
    
}
