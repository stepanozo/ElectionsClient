/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionsClient.Exceptions;

/**
 *
 * @author чтепоноза
 */
public class UnableToReadFileException extends Exception{
    
    private String nameOfFile ;
    
    public String getNameOfFile(){
        return nameOfFile;
    }
    
     public UnableToReadFileException(String message, String nameOfFile){
        super(message);
        this.nameOfFile = nameOfFile;
    }
}
