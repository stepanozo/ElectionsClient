/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service;

import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.CandidateAlreadyExistsException;
import ElectionsClient.NewExceptions.InvalidCandidateVoteException;
import ElectionsClient.NewExceptions.InvalidDeleteException;
import ElectionsClient.NewExceptions.NoSuchCandidateIdException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.model.Candidate;
import java.util.HashSet;
import org.springframework.stereotype.Service;

/**
 *
 * @author чтепоноза
 */

@Service
public interface CandidateClientService {
    public void newCandidate(Candidate candidate) throws BadResponseException, RequestException, CandidateAlreadyExistsException;
    
    public HashSet<Candidate> getCandidates() throws BadResponseException, RequestException;
    
    public void deleteAllCandidates() throws BadResponseException, RequestException, InvalidDeleteException;
    
    public void voteForCandidate(Candidate candidate) throws BadResponseException, RequestException, InvalidCandidateVoteException, NoSuchCandidateIdException ;
    
    public void voteForCandidateById(long id) throws BadResponseException, RequestException, InvalidCandidateVoteException, NoSuchCandidateIdException;
}
