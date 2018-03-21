/*
 * angelegt von  Fin Pohle am 17.1.18
 */
package fakten;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Fakt
{
	 private String titel;
    IDFakten iDFakten;
    private String quellenTyp;
    private String autor;
    private String link;
    private LocalDate datum;
    private String zeitStempel;
    private String aussage;


	public Fakt(String pTitel, String pAutor, LocalDate pDatum, String pQuellenTyp, String pLink, String pZeitStempel, String pAussage)
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

	public IDFakten getIDFakten() {
		return iDFakten;
	}

	public void setIDFakten(IDFakten piDFakten) {
		iDFakten = piDFakten;
		
	};
}