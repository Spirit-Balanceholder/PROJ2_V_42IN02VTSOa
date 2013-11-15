package Wordfeud;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 * @author Martin
 * 
 */
public class ViewLogin
{
	
	private JFrame frame;
	private JTextField txtUserName;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField txtPassword;
	private JLabel lblNewLabel_2;
	private JButton btnLogin;
	private ModelLogin ml;
	
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
					ViewLogin window = new ViewLogin();
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
	public ViewLogin()
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the window
	 */
	private void initialize()
	{
		ml = new ModelLogin();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(120, 44, 180, 20);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		lblNewLabel = new JLabel("Gebruikersnaam");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 47, 100, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Wachtwoord");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 78, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(120, 75, 180, 20);
		frame.getContentPane().add(txtPassword);
		
		lblNewLabel_2 = new JLabel("WordFeud");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 280, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			/**
			 * Verwerken van inloggegevens en checken of de gegevens kloppen Zo
			 * ja, dan ga naar het hoofdscherm
			 */
			public void actionPerformed(ActionEvent arg0)
			{
				
				try
				{
					if (ml.CheckLogin(txtUserName.getText(),
							txtPassword.getText()))
					{
						// dummy
						JOptionPane.showMessageDialog(frame, "goed.", "goed",
								JOptionPane.INFORMATION_MESSAGE);
						// dummy
					} else
					{
						JOptionPane.showMessageDialog(frame,
								"Ongeldige logingegevens.", "Fout!",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(211, 106, 89, 23);
		frame.getContentPane().add(btnLogin);
		
	}
}
