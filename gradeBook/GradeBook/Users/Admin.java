package GradeBook.Users;
import java.io.*;

public class Admin extends User implements Serializable{
	public Admin(String username, String password) 
	{
		super(username, password);
	}
}
