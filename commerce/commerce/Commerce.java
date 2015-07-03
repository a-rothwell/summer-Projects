package commerce;

import java.awt.Container;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;

/**
 * @author Andrew
 * @version Alpha .001A;
 */
public class Commerce extends JFrame implements ActionListener
{
	private static final int XCONSTANT = 20;
	private static final int YCONSTANT = 20;
	private Container contentPane;
	Timer timer = new Timer();
	Tile map[][] = new Tile[XCONSTANT][YCONSTANT];
	public Commerce() 
	{
		contentPane = getContentPane();
		contentPane.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Commerce");
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setResizable(false);
		for(int i = 0; i < XCONSTANT;i++)
		{
			for(int j = 0; j < YCONSTANT; j++)
			{
				map[i][j] = new Tile(i,j);
				map[i][j].setLocation(i*20 + 50, j*20 + 50);
				contentPane.add(map[i][j]);
			}
		}
		repaint();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Commerce frame = new Commerce();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
