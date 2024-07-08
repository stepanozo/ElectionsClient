/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.EntityClient;

import ElectionsClient.Service.*;
import ElectionsClient.Exceptions.WrongLoginOrPasswordException;
import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.InvalidAdminRightsException;
import ElectionsClient.NewExceptions.InvalidForgettingVotesException;
import ElectionsClient.NewExceptions.InvalidVoteException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.NewExceptions.UserAlreadyExistsException;
import ElectionsClient.model.User;
import electionsClient.Exceptions.NoSuchUserException;
import electionsClient.Exceptions.NoUsersException;
import electionsClient.security.LoginData;
import java.util.HashSet;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 *
 * @author чтепоноза
 */

@Service
public class UserClient {
    
    @Setter
    private static UserClientService service;
            
    public static User tryLogIn(LoginData loginData) throws WrongLoginOrPasswordException, RequestException, BadResponseException{
        return service.tryLogIn(loginData);
    }
    
    public static boolean checkIfAdmin(String login) throws RequestException, NoSuchUserException, BadResponseException{
        return service.checkIfAdmin(login);
    }
    public static User getUserByLogin(String login) throws NoSuchUserException, BadResponseException, RequestException{
        return service.getUserByLogin(login);
    }
    public static boolean tryRegister(LoginData loginData) throws RequestException, BadResponseException, UserAlreadyExistsException{
        return service.tryRegister(loginData);
    }
    public static HashSet<User> getUsers() throws RequestException, BadResponseException, NoUsersException{
        return service.getUsers();
    }
    public static void markAsVoted(String login) throws NoSuchUserException, InvalidVoteException, RequestException, BadResponseException{
        service.markAsVoted(login);
    }
    public static void forgetAllVotes() throws RequestException, BadResponseException, InvalidForgettingVotesException{
        service.forgetAllVotes();
    }
    
    public static void markAsAdmin(String login, boolean isAdmin) throws NoSuchUserException, InvalidAdminRightsException, RequestException, BadResponseException{
        service.markAsAdmin(login, isAdmin);
    }
}
