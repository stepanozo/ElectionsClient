/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.NewExceptions;

import lombok.Getter;

/**
 *
 * @author чтепоноза
 */
public class UserAlreadyExistsException extends Exception{
    @Getter
    private final String login;
    
    public UserAlreadyExistsException(String message, String login){
        super(message);
        this.login = login;
    }
}
