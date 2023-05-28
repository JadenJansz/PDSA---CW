/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.pdsa.cw.Game1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jaden
 */
public class EightQueensPuzzleTest {
    
    private EightQueensPuzzle puzzle;

    @Before
    public void setUp() {
        puzzle = new EightQueensPuzzle();
    }

    @Test
    public void testPlaceQueen() {
        puzzle.placeQueen(0, 0);
        boolean[][] board = puzzle.getBoard();
        Assert.assertTrue(board[0][0]);
    }

    @Test
    public void testRemoveQueen() {
        puzzle.placeQueen(0, 0);
        puzzle.removeQueen(0, 0);
        boolean[][] board = puzzle.getBoard();
        Assert.assertFalse(board[0][0]);
    }

    @Test
    public void testIsSafeToPlace() {
        puzzle.placeQueen(0, 0);
        boolean safe = puzzle.isSafeToPlace(1, 0);
        Assert.assertFalse(safe);
    }

    @Test
    public void testIsSolutionCorrect() {
        // Create a correct solution board
        boolean[][] board = {
            {false, true, false, false, false, false, false, false},
            {false, false, false, false, false, false, true, false},
            {false, false, false, false, true, false, false, false},
            {false, false, false, false, false, false, false, true},
            {false, false, true, false, false, false, false, false},
            {true, false, false, false, false, false, false, false},
            {false, false, false, true, false, false, false, false},
            {false, false, false, false, false, true, false, false}
        };

        puzzle.setBoard(board);
        boolean solutionCorrect = puzzle.isSolutionCorrect(board);
        Assert.assertTrue(solutionCorrect);
    }

    @Test
    public void testConvertBoardToString() {
        boolean[][] board = {
            {false, true, false, false, false, false, false, false},
            {false, false, false, false, false, false, true, false},
            {false, false, false, false, true, false, false, false},
            {false, false, false, false, false, false, false, true},
            {false, false, true, false, false, false, false, false},
            {true, false, false, false, false, false, false, false},
            {false, false, false, true, false, false, false, false},
            {false, false, false, false, false, true, false, false}
        };

        String expectedString = "-Q------\n" +
                                "------Q-\n" +
                                "----Q---\n" +
                                "-------Q\n" +
                                "--Q-----\n" +
                                "Q-------\n" +
                                "---Q----\n" +
                                "-----Q--\n";

        String convertedString = puzzle.convertBoardToString(board);
        System.out.print(convertedString);
        Assert.assertEquals(expectedString, convertedString);
    }


    
}
