package Wordfeud.DataBaseConnectie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 
 * @author Andy Scherrenberg
 * 
 *         Deze class regelt het opbouwen van de MySQL statements. Deze class
 *         stuurt ook de JTables terug voor de select statements.
 * 
 */
public class DBMySQL
{
	/**
	 * De variabele die in deze class worden gebruikt om de query's op te
	 * bouwen.
	 */
	private String	Where		= "";
	private String	TableName	= "";
	private String	Insert		= "";
	private String	Values		= "";
	private String	Updates		= "";

	/**
	 * Deze methode is verantwoordelijk voor het uitvoeren van een query. Deze
	 * methode mag nooit van buiten worden benaderd.
	 * 
	 * @param _query
	 *            De query die uitgevoerd moet worden.
	 * @throws SQLException
	 * 
	 *             De Connectie word ingeladen door ConnectionCl.Connect(). Er
	 *             word van de Connectie een Statement gemaakt. De query word
	 *             daarna uitgevoerd. De connectie word afgesloten.
	 */
	private void Execute(String _query) throws SQLException
	{
		Connection con = ConnectionCl.Connect();

		Statement executequery = con.createStatement();

		executequery.execute(_query);

		executequery.close();
		con.close();
	}

	/**
	 * Deze methode bouwt de where clasue op voor mysql
	 * 
	 * @param _field
	 *            de naam van het veld in de database.
	 * 
	 * @param _value
	 *            de waarde die het veld moet hebben.
	 * 
	 *            Als where leeg is dan word er een begin gemaakt aan de where
	 *            clause. Mochten er al gegevens staan in where dan word het
	 *            toegevoegd als een and.
	 */
	public void addWhere(String _field, String _value)
	{
		if (Where.equals(""))
			Where = String.format(" Where `%s` = '%s'", _field, _value);
		else
			Where += String.format(" and `%s` = '%s'", _field, _value);

	}

	/**
	 * Deze methode bouwt een where clause op die like bevat voor mysql.
	 * 
	 * @param _field
	 *            de naam van het veld in de database.
	 * @param _value
	 *            de waarde die het veld moet hebben.
	 * 
	 *            Als where leeg is dan word er een begin gemaakt aan de where
	 *            clause. Mochten er al gegevens staan in where dan word het
	 *            toegevoegd als een and.
	 */
	public void addWhereLike(String _field, String _value)
	{
		if (Where.equals(""))
			Where = " Where `" + _field + "` like '%" + _value + "%'";
		else
			Where += " and `" + _field + "` like '%" + _value + "%'";
	}

	/**
	 * Deze methode is verantwoordelijk voor het opbouwen van de insert en
	 * update statements voor MySQL.
	 * 
	 * @param _field
	 *            de naam van het veld in de database.
	 * @param _value
	 *            de waarde die het veld moet hebben.
	 * 
	 *            Update en Insert worden gelijk opgebouwd, omdat ze beide
	 *            afhankelijk zijn van add datavalue; Insert word opbebouwd door
	 *            _field als er al informatie in Insert staat dan word dit
	 *            anders opgebouwd. Dit geld ook voor Values en Updates.
	 */
	public void addDataValue(String _field, String _value)
	{
		if (Insert.equals(""))
			Insert = String.format("`%s`", _field);
		else
			Insert += String.format(",`%s`", _field);

		if (Values.equals(""))
			Values = String.format("'%s'", _value);
		else
			Values += String.format(",'%s'", _value);

		if (Updates.equals(""))
			Updates = String.format("`%s` = '%s'", _field, _value);
		else
			Updates += String.format(",`%s` = '%s'", _field, _value);
	}

	/**
	 * Deze methode bouwt de query voor het verwijderen van gegevens uit de
	 * database.
	 * 
	 * @param _tableName
	 *            De naam van de tabel waar gegevens uit moeten worden
	 *            verwijderd.
	 * 
	 * @throws SQLException
	 * 
	 *             Het Deletestatement word opgebouwd. Als Where aanwezig is dan
	 *             word deze toegevoegd. Aanroepen van Execute en het mysql
	 *             statement meesturen.
	 */
	public void Delete(String _tableName) throws SQLException
	{
		String DeleteStatement = String.format("Delete from `%s` ", _tableName)
				+ Where;

		Execute(DeleteStatement);
	}

	/**
	 * Deze methode bouwt een Updatestatement op voor mySql.
	 * 
	 * @param _tableName
	 *            De naam van de tabel waarin de gegevens moeten worden
	 *            geupdate.
	 * 
	 * @throws SQLException
	 * 
	 *             De update statement word opgebouwd. Als where aanwezig is dan
	 *             word deze toegevoegd. Aanroepen van Execute en het mysql
	 *             statement meesturen.
	 */
	public void Update(String _tableName) throws SQLException
	{
		String UpdateStament = String.format("Update `%s` set %s ", _tableName,
				Updates) + Where;

		Execute(UpdateStament);
	}

	/**
	 * De methode bouwt de query op voor het inserten van gegevens in de
	 * database.
	 * 
	 * @param _tableName
	 *            De naam van de tabel waarin de gegevens moeten worden
	 *            geinsert.
	 * 
	 * @throws SQLException
	 * 
	 *             Het insert statement word opgebouwd. Aanroepen van Execute en
	 *             het mysql statement meesturen.
	 */
	public void Insert(String _tableName) throws SQLException
	{
		String InsertStament = String.format("Insert into `%s`(%s) values(%s)",
				_tableName, Insert, Values);

		Execute(InsertStament);
	}

	/**
	 * Het ophalen van gegevens uit de database. Dit vraagt altijd alle velden
	 * op. Dit blijft zo. Totdat iemand komt met een perfecte reden waarom dit
	 * anders moet.
	 * 
	 * @param _tableName
	 *            De naam van tabel die moet worden opgevraagd.
	 * @return stuurt een JTable terug met alle benodigde informatie.
	 * 
	 * @throws SQLException
	 * 
	 *             Het opbouwen van een Select statement voor MySQL. Als er een
	 *             where statement is dan word deze toegevoegd.
	 * 
	 *             Een connectie maken gebaseerd op de ConnectionCl.Connect();
	 *             Statement uitvoerbaar maken. Een Resulset aanmaken en deze
	 *             vullen met een uitgevoerd statement.
	 * 
	 *             Een JTable opbouwen vanuit de resultset. Dit word gedaan door
	 *             buildTableModel waarin de resultset word meegestuurd.
	 * 
	 *             Alle connecties sluiten die open staan.
	 * 
	 *             De table terug sturen die de informatie bevat.
	 * 
	 */
	public JTable SelectDTTable(String _tableName) throws SQLException
	{
		String query = String.format("Select * From `%s` ", _tableName) + Where;

		Connection con = ConnectionCl.Connect();

		Statement select = con.createStatement();
		ResultSet result = select.executeQuery(query);

		JTable table = new JTable(buildTableModel(result));

		select.close();
		con.close();

		return table;
	}

	// deze heeft mike aangemaakt, omdat result gebruikelijk lijkt te zijn
	// (equivalent aan datatable van c#)
	public ResultSet SelectDTResult(String _tableName) throws SQLException
	{
		String query = String.format("Select * From `%s` ", _tableName) + Where;

		Connection con = ConnectionCl.Connect();

		Statement select = con.createStatement();
		ResultSet result = select.executeQuery(query);

		CachedRowSet rowset = new CachedRowSetImpl();
		rowset.populate(result);

		con.close();

		return rowset;
		/*
		 * try { return result; } finally {
		 * 
		 * result.close();
		 * 
		 * /* select.close(); con.close();
		 * 
		 * 
		 * }
		 */

	}

	/**
	 * Door gebruik te maken van deze methode kun je een custom select query
	 * uitvoeren. Dit is bijvoorbeeld bruikbaar als je niet alle velden wilt
	 * hebben.
	 * 
	 * @param _query
	 *            Een custom select query die je zou willen uitvoeren.
	 * 
	 * @return stuurt een JTable terug met alle benodigde informatie.
	 * @throws SQLException
	 * 
	 *             Een connectie maken gebaseerd op de ConnectionCl.Connect();
	 *             Statement uitvoerbaar maken. Een Resulset aanmaken en deze
	 *             vullen met een uitgevoerd statement.
	 * 
	 *             Een JTable opbouwen vanuit de resultset. Dit word gedaan door
	 *             buildTableModel waarin de resultset word meegestuurd.
	 * 
	 *             Alle connecties sluiten die open staan.
	 * 
	 *             De table terug sturen die de informatie bevat.
	 */
	public JTable RunSelect(String _query) throws SQLException
	{
		Connection con = ConnectionCl.Connect();

		Statement select = con.createStatement();
		ResultSet result = select.executeQuery(_query);

		JTable table = new JTable(buildTableModel(result));

		select.close();
		con.close();

		return table;
	}

	public Object[] SelectDR(String _tableName) throws SQLException
	{
		String query = String.format("Select * From `%s` ", _tableName) + Where;

		Connection con = ConnectionCl.Connect();

		Statement select = con.createStatement();
		ResultSet result = select.executeQuery(query);

		JTable table = new JTable(buildTableModel(result));

		if (table.getRowCount() >= 1)
		{
			Object[] val = new Object[table.getColumnCount()];
			// return table;

			for (int i = 0; i < table.getColumnCount(); i++)
			{
				val[i] = table.getValueAt(0, i);
			}

			return val;
		}

		return null;

	}

	/**
	 * Door deze methode kun je een custom query uitvoeren. Dit kan alleen een
	 * Update/Insert of delete statement zijn.
	 * 
	 * @param _query
	 *            De query die je wilt uitvoeren op de database.
	 * 
	 * @throws SQLException
	 * 
	 *             Execute word aangeroepen en _query word meegestuurd.
	 */
	void RunQuery(String _query) throws SQLException
	{
		Execute(_query);
	}

	/**
	 * Deze documenteer ik later. Ben er nog niet helemaal tevereden over.
	 * 
	 * @param _rs
	 * @return
	 * @throws SQLException
	 */
	private static DefaultTableModel buildTableModel(ResultSet _rs)
			throws SQLException
	{

		ResultSetMetaData metaData = _rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++)
		{
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (_rs.next())
		{
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++)
			{
				vector.add(_rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}

	public boolean RecordExcist(String _tableName, String _fieldName,
			String _value) throws SQLException
	{

		String RecordChecker = String.format(
				"select * from %S where %s = '%s'", _tableName, _fieldName,
				_value);

		Connection con = ConnectionCl.Connect();

		Statement select = con.createStatement();
		ResultSet result = select.executeQuery(RecordChecker);

		result.last();
		int i = result.getRow();

		if (i > 0)
			return true;

		return false;
	}

	public boolean RecordExcist(String _tableName, String _fieldName,
			String _value, String _fieldName2, String _value2)
			throws SQLException
	{

		String RecordChecker = String.format(
				"select * from %S where %s = '%s' and %s = '%s'", _tableName,
				_fieldName, _value, _fieldName2, _value2);

		Connection con = ConnectionCl.Connect();

		Statement select = con.createStatement();
		ResultSet result = select.executeQuery(RecordChecker);

		result.last();
		int i = result.getRow();

		if (i > 0)
			return true;

		return false;
	}

}
