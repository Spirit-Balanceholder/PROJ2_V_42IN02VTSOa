package Wordfeud;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Martin
 * 
 */
public class ViewAccountM
{
	
	private JFrame frame;
	private JComboBox comboBox;
	private JLabel lblAccountnaam;
	private JCheckBox chckbxModerator;
	private JCheckBox chckbxObserver;
	private JCheckBox chckbxAdmin;
	private JLabel lblRechten;
	private JButton btnToepassen;
	private JButton btnAnnuleren;
	private ModelAccountM AMC; // AMC = Account Management Control; dus de
								// logic/model layer
	String[][] players; // Martin, Temp
	
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
					ViewAccountM window = new ViewAccountM();
					window.frame.setVisible(true);
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
	public ViewAccountM()
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		
		AMC = new ModelAccountM();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 306, 193);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(120, 11, 148, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				refreshCbx();
			}
		});
		
		lblAccountnaam = new JLabel("Accountnaam:");
		lblAccountnaam.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccountnaam.setBounds(10, 14, 100, 14);
		frame.getContentPane().add(lblAccountnaam);
		
		chckbxModerator = new JCheckBox("Moderator");
		chckbxModerator.setBounds(120, 64, 97, 23);
		frame.getContentPane().add(chckbxModerator);
		
		chckbxObserver = new JCheckBox("Observer");
		chckbxObserver.setBounds(120, 38, 97, 23);
		frame.getContentPane().add(chckbxObserver);
		
		chckbxAdmin = new JCheckBox("Admin");
		chckbxAdmin.setBounds(120, 90, 97, 23);
		frame.getContentPane().add(chckbxAdmin);
		
		lblRechten = new JLabel("Rechten:");
		lblRechten.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRechten.setBounds(10, 42, 100, 14);
		frame.getContentPane().add(lblRechten);
		
		btnToepassen = new JButton("Toepassen");
		btnToepassen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String[] update = new String[4];
				update[0] = comboBox.getSelectedItem().toString();
				if (chckbxObserver.isSelected())
					update[1] = "true";
				else
					update[1] = "false";
				if (chckbxModerator.isSelected())
					update[2] = "true";
				else
					update[2] = "false";
				if (chckbxAdmin.isSelected())
					update[3] = "true";
				else
					update[3] = "false";
				
				AMC.UpdateStatus(update);
			}
		});
		btnToepassen.setBounds(168, 120, 100, 23);
		frame.getContentPane().add(btnToepassen);
		
		btnAnnuleren = new JButton("Annuleren");
		btnAnnuleren.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		btnAnnuleren.setBounds(58, 120, 100, 23);
		frame.getContentPane().add(btnAnnuleren);
		
		players = AMC.getPlayers();
		for (int x = 0; x < players.length; x++)
		{
			comboBox.addItem(players[x][0]);
		}
		refreshCbx();
	}
	
	/**
	 * Verversen van de checkboxes na het wisselen van geselecteerd account
	 * Nodig omdat anders de checkboxes niet veranderen na wissen van selectie
	 */
	private void refreshCbx()
	{
		for (int x = 0; x < players.length; x++)
		{
			if (players[x][0] == comboBox.getSelectedItem().toString())
			{
				if (players[x][1] == "true")
					chckbxObserver.setSelected(true);
				else
					chckbxObserver.setSelected(false);
				if (players[x][2] == "true")
					chckbxModerator.setSelected(true);
				else
					chckbxModerator.setSelected(false);
				if (players[x][3] == "true")
					chckbxAdmin.setSelected(true);
				else
					chckbxAdmin.setSelected(false);
			}
		}
	}
}
