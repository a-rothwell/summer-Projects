package GradeBook.Users;


public class Teacher extends User{

	public Teacher(String username, String password) 
	{
		super(username, password);
		System.out.println("Teacher");
	}

}
