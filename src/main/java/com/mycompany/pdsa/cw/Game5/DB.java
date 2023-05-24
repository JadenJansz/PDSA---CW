/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdsa.cw.Game5;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jaden
 */
public class DB {
    public static Connection createConnection() throws Exception
    {
        
        String url = "jdbc:mysql://localhost:3306/game5?zeroDateTimeBehavior=CONVERT_TO_NULL";
        
        Connection con = DriverManager.getConnection(url,"root","");
        
        return con;
    }
}
