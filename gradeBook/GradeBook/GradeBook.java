package GradeBook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import GradeBook.Users.*;

public class GradeBook extends JFrame implements ActionListener
{
	private int schoolSize = 0;
	private JFileChooser chooser;
	private Container contentPane;
	private JTextField username = new JTextField();
	private JTextField password = new JTextField();
	private JButton login = new JButton("Login");
	private JButton newAdmin = new JButton("New Admin");
	private JButton openFile = new JButton("Open File");
	private File inFile;
	private File outFile;
	private FileInputStream inFileStream;
	private ObjectInputStream inObjectStream;
	private FileOutputStream outFileStream;
	private ObjectOutputStream outObjectStream;
	private User[] userIndex = new User[100];
	private User currentUser;
	public GradeBook() 
	{
		//
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
		
		newAdmin.setBounds(200, 450, 100,50);
		contentPane.add(newAdmin);
		newAdmin.addActionListener(this);
		
		openFile.setBounds(400, 450, 100,50);
		contentPane.add(openFile);
		openFile.addActionListener(this);
	}
	public static void main(String args[])
	{
		GradeBook frame = new GradeBook();
		frame.setVisible(true);
	}
	private boolean checkPassword(String password)
	{
		int i = 0;
		while(currentUser == null)
		{
			if(userIndex[i].returnPassword().toString() == password)
			{
				currentUser = userIndex[i];
				return true;
			}
			i++;
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof JButton)
		{
			if(e.getSource() == login)
			{ 
				loginprotocol();
				if(currentUser.getClass().toString() ==  "class GradeBook.Users.Admin")
				{
					showAdminPerspective();
				}
				else if(currentUser.getClass().toString() ==  "class GradeBook.Users.Teacher")
				{
					showTeacherPerspective();
				}
				else if(currentUser.getClass().toString() ==  "class GradeBook.Users.Student")
				{
					showStudentPerspective();
				}
			}
			else if(e.getSource() == newAdmin)
			{
				newAdmin();
			}
			else if(e.getSource() == openFile)
			{
				openFile();
			}
		}
		
		
	}
	private void loginprotocol()
	{
		// TODO Auto-generated method stub
		findUser();
		checkPassword(password.getText().toUpperCase());
	}
	private void findUser() throws NullPointerException {
		// TODO Auto-generated method stub
		int i = 0;
		while(i != schoolSize + 1)
		{
			String name = userIndex[0].returnUserName();
			System.out.println(name);
			String loginName = username.getText().toString();
			System.out.println(loginName);
			if(name == loginName)
			{
				currentUser = userIndex[i];
				System.out.println("Here");
			}
			if(i > schoolSize)
			{
				//throw new NullPointerException();
			}
			i++;
		}
		System.out.println("Here 1");
	}
	private void newAdmin() 
	{
		userIndex[0] = new Admin("A", "P");
		saveFile();
	}
	private void showStudentPerspective() {
		// TODO Auto-generated method stub
		
	}
	private void showTeacherPerspective() {
		// TODO Auto-generated method stub
		
	}
	private void showAdminPerspective()
	{
		JButton addNewStudent = new JButton("Add New Student");
		JButton addNewTeacher = new JButton("Add New Teacher");
		addNewStudent.setBounds(250, 500, 100, 50);
		addNewTeacher.setBounds(250, 500, 100, 50);
		contentPane.add(addNewStudent);
		addNewStudent.addActionListener(this);
		contentPane.add(addNewTeacher);
		addNewTeacher.addActionListener(this);
		repaint();
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
			
		}
	}	

}
