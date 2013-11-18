package Wordfeud;

public class Convert
{
	public static String ToString(Object x)
	{
		return x.toString();
	}

	public static int ToInt(Object x)
	{
		int i = 0;
		try
		{
			i = Integer.valueOf((String) x);
		} catch (Exception e)
		{
			ErrorHandle.Print(e, "Convert.toInt");
			i = 0;
		}
		return i;
	}
}

class ErrorHandle
{
	public static void Print(Exception e, String From)
	{
		System.out.println("Error from " + From + ": " + e.getMessage());
	}
}
