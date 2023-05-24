/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pdsa.cw.Game4;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaden
 */
public class Game4Table extends javax.swing.JFrame {

    String playerName;
    String sourceCity;
    ArrayList<JTextField> textFieldsDistance = new ArrayList<>();
    ArrayList<JTextField> textFieldsPath = new ArrayList<>();
    /**
     * Creates new form Game4Table
     */
    public Game4Table(String player) {
        initComponents();
        
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
        
        populateTable();
        Random random = new Random();
        char randomLetter = (char) (random.nextInt(10) + 'A');
        sourceCity = String.valueOf(randomLetter);
        lbl_source.setText(sourceCity);
        btn_submit.setEnabled(false);
        btn_restart.setEnabled(false);
        playerName = player;
        
        textFieldsDistance.add(txt_A_dist); textFieldsPath.add(txt_A_path);
        textFieldsDistance.add(txt_B_dist); textFieldsPath.add(txt_B_path);
        textFieldsDistance.add(txt_C_dist); textFieldsPath.add(txt_C_path);
        textFieldsDistance.add(txt_D_dist); textFieldsPath.add(txt_D_path);
        textFieldsDistance.add(txt_E_dist); textFieldsPath.add(txt_E_path);
        textFieldsDistance.add(txt_F_dist); textFieldsPath.add(txt_F_path);
        textFieldsDistance.add(txt_G_dist); textFieldsPath.add(txt_G_path);
        textFieldsDistance.add(txt_H_dist); textFieldsPath.add(txt_H_path);
        textFieldsDistance.add(txt_I_dist); textFieldsPath.add(txt_I_path);
        textFieldsDistance.add(txt_J_dist); textFieldsPath.add(txt_J_path);
        
        for (JTextField textField : textFieldsDistance) {
            textField.getDocument().addDocumentListener(documentListener);
        }
        
        for (JTextField textField : textFieldsPath) {
            textField.getDocument().addDocumentListener(documentListener);
        }
    }
    
    private void UpdateButton(){
        boolean allFieldsEmpty = true;
        
        for (JTextField textField : textFieldsDistance) {
            if(textField.getText().isEmpty()){
                allFieldsEmpty = false;
                break;
            }
        }
        
        for (JTextField textField : textFieldsPath) {
            if(textField.getText().isEmpty()){
                allFieldsEmpty = false;
                break;
            }
        }
        
        btn_submit.setEnabled(allFieldsEmpty);
    }
    
    public void populateTable(){
        Connection con = null;
        PreparedStatement state, state1 = null;
        DefaultTableModel model = new DefaultTableModel();
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game4?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");        

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

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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

        txt_C_dist = new javax.swing.JTextField();
        txt_D_dist = new javax.swing.JTextField();
        txt_E_dist = new javax.swing.JTextField();
        txt_F_dist = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_show = new javax.swing.JTable();
        txt_G_dist = new javax.swing.JTextField();
        txt_H_dist = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_source = new javax.swing.JLabel();
        txt_I_dist = new javax.swing.JTextField();
        txt_A_path = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_D_path = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_B_path = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_C_path = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_E_path = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_G_path = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_F_path = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_H_path = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_I_path = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_J_dist = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_J_path = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_submit = new javax.swing.JButton();
        txt_A_dist = new javax.swing.JTextField();
        btn_restart = new javax.swing.JButton();
        txt_B_dist = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_C_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_C_distKeyReleased(evt);
            }
        });

        txt_D_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_D_distKeyReleased(evt);
            }
        });

        txt_E_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_E_distKeyReleased(evt);
            }
        });

        txt_F_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_F_distKeyReleased(evt);
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

        txt_G_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_G_distKeyReleased(evt);
            }
        });

        txt_H_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_H_distKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Enter your answser considering \nthe source city as : ");

        lbl_source.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_source.setText("A");

        txt_I_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_I_distKeyReleased(evt);
            }
        });

        txt_A_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_A_pathActionPerformed(evt);
            }
        });
        txt_A_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_A_pathKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Enter the Shortest distance and Shortest path to each city");

        txt_D_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_D_pathKeyReleased(evt);
            }
        });

        jLabel3.setText("A");

        txt_B_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_B_pathKeyReleased(evt);
            }
        });

        jLabel4.setText("B");

        txt_C_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_C_pathKeyReleased(evt);
            }
        });

        jLabel5.setText("C");

        txt_E_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_E_pathKeyReleased(evt);
            }
        });

        jLabel6.setText("D");

        txt_G_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_G_pathKeyReleased(evt);
            }
        });

        jLabel7.setText("E");

        txt_F_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_F_pathKeyReleased(evt);
            }
        });

        jLabel8.setText("F");

        txt_H_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_H_pathKeyReleased(evt);
            }
        });

        jLabel9.setText("G");

        txt_I_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_I_pathKeyReleased(evt);
            }
        });

        jLabel10.setText("H");

        jLabel11.setText("I");

        jLabel14.setText("J");

        txt_J_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_J_distKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Shortest Distance");

        txt_J_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_J_pathKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Shortest Path");

        btn_submit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        txt_A_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_A_distKeyReleased(evt);
            }
        });

        btn_restart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_restart.setText("Restart");
        btn_restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restartActionPerformed(evt);
            }
        });

        txt_B_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_B_distKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_E_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_F_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_G_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_H_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_I_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_A_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_J_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(txt_J_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_D_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_C_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_B_dist, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_D_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_E_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(165, 165, 165)
                                        .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(65, 65, 65)
                                        .addComponent(btn_restart, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_G_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_F_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_H_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_I_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_B_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_C_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_A_path, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_source, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_A_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_A_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_source, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_B_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_B_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_C_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_C_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_D_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txt_D_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_E_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_E_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_submit)
                    .addComponent(btn_restart))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_F_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_F_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_G_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_G_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_H_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_H_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_I_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_I_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_J_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_J_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_C_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_C_distKeyReleased
        Validator.validateNumber(txt_C_dist);
    }//GEN-LAST:event_txt_C_distKeyReleased

    private void txt_D_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_D_distKeyReleased
        Validator.validateNumber(txt_D_dist);
    }//GEN-LAST:event_txt_D_distKeyReleased

    private void txt_E_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_E_distKeyReleased
        Validator.validateNumber(txt_E_dist);
    }//GEN-LAST:event_txt_E_distKeyReleased

    private void txt_F_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_F_distKeyReleased
        Validator.validateNumber(txt_F_dist);
    }//GEN-LAST:event_txt_F_distKeyReleased

    private void txt_G_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_G_distKeyReleased
        Validator.validateNumber(txt_G_dist);
    }//GEN-LAST:event_txt_G_distKeyReleased

    private void txt_H_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_H_distKeyReleased
        Validator.validateNumber(txt_H_dist);
    }//GEN-LAST:event_txt_H_distKeyReleased

    private void txt_I_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_I_distKeyReleased
        Validator.validateNumber(txt_I_dist);
    }//GEN-LAST:event_txt_I_distKeyReleased

    private void txt_A_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_A_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_A_pathActionPerformed

    private void txt_A_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_A_pathKeyReleased
        Validator.validateLetters(txt_A_path);
    }//GEN-LAST:event_txt_A_pathKeyReleased

    private void txt_D_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_D_pathKeyReleased
        Validator.validateLetters(txt_D_path);
    }//GEN-LAST:event_txt_D_pathKeyReleased

    private void txt_B_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_B_pathKeyReleased
        Validator.validateLetters(txt_B_path);
    }//GEN-LAST:event_txt_B_pathKeyReleased

    private void txt_C_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_C_pathKeyReleased
        Validator.validateLetters(txt_C_path);
    }//GEN-LAST:event_txt_C_pathKeyReleased

    private void txt_E_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_E_pathKeyReleased
        Validator.validateLetters(txt_E_path);
    }//GEN-LAST:event_txt_E_pathKeyReleased

    private void txt_G_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_G_pathKeyReleased
        Validator.validateLetters(txt_G_path);
    }//GEN-LAST:event_txt_G_pathKeyReleased

    private void txt_F_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_F_pathKeyReleased
        Validator.validateLetters(txt_F_path);
    }//GEN-LAST:event_txt_F_pathKeyReleased

    private void txt_H_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_H_pathKeyReleased
        Validator.validateLetters(txt_H_path);
    }//GEN-LAST:event_txt_H_pathKeyReleased

    private void txt_I_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_I_pathKeyReleased
        Validator.validateLetters(txt_I_path);
    }//GEN-LAST:event_txt_I_pathKeyReleased

    private void txt_J_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_J_distKeyReleased
        Validator.validateNumber(txt_J_dist);
    }//GEN-LAST:event_txt_J_distKeyReleased

    private void txt_J_pathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_J_pathKeyReleased
        Validator.validateLetters(txt_J_path);
    }//GEN-LAST:event_txt_J_pathKeyReleased

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed

        btn_restart.setEnabled(true);
        btn_submit.setEnabled(false);
        ManageInputs inputs = new ManageInputs();
        int i = 0;
        for (JTextField textField : textFieldsDistance) {
            String userInput = textField.getText();

            boolean isCorrectDistance = inputs.compareInputsShortestDistance(sourceCity, i, userInput, playerName);

            if (isCorrectDistance) {
                textField.setBackground(Color.GREEN);
            } else {
                textField.setBackground(Color.RED);
            }

            i++;
        }

        int j = 0;
        for (JTextField textField : textFieldsPath) {
            String userInput = textField.getText();

            boolean isCorrectDistance = inputs.compareInputsShortestPath(sourceCity, j, userInput, playerName);
            if (isCorrectDistance) {
                textField.setBackground(Color.GREEN);
            } else {
                textField.setBackground(Color.RED);
            }

            j++;
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void txt_A_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_A_distKeyReleased
        Validator.validateNumber(txt_A_dist);
    }//GEN-LAST:event_txt_A_distKeyReleased

    private void btn_restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restartActionPerformed

        Game4Login login = new Game4Login();
        login.setVisible(rootPaneCheckingEnabled);
        dispose();

    }//GEN-LAST:event_btn_restartActionPerformed

    private void txt_B_distKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_B_distKeyReleased
        Validator.validateNumber(txt_B_dist);
    }//GEN-LAST:event_txt_B_distKeyReleased

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
            java.util.logging.Logger.getLogger(Game4Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game4Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game4Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game4Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game4Table("Table Title").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_restart;
    private javax.swing.JButton btn_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_source;
    private javax.swing.JTable table_show;
    private javax.swing.JTextField txt_A_dist;
    private javax.swing.JTextField txt_A_path;
    private javax.swing.JTextField txt_B_dist;
    private javax.swing.JTextField txt_B_path;
    private javax.swing.JTextField txt_C_dist;
    private javax.swing.JTextField txt_C_path;
    private javax.swing.JTextField txt_D_dist;
    private javax.swing.JTextField txt_D_path;
    private javax.swing.JTextField txt_E_dist;
    private javax.swing.JTextField txt_E_path;
    private javax.swing.JTextField txt_F_dist;
    private javax.swing.JTextField txt_F_path;
    private javax.swing.JTextField txt_G_dist;
    private javax.swing.JTextField txt_G_path;
    private javax.swing.JTextField txt_H_dist;
    private javax.swing.JTextField txt_H_path;
    private javax.swing.JTextField txt_I_dist;
    private javax.swing.JTextField txt_I_path;
    private javax.swing.JTextField txt_J_dist;
    private javax.swing.JTextField txt_J_path;
    // End of variables declaration//GEN-END:variables
}
