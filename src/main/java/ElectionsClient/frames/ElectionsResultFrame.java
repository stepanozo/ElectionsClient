/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ElectionsClient.frames;


import ElectionsClient.EntityClient.CandidateClient;
import ElectionsClient.EntityClient.UserClient;
import ElectionsClient.NewExceptions.BadResponseException;
import ElectionsClient.NewExceptions.RequestException;
import ElectionsClient.application.ElectionsFrames;
import ElectionsClient.model.Candidate;
import ElectionsClient.NewExceptions.NoSuchUserException;
import ElectionsClient.application.Application;
import java.util.HashSet;
import javax.swing.JLabel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author чтепоноза
 */

public class ElectionsResultFrame extends javax.swing.JFrame {
    
    private final int MAX_CANDIDATES = 8;
    private JLabel[] labelArray;
    
    /**
     * Creates new form ElectionsResultFrame
     */
    
    @Autowired
    
    
    public ElectionsResultFrame() {
        setLocationRelativeTo(null);
        initComponents();
        labelArray = new JLabel[]{
        jLabel0,
        jLabel1,
        jLabel2,
        jLabel3,
        jLabel4,
        jLabel5,
        jLabel6,
        jLabel7
        };
        
        try{
            HashSet<Candidate> candidates = CandidateClient.getCandidates();

            int numberOfCandidates = candidates.size();

            for(int i = MAX_CANDIDATES-1; i >= numberOfCandidates; i--){
                labelArray[i].setVisible(false);
            }

            int i =0;
            for(Candidate candidate: candidates){
                labelArray[i].setText(candidate.getName() + " - " + ElectionsFrames.percentageOfVotes(candidate, candidates) + " % голосов"
                );
                i++;
            }
        } catch (BadResponseException | RequestException e){
            new InfoFrame(e.getMessage()).setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        electionsEndedLabel = new javax.swing.JLabel();
        jLabel0 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        backButton.setText("Назад");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        electionsEndedLabel.setText("Выборы окончены. Результаты: ");

        jLabel0.setText("jLabel1");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel1");

        jLabel3.setText("jLabel1");

        jLabel4.setText("jLabel1");

        jLabel5.setText("jLabel1");

        jLabel6.setText("jLabel1");

        jLabel7.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel0)
                            .addComponent(electionsEndedLabel)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(electionsEndedLabel)
                .addGap(28, 28, 28)
                .addComponent(jLabel0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        try{
            if(UserClient.checkIfAdmin(Application.getCurrentUser().getLogin())){
                new AdminFrame().setVisible(true);
            } else{
                LogInFrame logInFrame = new LogInFrame();
                logInFrame.setVisible(true);
            }
        } catch (RequestException | NoSuchUserException | BadResponseException e){
            LogInFrame logInFrame = new LogInFrame();
            logInFrame.setVisible(true);
            new InfoFrame(e.getMessage()).setVisible(true);
        } finally {
            dispose();
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel electionsEndedLabel;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
