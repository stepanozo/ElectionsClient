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
public class BadResponseException extends Exception{
    
    @Getter
    private int status;
    
    public BadResponseException(String message, int status){
        super(message);
        this.status = status;
    }
}
