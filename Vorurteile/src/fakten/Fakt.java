/*
 * angelegt von  Fin Pohle am 17.1.18
 */
package fakten;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class Fakt
{
	 private String titel;
    IDFakten iDFakten;
    private boolean istInternetquelle;
    private String autor;
    private String link;
    private LocalDate datum;
    private String aussage;
    //private int IDFakten;
    Calendar ccalendar;


	public Fakt(String pTitel, String pAutor, LocalDate pDatum, boolean pIstInternetquelle, String pLink, String pAussage)
	{
			this.titel = pTitel;
			this.iDFakten = new IDFakten();
			this.istInternetquelle = pIstInternetquelle;
			this.autor = pAutor;
			this.link = pLink;
			this.datum = pDatum;
			this.aussage = pAussage;
	}

	public void anlegen()
	{
		speichernFakt();
		System.out.println(iDFakten.getIDFakten());

	}

	public void speichernFakt()
	{
	  Connection lConnection = DatenbankVerbindungFakten.holen();
	  Statement lBefehl;

	  try
	  {
		lBefehl = lConnection.createStatement();
      LocalDate datumStempel;
      datumStempel= LocalDate.now();
      // FIXME: injections
		lBefehl.execute("INSERT INTO dbo_vorurteile.fakten VALUES ("+iDFakten.getIDFakten()+",\""+titel+"\",\""+autor+"\",\""+datum+"\",\""+istInternetquelle+"\",\""+link+"\",\""+aussage+"\",\""+datumStempel+"\")");
	  } catch (SQLException e)
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}

	public static List<Fakt> suchenFakten(String pTitel)
	{
		Connection lConnection = DatenbankVerbindungFakten.holen();

		try
		{
			PreparedStatement lBefehl = lConnection.prepareStatement("SELECT * FROM dbo_vorurteile.fakten WHERE Titel LIKE ?");
			lBefehl.setString(1, "%" + pTitel + "%");
			
			ResultSet lResult = lBefehl.executeQuery();
			
			ArrayList<Fakt> lFakten = new ArrayList<Fakt>();
			
			while (lResult.next())
			{
				lFakten.add(new Fakt(lResult.getString("Titel"),lResult.getString("Autor"), lResult.getDate("Veröffentlichung").toLocalDate(), lResult.getBoolean("InternetQuelle_Ja_Nein"), lResult.getString("Link"), lResult.getString("Aussage") ));
			}
			
			return lFakten;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
	};
	

	public String getTitel()
	{
		return titel;
	}

	public void setTitel(String pTitel)
	{
		titel = pTitel;
	}

	public boolean istInternetquelle()
	{
		return istInternetquelle;
	}

	public void setIstInternetquelle(boolean pIstInternetquelle)
	{
		istInternetquelle = pIstInternetquelle;
	}

	public String getAutor()
	{
		return autor;
	}

	public void setAutor(String pAutor)
	{
		autor = pAutor;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String pLink)
	{
		link = pLink;
	}

	public LocalDate getDatum()
	{
		return datum;
	}

	public void setDatum(LocalDate pDatum)
	{
		datum = pDatum;
	}

	public String getAussage()
	{
		return aussage;
	}

	public void setAussage(String pAussage)
	{
		aussage = pAussage;
	}
}