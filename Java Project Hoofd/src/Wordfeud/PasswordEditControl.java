package Wordfeud;
public class PasswordEditControl
{
	
	/**
	 * Vergelijkt de passwords met elkaar
	 * 
	 * @param Pass
	 *            Het ingevoerde password, dat vergeleken moet worden
	 * @return Geeft boolean terug, met resultaat of de texten hetzelfde zijn
	 */
	public boolean ComparePass(String Pass)
	{
		return (Pass.equals(getpass()));
	}
	
	/**
	 * Sla het nieuwe password op, model/logic layer voor het verwerken van een
	 * nieuw wachtwoord in de database
	 * 
	 * @param Gebruiker
	 *            Naam van de gebruiker, op dit account wordt het wachtwoord
	 *            opgeslagen
	 * @param Password
	 *            Het nieuwe password, Uncoded en in een string vorm
	 */
	public void SetPassword(String Gebruiker, String Password)
	{
		System.out.print("The password of <" + Gebruiker
				+ "> has been changed to <" + Password + ">\n");
	}
	
	// DB dummy
	private String getpass()
	{
		return UserInfo.password;
	}
	// DB dummy
}
