/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdsa.cw.Game4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jaden
 */
public class ManageInputs {
     private Boolean playerSaved = false;
    
    public ManageInputs(){
        
    }
    
    public Boolean compareInputsShortestDistance(String sourceCity, int city, String input, String player){
        
        try{
            
            Connection con = DB.createConnection();
            PreparedStatement state = con.prepareStatement("SELECT ShortestDistance, ID FROM distance "
                    + "WHERE EndPoint = ? AND StartPoint = (SELECT CityID FROM city WHERE CityName = ?)");
            
            state.setInt(1, city);
            state.setString(2, sourceCity);
            
            ResultSet rs = state.executeQuery();
            
            while(rs.next()){
                if(Integer.parseInt(input) == rs.getInt("ShortestDistance")){
                    
                    saveAnswerToDatabase(player, rs.getInt("ID"));
                    
                    return true;
                }else{
                    return false;
                }
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public Boolean compareInputsShortestPath(String sourceCity, int city, String input, String player){
        
        try{
            Connection con = DB.createConnection();
            PreparedStatement state = con.prepareStatement("SELECT ShortestPath, ID FROM distance "
                    + "WHERE EndPoint = ? AND StartPoint = (SELECT CityID FROM city WHERE CityName = ?)");
            
            state.setInt(1, city);
            state.setString(2, String.valueOf(sourceCity));
            
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                String shortestPath = rs.getString("ShortestPath");
                String reversedPath = new StringBuilder(String.valueOf(shortestPath)).reverse().toString();
                
                String[] numbers = reversedPath.split(",");
                StringBuilder result = new StringBuilder();

                for (String number : numbers) {
                    int index = Integer.parseInt(number);
                    char letter = (char) ('A' + index);
                    result.append(letter);
                }
                if (input.toUpperCase().equals(result.toString())) {
                    saveAnswerToDatabase(player, rs.getInt("ID"));
                    return true;
                } else {
                    return false;
                }   
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public void saveAnswerToDatabase(String player, int input){
        
        try{
            Connection con = DB.createConnection();
            
            if(!playerSaved){
                
                PreparedStatement state = con.prepareStatement("INSERT INTO player(PlayerName) VALUES (?)");
                state.setString(1, player);
                state.executeUpdate();
                playerSaved = true;
            }
            
            
            PreparedStatement state1 = con.prepareStatement("SELECT PlayerID from player WHERE PlayerName = ?");
            state1.setString(1, player);
            
            ResultSet rs = state1.executeQuery();
            
            while(rs.next()){
                PreparedStatement state2 = con.prepareStatement("INSERT INTO answers(PlayerID, DistanceID) VALUES(?,?)");
                state2.setInt(1, rs.getInt("PlayerID"));
                state2.setInt(2, input);
                state2.executeUpdate();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Player Already Exists", "Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
