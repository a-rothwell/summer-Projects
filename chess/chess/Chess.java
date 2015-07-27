package chess;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

import gradeBook.GradeBook;

public class Chess extends JFrame implements ActionListener
{
	private final Icon BLACK_PAWN = new ImageIcon("black_pawn.png");
	private final Icon WHITE_PAWN = new ImageIcon("white_pawn.png");
	private Container contentPane;
	private final int XSIZE = 8,YSIZE = 8;
	private Tile board[][] = new Tile[XSIZE][YSIZE];
	public Chess() 
	{
		contentPane = getContentPane();
		contentPane.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Chess");
		setSize(700,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setup();
	}

	private void setup() 
	{
		createBoard();
		setPeices();
		repaint();
	}

	private void setPeices() 
	{
		//Sets both colors of pawns
		for(int i = 0; i < 8;i++)
		{
			board[i][1].setIcon(BLACK_PAWN);
			board[i][6].setIcon(WHITE_PAWN);
			System.out.println("Icons set");
		}
		repaint();
	}

	private void createBoard() 
	{
		for(int i = 0; i<XSIZE; i++)
		{
			for(int j = 0; j<YSIZE; j++)
			{
				board[i][j] = new Tile(i,j);
				board[i][j].setBounds(50 * i + 100, 50*j + 100, 50, 50);
				board[i][j].addActionListener(this);
				contentPane.add(board[i][j]);
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Chess chess = new Chess();
		chess.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}