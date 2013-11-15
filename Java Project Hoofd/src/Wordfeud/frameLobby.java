package Wordfeud;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * 
 * @author Kai
 * 
 */
public class frameLobby extends JFrame
{
	private JScrollPane scrollCompetite;
	private JList<String> listCompetite;
	
	public frameLobby()
	{
		listCompetite = new JList<String>();
		listCompetite.add("Kai", new JLabel("Kai"));
		
		scrollCompetite = new JScrollPane();
		scrollCompetite.setVisible(true);
		scrollCompetite.add(listCompetite);
		scrollCompetite.setSize(80, 200);
		
		setLayout(new BorderLayout());
		add(scrollCompetite);
		setTitle("wordfeud");
		setSize(600, 400);
		setEnabled(true);
		setVisible(true);
	}
}
