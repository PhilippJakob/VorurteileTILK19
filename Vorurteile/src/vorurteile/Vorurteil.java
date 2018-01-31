package vorurteile;

import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class Vorurteil
{
	private int id;
	
	private String titel;
	private String autor;
	private Date veröffentlichung;
	private String internetquelle;
	private String link;
	private Date zeitstempel;
	
	public Vorurteil(String pTitel, String pAutor, Date pVeröffentlichung, String pInternetQuelle, String pLink)
	{
		this.setTitel(pTitel);
		this.setAutor(pAutor);
		this.setVeröffentlichung(pVeröffentlichung);
		this.setInternetquelle(pInternetQuelle);
		this.setLink(pLink);
		this.setZeitstempel(new Date());
	}
	
	/** Getter & Setter **/

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

	public Date getVeröffentlichung()
	{
		return veröffentlichung;
	}

	public void setVeröffentlichung(Date pVeröffentlichung)
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

	public Date getZeitstempel()
	{
		return zeitstempel;
	}

	public void setZeitstempel(Date pZeitstempel)
	{
		zeitstempel = pZeitstempel;
	}
}
