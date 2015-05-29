package GradeBook;

public class Admin extends User {

	public Admin(String username, String password) 
	{
		// TODO Auto-generated constructor stub
		super(username, password);
		System.out.println("ADMIN");
	}
	private void createNewTeacher(String username, String password)
	{
		Teacher username = new Teacher(username, password);
	}
	private void createNewStudent(String username, String password, String name)
	{
		Student username = new Student(username, password);
	}

}
