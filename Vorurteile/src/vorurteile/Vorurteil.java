package vorurteile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class Vorurteil
{
	private int id;
	
	private String titel;
	private String autor;
	private Date veröffentlichung;
	private String internetquelle;
	private String link;
	private Date zeitstempel;
	
	public Vorurteil(String pTitel, String pAutor, Date pVeröffentlichung, String pInternetQuelle, String pLink)
	{
		this.setTitel(pTitel);
		this.setAutor(pAutor);
		this.setVeröffentlichung(pVeröffentlichung);
		this.setInternetquelle(pInternetQuelle);
		this.setLink(pLink);
		this.setZeitstempel(new Date());
	}
	
	public void erstellen()
	{
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("INSERT INTO `vorurteile` (`Titel`, `Autor`, `Veröffentlichung`, `InternetQuelle_Ja_Nein`, `Link`, `Zeitstempel`) VALUES (?, ?, ?, ?, ?, ?);");
			lStatement.setString(1, this.getTitel());
			lStatement.setString(2, this.getAutor());
			lStatement.setDate(3, (java.sql.Date) this.getVeröffentlichung());
			lStatement.setString(4, this.getInternetquelle());
			lStatement.setString(5, this.getLink());
			lStatement.setDate(6, (java.sql.Date) this.getZeitstempel());
			lStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void aktualisieren() 
	{
		MySqlConnector lConnector = new MySqlConnector();
		
		try
		{
			PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("UPDATE `vorurteile` SET `titel` = ?, `autor` = ?;");
			lStatement.setString(1, this.getTitel());
			lStatement.setString(2, this.getAutor());
			lStatement.setDate(3, (java.sql.Date) this.getVeröffentlichung());
			lStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/** Getter & Setter **/

	public String getTitel()
	{
		return titel;
	}

	public void setTitel(String pTitel)
	{
		titel = pTitel;
	}

	public String getAutor()
	{
		return autor;
	}

	public void setAutor(String pAutor)
	{
		autor = pAutor;
	}

	public Date getVeröffentlichung()
	{
		return veröffentlichung;
	}

	public void setVeröffentlichung(Date pVeröffentlichung)
	{
		veröffentlichung = pVeröffentlichung;
	}

	public String getInternetquelle()
	{
		return internetquelle;
	}

	public void setInternetquelle(String pInternetquelle)
	{
		internetquelle = pInternetquelle;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String pLink)
	{
		link = pLink;
	}

	public Date getZeitstempel()
	{
		return zeitstempel;
	}

	public void setZeitstempel(Date pZeitstempel)
	{
		zeitstempel = pZeitstempel;
	}
}
