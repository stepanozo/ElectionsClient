/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.application;

/**
 *
 * @author чтепоноза
 */
import ElectionsClient.frames.CandidateFrame;
import ElectionsClient.frames.FilterFrame;
import ElectionsClient.frames.VoteFrame;
import ElectionsClient.model.Candidate;
import java.util.HashSet;
import lombok.Getter;
import lombok.Setter;

public class Elections {
    
    @Getter
    @Setter
    private static VoteFrame voteFrame; //Храним эту форму здесь, чтобы после окончания выборов её закрыть и заменить на форму результатов выборов.
    
    @Getter
    @Setter
    private static CandidateFrame candidateFrame;
    
    @Getter
    @Setter
    private static FilterFrame filterFrame;
    
    public static double percentageOfVotes(Candidate candidate, HashSet<Candidate> candidates) {
        int sum = candidates.stream()
                   .mapToInt(Candidate::getVotes) // Преобразуем каждого кандидата в число голосов
                   .sum(); // Суммируем все голоса

        if(sum == 0) return 0;
        return candidate.getVotes()* 100/ sum;
                
    }
    
    private Elections(){
        //Конструктор-заглушка
    }
      
}
