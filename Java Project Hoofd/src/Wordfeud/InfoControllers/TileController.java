package Wordfeud.InfoControllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import Wordfeud.Convert;
import Wordfeud.DataBaseConnectie.DBMySQL;

public class TileController
{
	public static ResultSet Select() throws SQLException
	{
		DBMySQL db = new DBMySQL();

		return db.SelectDTtest("Tegel");

	}

	public static ResultSet getFromXY(int x, int y) throws SQLException
	{
		DBMySQL db = new DBMySQL();
		db.addWhere("x", Convert.ToString(x));
		db.addWhere("y", Convert.ToString(y));

		return db.SelectDTtest("Tegel");

	}
}
