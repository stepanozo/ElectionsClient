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
public class InvalidCandidateVoteException extends Exception {
    
    @Getter
    private final long id;
    
    public InvalidCandidateVoteException(String message, long id){
        super(message);
        this.id = id;
    }
}
