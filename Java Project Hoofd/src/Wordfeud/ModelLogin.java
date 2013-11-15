package Wordfeud;

import java.sql.SQLException;

import Wordfeud.InfoControllers.AccountController;
import Wordfeud.InfoControllers.AccountInfo;

/**
 * 
 * @author Martin
 * 
 */
public class ModelLogin
{
	
	AccountInfo SQLI;
	
	public ModelLogin()
	{
		SQLI = new AccountInfo();
	}
	
	protected boolean CheckLogin(String User, String Password)
			throws SQLException
	{
		SQLI.setName(User);
		SQLI.setPassword(Password);
		
		boolean result = false;
		if (AccountController.Select() != null)
			;
		{
			result = true;
		}
		return result;
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
