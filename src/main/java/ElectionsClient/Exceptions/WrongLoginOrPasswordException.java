/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.Exceptions;

/**
 *
 * @author чтепоноза
 */
public class WrongLoginOrPasswordException extends Exception{
   
    public WrongLoginOrPasswordException(String message){
        super(message);
    }
}
