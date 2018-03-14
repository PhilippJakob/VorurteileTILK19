/*
 * angelegt von  Fin Pohle am 17.1.18
 */
package fakten;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;

public class Fakt
{
	 private String titel;
    IDFakten iDFakten;
    private String quellenTyp;
    private String autor;
    private String link;
    private String datum;
    private String zeitStempel;
    private String aussage;


	public Fakt(String pTitel, String pAutor, String pDatum, String pQuellenTyp, String pLink, String pZeitStempel, String pAussage)
	{
			this.titel = pTitel;
			this.iDFakten = new IDFakten();
			this.quellenTyp = pQuellenTyp;
			this.autor = pAutor;
			this.link = pLink;
			this.datum = pDatum;
			this.zeitStempel = pZeitStempel;
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
	  ResultSet lErgebnis;

	  try
	  {
		lBefehl = lConnection.createStatement();

		lBefehl.execute("INSERT INTO dbo_vorurteile.fakten VALUES ("+iDFakten.getIDFakten()+",\""+titel+"\",\""+autor+"\",\""+datum+"\",\""+quellenTyp+"\",\""+link+"\",\""+zeitStempel+"\",\""+aussage+"\")");
	  } catch (SQLException e)
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}

	public ResultSet suchenFakt()
	{
		Connection lConnection = DatenbankVerbindungFakten.holen();
		Statement lBefehl;
		ResultSet lErgebnis;

		try
		{
			lBefehl = lConnection.createStatement();

			lErgebnis = lBefehl.executeQuery("SELECT * FROM dbo_vorurteile.fakten");

			return lErgebnis;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
	};

	public ResultSet suchenFakt(String pKriterium)
	{
		Connection lConnection = DatenbankVerbindungFakten.holen();
		Statement lBefehl;
		ResultSet lErgebnis;
		

		try
		{
			lBefehl = lConnection.createStatement();

			lErgebnis = lBefehl.executeQuery("SELECT * FROM dbo_vorurteile.fakten " + pKriterium);

			return lErgebnis;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
	};
}