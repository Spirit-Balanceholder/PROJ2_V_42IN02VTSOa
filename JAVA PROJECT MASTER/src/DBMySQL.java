import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBMySQL
{

	void Execute(String query) throws SQLException
	{
		Connection con = ConnectionCl.Connect();

		Statement executequery = con.createStatement();

		executequery.execute(query);

		executequery.close();
		con.close();
	}

	String	SelectQuery	= "";

	String	Where		= "";

	String	Table		= "";

	String	Insert		= "";

	String	Values		= "";

	String	Updates		= "";

	void addWhere(String Field, String Value)
	{
		if (Where.equals(""))
			Where = String.format(" Where %s = '%s'", Field, Value);
		else
			Where += String.format(" and %s = '%s'", Field, Value);
	}

	void addDataValue(String Field, String Value)
	{
		if (Insert.equals(""))
			Insert = String.format("%s", Field);
		else
			Insert += String.format(",%s", Field);

		if (Values.equals(""))
			Values = String.format("'%s'", Value);
		else
			Values += String.format(",'%s'", Value);

		if (Updates.equals(""))
			Updates = String.format("%s = '%s'", Field, Value);
		else
			Updates += String.format(",%s = '%s'", Field, Value);
	}

	void Update(String tableName) throws SQLException
	{
		String UpdateStament = String.format("Update `%s` set %s ", tableName,
				Updates) + Where;

		Connection con = ConnectionCl.Connect();
		Statement executequery = con.createStatement();

		executequery.executeUpdate(UpdateStament);
		executequery.close();
		con.close();
	}

	void Insert(String tableName) throws SQLException
	{
		String InsertStament = String.format("Insert into `%s`(%s) values(%s)",
				tableName, Insert, Values);
		Execute(InsertStament);
	}

	JTable SelectDT(String tableName) throws SQLException
	{
		String query = String.format("Select * From `%s` ", tableName) + Where;

		Connection con = ConnectionCl.Connect();

		Statement select = con.createStatement();
		ResultSet result = select.executeQuery(query);

		JTable table = new JTable(buildTableModel(result));

		select.close();
		con.close();

		return table;
	}

	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException
	{

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++)
		{
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next())
		{
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++)
			{
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
}
