package Datenbank;

import java.sql.*;

public class Datenbankverbindung
{
	private static Connection connection;
	private static String host = "dbserver";
	private static String database = "dbo_vorurteile";
	private static String user = "dbuser";
	private static String password = "benutzer";

	public static void setzenParameter(String pHost, String pDatabase, String pUser, String pPassword)
	{
		host = pHost;
		database = pDatabase;
		user = pUser;
		password = pPassword;
	}

	public static Connection herstellenVerbindung()
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
				System.out.println("Fehler beim Verbindungsaufbau. :c");
				return null;
			}
		}
		return connection;
	}
}
