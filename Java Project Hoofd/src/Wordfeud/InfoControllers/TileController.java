package Wordfeud.InfoControllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import Wordfeud.Convert;
import Wordfeud.DataBaseConnectie.DBMySQL;

public class TileController
{
	public static JTable Select() throws SQLException
	{
		DBMySQL db = new DBMySQL();

		return db.SelectDT("Tegel");

	}

	public static ResultSet getFromXY(int x, int y) throws SQLException
	{
		DBMySQL db = new DBMySQL();
		db.addWhere("x", Convert.ToString(x));
		db.addWhere("y", Convert.ToString(y));

		return db.SelectDTtest("Tegel");

	}
}
