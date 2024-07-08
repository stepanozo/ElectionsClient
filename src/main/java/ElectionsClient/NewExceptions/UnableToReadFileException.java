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
public class UnableToReadFileException extends Exception{
    
    @Getter
    private final String nameOfFile ;
    
     public UnableToReadFileException(String message, String nameOfFile){
        super(message);
        this.nameOfFile = nameOfFile;
    }
}
