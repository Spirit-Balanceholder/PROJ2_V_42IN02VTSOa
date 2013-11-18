package Wordfeud;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Wordfeud.DataBaseConnectie.DBMySQL;

/**
 * 
 * @author Andy Scherrenberg
 * 
 */
public class TestConnectieForm
{

	static JTextField	text1;
	static JTextField	text2;
	static JTable		tb;
	static JPanel		p	= new JPanel();
	static JFrame		f;
	static JScrollPane	js;

	public static void main(String[] args)
	{
		DBMySQL db = new DBMySQL();

		db.setisJoin(true);
		db.addJoin("inner", "Letter", "ID", "Gelegdeletter", "Letter_ID");
		db.addWhereJoin("GelegdeLetter", "Spel_ID", "511");

		f = new JFrame("This is a test");
		ResultSet set = null;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);

		p.setLayout(null);
		p.setBackground(Color.red);
		p.setBounds(0, 0, 500, 100);
		text1 = new JTextField();
		text1.setBounds(10, 10, 100, 20);
		text2 = new JTextField();
		text2.setBounds(10, 35, 100, 20);
		JButton btnTest = new JButton();
		btnTest.setBounds(10, 60, 50, 25);
		btnTest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{

				try
				{
					f.remove(js);

					js = new JScrollPane(tb);
					js.setBounds(0, 100, 490, 300);
					f.getContentPane().add(js);
				}
				catch (Exception e)
				{
					System.out.println(e);
				}

			}

		});

		try
		{

			tb = db.SelectDTTable("gelegdeletter");
			// set = d.SelectDTtest("Account");

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String a = "";
		try
		{
			set.absolute(1);
			a = set.getString(1);
		}
		catch (Exception e)
		{

		}

		p.add(btnTest);
		p.add(text1);
		p.add(text2);

		f.add(p);
		js = new JScrollPane(tb);
		js.setBackground(Color.black);
		js.setBounds(0, 100, 490, 300);
		f.getContentPane().setLayout(null);
		f.getContentPane().add(js);

		f.repaint();
		f.revalidate();
		f.setVisible(true);
	}
}
