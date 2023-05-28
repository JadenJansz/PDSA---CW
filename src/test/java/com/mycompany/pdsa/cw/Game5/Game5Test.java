/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.pdsa.cw.Game5;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaden
 */
public class Game5Test {
    
    private Game5 game;

    /**
     * Test of main method, of class Game5.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Game5.main(args);
    }

    /**
     * Test of prim method, of class Game5.
     */
    @Test
    public void testPrim() {
        System.out.println("prim");
        int startCity = 0;
        List<Integer> expResult = null;
        List<Integer> mst = game.prim(2);
        //Input is dynamic therfore test fails
        assertEquals(expResult, mst);
    }

    /**
     * Test of insertDistance method, of class Game5.
     */
    @Test
    public void testInsertDistance() {
        System.out.println("insertDistance");
        int[][] distance = {
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                                {21,33,52,65,47,68,74,33,64,20},
                           };
        Game5.insertDistance(distance);
    }

    /**
     * Test of validateAnswer method, of class Game5.
     */
    @Test
    public void testValidateAnswer() {
        System.out.println("validateAnswer");
        List<Integer> correctSolution = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> playerSolution = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertTrue(game.validateAnswer(correctSolution, playerSolution));
    }

    /**
     * Test of computeShortestDistance method, of class Game5.
     */
    @Test
    public void testComputeShortestDistance() {
        System.out.println("computeShortestDistance");
        List<Integer> cities = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int userDistance = 200;
        assertTrue(game.computeShortestDistance(cities, userDistance));
    }
    
}
