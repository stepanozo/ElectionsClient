/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.application;

import ElectionsClient.frames.ElectionsResultFrame;
import ElectionsClient.frames.InfoFrame;
import java.time.LocalDateTime;

/**
 *
 * @author чтепоноза
 */
public class Waiter implements Runnable {
    
    private static long delay = 1L;
    private static volatile boolean  exit = false;

    private static Waiter waiter = new Waiter();
    
    public static Waiter getInstance(){
        return waiter;
    }
    
    public static boolean getExit(){
        return exit;
    }
    
    public static void setExit(boolean value){
        exit = value;
    }
    
    private Waiter(){
        //Конструктор заглушка
    }
    
    private void waitForTime(LocalDateTime dateTime){
        //Здесь ждём какого-то времени, ничего не делаем
        while(LocalDateTime.now().isBefore(dateTime) && !exit){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e){
                new InfoFrame("Действующие выборы остановлены.").setVisible(true);
            }
        }
    }
    
    @Override
    public void run() {
        waitForTime(Elections.getDateTimeOfEnding()); //Сначала ждём конца выборов

        if(Elections.getVoteFrame() != null){
            new ElectionsResultFrame().setVisible(true);
            
            Elections.getVoteFrame().dispose();
            if(Elections.getCandidateFrame() != null)
                Elections.getCandidateFrame().dispose();
            if(Elections.getFilterFrame() != null)
                Elections.getFilterFrame().dispose();
        }
    }
}
