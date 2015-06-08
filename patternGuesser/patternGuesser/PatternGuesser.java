package patternGuesser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PatternGuesser extends JFrame implements ActionListener
{
	private Container contentPane;
	private JTextField numberField = new JTextField();
	private JButton numberSubmit = new JButton("Submit");
	public PatternGuesser() 
	{
		contentPane = getContentPane();
		contentPane.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("GradeBook");
		setSize(700,700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		numberField.setBounds(250,250,100,50);
		numberField.addActionListener(this);
		contentPane.add(numberField);
		
		numberSubmit.setBounds(250,350,100,50);
		numberSubmit.addActionListener(this);
		contentPane.add(numberSubmit);
	}
	public static void main(String[] args)
	{
		PatternGuesser frame = new PatternGuesser();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof JButton)
		{
			patternFinder();
		}
	}
	private void patternFinder() 
	{
		// TODO Auto-generated method stub
		
	}

}
