package vorurteile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class VorurteilManager
{
	
	public static void erstellenVorurteil(Vorurteil pVorurteil) 
	{
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("INSERT INTO `vorurteile` (`Vorurteile_ID`, `Titel`, `Autor`, `Veröffentlichung`, `InternetQuelle_Ja_Nein`, `Link`, `Zeitstempel`) VALUES (?, ?, ?, ?, ?, ?, ?);");
			lStatement.setInt(1, VorurteilManager.getNewID());
			lStatement.setString(2, pVorurteil.getTitel());
			lStatement.setString(3, pVorurteil.getAutor());
			lStatement.setDate(4, (java.sql.Date) pVorurteil.getVeröffentlichung());
			lStatement.setString(5, pVorurteil.getInternetquelle());
			lStatement.setString(6, pVorurteil.getLink());
			lStatement.setDate(7, (java.sql.Date) pVorurteil.getZeitstempel());
			lStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void speichernVorurteil(Vorurteil pVorurteil) 
	{
		MySqlConnector lConnector = new MySqlConnector();
			
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("UPDATE `vorurteile` SET `Titel` = ?, `Autor` = ?, `Veröffentlichung` = ?, `InternetQuelle_Ja_Nein` = ?, `Link` = ?, `Zeitstempel` = ? WHERE `Vorurteile_ID` = ?;");
			lStatement.setString(1, pVorurteil.getTitel());
			lStatement.setString(2, pVorurteil.getAutor());
			lStatement.setDate(3, (java.sql.Date) pVorurteil.getVeröffentlichung());
			lStatement.setString(4, pVorurteil.getInternetquelle());
			lStatement.setString(5, pVorurteil.getLink());
			lStatement.setDate(6, (java.sql.Date) pVorurteil.getZeitstempel());
			lStatement.setInt(7, pVorurteil.getID());
			lStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getNewID()
	{
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			Statement lStatement = lConnector.getConnection().createStatement();
			ResultSet lResult = lStatement.executeQuery("SELECT COUNT(`Vorurteile_ID`) FROM `vorurteile`;");
			
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
