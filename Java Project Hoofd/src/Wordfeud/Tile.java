package Wordfeud;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author MIKE
 * 
 */
public class Tile extends JPanel
{
	// Stijl van het tegel
	/** Stroke size. it is recommended to set it to 1 for better view */
	protected int strokeSize = 1; // 1
	/** Color of shadow */
	protected Color shadowColor = Color.black;
	/** Sets if it drops shadow */
	protected boolean shady = true;
	/** Sets if it has an High Quality view */
	protected boolean highQuality = true;
	/** Double values for Horizontal and Vertical radius of corner arcs */
	protected Dimension arcs = new Dimension(10, 10);
	/** Distance between shadow border and opaque panel border */
	protected int shadowGap = 3; // 5
	/** The offset of shadow. */
	protected int shadowOffset = 4; // 4
	/** The transparency value of shadow. ( 0 - 255) */
	protected int shadowAlpha = 150; // 150
	
	// Wat er voor tekst komt te staan op deze tegel
	JLabel lblLetter = new JLabel();
	JLabel lblValue = new JLabel();
	
	public Point tLoc;
	
	// Enum van status tegel
	// TileType = DW / DL / TL / TW
	// NoType = Geen Type (kan dus wel een letter bevatten)
	// X = begin veld (*)
	public enum eTileType
	{
		DW, DL, TL, TW, X, NoType
	};
	
	private eTileType tileType = null;
	private String letterType = "";
	
	public Tile(eTileType _tileType, String _letterType, int Value)
	{
		super();
		lblLetter.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValue.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 8));
		
		this.setLayout(null);
		//
		letterType = _letterType.toUpperCase();
		tileType = _tileType;
		
		// Set location
		lblLetter.setLocation(3, 10);
		lblLetter.setSize(25, 15);
		lblValue.setLocation(19, 1);
		lblValue.setSize(25, 15);
		//
		setOpaque(false);
		// lblLetter.setLocation(0, 0);
		// lblLetter.setSize(15, 15);
		
		/*
		 * lblLetter.setFont(new Font("Tahoma", Font.BOLD, 12));
		 * lblValue.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 9));
		 * lblValue.setHorizontalAlignment(JLabel.RIGHT);
		 * lblLetter.setHorizontalAlignment(SwingConstants.LEFT);
		 * lblLetter.setVerticalAlignment(SwingConstants.BOTTOM);
		 * lblValue.setHorizontalAlignment(SwingConstants.RIGHT);
		 * lblValue.setVerticalAlignment(SwingConstants.TOP);
		 */
		
		this.add(lblLetter);
		if (Value != 0)
			this.add(lblValue, BorderLayout.NORTH);
		
		// Set text and color
		if (tileType == eTileType.NoType)
		{
			lblLetter.setText(letterType);
			
			lblValue.setText(Integer.toString(Value));
			if (letterType.isEmpty())
				this.setBackground(Color.gray);
			else
				this.setBackground(Color.white);
			
		} else
		{
			lblLetter.setText(tileType.toString());
			lblLetter.setForeground(Color.white);
			switch (tileType)
			{
				case DL:// green
					this.setBackground(Color.green);
					break;
				case DW:// orange
					this.setBackground(Color.orange);
					break;
				case NoType:// gray
					this.setBackground(Color.lightGray);
					break;
				case TL:// blauw
					this.setBackground(Color.blue);
					break;
				case TW:// roodbruin
					this.setBackground(Color.red);
					break;
				case X:
					this.setBackground(Color.pink);
					break;
				default:
					this.setBackground(Color.black); // foutje
					break;
			
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int shadowGap = this.shadowGap;
		Color shadowColorA = new Color(shadowColor.getRed(),
				shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
		Graphics2D graphics = (Graphics2D) g;
		
		// Sets antialiasing if HQ.
		if (highQuality)
		{
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
		
		// Draws shadow borders if any.
		if (!shady)
		{
			graphics.setColor(shadowColorA);
			graphics.fillRoundRect(shadowOffset,// X position
					shadowOffset,// Y position
					width - strokeSize - shadowOffset, // width
					height - strokeSize - shadowOffset, // height
					arcs.width, arcs.height);// arc Dimension
		} else
		{
			shadowGap = 1;
		}
		
		// Draws the rounded opaque panel with borders.
		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap,
				arcs.width, arcs.height);
		graphics.setColor(getForeground());
		graphics.setStroke(new BasicStroke(strokeSize));
		graphics.drawRoundRect(0, 0, width - shadowGap, height - shadowGap,
				arcs.width, arcs.height);
		
		// Sets strokes to default, is better.
		graphics.setStroke(new BasicStroke());
	}
}