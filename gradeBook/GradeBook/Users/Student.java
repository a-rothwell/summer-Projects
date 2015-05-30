package GradeBook.Users;


public class Student extends User {

	public Student(String username, String password) 
	{
		super(username, password);
		System.out.println("Student");
	}

}
