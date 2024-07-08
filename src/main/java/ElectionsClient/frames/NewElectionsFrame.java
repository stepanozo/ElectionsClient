/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ElectionsClient.frames;

import ElectionsClient.EntityClient.CandidateClient;
import ElectionsClient.EntityClient.ElectionsTimeClient;
import ElectionsClient.EntityClient.UserClient;
import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.CandidateAlreadyExistsException;
import ElectionsClient.NewExceptions.InvalidDeleteException;
import ElectionsClient.NewExceptions.InvalidElectionsStartException;
import ElectionsClient.NewExceptions.InvalidForgettingVotesException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.application.ElectionsFrames;
import ElectionsClient.application.FilesUtil;
import ElectionsClient.model.Candidate;
import ElectionsClient.model.ElectionsTime;
import ElectionsClient.model.User;
import ElectionsClient.NewExceptions.NoElectionsException;
import ElectionsClient.NewExceptions.NoSuchFolderException;
import ElectionsClient.NewExceptions.NoSuchUserException;
import ElectionsClient.NewExceptions.NoUsersException;
import ElectionsClient.NewExceptions.TooManyCandidatesException;
import ElectionsClient.NewExceptions.UnableToReadFileException;
import electionsClient.application.Application;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
/**
 *
 * @author чтепоноза
 */

public class NewElectionsFrame extends javax.swing.JFrame {

    private AdminFrame adminFrame;
    
   
    public void setAdminFrame(AdminFrame adminFrame){
        this.adminFrame = adminFrame;
    }
    /**
     * Creates new form newElectionsForm
     */
    public NewElectionsFrame() {
        setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newElectionsLabel = new javax.swing.JLabel();
        candidateFolderPathField = new javax.swing.JTextField();
        timeBeginField = new javax.swing.JTextField();
        timeEndField = new javax.swing.JTextField();
        timeBeginLabel = new javax.swing.JLabel();
        timeEndLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        formatLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        newElectionsLabel.setText("Укажите путь к папке с текстовыми файлами кандидатов");
        newElectionsLabel.setToolTipText("");

        candidateFolderPathField.setText("Путь к папке");

        timeBeginField.setText("Начало выборов");

        timeEndField.setText("Конец выборов");

        timeBeginLabel.setText("Время начала выборов");

        timeEndLabel.setText("Время конца выборов");

        startButton.setText("Запустить выборы");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        formatLabel.setText("Вводите время в формате ГГГГ-ММ-ДД чч:мм");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(newElectionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(candidateFolderPathField)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(timeBeginField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(timeBeginLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(timeEndLabel)
                                .addComponent(timeEndField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(newElectionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(candidateFolderPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeBeginLabel)
                    .addComponent(timeEndLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeBeginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeEndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(formatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public void blockAdminButtons(){
        startButton.setEnabled(false);
    }
    
     private void savePreviousElections() throws NoElectionsException,  NoUsersException{
        
        String currentDir = System.getProperty("user.dir");
        File folder = new File(currentDir + "\\Save");
        if (!folder.exists()) {
            folder.mkdir();
        }        
        int i = 1;
        File file = new File(folder + "\\Elections" + i +".txt");
        while(file.exists()){
            file = new File(folder + "\\Elections" + i +".txt");
            i++;
        }
        try(FileWriter writer = new FileWriter(file.getPath())) {
            
            ElectionsTime electionsTime = ElectionsTimeClient.getLatestElectionsTime();
        
            writer.write("Начало выборов: " + electionsTime.getDateTimeOfBegining().toString() + "\n");
            writer.append("Конец выборов: " + electionsTime.getDateTimeOfEnding().toString() + "\n");
            writer.append("Результаты выборов: \n");
            
            HashSet<Candidate> candidates = CandidateClient.getCandidates();
 
            for(Candidate candidate : candidates)
                writer.append(candidate.getName() + " - " + ElectionsFrames.percentageOfVotes(candidate, candidates) + "% голосов \n");
            
            HashSet<User> users = UserClient.getUsers();
            
            int sumVotes = users.stream()
                   .mapToInt(user -> (user.isVoted()) ? 1 : 0) 
                   .sum(); 
            writer.append("Всего человек проголосовало " +sumVotes); 
            writer.append('\n');
            
            writer.append("Явка составила: " + sumVotes* 100/users.size() + " %\n");
            
            writer.append("\nПриходили на выборы:\n ");
            for(User user : users)
                if(user.isVoted())
                    writer.append(user.toString() + "\n");
             
            writer.append("\n\nУчаствовавшие кандидаты: \n\n");
            for(Candidate candidate : candidates) {
                writer.append(candidate.toString() + "\n\n");
            }
            writer.append("\n");
           
            writer.flush();
        } catch (IOException e) {
            new InfoFrame("Не получилось создать файл").setVisible(true);
        } catch (RequestException |
                BadResponseException e){
            new InfoFrame(e.getMessage()).setVisible(true);
        }
    }
    
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        try{ //Проверим, что пользователь всё ещё админ
           if(UserClient.checkIfAdmin(Application.getCurrentUser().getLogin())){
            
                LocalDateTime beginTime =  LocalDateTime.parse(timeBeginField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                LocalDateTime endTime = LocalDateTime.parse(timeEndField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                if(endTime.isAfter(beginTime)){
                    
                    if(ElectionsTimeClient.electionsHaveRecords()){ //Здесь мы должны сгрузить в файл информацию о предыдущих выборах, если они были
                        savePreviousElections();
                    }
                    
                    ArrayList<Candidate> candidates = FilesUtil.getCandidatesFromFiles(candidateFolderPathField.getText());
                    
                    ElectionsTimeClient.newElectionsTime(new ElectionsTime(beginTime, endTime));
                
                    UserClient.forgetAllVotes();
                    CandidateClient.deleteAllCandidates();
                    
                    for(Candidate candidate: candidates){
                        CandidateClient.newCandidate(candidate); //Заполняем таблицу кандидатов
                    }
                       
                    dispose();
                }   
                else{
                    new InfoFrame("Окончание выборов должно быть позже начала.").setVisible(true);
                }
            }
            else {
                blockAdminButtons();
                adminFrame.blockAdminButtons();
                adminFrame.notAdminAnymore();
            }
        } catch (DateTimeParseException e){
           new InfoFrame("Неверно введена дата.").setVisible(true);
        }
        catch (InvalidElectionsStartException|
                InvalidDeleteException |
                CandidateAlreadyExistsException |
                NoSuchFolderException | 
                UnableToReadFileException |
                TooManyCandidatesException |
                NoElectionsException |
                NoUsersException |
                RequestException |
                BadResponseException |
                InvalidForgettingVotesException |
                NoSuchUserException e){
            new InfoFrame(e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        adminFrame.enableAllButtons();
    }//GEN-LAST:event_formWindowClosed

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField candidateFolderPathField;
    private javax.swing.JLabel formatLabel;
    private javax.swing.JLabel newElectionsLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField timeBeginField;
    private javax.swing.JLabel timeBeginLabel;
    private javax.swing.JTextField timeEndField;
    private javax.swing.JLabel timeEndLabel;
    // End of variables declaration//GEN-END:variables
}
