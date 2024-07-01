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
public class NoSuchCandidateIdException extends Exception{
    
    @Getter
    private final Long id;
    
    public NoSuchCandidateIdException(String message, Long id){
        super(message);
        this.id = id;
    }
}
