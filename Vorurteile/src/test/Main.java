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
			Connection lConnection = Datenbankverbindung.herstellenVerbindung();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT id_einbindung FROM einbindung WHERE id_Vorurteile = 13");
			if(lResult.first())
			{
				int test = lResult.getInt(1);
				System.out.println(test);
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}
