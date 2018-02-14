/*
 * von Fin Pohle am 17.1.18 hinzugefügt
 */
package fakten;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Normalizer.Form;
import java.util.ArrayList;

public class IDFakten
{
    private static int aktuelleIDFakten = getAktuelleIDFakten(); //letzte vergebene FaktenID

	private static int IDFakten =1;

//  Konstruktoren

	IDFakten()
	{
		getHöchsteID(IDFakten);
		IDFakten ++;
		System.out.println(IDFakten);
	}

	IDFakten(int pIDFaktenFest)
	{
		setIDFakten(pIDFaktenFest);
	}


//  Getter Setter Methoden

	public int getIDFakten()
	{
		return IDFakten;
	}
	public void setIDFakten(int pIDFakten)
	{
		IDFakten = pIDFakten;
	}
	public static int getAktuelleIDFakten()
	{
		return aktuelleIDFakten;
	}
    public static void setAktuelleIDFakten(int paktuelleIDFakten)
    {
    	aktuelleIDFakten = paktuelleIDFakten;
	}

    public static IDFakten getHöchsteID(int IDFakten)
    {
    	Connection lConnection = DatenbankVerbindungFakten.holen();
    	IDFakten lIDFakten;
    	ArrayList<IDFakten> lIDFaktenListe = new ArrayList<IDFakten>();
    	Statement lBefehl;
    	ResultSet lErgebnis;

    	try {
    		lBefehl = lConnection.createStatement();
    		lErgebnis= lBefehl.executeQuery("SELECT MAX(IDFakten) FROM dbo_vorurteile.fakt");
    		lErgebnis.first();

    		while(! lErgebnis.isAfterLast())
    		{
    			lIDFakten = new IDFakten (lErgebnis.getInt(7));
    			lIDFaktenListe.add(lIDFakten);
      			return lIDFakten;
    		}

    	 } catch (Exception ex)
  			{
    		 	System.out.println("Fehler bei der Verarbeitung + " + "n" + ex.getMessage());
  			}
    	return null;

    	}


}