package Wordfeud;

import java.sql.SQLException;

import Wordfeud.DataBaseConnectie.DBMySQL;

/**
 * 
 * @author Martin
 * 
 */
public class ModelLogin
{
	DBMySQL SQLC;
	
	public ModelLogin()
	{
		SQLC = new DBMySQL();
	}
	
	protected boolean CheckLogin(String User, String Password)
			throws SQLException
	{
		SQLC.RecordExcist("account", "naam", User);
		return (DBCheck(User, Password));
	}
	
	// DB Dummy
	private boolean DBCheck(String User, String Password)
	{
		if (User.equals("bla") && Password.equals("1234567890"))
		{
			return true;
		}
		return false;
	}
	// DB Dummy
}
