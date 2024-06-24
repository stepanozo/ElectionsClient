/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electionsClient.Exceptions;

/**
 *
 * @author чтепоноза
 */
public class TooManyCandidatesException extends Exception{
    private int numberOfCandidates;
    public int getNumberOfCandidates(){
        return numberOfCandidates;
    }
    
    public TooManyCandidatesException(String message, int numberOfCandidates){
        super(message);
        this.numberOfCandidates = numberOfCandidates;
    }
}
