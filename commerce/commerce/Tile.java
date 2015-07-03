package commerce;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Tile extends JButton
{
	private static final int XSIZECONSTANT = 20;
	private static final int YSIZECONSTANT = 20;
	private Point point = new Point();
	public Tile(int x, int y)
	{
		point.setLocation(x, y);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(Color.WHITE);
		this.setSize(XSIZECONSTANT, YSIZECONSTANT);
		this.setVisible(true);
	}
	
}
