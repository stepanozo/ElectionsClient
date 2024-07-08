/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.EntityClient;

import ElectionsClient.Service.*;
import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.CandidateAlreadyExistsException;
import ElectionsClient.NewExceptions.InvalidCandidateVoteException;
import ElectionsClient.NewExceptions.InvalidDeleteException;
import ElectionsClient.NewExceptions.NoSuchCandidateIdException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.model.Candidate;
import java.util.HashSet;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 *
 * @author чтепоноза
 */

@Service
public class CandidateClient {
    
    @Setter
    private static CandidateClientService service;
               
    public static void newCandidate(Candidate candidate) throws BadResponseException, RequestException, CandidateAlreadyExistsException{
        service.newCandidate(candidate);
    }
    
    public static HashSet<Candidate> getCandidates() throws BadResponseException, RequestException{
       return service.getCandidates();
    }
    
    public static void deleteAllCandidates() throws BadResponseException, RequestException, InvalidDeleteException{
        service.deleteAllCandidates();
    }
    
    public static void voteForCandidate(Candidate candidate) throws BadResponseException, RequestException, InvalidCandidateVoteException, NoSuchCandidateIdException{
        service.voteForCandidate(candidate);
    }
    
    public static void voteForCandidateById(long id) throws BadResponseException, RequestException, InvalidCandidateVoteException, NoSuchCandidateIdException{
        service.voteForCandidateById(id);
    }
}
