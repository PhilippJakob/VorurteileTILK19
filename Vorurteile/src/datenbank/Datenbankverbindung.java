package datenbank;

import java.sql.Connection;
import java.sql.DriverManager;

public class Datenbankverbindung
{
	private static Connection connection;
	public static String host = "dbserver";
	public static String database = "dbo_vorurteile";
	public static String user = "dbuser";
	public static String password = "benutzer";

	public static Connection getConnection()
	{
		if(connection == null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?user=" + user + "&password=" + password);
			}
			catch(Exception ex)
			{
				System.out.println("An error is occured while connecting to the database!");
				return null;
			}
		}
		return connection;
	}
}
