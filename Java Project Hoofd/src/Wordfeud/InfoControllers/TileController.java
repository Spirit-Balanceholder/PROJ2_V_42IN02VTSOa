<<<<<<< HEAD
<<<<<<< HEAD
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
}
=======
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
		try (ResultSet resultSet = db.SelectDTtest("gelegdeletter"))
		{
			return resultSet;
		}

	}
}
>>>>>>> e2045e150c817acc36cecc07312bf3110828dc85
=======
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
		try (ResultSet resultSet = db.SelectDTtest("gelegdeletter"))
		{
			return resultSet;
		}

	}
}
>>>>>>> e2045e150c817acc36cecc07312bf3110828dc85
