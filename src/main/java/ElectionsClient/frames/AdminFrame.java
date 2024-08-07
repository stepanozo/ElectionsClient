/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ElectionsClient.frames;

import ElectionsClient.EntityClient.ElectionsTimeClient;
import ElectionsClient.EntityClient.UserClient;
import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.NewExceptions.NoElectionsException;
import ElectionsClient.NewExceptions.NoSuchUserException;
import ElectionsClient.application.Application;
import java.time.LocalDateTime;
/**
 *
 * @author чтепоноза
 */
public class AdminFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form AdminFrame
     */
    public AdminFrame() {
        setLocationRelativeTo(null);
        initComponents();
    }
    public void enableAllButtons(){
        newElectionsButton.setEnabled(true);
        voteButton.setEnabled(true);
        addAdminRightsButton.setEnabled(true);
        removeAdminRightsButton.setEnabled(true);
        exitButton.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        voteButton = new javax.swing.JButton();
        newElectionsButton = new javax.swing.JButton();
        addAdminRightsButton = new javax.swing.JButton();
        removeAdminRightsButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        voteButton.setText("Голосовать");
        voteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteButtonActionPerformed(evt);
            }
        });

        newElectionsButton.setText("Новые выборы");
        newElectionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newElectionsButtonActionPerformed(evt);
            }
        });

        addAdminRightsButton.setText("Назначить админа");
        addAdminRightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminRightsButtonActionPerformed(evt);
            }
        });

        removeAdminRightsButton.setText("Убрать админа");
        removeAdminRightsButton.setToolTipText("");
        removeAdminRightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAdminRightsButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Выйти");
        exitButton.setToolTipText("");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeAdminRightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAdminRightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newElectionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(voteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newElectionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addAdminRightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeAdminRightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void disableAllButtons(){
        voteButton.setEnabled(false);
        newElectionsButton.setEnabled(false);
        addAdminRightsButton.setEnabled(false); 
        removeAdminRightsButton.setEnabled(false);
        exitButton.setEnabled(false);
    }
    
    public void notAdminAnymore(){
         InfoFrame errorFrame = new InfoFrame("У вас больше нет прав админа.");
         errorFrame.setVisible(true);
    }
    
    public void blockAdminButtons(){
        newElectionsButton.setEnabled(false);
        addAdminRightsButton.setEnabled(false); 
        removeAdminRightsButton.setEnabled(false);
    }
    
    private void newElectionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newElectionsButtonActionPerformed
        NewElectionsFrame newElectionsFrame = new NewElectionsFrame();
        newElectionsFrame.setAdminFrame(this);
        newElectionsFrame.setVisible(true);
        disableAllButtons();
           
    }//GEN-LAST:event_newElectionsButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        new LogInFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void addAdminRightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminRightsButtonActionPerformed
        try{ //Проверим, что пользователь всё ещё админ
            if(UserClient.checkIfAdmin(Application.getCurrentUser().getLogin())){
                AddAdminRightsFrame addAdminRightsFrame = new AddAdminRightsFrame();
                addAdminRightsFrame.setVisible(true);
                addAdminRightsFrame.setAdminFrame(this);
                disableAllButtons();
            } else {
            blockAdminButtons();
            notAdminAnymore();
            }
        } catch (RequestException | NoSuchUserException | BadResponseException e){
            new InfoFrame(e.getMessage()).setVisible(true);
        }        
       
    }//GEN-LAST:event_addAdminRightsButtonActionPerformed

    private void removeAdminRightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAdminRightsButtonActionPerformed

        try{ //Проверим, что пользователь всё ещё админ
            if(UserClient.checkIfAdmin(Application.getCurrentUser().getLogin())){
                RemoveAdminRightsFrame removeAdminRightsFrame = new RemoveAdminRightsFrame();
                removeAdminRightsFrame.setVisible(true);
                removeAdminRightsFrame.setAdminFrame(this);
                disableAllButtons();
            } else {
            blockAdminButtons();
            notAdminAnymore();
            }
        } catch (RequestException | NoSuchUserException | BadResponseException e){
            new InfoFrame(e.getMessage()).setVisible(true);
        }        
    }//GEN-LAST:event_removeAdminRightsButtonActionPerformed

    private void voteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteButtonActionPerformed
        try{
            if(ElectionsTimeClient.electionsHaveRecords() &&
                LocalDateTime.now().isAfter(ElectionsTimeClient.getLatestElectionsTime().getDateTimeOfBegining()) )
            {
                if(LocalDateTime.now().isBefore(ElectionsTimeClient.getLatestElectionsTime().getDateTimeOfEnding())){
                    VoteFrame voteFrame = new VoteFrame();
                    voteFrame.setVisible(true);
                } else{
                    ElectionsResultFrame resultFrame = new ElectionsResultFrame();
                    resultFrame.setVisible(true);
                }
                dispose();
            }
            else{
                new InfoFrame("Выборы в данный момент не проводятся").setVisible(true);
            }
        } catch(RequestException | BadResponseException | NoElectionsException e){
                new InfoFrame(e.getMessage()).setVisible(true);
        }
        
    }//GEN-LAST:event_voteButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdminRightsButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton newElectionsButton;
    private javax.swing.JButton removeAdminRightsButton;
    private javax.swing.JButton voteButton;
    // End of variables declaration//GEN-END:variables
}
