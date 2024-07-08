/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Service;

import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.InvalidElectionsStartException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.model.ElectionsTime;
import ElectionsClient.NewExceptions.NoElectionsException;
import org.springframework.stereotype.Service;

/**
 *
 * @author чтепоноза
 */

@Service
public interface ElectionsTimeClientService {

    public boolean electionsHaveRecords() throws RequestException, BadResponseException;
    
    public ElectionsTime getLatestElectionsTime() throws RequestException, BadResponseException, NoElectionsException;
    
    public void newElectionsTime(ElectionsTime electionsTime) throws RequestException, BadResponseException, InvalidElectionsStartException;
}
