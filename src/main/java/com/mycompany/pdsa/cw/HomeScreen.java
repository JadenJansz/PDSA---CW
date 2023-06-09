/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pdsa.cw;

import com.mycompany.pdsa.cw.Game1.EightQueensPuzzle;
import com.mycompany.pdsa.cw.Game2.Menu;
import com.mycompany.pdsa.cw.Game3.TicTacToe;
import com.mycompany.pdsa.cw.Game4.Game4Login;
import com.mycompany.pdsa.cw.Game5.Game5Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaden
 */
public class HomeScreen extends javax.swing.JFrame {

    /**
     * Creates new form HomeScreen
     */
    public HomeScreen() {
        initComponents();
    }
    
    public void cleanTables(String database, String[] tables) throws Exception{
        
        String url = "jdbc:mysql://localhost:3306/"+database+"?zeroDateTimeBehavior=CONVERT_TO_NULL";
        
        Connection con = DriverManager.getConnection(url,"root","");
        
        Statement statement = con.createStatement();

        statement.execute("SET FOREIGN_KEY_CHECKS = 0");

        for (String tableName : tables) {
            String truncateQuery = "TRUNCATE TABLE " + tableName;
            statement.executeUpdate(truncateQuery);
            System.out.println("Truncated table: " + tableName);
        }

        statement.execute("SET FOREIGN_KEY_CHECKS = 1");

        System.out.println("All tables truncated successfully.");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_queen = new javax.swing.JButton();
        btn_connector = new javax.swing.JButton();
        btn_encode = new javax.swing.JButton();
        btn_tictactoe = new javax.swing.JButton();
        btn_path = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME");

        btn_queen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_queen.setText("8 Queens Puzzle");
        btn_queen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_queenActionPerformed(evt);
            }
        });

        btn_connector.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_connector.setText("Connectors");
        btn_connector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectorActionPerformed(evt);
            }
        });

        btn_encode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_encode.setText("Encode / Decode");
        btn_encode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_encodeActionPerformed(evt);
            }
        });

        btn_tictactoe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_tictactoe.setText("Tic - Tac - Toe");
        btn_tictactoe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tictactoeActionPerformed(evt);
            }
        });

        btn_path.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_path.setText("Shortest Path");
        btn_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_queen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_tictactoe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_path, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_encode)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(btn_connector, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_queen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_encode, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_path, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tictactoe, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btn_connector, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_queenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_queenActionPerformed
        EightQueensPuzzle game1 = new EightQueensPuzzle();
        game1.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_btn_queenActionPerformed

    private void btn_encodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encodeActionPerformed
        Menu game2 = new Menu();
        game2.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_btn_encodeActionPerformed

    private void btn_tictactoeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tictactoeActionPerformed
        TicTacToe game3 = new TicTacToe();
        game3.setVisible(rootPaneCheckingEnabled);
        dispose();
        
    }//GEN-LAST:event_btn_tictactoeActionPerformed

    private void btn_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pathActionPerformed
        String[] tables ={"answers","distance", "player"};
        
        try {
            cleanTables("game4", tables);
        } catch (Exception ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Game4Login game4 = new Game4Login();
        game4.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_btn_pathActionPerformed

    private void btn_connectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectorActionPerformed
        
        String[] tables ={"answer", "distance"};
        
        try {
            cleanTables("game5", tables);
        } catch (Exception ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Game5Login game5 = new Game5Login();
        game5.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_btn_connectorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connector;
    private javax.swing.JButton btn_encode;
    private javax.swing.JButton btn_path;
    private javax.swing.JButton btn_queen;
    private javax.swing.JButton btn_tictactoe;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
