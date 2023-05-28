/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.pdsa.cw.Game2;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jaden
 */
public class HuffmanGameTest {

    /**
     * Test of getLookupTable method, of class HuffmanGame.
     */
    @Test
    public void testGetLookupTable() {
        HuffmanGame huffmanGame = new HuffmanGame();
        String input = "DOD9EPVK";
        String expectedLookupTable = "{P=110, D=00, E=011, V=101, 9=010, K=100, O=111}";
        
        huffmanGame.encodeString(input);
        Map<Character, String> lookupTable = huffmanGame.getLookupTable();
        
        Assert.assertEquals(expectedLookupTable, lookupTable.toString());
    }

    /**
     * Test of encodeWithSpace method, of class HuffmanGame.
     */
    @Test
    public void testEncodeWithSpace() {
        HuffmanGame huffmanGame = new HuffmanGame();
        String input = "ABBCCCDDDDEEEEE";
        String expectedOutput = "010 011 011 00 00 00 10 10 10 10 11 11 11 11 11 ";
        
        String encodedString = huffmanGame.encodeWithSpace(input);
        
        Assert.assertEquals(expectedOutput, encodedString);
    }

    /**
     * Test of encodeString method, of class HuffmanGame.
     */
    @Test
    public void testEncodeString() {
        HuffmanGame huffmanGame = new HuffmanGame();
        String input = "VVVKFKPEBD31OLOTFM5RY06ZYZH";
        String expectedOutput = "0100100101110101011100110001110110101101110111011110001011000000101010110001100100111001011011111010001001100011111";
        
        String encodedString = huffmanGame.encodeString(input);
        
        Assert.assertEquals(expectedOutput, encodedString);
    }

    /**
     * Test of decodeString method, of class HuffmanGame.
     */
    @Test
    public void testDecodeString() {
        HuffmanGame huffmanGame = new HuffmanGame();
        String input = "00010100101010110000100011011001001101010010111111011011000111 ";
        String expectedOutput = "XUVJCTE0NOLKKS7I";

        // Encode the string first
        String encodedString = huffmanGame.encodeString(expectedOutput);

        // Decode the encoded string
        String decodedString = huffmanGame.decodeString(input);

        System.out.println("Expected: " + expectedOutput);
        System.out.println("Actual: " + decodedString);

        Assert.assertEquals(expectedOutput, decodedString);
    }
    
}
