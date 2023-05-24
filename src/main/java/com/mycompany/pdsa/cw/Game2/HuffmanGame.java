/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdsa.cw.Game2;

/**
 *
 * @author jaden
 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanGame {
    private static Node huffmanTreeRoot;
    
    public String encodeString(String input) {
        // Compute frequency of each character in the input string
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue to hold the Huffman tree nodes
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (char c : freqMap.keySet()) {
            pq.offer(new Node(c, freqMap.get(c)));
        }

        // Build the Huffman tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.offer(new Node('\0', left.freq + right.freq, left, right));
        }

        // Store the root of the Huffman tree
        huffmanTreeRoot = pq.peek();

        // Create a lookup table to store the Huffman codes for each character
        Map<Character, String> codeMap = new HashMap<>();
        buildCodeMap(huffmanTreeRoot, "", codeMap);

        // Encode the input string using the Huffman codes
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(codeMap.get(c));
        }
        return sb.toString();
    }

    public String decodeString(String input) {
        if (huffmanTreeRoot == null) {
            System.out.println("Please encode a string first.");
        }

    // Decode the input string using the Huffman tree
    StringBuilder sb = new StringBuilder();
    Node curr = huffmanTreeRoot;
    for (char c : input.toCharArray()) {
        if (c == '0') {
            curr = curr.left;
        } else if (c == '1') {
            curr = curr.right;
        }
        if (curr.isLeaf()) {
            sb.append(curr.ch);
            curr = huffmanTreeRoot;
        }
    }
    return sb.toString();
}


    // Helper method to build the Huffman codes lookup table
    public void buildCodeMap(Node node, String code, Map<Character, String> codeMap) {
    if (node.isLeaf()) {
        codeMap.put(node.ch, code);
        return;
    }
    buildCodeMap(node.left, code + "0", codeMap);
    buildCodeMap(node.right, code + "1", codeMap);
}

    // Inner class to represent a node in the Huffman tree
    public static class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }

    public int compareTo(Node other) {
        return Integer.compare(this.freq, other.freq);
    }
}

    public boolean validateAnswer(String originalString, String answer) {
    String encodedString = encodeString(originalString);
    return encodedString.equals(answer);
    }
}