package GradeBook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GradeBook extends JFrame implements ActionListener
{
	private Container contentPane;
	private JTextField username = new JTextField();
	private JTextField password = new JTextField();
	private JButton login = new JButton("Login");
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
		
		username.setBounds(300,250,100,50);
		username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(username);
		
		password.setBounds(300,350,100,50);
		password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(password);
		
		login.setBounds(300, 450, 100,50);
		contentPane.add(login);
		login.addActionListener(this);
		
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
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof JButton)
		{
			if(e.getSource() == login)
			{
				//
			}
		}
		
		
	}
}
