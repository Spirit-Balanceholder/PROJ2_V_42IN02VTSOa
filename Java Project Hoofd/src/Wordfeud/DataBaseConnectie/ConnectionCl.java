package Wordfeud.DataBaseConnectie;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Andy Scherrenberg
 * 
 */
class ConnectionCl
{
	static Connection Connect()
	{
		// DataBase locatie
		String url = DBConnectie.Connectie + DBConnectie.DataBase;

		// Driver die gebruikt gaat worden
		String driver = "com.mysql.jdbc.Driver";
		// Inlognaam
		String userName = DBConnectie.DB_User;
		// Wachtwoord
		String password = DBConnectie.DB_Password;

		Connection test = null;

		try
		{
			Class.forName(driver).newInstance();

		}
		catch (Exception e)
		{
			System.out.println("Driver fail");
		}

		try
		{
			test = DriverManager.getConnection(url, userName, password);

		}
		catch (Exception e)
		{
			System.out.println(e);

		}

		return test;
	}
}
