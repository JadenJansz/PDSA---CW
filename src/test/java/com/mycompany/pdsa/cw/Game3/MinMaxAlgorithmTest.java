/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.pdsa.cw.Game3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaden
 */
public class MinMaxAlgorithmTest {

    /**
     * Test of Move method, of class MinMaxAlgorithm.
     */
    @Test
    public void testMove() {
        System.out.println("Move");
        int pos = 0;
        int player = 0;
        MinMaxAlgorithm instance = new MinMaxAlgorithm();
        boolean expResult = false;
        boolean result = instance.Move(pos, player);
        assertEquals(expResult, result);
    }

    /**
     * Test of GenerateMove method, of class MinMaxAlgorithm.
     */
    @Test
    public void testGenerateMove() {
        System.out.println("GenerateMove");
        int Player = 0;
        MinMaxAlgorithm instance = new MinMaxAlgorithm();
        int expResult = 0;
        int result = instance.GenerateMove(Player);
        assertEquals(expResult, result);
    }

    /**
     * Test of getX method, of class MinMaxAlgorithm.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        MinMaxAlgorithm instance = new MinMaxAlgorithm();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getO method, of class MinMaxAlgorithm.
     */
    @Test
    public void testGetO() {
        System.out.println("getO");
        MinMaxAlgorithm instance = new MinMaxAlgorithm();
        int expResult = 0;
        int result = instance.getO();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBoard method, of class MinMaxAlgorithm.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        MinMaxAlgorithm instance = new MinMaxAlgorithm();
        int expResult = 0;
        int result = instance.getBoard();
        assertEquals(expResult, result);
    }

    /**
     * Test of NewGame method, of class MinMaxAlgorithm.
     */
    @Test
    public void testNewGame() {
        System.out.println("NewGame");
        MinMaxAlgorithm instance = new MinMaxAlgorithm();
        instance.NewGame();
    }

    /**
     * Test of isGameOver method, of class MinMaxAlgorithm.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        MinMaxAlgorithm instance = new MinMaxAlgorithm();
        int expResult = 0;
        int result = instance.isGameOver();
        assertEquals(expResult, result);
    }
    
}
