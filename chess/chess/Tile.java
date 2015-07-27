package chess;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

public class Tile extends JButton 
{
	private Color backGroundColor;
	private Point location;
	public Tile(int xLetter, int yLocation) 
	{
		if(yLocation % 2 ==0)
		{
			backGroundColor = xLetter % 2 == 0 ?Color.BLACK: Color.WHITE;
		}
		else
		{
			backGroundColor = xLetter % 2 == 0 ?Color.WHITE: Color.BLACK;
		}
		this.setBackground(backGroundColor);
	}
	
}
