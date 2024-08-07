/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.application;

import ElectionsClient.frames.ElectionsResultFrame;
import ElectionsClient.frames.InfoFrame;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author чтепоноза
 */
public class Waiter implements Runnable {
    
    private static final long delay = 1L;
    
    @Getter
    @Setter
    private static volatile boolean  exit = false;
    
    
    @Setter
    private static LocalDateTime ending;
    
    private static final Waiter waiter = new Waiter();
    
    public static Waiter getInstance(){
        return waiter;
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
        waitForTime(ending); //Сначала ждём конца выборов

        if(ElectionsFrames.getVoteFrame() != null){
            new ElectionsResultFrame().setVisible(true);
            
            ElectionsFrames.getVoteFrame().dispose();
            if(ElectionsFrames.getCandidateFrame() != null)
                ElectionsFrames.getCandidateFrame().dispose();
            if(ElectionsFrames.getFilterFrame() != null)
                ElectionsFrames.getFilterFrame().dispose();
        }
    }
}
