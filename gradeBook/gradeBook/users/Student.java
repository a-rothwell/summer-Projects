package gradeBook.users;

import java.io.Serializable;


public class Student extends User implements Serializable {

	public Student(String username, String password) 
	{
		super(username, password);
		System.out.println("Student");
	}

}
