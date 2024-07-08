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
public class CandidateAlreadyExistsException extends Exception{
    
    @Getter
    private final String name;
    
    public CandidateAlreadyExistsException(String message, String name){
        super(message);
        this.name = name;
    }
    
}
