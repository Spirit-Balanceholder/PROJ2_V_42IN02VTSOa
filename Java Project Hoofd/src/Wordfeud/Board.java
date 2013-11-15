package Wordfeud;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import Wordfeud.InfoControllers.TileController;

/**
 * 
 * @author MIKE
 * 
 */
public class Board
{

	private JFrame					frmWordfeud;
	// Hashmap with all tiles
	public HashMap<String, Tile>	hmTiles			= new HashMap<String, Tile>();
	// Waardes
	private int						Size			= 30;
	private int						BoardSize		= 15;
	private int						Offset			= 30;
	private final JButton			btnNewButton	= new JButton("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Board window = new Board(0);
					window.frmWordfeud.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public Board(int GameID)
	{
		initialize();
		// TODO

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize()
	{
		frmWordfeud = new JFrame();
		frmWordfeud.setTitle("Wordfeud");
		frmWordfeud.getContentPane().setBackground(new Color(0, 0, 0));
		frmWordfeud.setBounds(100, 100, 600, 600);
		frmWordfeud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWordfeud.getContentPane().setLayout(null);
		{
			this.btnNewButton.setBounds(38, 38, 89, 23);
			frmWordfeud.getContentPane().add(this.btnNewButton);
		}

		GenerateField();
	}

	private void GenerateField()
	{
		Object[] rr = null;
		try
		{
			rr = TileController.getFromXY(1, 1);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xxx = (String) rr[3];
		int asdasd = (int) rr[0];

		// Playfieldinfo pi = new Playfieldinfo();
		// hmTiles = pi.GethmByID();
		// ID NU TIJDELIJK DIT:

		Tile tile;
		for (int x = 0; x < BoardSize; x++)
			for (int y = 0; y < BoardSize; y++)
			{

				tile = new Tile(Tile.eTileType.NoType, RandomLetter(), 4);

				tile.setSize(Size, Size);
				tile.setLocation(y * Size + Offset, x * Size + Offset);
				// tile.addMouseListener(new Panel_1MouseListener());
				// frame.getContentPane().add(tile);

				hmTiles.put(x + "-" + y, tile);

			}

		for (Tile t : hmTiles.values())
		{
			frmWordfeud.getContentPane().add(t);
		}
	}

	private String RandomLetter()
	{
		Random r = new Random();
		// TODO TEMP . deze classe word weggegooit als er gwn een database
		// connectie is
		String[] sr = new String[]
		{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
				"o", "p", "q", "r", "s", "t", "u" };

		return sr[r.nextInt(sr.length)];
	}
}
