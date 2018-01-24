package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import datenbank.Datenbankverbindung;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT titel FROM vorurteile WHERE autor = 'ich'");
			if(lResult.first())
			{
				String s = lResult.getString(1);
				System.out.println(s);
			}
			else
				System.out.println("Nein");
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}
