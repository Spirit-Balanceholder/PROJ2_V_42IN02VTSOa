package Wordfeud;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Wordfeud.DataBaseConnectie.DBMySQL;
import Wordfeud.InfoControllers.AccountController;

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

		f = new JFrame("This is a test");

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
				DBMySQL d = new DBMySQL();

				try
				{
					f.remove(js);

					d.RecordExcist("account", "naam", "jager684");

					js = new JScrollPane(tb);
					js.setBounds(0, 100, 490, 300);
					f.getContentPane().add(js);
				} catch (Exception e)
				{
					System.out.println(e);
				}

			}

		});

		try
		{

<<<<<<< HEAD
<<<<<<< HEAD
			// tb = AccountController.("account");
=======
			tb = AccountController.Select();
>>>>>>> f4d8ab299875ebcc29ef6592517270ddbc7452db
=======
			tb = AccountController.Select();
>>>>>>> f4d8ab299875ebcc29ef6592517270ddbc7452db

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
