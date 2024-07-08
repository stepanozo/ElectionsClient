/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service;

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
import org.springframework.stereotype.Service;

/**
 *
 * @author чтепоноза
 */

public interface UserClientService {
    
    public User tryLogIn(LoginData loginData) throws WrongLoginOrPasswordException, RequestException, BadResponseException;
    
    public boolean checkIfAdmin(String login) throws RequestException, NoSuchUserException, BadResponseException;
    
    public User getUserByLogin(String login) throws NoSuchUserException, BadResponseException, RequestException ;
    
    public boolean tryRegister(LoginData loginData) throws RequestException, BadResponseException, UserAlreadyExistsException;
    
    public HashSet<User> getUsers() throws RequestException, BadResponseException, NoUsersException;
    
    public void markAsVoted(String login) throws NoSuchUserException, InvalidVoteException, RequestException, BadResponseException;
    
    public void forgetAllVotes() throws RequestException, BadResponseException, InvalidForgettingVotesException;
    
    public void markAsAdmin(String login, boolean isAdmin) throws NoSuchUserException, InvalidAdminRightsException, RequestException, BadResponseException;
}
