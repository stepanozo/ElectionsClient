/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.application;

/**
 *
 * @author чтепоноза
 */
public class MainClass {
    
    private static Thread waiterThread;

    public static Thread getWaiterThread(){
        return waiterThread;
    }
    public static void setWaiterThread(Thread thread){
        waiterThread = thread;
    }
   
}
