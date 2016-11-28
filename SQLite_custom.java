
import java.sql.*;

/*
	-> Add this class to your project folder and modify the package statement to yor own
	
	-> This code makes your usage of SQLite easier, have a look! 
	
	-> When an object is created for this class, specify the name of the database as an 
	argument.
	
	-> executeUpdate() takes a string argument and does the actual executeUpdate() operation
	for you.
	
	-> executeQuery() takes a string argument and returns the 'ResultSet' value
	of the given query. It does the actual executeQuery() operation for you.
	
	-> Always remember to close after the work is over using close() function.
*/
public class SQLite_custom
{
	Connection c = null;
	Statement stmt = null;
	ResultSet rs = null;

	public SQLite_custom(String dbName)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + dbName);//test.db
			stmt = c.createStatement();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		//System.out.println("Opened database successfully");
	}

	public void executeUpdate(String updateQuery)
	{
		try
		{
			//System.out.println("Opened database successfully");

			String sql = updateQuery;
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		//System.out.println("Table created successfully");
	}

	public ResultSet executeQuery(String query) throws SQLException
	{

		rs = stmt.executeQuery(query);
		return rs;
	}

	public void close() throws SQLException
	{
		rs.close();
		stmt.close();
		c.close();
	}
}
