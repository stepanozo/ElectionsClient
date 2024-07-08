/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.model;

import ElectionsClient.NewExceptions.UnableToReadFileException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author чтепоноза
 */
public class Candidate {

    @Getter
    private long id;
    
    @Getter
    private final String name;
    
    @Getter
    private final int yearOfBirth;
    
    @Getter
    private final String placeOfLiving;
    
    @Getter
    private final String party;
    
    @Getter
    private final String information;
    
    @Getter //Чтобы был и геттер, и сеттер
    @Setter
    private int votes;
    
    public Candidate(String name, int yearOfBirth, String placeOfLiving, String party, String information, int votes){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.placeOfLiving = placeOfLiving;
        this.party = party;
        this.information = information;
        this.votes = votes;
    }
    
    public static Candidate fromFile(String path) throws UnableToReadFileException{
        
        File file = new File(path);
        if(!file.exists())
            throw new UnableToReadFileException("Такого файла не существует: ", new File(path).getName());
        
        try( BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))){
            String name = r.readLine();
            int yearOfBirth = Integer.parseInt(r.readLine());
            String placeOfLiving = r.readLine();
            String party = r.readLine();
            String information = r.readLine();
            return new Candidate(name, yearOfBirth, placeOfLiving, party, information, 0);
        }
        catch (Exception e){
            throw new UnableToReadFileException("Не удалось прочитать кандидата из файла: " + file.getName(), file.getName());
        }
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Candidate candidate = (Candidate)obj;
        
        return 
            Objects.equals(candidate.name, this.name) && 
            candidate.yearOfBirth == this.yearOfBirth && 
            Objects.equals(candidate.placeOfLiving, this.placeOfLiving) &&
            Objects.equals(candidate.party, this.party) &&
            Objects.equals(candidate.information, this.information) && 
            candidate.votes == this.votes;
    }

    @Override
    public int hashCode() {
        return 
            name.hashCode() + 
            ((Integer)yearOfBirth).hashCode() +
            placeOfLiving.hashCode() +
            party.hashCode() +
            information.hashCode() +
            ((Integer)votes).hashCode();
    }
    
    @Override
    public String toString(){
        return String.format(
                "Имя: '%s' \n" +
                "Год рождения: %d \n" +
                "Место проживания: '%s' \n" +
                "Партия: '%s' \n" +
                "Информация: '%s' \n" +
                "Количество голосов: %d \n",
                name, yearOfBirth, placeOfLiving, party, information, votes
        );
    }
}
