/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.pdsa.cw.Game4;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaden
 */
public class Game4Test {

    private Game4 game;

    @Before
    public void setUp() {
        game = new Game4();
    }

    @Test
    public void testFindShortestPath() {
        // Test the shortest path between two cities
        game.findShortestPath(0, 1);
        game.findShortestPath(2, 5);
    }

    
}
