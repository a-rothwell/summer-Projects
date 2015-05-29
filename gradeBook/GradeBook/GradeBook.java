package GradeBook;

import javax.swing.JFrame;

public class GradeBook extends JFrame 
{
	protected Teacher teacherArray[] = new Teacher[20];
	protected Student studentArray[] = new Student[100];
	public GradeBook() 
	{
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		GradeBook frame = new GradeBook();
		frame.setVisible(true);
	}
	private boolean checkPassword(String userName, String password)
	{
		return false;
	}
}
