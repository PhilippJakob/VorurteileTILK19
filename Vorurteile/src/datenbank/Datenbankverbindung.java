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
				connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?user=" + user + "&password=" + password);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
		}
		return connection;
	}
}
