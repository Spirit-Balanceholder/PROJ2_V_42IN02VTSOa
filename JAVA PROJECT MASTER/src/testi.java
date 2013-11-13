import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class testi
{
	private static final Border				Border			= null;
	public HashMap<String, RoundedPanel>	hm				= new HashMap<String, RoundedPanel>();
	private JFrame							yoFrame;
	private String[]						aSF				= new String[]
															{ "8-10", "1-3",
			"1-5", "1-7", "1-9"							};

	private int								Size			= 30;
	private int								BoardSize		= 15;
	private int								Offset			= 30;
	private final JPanel					panel			= new JPanel();
	Random									r				= new Random();
	private final JButton					btnNewButton	= new JButton(
																	"Update");
	private final JButton					btnInvoer		= new JButton(
																	"Invoer");
	private final JTable					table			= new JTable();

	private String							dragginLetter	= "";

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
					testi window = new testi();
					window.getYoFrame().setVisible(true);
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
	public testi()
	{
		initialize();

	}

	private void newPnl(int i, int j, int index)
	{
		RoundedPanel p = new RoundedPanel();

		p.setSize(Size, Size);
		p.setLocation(i * Size + Offset, j * Size + Offset);
		p.addMouseListener(new Panel_1MouseListener());
		getYoFrame().getContentPane().add(p);
		hm.put(i + "-" + j, p);
	}

	private void UpdatePlayfield()
	{
		for (Entry<String, RoundedPanel> ehm : hm.entrySet())
		{
			RoundedPanel p = ehm.getValue();

			p.SetText("", false);
			int ri = r.nextInt(100);
			if (ri < 10)
			{
				p.setBackground(Color.white);
				p.SetText(RandomLetter(), false);
			} else
			{
				p.add(new JLabel());
				p.setBackground(Color.darkGray);
			}
			SpecialField(ehm);

			//
			/*
			 * try {
			 * 
			 * Thread.sleep(1); } catch (InterruptedException e) {
			 * 
			 * }
			 */
		}
	}

	private String RandomLetter()
	{

		String[] sr = new String[]
		{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
				"o", "p", "q", "r", "s", "t", "u" };

		return sr[r.nextInt(sr.length)];
	}

	/**
	 * Initialize the contents of the yoFrame.
	 */
	private void initialize()
	{
		setYoFrame(new JFrame());
		getYoFrame().getContentPane().setBackground(
				UIManager.getColor("Label.disabledForeground"));

		getYoFrame().setBounds(0, 0, 557, 700);
		getYoFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getYoFrame().getContentPane().setLayout(null);
		this.btnNewButton.setBounds(0, 0, 89, 23);
		getYoFrame().getContentPane().add(this.btnNewButton);

		this.btnNewButton.addActionListener(new BtnNewButtonActionListener());
		//
		for (int i = 0; i < 9; i++)
		{

			RoundedPanel ppp = new RoundedPanel();
			ppp.addMouseMotionListener(new PppMouseMotionListener());
			ppp.addMouseListener(new PppMouseListener());
			ppp.setBackground(Color.cyan);
			ppp.setLocation(Offset + (i * 50),
					((Offset * 2) + (Size * BoardSize)));
			ppp.pLoc = ppp.getLocation();
			ppp.setSize(50, 50);
			ppp.SetText(RandomLetter(), false);
			// ppp.setAlignmentY(Alignment.LEADING);
			ppp.setAlignmentY(100);
			getYoFrame().getContentPane().add(ppp);

		}

		{
			this.btnInvoer.addActionListener(new BtnInvoerActionListener());
			this.btnInvoer.setBounds(99, 0, 89, 23);
			getYoFrame().getContentPane().add(this.btnInvoer);
		}
		int index = 0;
		for (int i = 0; i < BoardSize; i++)
			for (int j = 0; j < BoardSize; j++)
			{
				newPnl(j, i, index);
				index++;
			}

		//
	}

	private class BtnNewButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			UpdatePlayfield();
		}
	}

	private void SpecialField(Entry<String, RoundedPanel> ehm)
	{
		String KEY = ehm.getKey();
		RoundedPanel rp = ehm.getValue();
		if (!rp.lbl.getText().isEmpty())
			return;
		if (Arrays.asList(aSF).contains(KEY))
		{
			rp.setBackground(Color.red);
			rp.SetText("DW", false);
			rp.lbl.setForeground(Color.white);
		}

	}

	public JFrame getYoFrame()
	{
		return yoFrame;
	}

	public void setYoFrame(JFrame yoFrame)
	{
		this.yoFrame = yoFrame;
	}

	private class BtnInvoerActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{// TODO
		}
	}

	private class PppMouseListener extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent me)
		{
			RoundedPanel rp = (RoundedPanel) me.getComponent();
			dragginLetter = rp.lbl.getText();
		}

		@Override
		public void mouseReleased(MouseEvent me)
		{
			if (rpHovered == null)
			{
				RoundedPanel rp = (RoundedPanel) me.getComponent();
				rp.setLocation(rp.GetStandardLocation());
				return;
			}
			rpHovered.SetText(dragginLetter, true);
			System.out.print(dragginLetter);
			dragginLetter = null;
			rpHovered = null;
			RoundedPanel rp = (RoundedPanel) me.getComponent();
			rp.setLocation(rp.GetStandardLocation());

		}
	}

	private class Panel_1MouseListener extends MouseAdapter
	{
		/*
		 * @Override public void mouseReleased(MouseEvent e) { // /mmouse up op
		 * veld RoundedPanel rp = (RoundedPanel) e.getComponent();
		 * System.out.print(rp.lbl.getText()); }
		 */

		@Override
		public void mouseEntered(MouseEvent e)
		{
			// /mmouse up op veld
			rpHovered = (RoundedPanel) e.getComponent();

		}
	}

	RoundedPanel	rpHovered	= null;

	private class PppMouseMotionListener extends MouseMotionAdapter
	{
		@Override
		public void mouseDragged(MouseEvent me)
		{
			//
			RoundedPanel rp = (RoundedPanel) me.getComponent();
			//
			me.translatePoint(me.getComponent().getLocation().x, me
					.getComponent().getLocation().y);
			//
			rp.setLocation(me.getX() - (rp.getWidth() / 2),
					me.getY() - (rp.getHeight() / 2));

		}
	}
}
