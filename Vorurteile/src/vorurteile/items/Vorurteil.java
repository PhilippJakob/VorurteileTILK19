package vorurteile.items;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
import java.util.Date;
>>>>>>> master

public class Vorurteil
{
	private int id;
	
	private String titel;
	private String autor;
<<<<<<< HEAD
	private LocalDateTime veröffentlichung;
	private String internetquelle;
	private String link;
	private LocalDateTime zeitstempel;
	
	public Vorurteil(int pID, String pTitel, String pAutor, LocalDateTime pVeröffentlichung, String pInternetQuelle, String pLink)
=======
	private long veröffentlichung;
	private String internetquelle;
	private String link;
	private long zeitstempel;
	
	public Vorurteil(int pID, String pTitel, String pAutor, long pVeröffentlichung, String pInternetQuelle, String pLink)
>>>>>>> master
	{
		this.setID(pID);
		this.setTitel(pTitel);
		this.setAutor(pAutor);
		this.setVeröffentlichung(pVeröffentlichung);
		this.setInternetquelle(pInternetQuelle);
		this.setLink(pLink);
<<<<<<< HEAD
		this.setZeitstempel(LocalDateTime.now());
=======
		this.setZeitstempel(new Date().getTime());
>>>>>>> master
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

<<<<<<< HEAD
	public LocalDateTime getVeröffentlichung()
=======
	public long getVeröffentlichung()
>>>>>>> master
	{
		return veröffentlichung;
	}

<<<<<<< HEAD
	public void setVeröffentlichung(LocalDateTime pVeröffentlichung)
=======
	public void setVeröffentlichung(long pVeröffentlichung)
>>>>>>> master
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

<<<<<<< HEAD
	public LocalDateTime getZeitstempel()
=======
	public long getZeitstempel()
>>>>>>> master
	{
		return zeitstempel;
	}

<<<<<<< HEAD
	public void setZeitstempel(LocalDateTime pZeitstempel)
=======
	public void setZeitstempel(long pZeitstempel)
>>>>>>> master
	{
		zeitstempel = pZeitstempel;
	}
}
