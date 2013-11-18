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

	public static ResultSet getPlayedLetters(int Spel_ID) throws SQLException
	{
		DBMySQL db = new DBMySQL();
		db.addWhere("Spel_ID", Convert.ToString(Spel_ID));

		int lolol = Convert.ToInt("123");
		try (ResultSet resultSet = db.SelectDTtest("gelegdeletter"))
		{
			return resultSet;
		}

	}
}
