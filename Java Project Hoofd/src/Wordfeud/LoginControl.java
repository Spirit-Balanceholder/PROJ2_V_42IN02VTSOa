package Wordfeud;
/**
 * 
 * @author Martin
 * 
 */
public class LoginControl
{
	protected boolean CheckLogin(String User, String Password)
	{
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
