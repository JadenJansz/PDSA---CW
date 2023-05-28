/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdsa.cw.Game1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author jaden
 */
public class EightQueensPuzzle extends JFrame{
    
     private static final int BOARD_SIZE = 8;
    private JButton[][] boardButtons;
    private boolean[][] board;

    public EightQueensPuzzle() {
        super("8 Queens Puzzle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        setLocationRelativeTo(null);

        boardButtons = new JButton[BOARD_SIZE][BOARD_SIZE];
        board = new boolean[BOARD_SIZE][BOARD_SIZE];

        initializeBoardButtons();

        setVisible(true);
    }

    private void initializeBoardButtons() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                final int r = row;
                final int c = col;

                boardButtons[row][col] = new JButton();
                boardButtons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(r, c);
                    }
                });

                add(boardButtons[row][col]);
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        if (!board[row][col]) {
            placeQueen(row, col);
        } else {
            removeQueen(row, col);
        }
        if (isSolutionCorrect(board)) {
            System.out.println("Correct Solution!");
            // Solution is correct
            // Display the "Your answer is correct!" message
            JOptionPane.showMessageDialog(this, "Your answer is correct!");
            checkDuplicateAnswer(board);
        }
    }

    public void placeQueen(int row, int col) {
        if (isSafeToPlace(row, col)) {
            board[row][col] = true;
            boardButtons[row][col].setText("Q");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid move! Queens cannot attack each other.");
        }
    }


    public void removeQueen(int row, int col) {
        if (board[row][col]) {
            board[row][col] = false;
            boardButtons[row][col].setText("");
        }
    }


    public boolean isSafeToPlace(int row, int col) {
        // Check row and column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] || board[i][col]) {
                return false;
            }
        }
        
    isDiagonalSafe(board, row, col);
            return true;
    }

public boolean isSolutionCorrect(boolean[][] board) {
    int queensCount = 0;
    // Check each row for exactly one queen
    for (int row = 0; row < BOARD_SIZE; row++) {
        int queensInRow = 0;
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (board[row][col]) {
                queensInRow++;
                queensCount++;
            }
        }
        if (queensInRow != 1) {
            return false;
        }
    }

    // Check the total number of queens
    if (queensCount != BOARD_SIZE) {
        return false;
    }

    // Check diagonals for conflicts
    for (int row = 0; row < BOARD_SIZE; row++) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (board[row][col]) {
                if (!isDiagonalSafe(board, row, col)) {
                    return true;
                }
            }
        }
    }
    
    return true;
}


private boolean isDiagonalSafe(boolean[][] board, int row, int col) {
    System.out.println("Checking diagonal safety...");

    // Check upper left diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
            return false;
        }
    }

    // Check lower left diagonal
    for (int i = row, j = col; i < BOARD_SIZE && j >= 0; i++, j--) {
        if (board[i][j]) {
            return false;
        }
    }

    // Check upper right diagonal
    for (int i = row, j = col; i >= 0 && j < BOARD_SIZE; i--, j++) {
        if (board[i][j]) {
            return false;
        }
    }

    // Check lower right diagonal
    for (int i = row, j = col; i < BOARD_SIZE && j < BOARD_SIZE; i++, j++) {
        if (board[i][j]) {
            return false;
        }
    }
    return true;
}

public String convertBoardToString(boolean[][] board) {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < BOARD_SIZE; row++) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (board[row][col]) {
                sb.append("Q");
            } else {
                sb.append("-");
            }
        }
        sb.append("\n");
    }
    return sb.toString();
}

private void saveSolutionToDatabase(boolean[][] board, int id) {
        int totalRows = 0;
        if (isSolutionCorrect(board)) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game1?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");

                
                
                String sql = "UPDATE solutions set identified = true WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);

                String boardState = convertBoardToString(board);

                statement.setInt(1, id);
                statement.executeUpdate();
                statement.close();
                
                String checkFlags = "SELECT COUNT(*) AS total_rows FROM solutions WHERE identified = true ";
                PreparedStatement statement1 = connection.prepareStatement(checkFlags);
                ResultSet resultSet = statement1.executeQuery();
                
                if (resultSet.next()) {
                    totalRows = resultSet.getInt("total_rows");
                    
                }
                
                if(totalRows == 10){
                    JOptionPane.showMessageDialog(this, "All solutions are identified");
                    sql = "UPDATE solutions set identified = false";
                    statement = connection.prepareStatement(sql);
                    statement.executeUpdate();
                    statement.close();
                }
                
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error occurred while saving the solution to the database.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid move! Queens cannot attack each other.");
        }
    }

private void checkDuplicateAnswer(boolean[][] board) {
    String boardState = convertBoardToString(board);

    try {
        // Connect to the database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game1?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");

        String sql = "SELECT id,board_state, identified FROM solutions WHERE board_state = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, boardState);

        ResultSet resultSet = statement.executeQuery();
        if(!resultSet.next()){
            System.out.println(boardState);
        }
        
        else{
        do {
                if (resultSet.getBoolean("identified") == true) {
                    JOptionPane.showMessageDialog(this, "This answer is already identified");
                    return;
                } else {
                    System.out.println(boardState);
                    System.out.println(resultSet.getString("board_state"));
                    saveSolutionToDatabase(board, resultSet.getInt("id"));
                    return;
                }
            } while (resultSet.next()); 
        }
        resultSet.close();
        statement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error occurred while checking the duplicate answer in the database.");
    }
}

    public boolean[][] getBoard() {
        return board;
    }

    public void setBoard(boolean[][] board) {
        this.board = board;
    }

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new EightQueensPuzzle();
        }
    });
}
}
