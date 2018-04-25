/**
  * Angelegt: 10.01.2018, Chantal Mielenz & Florian Henderkes, Zweck: Methoden zum auslesen von Informationen aus der Datenbank
  * Geändert: Januar & Anfang Februar, Chantal Mielenz, Methoden hinzugefügt und abgeändert
  * Geändert: 07.03.2018, Chantal Mielenz, Namenskonventionen
  * 14.3.2018 Tobias suchenUntergeordneteFakten Vorurteil zu Fakt geändert und methode temporär erweitert
  */
package hierarchie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import datenbank.Datenbankverbindung;
import fakten.Fakt;
import vorurteile.Vorurteil;
import vorurteile.VorurteilManager;

public class Hierarchie
{	
	
	/**
	 * Auslesen von untergeordneten Vorurteilen aus der Datenbank anhand einer ID eines übergeordneten Vorurteils.
	 * Gespeichert werden diese in einer ArrayList.
	 * @param pVorurteilID
	 * @return
	 */
	public static ArrayList<Vorurteil> suchenUntergeordneteVorurteile(int pVorurteilID)
	{
		ArrayList<Vorurteil> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lVerbindung = Datenbankverbindung.getConnection();
			Statement lBefehl = lVerbindung.createStatement();
			ResultSet lErgebnis = lBefehl.executeQuery("SELECT vu.ID_Vorurteile FROM dbo_vorurteile.vorurteile vo, dbo_vorurteile.vorurteile vu, dbo_vorurteile.verbindung_v_v vv WHERE vv.ID_Untergeordnetes_Vorurteil = vu.ID_Vorurteile AND vv.ID_Vorurteil = vo.ID_Vorurteile AND vo.ID_Vorurteile=" + pVorurteilID + ";");
			while(lErgebnis.next())
			{
				lListeVorurteile.add(VorurteilManager.getVorurteil(lErgebnis.getInt("vu.ID_vorurteile")));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return lListeVorurteile;

	}
	
	
	/**
	 * Auslesen von übergeordneten Vorurteilen aus der Datenbank anhand einer ID eines untergeordneten Vorurteils.
	 * Gespeichert werden diese in einer ArrayList.
	 * @param pVorurteilID
	 * @return
	 */
	public static ArrayList<Vorurteil> suchenÜbergeordneteVorurteile(int pVorurteilID)
	{
		ArrayList<Vorurteil> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lVerbindung = Datenbankverbindung.getConnection();
			Statement lBefehl = lVerbindung.createStatement();
			ResultSet lErgebnis = lBefehl.executeQuery("SELECT vo.Titel, vo.ID_Vorurteile, vo.Autor, vo.Internetquelle_Ja_Nein, vo.Link FROM dbo_vorurteile.vorurteile vo, dbo_vorurteile.vorurteile vu, dbo_vorurteile.verbindung_v_v vv WHERE vv.ID_Untergeordnetes_Vorurteil = vu.ID_Vorurteile AND vv.ID_Vorurteil = vo.ID_Vorurteile AND vu.ID_Vorurteile=" + pVorurteilID + ";");
			while(lErgebnis.next())
			{
				lListeVorurteile.add(VorurteilManager.getVorurteil(lErgebnis.getInt("vo.ID_vorurteile")));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return lListeVorurteile;
	}
	
	
	
	/**
	 * Auslesen von Fakten aus der Datenbank anhand einer ID eines untergeordneten Vorurteils.
	 * @param pVorurteilID
	 * @return
	 */
	public static ArrayList<Fakt> suchenUntergeordneteFakten(int pVorurteilID)
	{
		ArrayList<Fakt> lListeFakten = new ArrayList<>();
		try
		{
			Connection lVerbindung = Datenbankverbindung.getConnection();
			Statement lBefehl = lVerbindung.createStatement();
			ResultSet lErgebnis = lBefehl.executeQuery("SELECT f.ID_Fakten FROM dbo_vorurteile.fakten f, dbo_vorurteile.verbindung_f_v ve, dbo_vorurteile.vorurteile vo WHERE vo.ID_Vorurteile = ve.ID_Vorurteile AND ve.ID_Fakten = f.ID_Fakten AND vo.ID_Vorurteile=" + pVorurteilID + ";");
			while(lErgebnis.next())
			{
				lListeFakten.add(Fakt.suchenFaktenNachId(lErgebnis.getInt("f.ID_Fakten")));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		return lListeFakten;
	}
	
	
	
	/**
	 * Auslesen von untergeordneten Vorurteilen aus der Datenbank anhand einer ID eines Faktes.
	 * @param pFaktenID
	 * @return
	 */
	public static ArrayList<Vorurteil> suchenVorurteileMitFakten(int pFaktenID)
	{
		ArrayList<Vorurteil> lListeVorurteile = new ArrayList<>();
		try
		{
			Connection lVerbindung = Datenbankverbindung.getConnection();
			Statement lBefehl = lVerbindung.createStatement();
			ResultSet lErgebnis = lBefehl.executeQuery("SELECT vo.Titel, vo.ID_Vorurteile, vo.Autor, vo.Internetquelle_Ja_Nein, vo.Link FROM dbo_vorurteile.fakten f, dbo_vorurteile.verbindung_f_v ve, dbo_vorurteile.vorurteile vo WHERE vo.ID_Vorurteile = ve.ID_Vorurteile AND ve.ID_Fakten = f.ID_Fakten AND f.ID_Fakten=" + pFaktenID + ";");
			while(lErgebnis.next())
			{
				lListeVorurteile.add(VorurteilManager.getVorurteil(lErgebnis.getInt("vo.ID_vorurteile")));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return lListeVorurteile;
	}

}
