/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.application;

import ElectionsClient.model.User;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author чтепоноза
 */
public class ApplicationState {
    
    @Getter
    @Setter
    private static User currentUser;
    
}
