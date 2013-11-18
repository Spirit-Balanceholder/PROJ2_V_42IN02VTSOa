package Wordfeud;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;

import Wordfeud.DataBaseConnectie.DBConnectie;
import Wordfeud.DataBaseConnectie.DBMySQL;

/**
 * 
 * @author Kai
 * 
 */
public class frameLobby extends JFrame
{
	
	private JScrollPane scrollCompetite;
	private JList<String> listCompetite;
	private DBConnectie connectie;
	private DBMySQL querybuilder;
	private JTable competitions;
	
	public frameLobby()
	{
		connectie = new DBConnectie();
		querybuilder = new DBMySQL();
		
		try {
			querybuilder.SelectDT("competitie");
		} catch (SQLException e) {
			
		}
		
		scrollCompetite = new JScrollPane(competitions);
		
		setLayout(new BorderLayout());
		add(BorderLayout.WEST, scrollCompetite);
		setTitle("wordfeud");
		setSize(600, 400);
		setVisible(true);
	}
}
