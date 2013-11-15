package Wordfeud;

import java.awt.Point;
import java.sql.SQLException;

import javax.swing.JTable;

import Wordfeud.InfoControllers.AccountController;
import Wordfeud.InfoControllers.AccountInfo;

/**
 * 
 * @author Martin
 * 
 */
public class ModelLogin
{
	
	AccountInfo ai;
	
	public ModelLogin()
	{
		ai = new AccountInfo();
	}
	
	protected boolean CheckLogin(String User, String Password)
			throws SQLException
	{
		JTable temp = AccountController.Select();
		for (int x = 0; x < temp.getRowCount(); x++)
		{
			System.out.print(String.valueOf(temp.rowAtPoint(new Point(x, 0)))
					+ " " + String.valueOf(temp.rowAtPoint(new Point(x, 1))));
		}
		
		ai.setName(User);
		ai.setPassword(Password);
		
		return AccountController.AccountExists(ai);
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
