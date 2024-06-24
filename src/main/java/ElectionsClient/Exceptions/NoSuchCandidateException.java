/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionsClient.Exceptions;

/**
 *
 * @author чтепоноза
 */
public class NoSuchCandidateException extends Exception{
    
    private String name;
    
    public String getName(){
        return name;
    }
    
    public NoSuchCandidateException(String message, String name){
        super(message);
        this.name = name;
    }
}
