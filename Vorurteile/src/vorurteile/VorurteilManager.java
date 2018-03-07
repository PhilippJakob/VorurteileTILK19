/**
 * @author Dimaa, 31. Januar 2018
 * @description Greift auf die Vorurteil Tabelle in der Datenbank zu
 * @changelog
 * | 31. Januar 2018: Dimaa 「erstellenVorurteil(), aktualisiertVorurteil(), istTitelVorhanden(), getVorurteil(), getVorurteile(), getNewID()」
 */

package vorurteile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TimeZone;

import com.mysql.jdbc.PreparedStatement;

import vorurteile.items.Vorurteil;

public class VorurteilManager
{
	/*
	 * Tutorial :)
	 * 
	 * Gibt alle Vorurteile mit dem Titel "Baum" aus
	 * for (Vorurteil lVorurteil : VorurteilManager.getVorurteile("Baum"))
	 * {
	 * 	System.out.println(lVorurteil.getID());
	 * }
	 * 
	 * Erstellt ein Vorurteil
	 *	VorurteilManager.erstellenVorurteil("Baumrinde", "Dimaa", LocalDateTime.now(), true, "https://dimaa.vip/", "Die beste Seite der Welt.");
	 */
	
	
	/**
	 * Erstellt ein neues Vorurteil
	 */
	public static Vorurteil erstellenVorurteil(String pTitel, String pAutor, LocalDateTime pVeröffentlichung, boolean pInternetquelle, String pLink, String pHauptaussage) 
	{		
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{			
			LocalDateTime lAktuellesDatum = LocalDateTime.now();
			Vorurteil lVorurteil = new Vorurteil(VorurteilManager.getNewID(), pTitel, pAutor, pVeröffentlichung, pInternetquelle, pLink, lAktuellesDatum, pHauptaussage);
			
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("INSERT INTO `vorurteile` (`ID_Vorurteile`, `Titel`, `Autor`, `Veröffentlichung`, `InternetQuelle_Ja_Nein`, `Link`, `Zeitstempel`, `Vorurteil_Text`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			lStatement.setInt(1, lVorurteil.getID());
			lStatement.setString(2, lVorurteil.getTitel());
			lStatement.setString(3, lVorurteil.getAutor());
			lStatement.setTimestamp(4, Timestamp.valueOf(lVorurteil.getVeröffentlichung()));
			lStatement.setBoolean(5, lVorurteil.getInternetquelle());
			lStatement.setString(6, lVorurteil.getLink());
			lStatement.setTimestamp(7, Timestamp.valueOf(lAktuellesDatum));
			lStatement.setString(8, lVorurteil.getHauptaussage());
			lStatement.executeUpdate();
			
			return lVorurteil;
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Aktualisiert das gegebene Vorurteil in der Datenbank.
	 */
	public static void aktualisiertVorurteil(Vorurteil pVorurteil) 
	{
		MySqlConnector lConnector = new MySqlConnector();
			
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("UPDATE `vorurteile` SET `Titel` = ?, `Autor` = ?, `Veröffentlichung` = ?, `InternetQuelle_Ja_Nein` = ?, `Link` = ?, `Zeitstempel` = ?, `Vorurteil_Text` = ? WHERE `ID_Vorurteile` = ?;");
			lStatement.setString(1, pVorurteil.getTitel());
			lStatement.setString(2, pVorurteil.getAutor());
			lStatement.setTimestamp(3, Timestamp.valueOf(pVorurteil.getVeröffentlichung()));
			lStatement.setBoolean(4, pVorurteil.getInternetquelle());
			lStatement.setString(5, pVorurteil.getLink());
			lStatement.setTimestamp(6, Timestamp.valueOf(pVorurteil.getZeitstempel()));
			lStatement.setString(7, pVorurteil.getHauptaussage());
			lStatement.setInt(8, pVorurteil.getID());
			lStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Prüft, ob Titel vom Vorurteil in der Datenbank schon vorhanden ist.
	 */
	public static boolean istTitelVorhanden(String pTitel) 
	{
		ArrayList<Vorurteil> lVorurteile = VorurteilManager.getVorurteile(pTitel);
		
		for(Vorurteil lVorurteil : lVorurteile) 
		{
			if (lVorurteil.getTitel().trim().equals(pTitel.trim())) 
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Gibt ein Vorurteil mit der eingegebenen ID aus.
	 */
	public static Vorurteil getVorurteil(int pID) 
	{
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("SELECT * FROM `vorurteile` WHERE `ID_Vorurteile` = ?;");
			lStatement.setInt(1, pID);
			ResultSet lResult = lStatement.executeQuery();
			
			if (lResult.next()) 
			{
				Vorurteil lVorurteil = new Vorurteil(lResult.getInt(1), lResult.getString(2), lResult.getString(3), LocalDateTime.ofInstant(Instant.ofEpochMilli(lResult.getDate(4).getTime()), TimeZone.getDefault().toZoneId()), lResult.getBoolean(5), lResult.getString(6), LocalDateTime.ofInstant(Instant.ofEpochMilli(lResult.getDate(7).getTime()), TimeZone.getDefault().toZoneId()), lResult.getString(8));
				return lVorurteil;
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Gibt eine Vorurteil-Liste mit dem gewünschten Titel aus.
	 */
	public static ArrayList<Vorurteil> getVorurteile(String pTitel)
	{
		ArrayList<Vorurteil> lVorurteile = new ArrayList<Vorurteil>();
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("SELECT * FROM `vorurteile` WHERE `Titel` LIKE ?;");
			lStatement.setString(1, "%" + pTitel + "%");
			ResultSet lResult = lStatement.executeQuery();
			
			while (lResult.next()) 
			{
				Vorurteil lVorurteil = new Vorurteil(lResult.getInt(1), lResult.getString(2), lResult.getString(3), LocalDateTime.ofInstant(Instant.ofEpochMilli(lResult.getDate(4).getTime()), TimeZone.getDefault().toZoneId()), lResult.getBoolean(5), lResult.getString(6), LocalDateTime.ofInstant(Instant.ofEpochMilli(lResult.getDate(7).getTime()), TimeZone.getDefault().toZoneId()), lResult.getString(8));
				lVorurteile.add(lVorurteil);
			}
			
			return lVorurteile;
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Erstellt eine nächsthöhere ID, die in der Datenbank noch nicht existiert.
	 */
	public static int getNewID()
	{
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			Statement lStatement = lConnector.getConnection().createStatement();
			ResultSet lResult = lStatement.executeQuery("SELECT MAX(`ID_Vorurteile`) FROM `vorurteile`;");
			
			if (lResult.next()) 
			{
				return (lResult.getInt(1) + 1);
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
}
