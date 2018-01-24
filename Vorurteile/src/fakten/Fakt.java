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
    private LocalDate datum;
    private LocalDate zeitStempel;

	public Fakt(String pTitel, String pAutor, LocalDate pDatum, String pQuellenTyp, String pLink, LocalDate pZeitStempel, IDFakten iDFakten)
	{
			this.titel = pTitel;
			this.iDFakten = new IDFakten();
			this.quellenTyp = pQuellenTyp;
			this.autor = pAutor;
			this.link = pLink;
			this.datum = pDatum;
			this.zeitStempel = pZeitStempel;
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

		lBefehl.execute("INSERT INTO dbo_vorurteile.fakt VALUES ("+titel+",\""+autor+"\",\""+datum+"\",\""+quellenTyp+"\",\""+link+"\",\""+zeitStempel+"\",\""+iDFakten.getIDFakten()+"\")");
	  } catch (SQLException e)
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
}