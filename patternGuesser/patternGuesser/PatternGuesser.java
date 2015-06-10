package patternGuesser;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

import javax.swing.*;

public class PatternGuesser extends JFrame implements ActionListener
{
	private Container contentPane;
	private JTextField numberFieldOneX = new JTextField();
	private JTextField numberFieldOneY = new JTextField();
	private JTextField numberFieldTwoX = new JTextField();
	private JTextField numberFieldTwoY = new JTextField();
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
		
		numberFieldOneX.setBounds(250,250,25,25);
		contentPane.add(numberFieldOneX);
		
		numberFieldOneY.setBounds(275,250,25,25);
		contentPane.add(numberFieldOneY);
		
		numberFieldTwoX.setBounds(250,325,25,25);
		contentPane.add(numberFieldTwoX);
		
		numberFieldTwoY.setBounds(275,325,25,25);
		contentPane.add(numberFieldTwoY);
		
		numberSubmit.setBounds(250,400,100,50);
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
		Point2D.Double one = new Point2D.Double(Double.parseDouble((numberFieldOneX.getText())) , Double.parseDouble((numberFieldOneY.getText())));
		Point2D.Double two = new Point2D.Double(Double.parseDouble((numberFieldTwoX.getText())) , Double.parseDouble((numberFieldTwoY.getText())));
		System.out.println((two.getY()-one.getY())/(two.getX()-one.getX()));
	}

}
