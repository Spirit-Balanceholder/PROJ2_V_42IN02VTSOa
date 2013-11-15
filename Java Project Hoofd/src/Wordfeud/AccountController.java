package Wordfeud;
import java.sql.SQLException;

public class AccountController
{
	void Select()
	{

	}

	void Insert(AccountInfo ai)
	{
		DBMySQL db = new DBMySQL();
		db.addDataValue("naam", ai.getName());
		db.addDataValue("wachtwoord", ai.getPassword());

		try
		{
			db.Insert("Account");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	void Update(AccountInfo ai) throws SQLException
	{
		DBMySQL db = new DBMySQL();
		db.addDataValue("wachtwoord", ai.getPassword());

		if (db.RecordExcist("Account", "naam", ai.getName()))
		{
			db.addWhere("naam", ai.getName());
			try
			{
				db.Update("Account");
			}
			catch (SQLException e)
			{

				e.printStackTrace();
			}
		}
	}

	void Delete(AccountInfo ai)
	{
		DBMySQL db = new DBMySQL();
		db.addWhere("Naam", ai.getName());

		try
		{
			db.Delete("Account");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
