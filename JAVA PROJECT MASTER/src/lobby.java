import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class lobby
{

	private JFrame					frmLobby;
	private final JMenuBar			menuBar					= new JMenuBar();
	private final JMenu				mnNewMenu				= new JMenu(
																	"Dingen");
	private final JMenu				mnAndereDingen			= new JMenu(
																	"Andere Dingen");
	private final JList				list					= new JList();
	private final JButton			btnNewButton			= new JButton(
																	"New button");
	private final JInternalFrame	internalFrame			= new JInternalFrame(
																	"Tha Gamez");
	private final Choice			choice					= new Choice();
	private final JToggleButton		tglbtnNewToggleButton	= new JToggleButton(
																	"New toggle button");

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
					lobby window = new lobby();
					window.frmLobby.setVisible(true);
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
	public lobby()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		try
		{
			this.internalFrame.setResizable(true);
			this.internalFrame.setNormalBounds(new Rectangle(4, 4, 4, 4));
			this.internalFrame.setBorder(new TitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			this.internalFrame.setSelected(true);
			this.internalFrame.setIcon(true);
		} catch (PropertyVetoException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.internalFrame.setBounds(331, 44, 707, 500);
		this.internalFrame.setVisible(true);
		frmLobby = new JFrame();
		frmLobby.setTitle("Lobby");
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		frmLobby.setBounds(0, 0, 1200, 582);
		frmLobby.getContentPane().setLayout(null);
		{
			this.menuBar.setBounds(0, 0, 1184, 37);
			frmLobby.getContentPane().add(this.menuBar);
		}
		{
			this.menuBar.add(this.mnNewMenu);
		}
		{
			this.menuBar.add(this.mnAndereDingen);
		}
		{
			this.list.setBounds(0, 41, 217, 503);
			this.list.setValueIsAdjusting(true);
			this.list.setVisibleRowCount(200);
			this.list.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			this.list.setModel(new AbstractListModel()
			{
				String[]	values	= new String[]
									{ "Gold league ", "Silver league ",
											"Bronze league ", "Test league ",
											"Grasshopper league " };

				public int getSize()
				{
					return values.length;
				}

				public Object getElementAt(int index)
				{
					return values[index];
				}
			});
			frmLobby.getContentPane().add(this.list);
		}
		{
			this.btnNewButton
					.addActionListener(new BtnNewButtonActionListener());
			this.btnNewButton.setBounds(227, 82, 89, 23);
			frmLobby.getContentPane().add(this.btnNewButton);
		}
		{
			frmLobby.getContentPane().add(this.internalFrame);
		}
		{
			this.choice.setBounds(237, 124, 79, 37);
			frmLobby.getContentPane().add(this.choice);
		}
		{
			this.tglbtnNewToggleButton.setBounds(224, 164, 97, 23);
			frmLobby.getContentPane().add(this.tglbtnNewToggleButton);
		}
		frmLobby.setExtendedState(frmLobby.MAXIMIZED_BOTH);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class BtnNewButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{

				testi test = new testi();
				test.getYoFrame().setFocusableWindowState(false);
				internalFrame.add(test.getYoFrame().getContentPane());
				internalFrame.setTitle("Yoyo");

			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
