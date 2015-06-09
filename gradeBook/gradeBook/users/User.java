package gradeBook.users;

import java.io.*;

public class User implements Serializable{
	private String username;
	private String password;
	public User(String usernameToSet, String passwordToSet)
	{
		username = usernameToSet;
		password = passwordToSet;
	}
	public String returnUserName()
	{
		return username;
	}
	public String returnPassword() 
	{
		return password;
	}
}
