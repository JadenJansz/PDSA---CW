/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdsa.cw.Game5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author jaden
 */
public class Game5 {
    
    

    private static final int NUM_CITIES = 10;
    private static final int MIN_DISTANCE = 10;
    private static final int MAX_DISTANCE = 100;
    private static final String[] CITY_NAMES = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private static int[][] distances;
    
    public Game5(){
        distances = generateRandomDistances();
        
        List<Integer> mst = prim(2);

        System.out.println("Correct Solution:");
        for (int i = 1; i < NUM_CITIES; i++) {
            int cityA = mst.get(i);
            int cityB = i;
            int distance = distances[cityA][cityB];
            System.out.println("City " + (char) ('A' + cityA) + " - City " + (char) ('A' + cityB) + ": " + distance + " km");
        }
    }
    

    public static void main(String[] args) {
        // Generate random distances between cities
        int[][] distances = generateRandomDistances();

        Random random = new Random();
        int startCity = random.nextInt(NUM_CITIES);

        
    }

    private static int[][] generateRandomDistances() {
        Random random = new Random();
        int[][] distances = new int[NUM_CITIES][NUM_CITIES];
        for (int i = 0; i < NUM_CITIES; i++) {
            for (int j = 0; j < NUM_CITIES; j++) {
                if (i == j) {
                    distances[i][j] = 0; // Distance from a city to itself is 0
                } else {
                    distances[i][j] = random.nextInt(MAX_DISTANCE - MIN_DISTANCE + 1) + MIN_DISTANCE;
                }
            }
        }
        insertDistance(distances);
        return distances;
    }

    static List<Integer> prim(int startCity) {
        List<Integer> mst = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));

        // Start with the specified starting city
        mst.add(startCity);
        visited.add(startCity);

        // Add all edges from the starting city to the minHeap
        for (int i = 0; i < NUM_CITIES; i++) {
            if (i != startCity) {
                minHeap.add(new Edge(startCity, i, distances[startCity][i]));
            }
        }

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int cityA = edge.cityA;
            int cityB = edge.cityB;

            if (visited.contains(cityB)) {
                continue;
            }

            // Add the edge and cityB to the MST
            mst.add(cityB);
            visited.add(cityB);

            // Add all edges from cityB to unvisited cities to the minHeap
            for (int i = 0; i < NUM_CITIES; i++) {
                if (!visited.contains(i) && distances[cityB][i] != 0) {
                    minHeap.add(new Edge(cityB, i, distances[cityB][i]));
                }
            }
        }

        return mst;
    }
    
    public static void insertDistance(int [][] distance){
        PreparedStatement state = null;
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DB.createConnection();        

        state = con.prepareStatement("INSERT INTO distance (StartPoint, EndPoint, Distance) VALUES (?, ?, ?)");
    
            for (int i = 0; i < NUM_CITIES; i++) {
//                        System.out.print(CITY_NAMES[i] + "\t");
            }
            System.out.println();
            for (int i = 0; i < NUM_CITIES; i++) {
                
//                 System.out.print(CITY_NAMES[i] + "\t");
                for (int j = 0; j < NUM_CITIES; j++) {
                    System.out.print(distance[i][j] + "\t");
                    state.setInt(1, i);
                    state.setInt(2, j);
                    state.setInt(3, distance[i][j]);
                    state.executeUpdate();
                    

                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static boolean validateAnswer(List<Integer> correctSolution, List<Integer> playerSolution) {
        
        if (correctSolution.size() != playerSolution.size()) {
            return false;
        }

        // Check if the answer connects the cities correctly
        for (int i = 1; i < correctSolution.size(); i++) {
            int cityA = correctSolution.get(i);
            int cityB = correctSolution.get(i - 1);

            if (!playerSolution.contains(cityA) || !playerSolution.contains(cityB)) {
                return false; // Missing a city in the answer
            }

            int distance = distances[cityA][cityB];

            if (playerSolution.indexOf(cityA) != playerSolution.indexOf(cityB) + 1
                    && playerSolution.indexOf(cityA) != playerSolution.indexOf(cityB) - 1) {
                return false; // Cities are not connected in the correct order
            }

            if (playerSolution.indexOf(cityA) < playerSolution.indexOf(cityB) && distance != 0) {
                return false; // Distance is not zero for an incorrect connection
            }

            if (playerSolution.indexOf(cityA) > playerSolution.indexOf(cityB) && distance == 0) {
                return false; // Distance is zero for an incorrect connection
            }
        }

        return true;
    }
    
    static boolean computeShortestDistance(List<Integer> cities, int userDistance) {
        int distance = 0;
        for (int i = 1; i < cities.size(); i++) {
            int cityA = cities.get(i - 1);
            int cityB = cities.get(i);
            int edgeDistance = distances[cityA][cityB];
            if (edgeDistance == 0) {
                return false;
            }
            distance += edgeDistance;
        }
        System.out.print("Distance " + distance + " " + userDistance);
        
        return distance == userDistance;
    }

    private static class Edge {
        int cityA;
        int cityB;
        int distance;

        Edge(int cityA, int cityB, int distance) {
            this.cityA = cityA;
            this.cityB = cityB;
            this.distance = distance;
        }
    }
}