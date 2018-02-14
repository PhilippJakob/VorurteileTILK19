package test;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import datenbank.Datenbankverbindung;
import vorurteile.Vorurteile;

public class Verknüpfung
{
	public static ArrayList<String> suchenUntergeordneteVorurteile(int pVorurteilID){
		ArrayList<String> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT vu.Titel FROM dbo_vorurteile.vorurteile vo, dbo_vorurteile.vorurteile vu, dbo_vorurteile.verbindung_v_v vv WHERE vv.ID_Untergeordnetes_Vorurteil = vu.ID_Vorurteile AND vv.ID_Vorurteil = vo.ID_Vorurteile AND vo.ID_Vorurteile=" + pVorurteilID + ";");
			while(lResult.next())
			{
				lListeVorurteile.add(lResult.getString("Titel"));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		for(String s : lListeVorurteile){
			System.out.println(s);
		}
		return lListeVorurteile;

	}

	public static ArrayList<String> suchenÜbergeordneteVorurteile(int pVorurteilID){
		ArrayList<String> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT vo.Titel FROM dbo_vorurteile.vorurteile vo, dbo_vorurteile.vorurteile vu, dbo_vorurteile.verbindung_v_v vv WHERE vv.ID_Untergeordnetes_Vorurteil = vu.ID_Vorurteile AND vv.ID_Vorurteil = vo.ID_Vorurteile AND vu.ID_Vorurteile=" + pVorurteilID + ";");
			while(lResult.next())
			{
				lListeVorurteile.add(lResult.getString("Titel"));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		for(String s : lListeVorurteile){
			System.out.println(s);
		}
		return lListeVorurteile;

	}

	public static ArrayList<String> suchenUntergeordneteFakten(int pVorurteilID){
		ArrayList<String> lListeFakten = new ArrayList<>();
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT f.Titel FROM dbo_vorurteile.fakten f, dbo_vorurteile.verbindung ve, dbo_vorurteile.vorurteile vo WHERE vo.ID_Vorurteile = ve.ID_Vorurteile AND ve.ID_Fakten = f.ID_Fakten AND vo.ID_Vorurteile=" + pVorurteilID + ";");
			while(lResult.next())
			{
				lListeFakten.add(lResult.getString("Titel"));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		for(String s : lListeFakten){
			System.out.println(s);
		}
		return lListeFakten;

	}

}
