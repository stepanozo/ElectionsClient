/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionsClient.Exceptions;

import lombok.Getter;

/**
 *
 * @author чтепоноза
 */
public class HTTPException extends Exception{
    @Getter
    String url;
    public HTTPException(String message, String url){
        super(message);
        this.url = url;
    }
}
