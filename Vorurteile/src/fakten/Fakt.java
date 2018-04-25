/*
 * angelegt von  Fin Pohle am 17.1.18
 */
package  fakten;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;

public class Fakt
{
	 private String titel;
    IDFakten iDFakten;
    private String quellenTyp;
    private String autor;
    private String link;
    private LocalDate datum;
    private String aussage;
    private String IDFakten;
    private int idFakten;
    Calendar ccalendar;


	public Fakt(String pTitel, String pAutor, LocalDate pDatum, String pQuellenTyp, String pLink, String pAussage)
	{
			this.titel = pTitel;
			this.iDFakten = new IDFakten();
			this.quellenTyp = pQuellenTyp;
			this.autor = pAutor;
			this.link = pLink;
			this.datum = pDatum;
			this.aussage = pAussage;
	}

	public Fakt(int pID, String pTitel, String pAutor, LocalDate pDatum, String pQuellenTyp, String pLink, String pAussage)
	{
		   this.idFakten = pID;
			this.titel = pTitel;
			this.quellenTyp = pQuellenTyp;
			this.autor = pAutor;
			this.link = pLink;
			this.datum = pDatum;
			this.aussage = pAussage;
	}
	
	public Fakt(String pIDFakten)
	{
		this.IDFakten = pIDFakten;
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
      LocalDate datumStempel;
      datumStempel= LocalDate.now();
		lBefehl.execute("INSERT INTO dbo_vorurteile.fakten VALUES ("+iDFakten.getIDFakten()+",\""+titel+"\",\""+autor+"\",\""+datum+"\",\""+quellenTyp+"\",\""+link+"\",\""+aussage+"\",\""+datumStempel+"\")");
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
	
	public void entfernenFakt()
	{
		Connection lConnection = DatenbankVerbindungFakten.holen();
		Statement lBefehl;

		try
		{
			lBefehl = lConnection.createStatement();

		   lBefehl.execute("DELETE FROM dbo_vorurteile.verbindung_f_v WHERE ID_Fakten='"+IDFakten+"'");
		   lBefehl.execute("DELETE FROM dbo_vorurteile.fakten WHERE ID_Fakten='"+IDFakten+"'");
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

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