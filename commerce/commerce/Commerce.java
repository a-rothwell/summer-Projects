package commerce;

import java.awt.Color;
import java.awt.Container;
import java.awt.Event;
import java.awt.event.*;
import java.util.*;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * @author Andrew
 * @version Alpha .001A;
 */
@SuppressWarnings("serial")
public class Commerce extends JFrame implements ActionListener
{
	private static final int XCONSTANT = 20;
	private static final int YCONSTANT = 20;
	private static final Color RED = Color.RED;
	private static final Color BLUE = Color.BLUE;
	private static final Color GREEN = Color.GREEN;
	private static final Color WHITE = Color.WHITE;
	private static final Color BLACK = Color.BLACK;
	private static final Color YELLOW = Color.YELLOW;
	private Container contentPane;
	private Color selectorColor = WHITE;
	Timer timer = new Timer();
	Tile map[][] = new Tile[XCONSTANT][YCONSTANT];
	public Commerce() 
	{
		addKeyMap();
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
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
				map[i][j].addActionListener(this);
				contentPane.add(map[i][j]);
			}
		}
		repaint();
	}
	public static void main(String[] args) 
	{
		Commerce frame = new Commerce();
		frame.setVisible(true);
	}
	protected void addKeyMap()
	{
		InputMap inputMap = new InputMap();
		KeyStroke key = KeyStroke.getAWTKeyStrokeForEvent(anEvent)
		inputMap.put(changeSelectorColor(GREEN),key);
	}
	public void keyPressed(KeyEvent k)
	{
		if(k.getKeyCode() == KeyEvent.VK_1)
		{
			
		}
		else if(k.getKeyCode() == KeyEvent.VK_2)
		{
			changeSelectorColor(BLUE);
		}
		else if(k.getKeyCode() == KeyEvent.VK_3)
		{
			changeSelectorColor(YELLOW);
		}
		else if(k.getKeyCode() == KeyEvent.VK_4)
		{
			changeSelectorColor(BLACK);
		}
		else if(k.getKeyCode() == KeyEvent.VK_5)
		{
			changeSelectorColor(WHITE);
		}
	}
	private void changeSelectorColor(Color constantColor) 
	{
		selectorColor = constantColor;
		System.out.println(selectorColor);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof JButton)
		{
			JButton clicked = (JButton) e.getSource();
			clicked.setBackground(selectorColor);
			repaint();
		}
	}
}
