package Wordfeud;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 
 * @author Martin
 * 
 */
public class ViewCompetitieManagement
{
	
	private JFrame frame;
	private JButton btnToepassen;
	private JButton btnAnnuleren;
	private JLabel lblBegindatum;
	private JLabel lblEinddatum;
	private JLabel lblBeschrijving;
	private JTextField txtBegindatum;
	private JTextField txtEinddatum;
	private JEditorPane txtBeschrijving;
	private JLabel lblLetterCount;
	private ModelCompetitie COCO;
	private int CompID = 0;
	
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
					ViewCompetitieManagement window = new ViewCompetitieManagement();
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
	public ViewCompetitieManagement()
	{
		initialize();
	}
	
	public ViewCompetitieManagement(int ID)
	{
		CompID = ID;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		COCO = new ModelCompetitie();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnToepassen = new JButton("Toepassen");
		btnToepassen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
		btnToepassen.setBounds(324, 206, 100, 23);
		frame.getContentPane().add(btnToepassen);
		
		btnAnnuleren = new JButton("Annuleren");
		btnAnnuleren.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		btnAnnuleren.setBounds(214, 206, 100, 23);
		frame.getContentPane().add(btnAnnuleren);
		
		lblBegindatum = new JLabel("Begindatum:");
		lblBegindatum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBegindatum.setBounds(10, 14, 90, 14);
		frame.getContentPane().add(lblBegindatum);
		
		lblEinddatum = new JLabel("Einddatum:");
		lblEinddatum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEinddatum.setBounds(10, 39, 90, 14);
		frame.getContentPane().add(lblEinddatum);
		
		lblBeschrijving = new JLabel("Beschrijving:");
		lblBeschrijving.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBeschrijving.setBounds(10, 64, 90, 14);
		frame.getContentPane().add(lblBeschrijving);
		
		txtBegindatum = new JTextField();
		txtBegindatum.setBounds(110, 11, 150, 20);
		frame.getContentPane().add(txtBegindatum);
		txtBegindatum.setColumns(10);
		
		txtEinddatum = new JTextField();
		txtEinddatum.setBounds(110, 36, 150, 20);
		frame.getContentPane().add(txtEinddatum);
		txtEinddatum.setColumns(10);
		
		txtBeschrijving = new JEditorPane();
		txtBeschrijving.setBounds(110, 64, 314, 106);
		txtBeschrijving.getDocument().addDocumentListener(
				new DocumentListener()
				{
					@Override
					public void changedUpdate(DocumentEvent arg0)
					{
						lblLetterCount.setText("U heeft nog "
								+ (255 - txtBeschrijving.getDocument()
										.getLength()) + " tekens te gaan");
					}
					
					@Override
					public void insertUpdate(DocumentEvent arg0)
					{
						lblLetterCount.setText("U heeft nog "
								+ (255 - txtBeschrijving.getDocument()
										.getLength()) + " tekens te gaan");
						if (255 - txtBeschrijving.getDocument().getLength() < 0)
						{
							lblLetterCount.setForeground(Color.red);
						}
					}
					
					@Override
					public void removeUpdate(DocumentEvent arg0)
					{
						lblLetterCount.setText("U heeft nog "
								+ (255 - txtBeschrijving.getDocument()
										.getLength()) + " tekens te gaan");
						if (255 - txtBeschrijving.getDocument().getLength() >= 0)
						{
							lblLetterCount.setForeground(Color.BLACK);
						}
					}
				});
		frame.getContentPane().add(txtBeschrijving);
		
		lblLetterCount = new JLabel("U heeft nog 255 tekens te gaan");
		lblLetterCount.setBounds(110, 181, 314, 14);
		frame.getContentPane().add(lblLetterCount);
		
		if (CompID != 0)
		{
			
		}
	}
}
