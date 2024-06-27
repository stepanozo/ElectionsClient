/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElectionsClient.application;

import ElectionsClient.model.Candidate;
import electionsClient.Exceptions.NoSuchFolderException;
import electionsClient.Exceptions.TooManyCandidatesException;
import electionsClient.Exceptions.UnableToReadFileException;
import java.util.ArrayList;
import java.io.File;
/**
 *
 * @author чтепоноза
 */
public class FilesUtil {
    
    
    public static ArrayList<Candidate> getCandidatesFromFiles(String folderPath) 
            throws NoSuchFolderException, UnableToReadFileException, TooManyCandidatesException{
        File folder = new File(folderPath);
        if(!folder.exists())
            throw new NoSuchFolderException("Нет такой папки: " + folderPath, folderPath);
        File[] files = folder.listFiles();
        if(files.length > 8)
            throw new TooManyCandidatesException("Кандидатов должно быть меньше 8. Сейчас: " + files.length, files.length);
        ArrayList<Candidate> candidates = new ArrayList();
        for(File file: files)
            candidates.add(Candidate.fromFile(file.getAbsolutePath()));
        return candidates;
    }
}
