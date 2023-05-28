/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pdsa.cw.Game2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jaden
 */
public class Decode extends javax.swing.JFrame {

    /**
     * Creates new form Decode
     */
    String encodedStr;
    String decodedStr;
    private static final int MAX_STRING_LENGTH = 30;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public Decode() {
        initComponents();
        Submit_btn.setEnabled(false);
        lbl_ranString2.addPropertyChangeListener("text", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                 Submit_btn.setEnabled(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_ranString2 = new javax.swing.JLabel();
        lbl_output2 = new javax.swing.JLabel();
        txtbox_de = new javax.swing.JTextField();
        Submit_btn = new javax.swing.JButton();
        reload_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_lookup = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_ranString2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lbl_output2.setText(" ");
        lbl_output2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtbox_de.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbox_deKeyReleased(evt);
            }
        });

        Submit_btn.setText("Submit");
        Submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_btnActionPerformed(evt);
            }
        });

        reload_btn.setText("Reload");
        reload_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reload_btnActionPerformed(evt);
            }
        });

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Lookup table");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Random String");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(reload_btn)
                .addGap(164, 164, 164)
                .addComponent(Submit_btn)
                .addGap(0, 278, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(789, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back_btn)
                            .addComponent(jLabel3))
                        .addGap(0, 798, Short.MAX_VALUE))
                    .addComponent(txtbox_de)
                    .addComponent(lbl_lookup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_output2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(401, 401, 401))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_ranString2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(back_btn)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ranString2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_lookup, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbox_de, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_output2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reload_btn)
                    .addComponent(Submit_btn))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_btnActionPerformed
        String userAnswer = txtbox_de.getText();

        boolean isMatch = decodedStr.equals(userAnswer);

        JOptionPane.showMessageDialog(null, isMatch ? "Correct!" : "Wrong answer.", "Result",JOptionPane.INFORMATION_MESSAGE);
        System.out.println(isMatch ? "Correct!" : "Wrong answer.");
        lbl_output2.setText(isMatch ? "Correct!" : "Wrong answer.");
    }//GEN-LAST:event_Submit_btnActionPerformed

    private void reload_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reload_btnActionPerformed
        Random random = new Random();
        int length = random.nextInt(MAX_STRING_LENGTH) + 1;
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        HuffmanGame h = new HuffmanGame();

        encodedStr = h.encodeString(sb.toString());
        decodedStr = h.decodeString(encodedStr);
        String encStrS = h.encodeWithSpace(sb.toString());

        Map codeMap = h.getLookupTable();

        System.out.println("Encoded String: " + encodedStr);
        System.out.println("Decoded String: " + decodedStr);
        System.out.println("Lookup table: " + codeMap);

        lbl_lookup.setText(codeMap.toString());
        lbl_ranString2.setText(encStrS);
    }//GEN-LAST:event_reload_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void txtbox_deKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbox_deKeyReleased
       Validator.validateLettersAndNumbers(txtbox_de);
    }//GEN-LAST:event_txtbox_deKeyReleased

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
            java.util.logging.Logger.getLogger(Decode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Decode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Decode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Decode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Decode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Submit_btn;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_lookup;
    private javax.swing.JLabel lbl_output2;
    private javax.swing.JLabel lbl_ranString2;
    private javax.swing.JButton reload_btn;
    private javax.swing.JTextField txtbox_de;
    // End of variables declaration//GEN-END:variables
}
