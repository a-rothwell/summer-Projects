package chess;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

import gradeBook.GradeBook;

public class Chess extends JFrame implements ActionListener
{
	private Container contentPane;
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
		// TODO Auto-generated constructor stub
	}

	private void setup() 
	{
		createBoard();
		
	}

	private void createBoard() 
	{
		final int XSIZE = 8,YSIZE = 8;
		Tile board[][] = new Tile[XSIZE][YSIZE];
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