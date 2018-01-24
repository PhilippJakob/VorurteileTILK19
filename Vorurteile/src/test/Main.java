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
			ResultSet lResult = lBefehl.executeQuery("");
			if(lResult.first())
				System.out.println("Ja");
			else
				System.out.println("Nein");
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}
