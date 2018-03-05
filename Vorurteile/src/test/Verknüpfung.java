package test;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import datenbank.Datenbankverbindung;
import vorurteile.items.Vorurteil;

public class Verknüpfung
{
	public static ArrayList<Vorurteil> suchenUntergeordneteVorurteile(int pVorurteilID){
		ArrayList<Vorurteil> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT vu.Titel, vu.ID_Vorurteile, vu.Autor, vu.Internetquelle_Ja_Nein, vu.Link FROM dbo_vorurteile.vorurteile vo, dbo_vorurteile.vorurteile vu, dbo_vorurteile.verbindung_v_v vv WHERE vv.ID_Untergeordnetes_Vorurteil = vu.ID_Vorurteile AND vv.ID_Vorurteil = vo.ID_Vorurteile AND vo.ID_Vorurteile=" + pVorurteilID + ";");
			while(lResult.next())
			{
				lListeVorurteile.add(new Vorurteil(lResult.getInt("vu.ID_Vorurteile"), lResult.getString("vu.Titel"), lResult.getString("vu.Autor"), 0, lResult.getString("vu.Internetquelle_Ja_Nein"), lResult.getString("vu.Link")));

			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		for(Vorurteil s : lListeVorurteile){
			System.out.println(s.getTitel());
		}
		return lListeVorurteile;

	}

	public static ArrayList<Vorurteil> suchenVorurteil(int pVorurteilID){
		ArrayList<Vorurteil> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT Titel, Autor, Internetquelle_Ja_Nein, Link FROM dbo_vorurteile.vorurteile vu WHERE ID_Vorurteile=" + pVorurteilID + ";");
			while(lResult.next())
			{
				lListeVorurteile.add(new Vorurteil(pVorurteilID, lResult.getString("Titel"), lResult.getString("Autor"), 0, lResult.getString("Internetquelle_Ja_Nein"), lResult.getString("Link")));

			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		for(Vorurteil s : lListeVorurteile){
			System.out.println(s.getTitel());
		}
		return lListeVorurteile;

	}

	public static ArrayList<Vorurteil> suchenÜbergeordneteVorurteile(int pVorurteilID){
		ArrayList<Vorurteil> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT vo.Titel, vo.ID_Vorurteile, vo.Autor, vo.Internetquelle_Ja_Nein, vo.Link FROM dbo_vorurteile.vorurteile vo, dbo_vorurteile.vorurteile vu, dbo_vorurteile.verbindung_v_v vv WHERE vv.ID_Untergeordnetes_Vorurteil = vu.ID_Vorurteile AND vv.ID_Vorurteil = vo.ID_Vorurteile AND vu.ID_Vorurteile=" + pVorurteilID + ";");
			while(lResult.next())
			{
				lListeVorurteile.add(new Vorurteil(lResult.getInt("vo.ID_Vorurteile"), lResult.getString("vo.Titel"), lResult.getString("vo.Autor"), 0, lResult.getString("vo.Internetquelle_Ja_Nein"), lResult.getString("vo.Link")));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		for(Vorurteil s : lListeVorurteile){
			System.out.println(s.getTitel());
		}

		return lListeVorurteile;

	}

	public static ArrayList<Vorurteil> suchenUntergeordneteFakten(int pVorurteilID){
		ArrayList<Vorurteil> lListeFakten = new ArrayList<>();
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT f.Titel, f.ID_Fakten FROM dbo_vorurteile.fakten f, dbo_vorurteile.verbindung_f_v ve, dbo_vorurteile.vorurteile vo WHERE vo.ID_Vorurteile = ve.ID_Vorurteile AND ve.ID_Fakten = f.ID_Fakten AND vo.ID_Vorurteile=" + pVorurteilID + ";");
			while(lResult.next())
			{

			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		for(Vorurteil s : lListeFakten){
			System.out.println(s);
		}
		return lListeFakten;

	}

	public static ArrayList<Vorurteil> suchenVorurteileMitFakten(int pFaktenID){
		ArrayList<Vorurteil> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT vo.Titel, vo.ID_Vorurteile, vo.Autor, vo.Internetquelle_Ja_Nein, vo.Link FROM dbo_vorurteile.fakten f, dbo_vorurteile.verbindung_f_v ve, dbo_vorurteile.vorurteile vo WHERE vo.ID_Vorurteile = ve.ID_Vorurteile AND ve.ID_Fakten = f.ID_Fakten AND f.ID_Fakten=" + pFaktenID + ";");
			while(lResult.next())
			{
				lListeVorurteile.add(new Vorurteil(lResult.getInt("vo.ID_Vorurteile"), lResult.getString("vo.Titel"), lResult.getString("vo.Autor"), 0, lResult.getString("vo.Internetquelle_Ja_Nein"), lResult.getString("vo.Link")));

			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		for(Vorurteil s : lListeVorurteile){
			System.out.println(s.getTitel());
		}
		return lListeVorurteile;
	}


}
