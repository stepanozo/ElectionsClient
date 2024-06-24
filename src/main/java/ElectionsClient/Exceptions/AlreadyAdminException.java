/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionsClient.Exceptions;

/**
 *
 * @author чтепоноза
 */
public class AlreadyAdminException extends Exception{
    
    private String login;
    
    public String getLogin(){
        return login;
    }
    
    public AlreadyAdminException(String message, String login){
        super(message);
        this.login = login;
    }
}
