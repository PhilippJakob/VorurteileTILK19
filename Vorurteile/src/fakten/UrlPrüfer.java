	//Keine Subdomains werden erkannt! (bsp: mobile.youtube.com)
package fakten;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlPrüfer
{

	public boolean pruefeURL(String pURL)
	{
		try
		{

			URL url = new URL(pURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			System.err.println(con.getResponseCode());
			return true;
		}
		catch(MalformedURLException ex)
		{
			//Wenn ungüktig
			System.out.println("Bei der URL: '" + pURL + "' fehlt das Protokoll! (HTTP, HTTPS, FTP, ...)");
			System.out.println(ex);
			return false;
		}
		catch(IOException ex)
		{
			//Andere Fehler
			System.err.println("Ein anderer Fehler ist aufgetreten!");
			System.out.println(ex);
			return false;

		}

	}
}
