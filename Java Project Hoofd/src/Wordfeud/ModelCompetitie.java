package Wordfeud;
/**
 * 
 * @author Martin
 * 
 */
public class ModelCompetitie
{
	protected String[] GetComp(int ID)
	{
		return DBGetComp(ID);
	}
	
	// DB dummy
	private String[] DBGetComp(int ID)
	{
		String[] x =
		{
				"15-11-2013",
				"15-11-2014",
				"bla bla bla test shit bla bla bla competitie bla bla yolo bla join now bla bla bla wordfeud ftw bla" };
		return x;
	}
	// DB dummy
}
