/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author чтепоноза
 */

@AllArgsConstructor
public class LoginData {
    
    @Getter
    private final String login;
    @Getter
    private final String password; 
}
