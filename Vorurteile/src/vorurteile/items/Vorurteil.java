/** 
 * Hier ist keiner verantwortlich
 */
package vorurteile.items;

import java.util.Date;

public class Vorurteil
{
	private int id;
	
	private String titel;
	private String autor;
	private long veröffentlichung;
	private String internetquelle;
	private String link;
	private long zeitstempel;
	
	public Vorurteil(int pID, String pTitel, String pAutor, long pVeröffentlichung, String pInternetQuelle, String pLink)
	{
		this.setID(pID);
		this.setTitel(pTitel);
		this.setAutor(pAutor);
		this.setVeröffentlichung(pVeröffentlichung);
		this.setInternetquelle(pInternetQuelle);
		this.setLink(pLink);
		this.setZeitstempel(new Date().getTime());
	}
	
	/** Getter & Setter **/

	public int getID()
	{
		return id;
	}

	public void setID(int pID)
	{
		id = pID;
	}

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

	public long getVeröffentlichung()
	{
		return veröffentlichung;
	}

	public void setVeröffentlichung(long pVeröffentlichung)
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

	public long getZeitstempel()
	{
		return zeitstempel;
	}

	public void setZeitstempel(long pZeitstempel)
	{
		zeitstempel = pZeitstempel;
	}
}
