package Wordfeud;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;

/**
 * 
 * @author MIKE Commentaar word in een later stadia toegevoegd omdat: Deze
 *         klasse nog niet zo werkt zoals ik wil, en dan overbodig werk ga
 *         verrichten.
 */
public class Board
{

	private JFrame					frmWordfeud;
	// Hashmap met alle tiles
	public HashMap<String, Tile>	hmTiles		= new HashMap<String, Tile>();
	// Waardes
	private int						Size		= 30;
	private int						BoardSize	= 15;
	private int						Offset		= 30;

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
	 */
	public Board(int _gameID)
	{
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmWordfeud = new JFrame();
		frmWordfeud.setTitle("Wordfeud");
		frmWordfeud.getContentPane().setBackground(new Color(0, 0, 0));
		frmWordfeud.setBounds(100, 100, 600, 600);
		frmWordfeud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWordfeud.getContentPane().setLayout(null);

		GenerateField();
	}

	private void GenerateField()
	{
		// Playfieldinfo pi = new Playfieldinfo();
		// hmTiles = pi.GethmByID();
		// ID NU TIJDELIJK DIT:
		int index = 0;
		Tile tile;
		for (int x = 0; x < BoardSize; x++)
			for (int y = 0; y < BoardSize; y++)
			{
				if (index == 1 || index == 5 || index == 10)
					tile = new Tile(Tile.eTileType.DL, "", 0);
				else if (index == 3 || index == 7 || index == 13)
					tile = new Tile(Tile.eTileType.TW, "", 0);
				else if (index == 2 || index == 8 || index == 18)
					tile = new Tile(Tile.eTileType.NoType, "", 0);
				else
					tile = new Tile(Tile.eTileType.NoType, RandomLetter(),
							new Random().nextInt(5));

				tile.setSize(Size, Size);
				tile.setLocation(y * Size + Offset, x * Size + Offset);
				// tile.addMouseListener(new Panel_1MouseListener());
				// frame.getContentPane().add(tile);

				hmTiles.put(x + "-" + y, tile);

				index++;
			}

		for (Tile t : hmTiles.values())
		{
			frmWordfeud.getContentPane().add(t);
		}

		// alle database doorlopen en zoeken in de hashmap, deze aanpassen naar
		// correcte waarde wat in de edatabase staat
		// als dat gedaaan is word dat meteen wergegeven op het scherm
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
