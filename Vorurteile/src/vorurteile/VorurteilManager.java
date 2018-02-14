package vorurteile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import vorurteile.items.Vorurteil;

public class VorurteilManager
{
	public static Vorurteil erstellenVorurteil(String pTitel, String pAutor, long pVeröffentlichung, String pInternetquelle, String pLink) 
	{		
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			Vorurteil lVorurteil = new Vorurteil(VorurteilManager.getNewID(), pTitel, pAutor, pVeröffentlichung, pInternetquelle, pLink);
			
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("INSERT INTO `vorurteile` (`ID_Vorurteile`, `Titel`, `Autor`, `Veröffentlichung`, `InternetQuelle_Ja_Nein`, `Link`, `Zeitstempel`) VALUES (?, ?, ?, ?, ?, ?, ?);");
			lStatement.setInt(1, lVorurteil.getID());
			lStatement.setString(2, lVorurteil.getTitel());
			lStatement.setString(3, lVorurteil.getAutor());
			lStatement.setTimestamp(4, new Timestamp(lVorurteil.getVeröffentlichung()));
			lStatement.setString(5, lVorurteil.getInternetquelle());
			lStatement.setString(6, lVorurteil.getLink());
			lStatement.setTimestamp(7, new Timestamp(new Date().getTime()));
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
	
	public static void speichernVorurteil(Vorurteil pVorurteil) 
	{
		MySqlConnector lConnector = new MySqlConnector();
			
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("UPDATE `vorurteile` SET `Titel` = ?, `Autor` = ?, `Veröffentlichung` = ?, `InternetQuelle_Ja_Nein` = ?, `Link` = ?, `Zeitstempel` = ? WHERE `ID_Vorurteile` = ?;");
			lStatement.setString(1, pVorurteil.getTitel());
			lStatement.setString(2, pVorurteil.getAutor());
			lStatement.setTimestamp(3, new Timestamp(pVorurteil.getVeröffentlichung()));
			lStatement.setString(4, pVorurteil.getInternetquelle());
			lStatement.setString(5, pVorurteil.getLink());
			lStatement.setTimestamp(6, new Timestamp(pVorurteil.getZeitstempel()));
			lStatement.setInt(7, pVorurteil.getID());
			lStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
				Vorurteil lVorurteil = new Vorurteil(lResult.getInt(1), lResult.getString(2), lResult.getString(3), lResult.getDate(4).getTime(), lResult.getString(5), lResult.getString(6));
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
	
	public static ArrayList<Vorurteil> getVorurteile(String pTitel)
	{
		ArrayList<Vorurteil> lVorurteile = new ArrayList<Vorurteil>();
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("SELECT * FROM `vorurteile` WHERE `Titel` LIKE ?");
			lStatement.setString(1, "%" + pTitel + "%");
			ResultSet lResult = lStatement.executeQuery();
			
			while (lResult.next()) 
			{
				Vorurteil lVorurteil = new Vorurteil(lResult.getInt(1), lResult.getString(2), lResult.getString(3), lResult.getDate(4).getTime(), lResult.getString(5), lResult.getString(6));
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
	
	public static int getNewID()
	{
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			Statement lStatement = lConnector.getConnection().createStatement();
			ResultSet lResult = lStatement.executeQuery("SELECT COUNT(`ID_Vorurteile`) FROM `vorurteile`;");
			
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
