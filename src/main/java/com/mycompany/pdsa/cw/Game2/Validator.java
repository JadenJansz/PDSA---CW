/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdsa.cw.Game2;

import javax.swing.JTextField;

/**
 *
 * @author jaden
 */
public class Validator {
    
    public static void validateBinary(JTextField text)
    {
        if (!text.getText().isEmpty()) {
        for (int i = 0; i < text.getText().length(); i++) {
            char c = text.getText().charAt(i);
            if (c != '0' && c != '1') {
                String s = text.getText().substring(0, i);
                text.setText(null);
                text.setText(s);
            }
        }
        } else {
            return;
        }
    }
    
    public static void validateLettersAndNumbers(JTextField text) {
        if (!text.getText().isEmpty()) {
        for (int i = 0; i < text.getText().length(); i++) {
            char c = text.getText().charAt(i);

            if (!Character.isLetterOrDigit(c)) {
                String s = text.getText().substring(0, i);
                text.setText(s);
            }
        }
        } else {
            return;
        }
    }
}
