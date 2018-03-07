	//Keine Subdomains werden erkannt! (bsp: mobile.youtube.com)
package fakten;

import java.net.MalformedURLException;

public class UrlPrüfer
{

	public boolean pruefeURL(String pURL) throws MalformedURLException
	{
		String[] domains = {"de","com","net","org"};
		String[] PunktTrennung = pURL.split("\\.");
		String[] StrichTrennung = null;

		//Am Punkt trennen
		for(int i = 0; i <= PunktTrennung.length-1; i++)
		{
			System.out.println(i + " - " + PunktTrennung[i]);
		}

		//Bei '/' trennen
		for(int i = 0; i <= PunktTrennung.length-1; i++)
		{
			//Suche nach /
			if(PunktTrennung[i].contains("/"))
			{
				StrichTrennung = PunktTrennung[i].split("/");
			}
			else
			{

			}

			for(int l = 0; l <= StrichTrennung.length-1; l++)
			{
				if(StrichTrennung[l] == domains[i])
				{
					System.out.println("ERFOLG!!!");
				}
				else
				{
					System.out.println("Kein erfolg :(");
				}
			}
		}

		return false;
	}
}
