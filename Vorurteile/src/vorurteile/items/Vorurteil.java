/**
 * @author Dimaa, 31. Januar 2018
 * @description Objekt Vorurteil
 * @changelog
 * | 31. Januar 2018: Dimaa 「Vorurteil(), Getter & Setter」
 */

package vorurteile.items;

import java.time.LocalDateTime;

public class Vorurteil
{
	private int id;
	
	private String titel;
	private String autor;
	private LocalDateTime veröffentlichung;
	private boolean internetquelle;
	private String link;
	private LocalDateTime zeitstempel;
	private String hauptaussage;
	
	public Vorurteil(int pID, String pTitel, String pAutor, LocalDateTime pVeröffentlichung, boolean pInternetQuelle, String pLink, LocalDateTime pZeitstempel, String pHauptaussage)
	{
		this.setID(pID);
		this.setTitel(pTitel);
		this.setAutor(pAutor);
		this.setVeröffentlichung(pVeröffentlichung);
		this.setInternetquelle(pInternetQuelle);
		this.setLink(pLink);
		this.setZeitstempel(pZeitstempel);
		this.setHauptaussage(pHauptaussage);
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

	public LocalDateTime getVeröffentlichung()
	{
		return veröffentlichung;
	}

	public void setVeröffentlichung(LocalDateTime pVeröffentlichung)
	{
		veröffentlichung = pVeröffentlichung;
	}

	public boolean getInternetquelle()
	{
		return internetquelle;
	}

	public void setInternetquelle(boolean pInternetquelle)
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

	public LocalDateTime getZeitstempel()
	{
		return zeitstempel;
	}

	public void setZeitstempel(LocalDateTime pZeitstempel)
	{
		zeitstempel = pZeitstempel;
	}

	public String getHauptaussage()
	{
		return hauptaussage;
	}

	public void setHauptaussage(String pHauptaussage)
	{
		hauptaussage = pHauptaussage;
	}
}
