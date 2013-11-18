package Wordfeud.InfoControllers;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import Wordfeud.DataBaseConnectie.DBMySQL;

public class CompetitionController {
	public static void Select() throws SQLException
	{
		DBMySQL db = new DBMySQL();
		// hier nog where toevoegen waarmee alleen de competities worden getoond die 
		// vandaag of eerder gestard zijn en vandaag of later eindigen.
		JTable dt = db.SelectDTTable("competitie");
		for (int i = 1; i < dt.getColumnCount(); i++) {
			TableColumn column = dt.getColumnModel().getColumn(i);
			int index = tcm.getColumnIndex(columnName);
		}
	}
}
