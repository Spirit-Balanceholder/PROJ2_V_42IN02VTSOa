package Wordfeud;

public class AccMControl {

	
	public String[][] getPlayers ()
	{
		return GetAccountnamesFromDB();
	}
	
	public void UpdateStatus (String[] nwstatus)
	{
		System.out.print("Naam:" + nwstatus[0] + " " + "Observer:" + nwstatus[1] + " " + "Mod:" + nwstatus[2] + " " + "Admin:" + nwstatus[3] + " ");
	}
	
	/////////////////
	// DB Dummy
	private String[][] GetAccountnamesFromDB()
	{
		String[][] x = {{"henk", "true", "false", "false"}, 
				{"kaas", "true", "true", "true"}, 
				{"bla", "false", "true", "false"},
				{"test", "false", "false", "true"}};
		return x;
	}
	// DB Dummy
	//////////////////
}
