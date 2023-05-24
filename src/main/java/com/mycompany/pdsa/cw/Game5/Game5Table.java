/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pdsa.cw.Game5;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaden
 */
public class Game5Table extends javax.swing.JFrame {

    String playerName;
    String sourceCity;
    Game5 gameObject;
    private Boolean playerSaved = false;
    /**
     * Creates new form Game5Table
     */
    public Game5Table(String player, Game5 game) {
        initComponents();
        
        populateTable();
        Random random = new Random();
        char randomLetter = (char) (random.nextInt(10) + 'A');
        sourceCity = String.valueOf(randomLetter);
        lbl_source.setText(sourceCity);
        btn_restart.setEnabled(false);
        playerName = player;
        gameObject = game;
         btn_submit.setEnabled(false);
        
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                UpdateButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                UpdateButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                UpdateButton();
            }
        };
        
        txt_connectors.getDocument().addDocumentListener(documentListener);
        txt_distance.getDocument().addDocumentListener(documentListener);
    }
    
    private void UpdateButton(){
        boolean allFieldsEmpty = true;
        
        if(txt_connectors.getText().isEmpty()){
            allFieldsEmpty = false;
        }
        
        if(txt_distance.getText().isEmpty()){
            allFieldsEmpty = false;
        }
        
        btn_submit.setEnabled(allFieldsEmpty);
    }
    
    public void populateTable(){
        PreparedStatement state, state1 = null;
        DefaultTableModel model = new DefaultTableModel();
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DB.createConnection();         

            String columns[] = {"","A", "B","C","D","E","F","G","H","I","J"};
            model.setColumnIdentifiers(columns);
            
            state = con.prepareStatement("SELECT * FROM distance WHERE StartPoint = ?");
                        
            for (char i = 0; i <= 9; i++) {
                state.setInt(1, i);

                ResultSet rs = state.executeQuery();
                
                state1 = con.prepareStatement("SELECT CityName FROM city WHERE CityID = ?");
                state1.setInt(1, i);
                ResultSet rs1 = state1.executeQuery();
                Object[] rowData = new Object[11];
                while (rs1.next()) {
                   rowData[0] = rs1.getString("CityName");
                }

                int j = 1;
                while (rs.next()) {
                    rowData[j] = rs.getString("Distance");
                    j++;
                }

                model.addRow(rowData);
            }

            table_show.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int convertToNumber(String letter) {
        char firstChar = letter.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            return firstChar - 'A';
        } else if (firstChar >= 'a' && firstChar <= 'z') {
            return firstChar - 'a';
        } else {
            throw new IllegalArgumentException("Invalid letter: " + letter);
        }
    }
    
    private static List<Integer> convertAnswerToList(String answer) {
        List<Integer> cities = new ArrayList<>();
        String[] cityNames = answer.split("(?<=.)");
        for (String cityName : cityNames) {
            int cityIndex = cityName.charAt(0) - 'A';
            cities.add(cityIndex);
        }
        return cities;
    }
    
    private void saveGamePlayer(String connectors, String distance){
        try{
            Connection con = DB.createConnection();
            
            if(!playerSaved){
                
                PreparedStatement state = con.prepareStatement("INSERT INTO answer(PlayerName, MinConnectors, Distance) VALUES(?,?,?)");
                state.setString(1, playerName);
                state.setString(2, connectors);
                state.setString(3, distance);
                state.executeUpdate();
                playerSaved = true;
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Player Already Exists", "Error",JOptionPane.INFORMATION_MESSAGE);
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

        jLabel3 = new javax.swing.JLabel();
        txt_connectors = new javax.swing.JTextField();
        txt_distance = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_show = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_submit = new javax.swing.JButton();
        btn_restart = new javax.swing.JButton();
        lbl_source = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Enter the Shortest Distance  ");

        txt_connectors.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_connectors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_connectorsKeyReleased(evt);
            }
        });

        txt_distance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_distance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_distanceKeyReleased(evt);
            }
        });

        table_show.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        table_show.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "A", "B", "C", "D", "E", "F", "G", "H", "I"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_show);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Enter your answer considering  the source city as : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Enter the Minimum Connectors (In Capital Letters) ");

        btn_submit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        btn_restart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_restart.setText("Restart");
        btn_restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restartActionPerformed(evt);
            }
        });

        lbl_source.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_source.setText("A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_source))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_distance, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_connectors, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(btn_restart, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_source))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_connectors, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_distance, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_submit)
                    .addComponent(btn_restart))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_connectorsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_connectorsKeyReleased
        Validator.validateLetters(txt_connectors);
        txt_connectors.setBackground(Color.WHITE);
    }//GEN-LAST:event_txt_connectorsKeyReleased

    private void txt_distanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_distanceKeyReleased
        Validator.validateNumber(txt_distance);
        txt_distance.setBackground(Color.WHITE);
    }//GEN-LAST:event_txt_distanceKeyReleased

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        List<Integer> playerSolution = convertAnswerToList(txt_connectors.getText());
        btn_restart.setEnabled(true);

        //        ManageInputs inputs = new ManageInputs();

        List<Integer> correctAnswer = gameObject.prim(convertToNumber(sourceCity));
        boolean connectorsAnswer = gameObject.validateAnswer(correctAnswer, playerSolution);
        boolean distanceAnswer = gameObject.computeShortestDistance(correctAnswer, Integer.parseInt(txt_distance.getText()));

        if(connectorsAnswer){
            txt_connectors.setBackground(Color.GREEN);
        }else{
            txt_connectors.setBackground(Color.RED);
        }

        if(distanceAnswer){
            txt_distance.setBackground(Color.GREEN);
        }else{
            txt_distance.setBackground(Color.RED);
        }

        if(connectorsAnswer && distanceAnswer){
            txt_connectors.setBackground(Color.GREEN);
            txt_distance.setBackground(Color.GREEN);
            saveGamePlayer(txt_connectors.getText(), txt_distance.getText());
            btn_submit.setEnabled(false);
        }

    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restartActionPerformed

        try{
            Connection con = DB.createConnection();

            Statement statement = con.createStatement();
            statement.executeUpdate("TRUNCATE TABLE distance");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        Game5Login login = new Game5Login();
        login.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_btn_restartActionPerformed

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
            java.util.logging.Logger.getLogger(Game5Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game5Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game5Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game5Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Game5 game = null;
                new Game5Table("Table Title", game).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_restart;
    private javax.swing.JButton btn_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_source;
    private javax.swing.JTable table_show;
    private javax.swing.JTextField txt_connectors;
    private javax.swing.JTextField txt_distance;
    // End of variables declaration//GEN-END:variables
}
