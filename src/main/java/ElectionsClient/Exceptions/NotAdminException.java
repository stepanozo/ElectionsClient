/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionsClient.Exceptions;

/**
 *
 * @author чтепоноза
 */
public class NotAdminException extends Exception{
    
    private String login;
    
    public String getLogin(){
        return login;
    }
    
    public NotAdminException(String message, String login){
        super(message);
        this.login = login;
    }
}
