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

		return db.SelectDTResult("Tegel");

	}

	public static ResultSet getFromXY(int x, int y) throws SQLException
	{
		DBMySQL db = new DBMySQL();
		db.addWhere("x", Convert.ToString(x));
		db.addWhere("y", Convert.ToString(y));

		return db.SelectDTResult("Tegel");

	}

	public static ResultSet getPlayedLetters(int Spel_ID) throws SQLException
	{
		DBMySQL db = new DBMySQL();
		// db.addWhere("", Convert.ToString(Spel_ID));
		db.addJoin("inner", "Letter", "ID", "gelegdeletter", "Letter_ID");
		db.addWhereJoin("gelegdeletter", "Spel_ID", Convert.ToString(Spel_ID));
		db.setisJoin(true);
		ResultSet resultSet = db.SelectDTResult("gelegdeletter");

		/*
		 * 
		 * select * from gelegdeletter join Letter on Gelegdeletter.Letter_ID =
		 * Letter.ID where Gelegdeletter.Spel_ID = 511
		 * 
		 * 
		 * select * FROM lettertype
		 */
		return resultSet;

	}
}
