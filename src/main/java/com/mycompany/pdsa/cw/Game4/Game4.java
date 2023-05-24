/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdsa.cw.Game4;

/**
 *
 * @author jaden
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author jaden
 */
public class Game4 {
    
    private static final int NUM_CITIES = 10;
    private static final String[] CITY_NAMES = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private static final int MIN_DISTANCE = 5;
    private static final int MAX_DISTANCE = 50;

    private int[][] graph;
    private int[] dist;
    private boolean[] visited;
    private int[] prev;

    public Game4() {
        // Initialize graph with random distances
        graph = new int[NUM_CITIES][NUM_CITIES];
        for (int i = 0; i < NUM_CITIES; i++) {
            for (int j = 0; j < NUM_CITIES; j++) {
                if (i != j) {
                    int distance = (int) (Math.random() * (MAX_DISTANCE - MIN_DISTANCE + 1)) + MIN_DISTANCE;
                    graph[i][j] = distance;
                    graph[j][i] = distance;
                    
                }
            }
        }
        insertDistance();
        
        for(int i = 0; i < 10; i++){
            
            for(int j = 0; j < 10; j++){
                findShortestPath(i, j);
            }
            
        }
    }

    public void findShortestPath(int start, int end) {
        // Initialize variables
        dist = new int[NUM_CITIES];
        visited = new boolean[NUM_CITIES];
        prev = new int[NUM_CITIES];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        // Dijkstra's algorithm
        for (int i = 0; i < NUM_CITIES - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < NUM_CITIES; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            for (int j = 0; j < NUM_CITIES; j++) {
                if (!visited[j] && graph[minIndex][j] != 0 && dist[minIndex] != Integer.MAX_VALUE &&
                        dist[minIndex] + graph[minIndex][j] < dist[j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                    prev[j] = minIndex;
                }
            }
        }

        // Print shortest path and distance
        ArrayList<Integer> pathArray = new ArrayList<>();
        
        System.out.println("Shortest path from " + CITY_NAMES[start] + " to " + CITY_NAMES[end] + ":");
        System.out.print(CITY_NAMES[end]);
        pathArray.add(end);
        int curr = end;
        while (prev[curr] != -1) {
            curr = prev[curr];
            System.out.print(" <- " + CITY_NAMES[curr]);
            pathArray.add(curr);
        }
        System.out.println();
        System.out.println("Shortest distance: " + dist[end] + " km");
        
        insertShortestDistance(start, end, dist[end], pathArray);
    }
    
    public void insertShortestDistance(int cityStart, int cityEnd, int dist, ArrayList path){
        
        Connection con = null;
        PreparedStatement state = null;
        String pathString = (String) path.stream()
                              .map(Object::toString)
                              .collect(Collectors.joining(","));
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game4?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");        

            state = con.prepareStatement("UPDATE distance SET ShortestDistance = ?, ShortestPath = ? WHERE StartPoint = ? AND EndPoint = ?");


                state.setInt(1, dist);
                state.setString(2, pathString);
                state.setInt(3, cityStart);
                state.setInt(4, cityEnd);

                state.executeUpdate();
        
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (state != null) {
                    state.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void insertDistance(){
        Connection con = null;
        PreparedStatement state = null;
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game4?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");        

        state = con.prepareStatement("INSERT INTO distance (StartPoint, EndPoint, Distance) VALUES (?, ?, ?)");
    
            for (int i = 0; i < NUM_CITIES; i++) {
//                        System.out.print(CITY_NAMES[i] + "\t");
            }
            System.out.println();
            for (int i = 0; i < NUM_CITIES; i++) {
                
//                 System.out.print(CITY_NAMES[i] + "\t");
                for (int j = 0; j < NUM_CITIES; j++) {
                        System.out.print(graph[i][j] + "\t");
                        state.setInt(1, i);
                        state.setInt(2, j);
                        state.setInt(3, graph[i][j]);
                        state.executeUpdate();
                    

                }
//                System.out.println();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (state != null) {
                    state.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    

    public static void main(String[] args) {
        
    }
}
