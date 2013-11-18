package Wordfeud.InfoControllers;

import java.sql.SQLException;

import javax.swing.JTable;

import Wordfeud.DataBaseConnectie.DBMySQL;

/**
 * 
 * @author Andy Scherrenberg
 * 
 */
public class AccountController
{
	public static JTable Select() throws SQLException
	{
		DBMySQL db = new DBMySQL();
		
		return db.SelectDT("Account");
	}
	
	public static void Insert(AccountInfo ai)
	{
		DBMySQL db = new DBMySQL();
		db.addDataValue("naam", ai.getName());
		db.addDataValue("wachtwoord", ai.getPassword());
		
		try
		{
			db.Insert("Account");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void Update(AccountInfo ai)
	{
		DBMySQL db = new DBMySQL();
		db.addDataValue("wachtwoord", ai.getPassword());
		try
		{
			if (db.RecordExcist("Account", "naam", ai.getName()))
			{
				db.addWhere("naam", ai.getName());
				
				db.Update("Account");
			}
		} catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	public static void Delete(AccountInfo ai)
	{
		DBMySQL db = new DBMySQL();
		db.addWhere("Naam", ai.getName());
		
		try
		{
			db.Delete("Account");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Auteur: Martin
	 * 
	 * @return geeft terug of account bestaat
	 * @throws SQLException
	 */
	public static boolean AccountExists(AccountInfo ai) throws SQLException
	{
		DBMySQL db = new DBMySQL();
		
		return db.RecordExcist("Account", "naam", ai.getName(), "wachtwoord",
				ai.getPassword());
	}
}
