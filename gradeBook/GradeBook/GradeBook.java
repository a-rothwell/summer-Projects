package GradeBook;

import java.awt.*;
import javax.swing.*;

public class GradeBook extends JFrame 
{
	private Container contentPane;
	
	public GradeBook() 
	{
		// TODO Auto-generated constructor stub
		contentPane = getContentPane();
		contentPane.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("GradeBook");
		setSize(700,700);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	public static void main(String args[])
	{
		GradeBook frame = new GradeBook();
		frame.setVisible(true);
	}
	private boolean checkPassword(String userName, String password)
	{
		return false;
	}
}
