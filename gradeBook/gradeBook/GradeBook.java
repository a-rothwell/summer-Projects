package gradeBook;

import gradeBook.users.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class GradeBook extends JFrame implements ActionListener
{
	private int schoolSize = 100;
	private JFileChooser chooser;
	private Container contentPane;
	private JTextField username = new JTextField();
	private JTextField password = new JTextField();
	private JButton login = new JButton("Login");
	private JButton openFile = new JButton("Open File");
	private JButton logout = new JButton("Logout");
	private JButton addNewStudent = new JButton("Add New Student");
	private JButton addNewTeacher = new JButton("Add New Teacher");
	private JLabel userList[] = new JLabel[schoolSize];
	private File inFile;
	private File outFile;
	private FileInputStream inFileStream;
	private ObjectInputStream inObjectStream;
	private FileOutputStream outFileStream;
	private ObjectOutputStream outObjectStream;
	private User[] userIndex = new User[schoolSize];
	private User currentUser;
	public GradeBook() 
	{
		contentPane = getContentPane();
		contentPane.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("GradeBook Window");
		setSize(700,700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		username.setBounds(300,250,100,50);
		username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		password.setBounds(300,350,100,50);
		password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		login.setBounds(300, 450, 100,50);
		login.addActionListener(this);
		openFile.setBounds(400, 450, 100,50);
		openFile.addActionListener(this);
		addNewStudent.setBounds(250, 500, 200, 50);
		addNewStudent.addActionListener(this);
		addNewTeacher.setBounds(250, 550, 200, 50);
		addNewTeacher.addActionListener(this);
		logout.setBounds(0,0,50,50);
		logout.addActionListener(this);
		loginView();
	}
	public static void main(String args[])
	{
		GradeBook frame = new GradeBook();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof JButton)
		{
			if(e.getSource() == login)
			{ 
				loginprotocol();
			}
			else if(e.getSource() == openFile)
			{
				openFile();
			}
			else if(e.getSource() == logout)
			{
				logout();
			}
			else if(e.getSource() == addNewTeacher)
			{
				addNewTeacher();
			}
			else if(e.getSource() == addNewStudent)
			{
				addNewStudent();
			}
		}
	}
	private void logout() 
	{
		saveFile();
		currentUser = null;
		clearCurrentView();
		loginView();
	}
	private void loginView() 
	{
		contentPane.add(username);
		contentPane.add(password);
		contentPane.add(login);
		contentPane.add(openFile);
		repaint();
	}
	private void clearCurrentView() 
	{
		contentPane.removeAll();
		repaint();
	}
	private void loginprotocol()
	{
		findUser();
		if(checkPassword(password.getText()))
		{
			changeView();
		}
		else
		{
			compatiblityMismatch();
		}
		username.setText(null);
		password.setText(null);
	}
	private void changeView() 
	{
		clearCurrentView();
		if(currentUser.getClass().toString().equals("class GradeBook.Users.Admin"))
		{
			showAdminPerspective();
		}
		else if(currentUser.getClass().toString().equals("class GradeBook.Users.Teacher"))
		{
			showTeacherPerspective();
		}
		else if(currentUser.getClass().toString().equals("class GradeBook.Users.Student"))
		{
			showStudentPerspective();
		}
	}
	private boolean checkPassword(String password)
	{
		if(currentUser.returnPassword().equals(password))
		{
			System.out.println("Password Correct");
			return true;
		}
		else
		{
			return false;
		}
	}
	private void compatiblityMismatch() 
	{
		username.setText(null);
		password.setText(null);
		System.out.println("Incorrect Username or Password");
	}
	private void findUser() 
	{
		int i = 0;
		while(currentUser == null)
		{
			try
			{
				String name = userIndex[i].returnUserName();
				String loginName = username.getText().toString();
				if(name.equals(loginName))
				{
					currentUser = userIndex[i];
					System.out.println("Found User");
				}
				i++;
			}
			catch(NullPointerException e)
			{
				i++;
			}
			catch(IndexOutOfBoundsException e)
			{
				compatiblityMismatch();
				break;
			}
		}
	}
	private void addNewStudent()
	{
		
		
	}
	private void addNewTeacher()
	{
		// TODO Auto-generated method stub
		
	}
	private void showStudentPerspective() 
	{
		// TODO Auto-generated method stub
		
	}
	private void showTeacherPerspective() 
	{
		// TODO Auto-generated method stub
		
	}
	private void showAdminPerspective()
	{
		contentPane.add(logout);
		contentPane.add(addNewStudent);
		contentPane.add(addNewTeacher);
		showUsers();
		repaint();
	}
	private void showUsers() {
		// TODO Auto-generated method stub
		
	}
	private void openFile()
	{
		chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		inFile = chooser.getSelectedFile();
		try
		{
			inFileStream = new FileInputStream(inFile);
			inObjectStream = new ObjectInputStream(inFileStream);
			try
			{
				userIndex = (User[])inObjectStream.readObject();	
			}
			catch(ClassNotFoundException e)
			{
			}
			inObjectStream.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}	
	private void saveFile()
	{
		chooser = new JFileChooser();
		chooser.showSaveDialog(null);
		outFile = chooser.getSelectedFile();
		try
		{
			outFileStream = new FileOutputStream(outFile);
			outObjectStream = new ObjectOutputStream(outFileStream);
			outObjectStream.writeObject(userIndex);
			outObjectStream.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}	
}
