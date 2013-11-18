package Wordfeud.InfoControllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import Wordfeud.Convert;
import Wordfeud.DataBaseConnectie.DBMySQL;
import Wordfeud.DataBaseConnectie.DBMySQL.Joins;

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
		//
		db.addJoin(Joins.Inner, "Letter", "ID", "gelegdeletter", "Letter_ID");
		//
		// inner join LetterType on LetterType.karakter =
		// Letter.LetterType_Karakter
		db.addJoin(Joins.Inner, "LetterType", "karakter", "Letter",
				"LetterType_Karakter");
		//
		db.addWhereJoin("gelegdeletter", "Spel_ID", Convert.ToString(Spel_ID));

		db.setisJoin(true);
		ResultSet resultSet = db.SelectDTResult("gelegdeletter");

		return resultSet;

	}
}
