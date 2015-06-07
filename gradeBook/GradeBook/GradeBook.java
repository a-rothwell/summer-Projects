package GradeBook;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import GradeBook.Users.*;

public class GradeBook extends JFrame implements ActionListener
{
	private int schoolSize = 100;
	private JFileChooser chooser;
	private Container contentPane;
	private JTextField username = new JTextField();
	private JTextField password = new JTextField();
	private JButton login = new JButton("Login");
	private JButton newAdmin = new JButton("New Admin");
	private JButton openFile = new JButton("Open File");
	private JButton logout = new JButton("Logout");
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
		userIndex[1] = new Admin("Admin 2", "Password 2");
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
		
		logout.setBounds(0,0,50,50);
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
			else if(e.getSource() == newAdmin)
			{
				newAdmin();
			}
			else if(e.getSource() == openFile)
			{
				openFile();
			}
			else if(e.getSource() == logout)
			{
				logout();
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
		contentPane.add(newAdmin);
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
	}
	private void changeView() 
	{
		if(currentUser.getClass().toString().equals("class GradeBook.Users.Admin"))
		{
			clearCurrentView();
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
			}
		}
	}
	private void newAdmin() 
	{
		userIndex[0] = new Admin("A", "P");
		saveFile();
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
		logout.addActionListener(this);
		contentPane.add(logout);
		JButton addNewStudent = new JButton("Add New Student");
		JButton addNewTeacher = new JButton("Add New Teacher");
		addNewStudent.setBounds(250, 500, 200, 50);
		addNewTeacher.setBounds(250, 550, 200, 50);
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
			e.printStackTrace();
		}
	}	
}
