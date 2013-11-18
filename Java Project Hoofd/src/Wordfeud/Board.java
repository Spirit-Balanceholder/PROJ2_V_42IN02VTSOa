package Wordfeud;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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
	// aanpasbaar (30)
	private int						Size			= 30;
	// standaard! (16)
	private int						BoardSize		= 16;
	// Aanpasbaar, tussenruimte (30)
	private int						Offset			= 30;
	// een test knopje
	private final JButton			btnNewButton	= new JButton("Druk dan");

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
		frmWordfeud.setTitle("Freddy vs Jason");
		frmWordfeud.getContentPane().setBackground(new Color(24, 24, 24));
		frmWordfeud.setBounds(100, 100, 600, 600);
		frmWordfeud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWordfeud.getContentPane().setLayout(null);
		{
			this.btnNewButton
					.addActionListener(new BtnNewButtonActionListener());
			this.btnNewButton.setBounds(10, 11, 89, 23);
			frmWordfeud.getContentPane().add(this.btnNewButton);
		}

		//
		GenerateField();

		//
		FillField();

	}

	/**
	 * Vul het veld met waarde vanuit de database Dit is of het een dubbel
	 * letterwaarde is of eventueel een leeg veld of etc.
	 */
	private void FillField()
	{
		try
		{
			ResultSet rs = TileController.Select();

			while (rs.next())
			{
				String xx = rs.getString(1);
				String yy = rs.getString(2);
				Tile t = hmTiles.get(xx + "-" + yy);
				// t.SetText(rs.getString(4));
				t.Set(rs.getString(4), 0);

			}

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Dit maakt het veld aan, dit zijn alleen de controls, dus ze bevatten nog
	 * geen waardes
	 */
	private void GenerateField()
	{

		// Playfieldinfo pi = new Playfieldinfo();
		// hmTiles = pi.GethmByID();
		// ID NU TIJDELIJK DIT:

		Tile tile;
		for (int x = 1; x < BoardSize; x++)
			for (int y = 1; y < BoardSize; y++)
			{

				tile = new Tile();
				tile.setSize(Size, Size);
				tile.setLocation(y * Size + Offset, x * Size + Offset);
				// tile.addMouseListener(new Panel_1MouseListener());
				// frame.getContentPane().add(tile);

				hmTiles.put(x + "-" + y, tile);
				frmWordfeud.getContentPane().add(tile);
			}

	}

	private class BtnNewButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			// een test om door middel van een opgegeven locatie een letter in
			// te voeren met een waarde van de letter
			Tile t = hmTiles.get("1-1");
			t.Set("M", 1);

			t = hmTiles.get("1-2");
			t.Set("i", 3);

			t = hmTiles.get("1-3");
			t.Set("k", 3);

			t = hmTiles.get("1-4");
			t.Set("e", 7);

			// je moet repainten anders komt er blijkbaar geen letter in.
			frmWordfeud.repaint();
		}
	}
}
