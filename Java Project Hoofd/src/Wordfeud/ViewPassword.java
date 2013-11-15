package Wordfeud;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class ViewPassword
{
	
	private JFrame frame;
	private JPasswordField OudWW;
	private JPasswordField NieuwWWH;
	private JButton btnToepassen;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblAccountnaam;
	private JLabel label;
	private JPasswordField NieuwWW;
	private JButton btnAnnuleren;
	private ModelPasswordEdit PEC;
	private JLabel AccNaam;
	
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
					ViewPassword window = new ViewPassword();
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
	public ViewPassword()
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		
		PEC = new ModelPasswordEdit();
		
		frame = new JFrame();
		frame.setTitle("Wachtwoord Wijzigen");
		frame.setBounds(100, 100, 350, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		OudWW = new JPasswordField();
		OudWW.setBounds(146, 42, 175, 20);
		frame.getContentPane().add(OudWW);
		OudWW.setColumns(10);
		
		lblNewLabel = new JLabel("Oud Wachtwoord");
		lblNewLabel.setBounds(10, 45, 126, 14);
		frame.getContentPane().add(lblNewLabel);
		
		NieuwWWH = new JPasswordField();
		NieuwWWH.setBounds(146, 120, 175, 20);
		frame.getContentPane().add(NieuwWWH);
		NieuwWWH.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Herhalen");
		lblNewLabel_1.setBounds(10, 120, 126, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblAccountnaam = new JLabel("Accountnaam");
		lblAccountnaam.setBounds(10, 14, 126, 14);
		frame.getContentPane().add(lblAccountnaam);
		
		label = new JLabel("Nieuw Wachtwoord");
		label.setBounds(10, 89, 126, 14);
		frame.getContentPane().add(label);
		
		NieuwWW = new JPasswordField();
		NieuwWW.setColumns(10);
		NieuwWW.setBounds(146, 89, 175, 20);
		frame.getContentPane().add(NieuwWW);
		
		btnToepassen = new JButton("Toepassen");
		btnToepassen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (PEC.ComparePass(OudWW.getText()))
				{
					if (Arrays.equals(NieuwWW.getPassword(),
							NieuwWWH.getPassword()))
					{
						if (NieuwWW.getText().length() > 8)
						{
							PEC.SetPassword(AccNaam.getText(),
									NieuwWW.getText());
						} else
						{
							JOptionPane
									.showMessageDialog(
											frame,
											"Het nieuwe wachtwoord is niet lang genoeg\nHet moet minstens 8 tekens lang zijn.",
											"Fout!",
											JOptionPane.WARNING_MESSAGE);
						}
					} else
					{
						JOptionPane
								.showMessageDialog(
										frame,
										"Het nieuwe wachtwoord en de herhaling hiervan zijn niet hetzelfde.",
										"Fout!", JOptionPane.WARNING_MESSAGE);
					}
				} else
				{
					JOptionPane.showMessageDialog(frame,
							"Incorrect wachtwoord (oud wachtwoord).", "Fout!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnToepassen.setBounds(224, 151, 100, 23);
		frame.getContentPane().add(btnToepassen);
		
		btnAnnuleren = new JButton("Annuleren");
		btnAnnuleren.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnAnnuleren.setBounds(114, 151, 100, 23);
		frame.getContentPane().add(btnAnnuleren);
		
		AccNaam = new JLabel(UserInfo.userName);
		AccNaam.setBounds(146, 14, 46, 14);
		frame.getContentPane().add(AccNaam);
	}
}
