/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdsa.cw.Game3;

import com.mycompany.pdsa.cw.HomeScreen;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jaden
 */
public class TicTacToe extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public class JLabelBox extends JLabel {

		private static final long serialVersionUID = 1L;
		public int Field = 0;
	}

	private int XWins = 0;
	private int OWins = 0;
	private int Draws = 0;

	private JPanel contentPane;
	private JButton btnNewGame, btnReset, btnBack;
	private JLabelBox P1, P2, P3, P4, P5, P6, P7, P8, P9;
	private JLabel lblPlayer, lblComp, lblDraws;
	private MinMaxAlgorithm MiniMax;
	private JLabel lblPlayerWins;
	private JLabel lblCompWins;
	private JLabel lblDraws_1;
        private JLabel message;
        Border blackline = BorderFactory.createLineBorder(Color.black);

        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TicTacToe() {
		MiniMax = new MinMaxAlgorithm();
		setResizable(false);
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
                contentPane.setLayout(null);
                
                btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setBounds(10, 5, 80, 20);
		contentPane.add(btnBack);

		P1 = new JLabelBox();
		P1.Field = 1;
		P1.addMouseListener(new LabelAdapter(P1));
		P1.setFont(new Font("Tahoma", Font.BOLD, 36));
                P1.setBorder(blackline);
		P1.setForeground(Color.BLUE);
		P1.setBackground(Color.WHITE);
		P1.setHorizontalAlignment(SwingConstants.CENTER);
		P1.setBounds(10, 33, 64, 64);
		P1.setOpaque(true);
		contentPane.add(P1);

		P2 = new JLabelBox();
		P2.Field = 2;
		P2.addMouseListener(new LabelAdapter(P2));
		P2.setOpaque(true);
		P2.setHorizontalAlignment(SwingConstants.CENTER);
		P2.setForeground(Color.BLUE);
		P2.setFont(new Font("Tahoma", Font.BOLD, 36));
                P2.setBorder(blackline);
		P2.setBackground(Color.WHITE);
		P2.setBounds(76, 33, 64, 64);
		contentPane.add(P2);

		P3 = new JLabelBox();
		P3.Field = 3;
		P3.addMouseListener(new LabelAdapter(P3));
		P3.setOpaque(true);
		P3.setHorizontalAlignment(SwingConstants.CENTER);
		P3.setForeground(Color.BLUE);
		P3.setFont(new Font("Tahoma", Font.BOLD, 36));
                P3.setBorder(blackline);
		P3.setBackground(Color.WHITE);
		P3.setBounds(142, 33, 64, 64);
		contentPane.add(P3);

		P4 = new JLabelBox();
		P4.Field = 4;
		P4.addMouseListener(new LabelAdapter(P4));
		P4.setOpaque(true);
		P4.setHorizontalAlignment(SwingConstants.CENTER);
		P4.setForeground(Color.BLUE);
		P4.setFont(new Font("Tahoma", Font.BOLD, 36));
                P4.setBorder(blackline);
		P4.setBackground(Color.WHITE);
		P4.setBounds(10, 99, 64, 64);
		contentPane.add(P4);

		P5 = new JLabelBox();
		P5.Field = 5;
		P5.addMouseListener(new LabelAdapter(P5));
		P5.setOpaque(true);
		P5.setHorizontalAlignment(SwingConstants.CENTER);
		P5.setForeground(Color.BLUE);
		P5.setFont(new Font("Tahoma", Font.BOLD, 36));
                P5.setBorder(blackline);
		P5.setBackground(Color.WHITE);
		P5.setBounds(76, 99, 64, 64);
		contentPane.add(P5);

		P6 = new JLabelBox();
		P6.Field = 6;
		P6.addMouseListener(new LabelAdapter(P6));
		P6.setOpaque(true);
		P6.setHorizontalAlignment(SwingConstants.CENTER);
		P6.setForeground(Color.BLUE);
		P6.setFont(new Font("Tahoma", Font.BOLD, 36));
                P6.setBorder(blackline);
		P6.setBackground(Color.WHITE);
		P6.setBounds(142, 99, 64, 64);
		contentPane.add(P6);

		P7 = new JLabelBox();
		P7.Field = 7;
		P7.addMouseListener(new LabelAdapter(P7));
		P7.setOpaque(true);
		P7.setHorizontalAlignment(SwingConstants.CENTER);
		P7.setForeground(Color.BLUE);
		P7.setFont(new Font("Tahoma", Font.BOLD, 36));
                P7.setBorder(blackline);
		P7.setBackground(Color.WHITE);
		P7.setBounds(10, 165, 64, 64);
		contentPane.add(P7);

		P8 = new JLabelBox();
		P8.Field = 8;
		P8.addMouseListener(new LabelAdapter(P8));
		P8.setOpaque(true);
		P8.setHorizontalAlignment(SwingConstants.CENTER);
		P8.setForeground(Color.BLUE);
		P8.setFont(new Font("Tahoma", Font.BOLD, 36));
                P8.setBorder(blackline);
		P8.setBackground(Color.WHITE);
		P8.setBounds(76, 165, 64, 64);
		contentPane.add(P8);

		P9 = new JLabelBox();
		P9.Field = 9;
		P9.addMouseListener(new LabelAdapter(P9));
		P9.setOpaque(true);
		P9.setHorizontalAlignment(SwingConstants.CENTER);
		P9.setForeground(Color.BLUE);
		P9.setFont(new Font("Tahoma", Font.BOLD, 36));
                P9.setBorder(blackline);
		P9.setBackground(Color.WHITE);
		P9.setBounds(142, 165, 64, 64);
		contentPane.add(P9);
                
                message = new JLabel("");
		message.setFont(new Font("Tahoma", Font.BOLD, 14));
		message.setHorizontalAlignment(SwingConstants.CENTER);
                message.setForeground(Color.RED);
		message.setBounds(10, 5, 200, 20);
		contentPane.add(message);

		lblPlayerWins = new JLabel("Player Wins:");
		lblPlayerWins.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlayerWins.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerWins.setBounds(226, 33, 150, 36);
		contentPane.add(lblPlayerWins);
                
                lblPlayer = new JLabel("0");
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlayer.setBounds(400, 33, 169, 36);
		contentPane.add(lblPlayer);

		lblCompWins = new JLabel("Computer Wins:");
		lblCompWins.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCompWins.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompWins.setBounds(226, 66, 150, 36);
		contentPane.add(lblCompWins);
                
                lblComp = new JLabel("0");
		lblComp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblComp.setBounds(400, 66, 169, 36);
		contentPane.add(lblComp);

		lblDraws_1 = new JLabel("Game Draws:");
		lblDraws_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDraws_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDraws_1.setBounds(226, 104, 150, 30);
		contentPane.add(lblDraws_1);     
                
                lblDraws = new JLabel("0");
		lblDraws.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDraws.setBounds(400, 104, 169, 30);
		contentPane.add(lblDraws);
                
                btnNewGame = new JButton("New game");
		btnNewGame.addActionListener(this);
		btnNewGame.setBounds(226, 160, 185, 30);
		contentPane.add(btnNewGame);
                
                btnReset = new JButton("Reset");
		btnReset.setBounds(226, 200, 185, 30);
		btnReset.addActionListener(this);
		contentPane.add(btnReset);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnNewGame) {
                        message.setText("");
			P1.setText("");
			P2.setText("");
			P3.setText("");
			P4.setText("");
			P5.setText("");
			P6.setText("");
			P7.setText("");
			P8.setText("");
			P9.setText("");
			MiniMax.NewGame();
		}

		if (e.getSource() == btnReset) {
			SetCounters(0);
                        message.setText("");
			P1.setText("");
			P2.setText("");
			P3.setText("");
			P4.setText("");
			P5.setText("");
			P6.setText("");
			P7.setText("");
			P8.setText("");
			P9.setText("");
			MiniMax.NewGame();
		}
                
                if(e.getSource() == btnBack){
                    HomeScreen home = new HomeScreen();
                    home.setVisible(rootPaneCheckingEnabled);
                    dispose();
                }
	}

	public void SetCounters(int Num) {
		switch (Num) {
		case 1:
			XWins++;
                        message.setText("Player Wins !");
			break;
		case -1:
			OWins++;
                        message.setText("Computer Wins !");
			break;
		case 2:
			Draws++;
                        message.setText("Game Draw !");
			break;
		case 0:
			XWins = 0;
			OWins = 0;
			Draws = 0;
			break;
		}
		lblPlayer.setText(XWins + "");
		lblComp.setText(OWins + "");
		lblDraws.setText(Draws + "");
	}

	class LabelAdapter extends MouseAdapter {
		JLabelBox sender;

		public LabelAdapter(JLabelBox sender) {
			this.sender = sender;
		}

		public void mouseReleased(MouseEvent me) {
			int GO = MiniMax.isGameOver();
			if (MiniMax.Move(sender.Field, 1) && GO == 0) {
				sender.setForeground(Color.BLUE);
				sender.setText("X");
				ComputerMove(-1, Color.RED,0);
				if ((GO = MiniMax.isGameOver()) != 0)
					SetCounters(GO);
			}
		}
	}

	private void NewGame() {
		P1.setText("");
		P2.setText("");
		P3.setText("");
		P4.setText("");
		P5.setText("");
		P6.setText("");
		P7.setText("");
		P8.setText("");
		P9.setText("");
		MiniMax.NewGame();
	}
	
	private void ComputerMove(int player, Color pcolor,int move) {
		if (move==0) 
			move = MiniMax.isGameOver() == 0 ? MiniMax.GenerateMove(player) : 0;
		String PText = (player == 1) ? "X" : "O";

		switch (move) {
		case 1:
			P1.setForeground(pcolor);
			P1.setText(PText);
			MiniMax.Move(move, player);
			break;
		case 2:
			P2.setForeground(pcolor);
			P2.setText(PText);
			MiniMax.Move(move, player);
			break;
		case 3:
			P3.setForeground(pcolor);
			P3.setText(PText);
			MiniMax.Move(move, player);
			break;
		case 4:
			P4.setForeground(pcolor);
			P4.setText(PText);
			MiniMax.Move(move, player);
			break;
		case 5:
			P5.setForeground(pcolor);
			P5.setText(PText);
			MiniMax.Move(move, player);
			break;
		case 6:
			P6.setForeground(pcolor);
			P6.setText(PText);
			MiniMax.Move(move, player);
			break;
		case 7:
			P7.setForeground(pcolor);
			P7.setText(PText);
			MiniMax.Move(move, player);
			break;
		case 8:
			P8.setForeground(pcolor);
			P8.setText(PText);
			MiniMax.Move(move, player);
			break;
		case 9:
			P9.setForeground(pcolor);
			P9.setText(PText);
			MiniMax.Move(move, player);
			break;
		}

	}
}
