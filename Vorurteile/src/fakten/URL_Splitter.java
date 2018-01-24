//Keine Subdomains werden erkannt! (bsp: mobile.youtube.com)
package fakten;

public class URL_Splitter {
String[] endungen = {"com", "de"};
	public boolean pruefeURL(String pURL)
	{

		//Trenne URL von HTTPS://
		String[] HTTP_URLsplit = pURL.split("://");
		System.out.println("HTTP/S: '" + HTTP_URLsplit[0] + "' - Domain + Pfad: '" + HTTP_URLsplit[1] + "'");

		//Trenne Domain von Pfad
		String[] Link_URLsplit = HTTP_URLsplit[1].split("/",2);
		System.out.println("Domain: '" + Link_URLsplit[0] + "' - Pfad: '" + Link_URLsplit[1] + "'");

		//Trenne Domain von Endung (de, com, net, ...)
		String[] Domain_URLsplit = Link_URLsplit[0].split("\\.");
		System.out.println("Domain: '" + Domain_URLsplit[0] + "' - Endung: '" + Domain_URLsplit[1] + "'");

		//Überprüfe Endung
		if(pruefeEndung(Domain_URLsplit[1]) == true)
		{
			return true;
		}
		return false;
	}

	boolean pruefeEndung(String pEndung)
	{
		//Vergleiche Endung mit Array
		for ( int i = 0; pEndung != endungen[i]; i ++ )
		{
			System.out.println("" + i + "");
			System.out.println("" + pEndung + "");
			System.out.println("" + endungen[i] + "");
			return true;
		}
		return false;
	}
}
