/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author чтепоноза
 */

public class ElectionsTime {
    
    @Getter
    private Long id;
    
    @Getter
    private LocalDateTime dateTimeOfBegining;
    
    @Getter
    private LocalDateTime dateTimeOfEnding;
    
    @Getter
    @Setter
    private boolean ended;
    
    public ElectionsTime(LocalDateTime dateTimeOfBegining, LocalDateTime dateTimeOfEnding){
        this.dateTimeOfBegining = dateTimeOfBegining;
        this.dateTimeOfEnding = dateTimeOfEnding;
        this.ended = false;
    }
    
    public ElectionsTime(Long id, LocalDateTime dateTimeOfBegining, LocalDateTime dateTimeOfEnding){
        this.id = id;
        this.dateTimeOfBegining = dateTimeOfBegining;
        this.dateTimeOfEnding = dateTimeOfEnding;
        this.ended = false;
    }
}
