package Wordfeud;

import java.sql.SQLException;

/**
 * 
 * @author Martin
 * 
 */
public class LoginControl
{
	DBMySQL SQLC;
	
	public LoginControl()
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
