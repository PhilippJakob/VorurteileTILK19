//Keine Subdomains werden erkannt! (bsp: mobile.youtube.com)
package fakten;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlPrüfer
{

	public boolean pruefeURL(String pURL)
	{
		try
		{
			new URL(pURL).openStream().close();
			//Danach ist gültig
			System.out.println("Die URL: '" + pURL + "' ist gültig!");
			return true;
		}
		catch(MalformedURLException ex)
		{
			//Wenn ungüktig
			System.out.println("Die URL: '" + pURL + "' ist nicht gültig!");

			System.out.println(ex);
			return false;
		}
		catch(IOException ex)
		{
			//Andere Fehler
			System.out.println("Ein anderer Fehler ist aufgetreten!");
			System.out.println(ex);
			return false;

		}

	}
}
