package gradeBook.users;

import java.io.*;

public class User implements Serializable
{
	private String legalName;
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
	public void setName(String name)
	{
		name = legalName;
	}
	public String getName()
	{
		return legalName;
	}
}
