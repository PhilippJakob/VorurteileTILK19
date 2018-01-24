package hierarchien;

import java.util.ArrayList;

public class Testklasse
{

	private String vorurteil;
	private ArrayList<String> fakten;
	private ArrayList<String> vorVorurteile;

	public Testklasse(String pVorurteil){
		vorurteil = pVorurteil;
		fakten = new ArrayList<String>();
		vorVorurteile = new ArrayList<String>();
	}

	public void hinzufuegenFakt(String pFakt)
	{
		fakten.add(pFakt);
	}

	public void hinzufuegenVorVorurteil(String pVorVorurteil)
	{
		vorVorurteile.add(pVorVorurteil);
	}
	//Getter & Setter
	public String getVorurteil()
	{
		return vorurteil;
	}

	public ArrayList<String> getFakten()
	{
		return fakten;
	}

	public ArrayList<String> getVorVorurteile()
	{
		return vorVorurteile;
	}


}
