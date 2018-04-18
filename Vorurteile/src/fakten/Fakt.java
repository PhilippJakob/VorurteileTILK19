/*
 * angelegt von  Fin Pohle am 17.1.18
 * Tobias 14.03.2018 getter und setter methoden hinzugefügt
 */
package fakten;

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
	 private IDFakten iDFakten;
    private String quellenTyp;
    private String autor;
    private String link;
    private LocalDate datum;
    private String aussage;
    private int IDFakten;
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
		   this.IDFakten = pID;
			this.titel = pTitel;
			this.quellenTyp = pQuellenTyp;
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
	}
	//Getter und setter

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public IDFakten getiDFakten() {
		return iDFakten;
	}

	public void setiDFakten(IDFakten iDFakten) {
		this.iDFakten = iDFakten;
	}

	public String getQuellenTyp() {
		return quellenTyp;
	}

	public void setQuellenTyp(String quellenTyp) {
		this.quellenTyp = quellenTyp;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getAussage() {
		return aussage;
	}

	public void setAussage(String aussage) {
		this.aussage = aussage;
	}

	public int getIDFakten() {
		return IDFakten;
	}

	public void setIDFakten(int iDFakten) {
		IDFakten = iDFakten;
		
	};
}