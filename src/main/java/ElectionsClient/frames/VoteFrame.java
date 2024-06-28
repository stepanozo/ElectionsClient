/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ElectionsClient.frames;

import ElectionsClient.application.ApplicationState;
import ElectionsClient.application.Elections;
import ElectionsClient.model.Candidate;
import ElectionsClient.model.User;
import electionsClient.Exceptions.HTTPException;
import electionsClient.Exceptions.NoSuchCandidateException;
import electionsClient.Exceptions.NoSuchUserException;
import electionsClient.HTTP.HTTPUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.sql.*;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.util.HashMap;

/**
 *
 * @author чтепоноза
 */
public class VoteFrame extends javax.swing.JFrame {

    private final int MAX_CANDIDATES = 8;
    private JCheckBox[] checkBoxArray;
    private JButton[] candidateButtonsArray;
    private int choice;
    private int numberOfCandidates;
    private HashMap<Integer, Candidate> numberAndCandidate;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterButton = new javax.swing.JButton();
        jCheckBox0 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        cancelFilter = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        voteButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        filterButton.setText("Фильтр по критериям");
        filterButton.setToolTipText("");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        jCheckBox0.setText("jCheckBox0");
        jCheckBox0.setToolTipText("");
        jCheckBox0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox0ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("jCheckBox2");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        cancelFilter.setText("Сбросить фильтр");
        cancelFilter.setToolTipText("");
        cancelFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelFilterActionPerformed(evt);
            }
        });

        jButton0.setText("Информация");
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });

        jButton1.setText("Информация");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Информация");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Информация");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Информация");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Информация");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Информация");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Информация");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        voteButton.setText("Подтвердить голос");
        voteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jCheckBox3.setText("jCheckBox3");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("jCheckBox4");
        jCheckBox4.setToolTipText("");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("jCheckBox5");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("jCheckBox6");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setText("jCheckBox7");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox0)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton0, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton7)
                                .addComponent(jButton6)
                                .addComponent(jButton5)
                                .addComponent(jButton4)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(cancelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton0)
                    .addComponent(jCheckBox0))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jCheckBox4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jCheckBox5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jCheckBox6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jCheckBox7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public VoteFrame() {
        setLocationRelativeTo(null);
        initComponents();
        checkBoxArray = new JCheckBox[]{
        jCheckBox0,
        jCheckBox1,
        jCheckBox2,
        jCheckBox3,
        jCheckBox4,
        jCheckBox5,
        jCheckBox6,
        jCheckBox7
        };
        candidateButtonsArray = new JButton[]{
        jButton0,
        jButton1,
        jButton2,
        jButton3,
        jButton4,
        jButton5,
        jButton6,
        jButton7,
        };
        Elections.setVoteFrame(this);
        try{
            
            HashSet<Candidate> candidates = HTTPUtil.getCandidates();
            numberOfCandidates = candidates.size();
            choice = -1;

            showCandidates(candidates);
            User user = HTTPUtil.getUserByLogin((ApplicationState.getCurrentUser().getLogin()));
            if(user.isVoted())
                voteButton.setEnabled(false);
        } catch (HTTPException e){
            new InfoFrame("Ошибка HTTP-запроса").setVisible(true);
        }
    }
    
    private void showCandidate(int i){
       enableAllButtons(false);
       CandidateFrame candidateFrame = new CandidateFrame(numberAndCandidate.get(i));
       candidateFrame.setVisible(true);
       candidateFrame.setVoteFrame(this);
    }
    
    public void showCandidates(HashSet<Candidate> candidates){
        choice = -1;
        numberOfCandidates = candidates.size();
        for(int i = MAX_CANDIDATES-1; i >= candidates.size(); i--){
            checkBoxArray[i].setVisible(false);
            candidateButtonsArray[i].setVisible(false);
        }
        
        numberAndCandidate = new HashMap();
        int i =0;
        for(Candidate candidate: candidates){
            numberAndCandidate.put(i, candidate);
            checkBoxArray[i].setText(candidate.getName());
            checkBoxArray[i].setVisible(true);
            checkBoxArray[i].setSelected(false);
            candidateButtonsArray[i].setVisible(true);
            i++;
        }
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        try{
            if(HTTPUtil.checkIfAdmin(ApplicationState.getCurrentUser().getLogin())){
                new AdminFrame().setVisible(true);
            } else{
                LogInFrame logInFrame = new LogInFrame();
                logInFrame.setVisible(true);
            }
        } catch (HTTPException e){
            LogInFrame logInFrame = new LogInFrame();
            logInFrame.setVisible(true);
            logInFrame.showConnectionErrorMessage();
        } finally {
            dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectCandidate(int numberOfCheckbox){
         if(checkBoxArray[numberOfCheckbox].isSelected())
            for(int i = 0; i< MAX_CANDIDATES; i++){
                if(i!=numberOfCheckbox){
                    checkBoxArray[i].setSelected(false);
                }
            }
        choice = numberOfCheckbox;
    }
    
    private void jCheckBox0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox0ActionPerformed
        selectCandidate(0);
    }//GEN-LAST:event_jCheckBox0ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        selectCandidate(1);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        selectCandidate(2);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        selectCandidate(3);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        selectCandidate(4);
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        selectCandidate(5);
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        selectCandidate(6);
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        selectCandidate(7);
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void voteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteButtonActionPerformed
        if(choice == -1){
            new InfoFrame("Сначала выберите кандидата").setVisible(true);
        } else {
            try{

                User user = HTTPUtil.getUserByLogin(ApplicationState.getCurrentUser().getLogin());
                if(!user.isVoted()){
                    HTTPUtil.voteForCandidate(numberAndCandidate.get(choice));
                    HTTPUtil.markAsVoted(user.getLogin());
                    voteButton.setEnabled(false);
                    new InfoFrame("Ваш голос успешно зарегистрирован").setVisible(true);
                } else {
                    new InfoFrame("Вы уже голосовали").setVisible(true);
                    voteButton.setEnabled(false);
                }
            } catch (HTTPException e){
                new InfoFrame("Ошибка соединения с сервером").setVisible(true);
            } catch (UnsupportedEncodingException e) {
                new InfoFrame("Ошибка кодировки имени кандидата").setVisible(true);
            }
                
        }
    }//GEN-LAST:event_voteButtonActionPerformed

    
    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
        showCandidate(0);
    }//GEN-LAST:event_jButton0ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showCandidate(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showCandidate(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showCandidate(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        showCandidate(4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        showCandidate(5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        showCandidate(6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        showCandidate(7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        FilterFrame filterFrame = new FilterFrame();
        filterFrame.setVisible(true);
        filterFrame.setVoteFrame(this);
        enableAllButtons(false);
    }//GEN-LAST:event_filterButtonActionPerformed

    private void cancelFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelFilterActionPerformed
        try{
            showCandidates(HTTPUtil.getCandidates());
        } catch (HTTPException e){
            new InfoFrame("Ошибка соединения").setVisible(true);
        }
        
    }//GEN-LAST:event_cancelFilterActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
                
    }//GEN-LAST:event_formWindowClosed

    
    public void enableAllButtons(boolean value){
        for(int i = 0; i < MAX_CANDIDATES; i++){
            checkBoxArray[i].setEnabled(value);
            candidateButtonsArray[i].setEnabled(value);
        }
        
        cancelButton.setEnabled(value);
        voteButton.setEnabled(value);
        cancelFilter.setEnabled(value);
        filterButton.setEnabled(value);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelFilter;
    private javax.swing.JButton filterButton;
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox0;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JButton voteButton;
    // End of variables declaration//GEN-END:variables
}
