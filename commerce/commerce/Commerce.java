package commerce;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import javax.swing.*;
/**
 * @author Andrew
 * @version Alpha .001A;
 */
public class Commerce extends JFrame implements ActionListener, KeyListener
{
	private boolean startSelected = false;
	private final int XCONSTANT = 20;
	private final int YCONSTANT = 20;
	private final Color RED = Color.RED;
	private final Color BLUE = Color.BLUE;
	private final Color GREEN = Color.GREEN;
	private final Color WHITE = Color.WHITE;
	private final Color BLACK = Color.BLACK;
	private final Color YELLOW = Color.YELLOW;
	private JLabel colorBox = new JLabel();
	private Container contentPane;
	private Color selectorColor = WHITE;
	Timer timer = new Timer();
	Tile map[][] = new Tile[XCONSTANT][YCONSTANT];
	public Commerce() 
	{
		addKeyListener(this);
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
				map[i][j].addKeyListener(this);
				contentPane.add(map[i][j]);
			}
		}
		colorBox.setBounds(750, 750, 50, 50);
		colorBox.setBorder(BorderFactory.createLineBorder(BLACK));
		colorBox.setBackground(selectorColor);
		colorBox.setOpaque(true);
		colorBox.setVisible(true);
		contentPane.add(colorBox);
		selectorColor = RED;
		repaintColorBox();
		selectStart();
		repaint();
	}
	private void selectStart()
	{
		for(int i = 1; i < XCONSTANT - 1;i++)
		{
			for(int j = 1; j < YCONSTANT - 1; j++)
			{
				map[i][j].setEnabled(false);
			}
		}
		repaint();
	}
	public static void main(String[] args) 
	{
		Commerce frame = new Commerce();
		frame.setVisible(true);
	}
	public void keyPressed(KeyEvent k)
	{
		if(selectorColor == RED && startSelected == false)
		{
			changeSelectorColor(RED);
		}
		else if(k.getKeyCode() == KeyEvent.VK_1)
		{
			changeSelectorColor(GREEN);
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
		repaintColorBox();
	}
	private void repaintColorBox() 
	{
		colorBox.setBackground(selectorColor);
		colorBox.setOpaque(true);
		repaint();
	}
	private void changeSelectorColor(Color constantColor) 
	{
		selectorColor = constantColor;
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof JButton)
		{
			if(selectorColor == RED)
			{
				for(int i = 1; i < XCONSTANT - 1;i++)
				{
					for(int j = 1; j < YCONSTANT - 1; j++)
					{
						map[i][j].setEnabled(true);
					}
				}
			}
			JButton clicked = (JButton) e.getSource();
			colorChange(clicked);
		}
		
	}
	private void colorChange(JButton clicked) 
	{
		if(clicked.getBackground() == WHITE || selectorColor == WHITE && clicked.getBackground() != RED)
		{
			clicked.setBackground(selectorColor);
			selectorColor = WHITE;
		}
		repaint();
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent e) {}
}