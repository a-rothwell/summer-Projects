package GradeBook.Users;


public class Admin extends User {
	private int studentNumber = 0;
	private int teacherNumber = 0;
	private Teacher teacherArray[20];
	public Admin(String username, String password) 
	{
		// TODO Auto-generated constructor stub
		super(username, password);
		teacherArray[] = new Teacher[];
		Student studentArray[] = new Student[100];
		System.out.println("ADMIN");
	}
	private void createNewTeacher(String username, String password)
	{
		teacherArray[teacherNumber] = new Teacher(username, password);
		
	}
	private void createNewStudent(String username, String password)
	{
		studentArray[studentNumber] = new Student(username, password);
		studentNumber++;
	}

}
