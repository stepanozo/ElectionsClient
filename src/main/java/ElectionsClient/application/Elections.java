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
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.stream.Stream;

public class Elections {
    
    private static volatile LocalDateTime dateTimeOfBegining;
    private static volatile LocalDateTime dateTimeOfEnding;
    
    private static VoteFrame voteFrame; //Храним эту форму здесь, чтобы после окончания выборов её закрыть и заменить на форму результатов выборов.
    private static CandidateFrame candidateFrame;
    private static FilterFrame filterFrame;
    
    public static FilterFrame getFilterFrame(){
        return filterFrame;
    }
    public static void setFilterFrame(FilterFrame newFilterFrame){
        filterFrame = newFilterFrame;
    }
    
    public static VoteFrame getVoteFrame(){
        return voteFrame;
    }
    public static void setVoteFrame(VoteFrame newVoteFrame){
        voteFrame = newVoteFrame;
    }
     public static CandidateFrame getCandidateFrame(){
        return candidateFrame;
    }
    public static void setCandidateFrame(CandidateFrame newCandidateFrame){
        candidateFrame = newCandidateFrame;
    }
    
    public static LocalDateTime getDateTimeOfBegining(){
        return dateTimeOfBegining;
    }
    
    public static LocalDateTime getDateTimeOfEnding(){
        return dateTimeOfEnding;
    }
     
    public static void setTimeOfBegining(LocalDateTime newDateTimeOfBegining){
        dateTimeOfBegining = newDateTimeOfBegining;
    }
    
    public static void setTimeOfEnding(LocalDateTime newDateTimeOfEnding){
        dateTimeOfEnding = newDateTimeOfEnding;
    }
    
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
