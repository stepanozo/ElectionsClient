/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.NewExceptions;

/**
 *
 * @author чтепоноза
 */
public class NoSuchUserException extends Exception{
    
    private final String login;
    
    public String getLogin(){
        return login;
    }
    
    public NoSuchUserException(String message, String login){
        super(message);
        this.login = login;
    }
}
