/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.EntityClient;

import ElectionsClient.Service.*;
import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.InvalidElectionsStartException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.model.ElectionsTime;
import electionsClient.Exceptions.NoElectionsException;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 *
 * @author чтепоноза
 */

@Service
public class ElectionsTimeClient {
    
    @Setter
    private static ElectionsTimeClientService service;
            
    public static boolean electionsHaveRecords() throws RequestException, BadResponseException{
        return service.electionsHaveRecords();
    }
    
    public static ElectionsTime getLatestElectionsTime() throws RequestException, BadResponseException, NoElectionsException{
        return service.getLatestElectionsTime();
    }
    
    public static void newElectionsTime(ElectionsTime electionsTime) throws RequestException, BadResponseException, InvalidElectionsStartException{
        service.newElectionsTime(electionsTime);
    }
}
