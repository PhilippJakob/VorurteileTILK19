package fakten;

import java.net.MalformedURLException;

public class UrlPrüfer
{

	public boolean pruefeURL(String pURL) throws MalformedURLException
	{
		String[] domain = {"de","com","net","org"};
		String[] protokoll = {"http","https"};

		for(int i = 0; i <= domain.length-1; i++)
		{
			if(pURL.contains("." + domain[i]))
			{
				for(int l = 0; l <= protokoll.length-1; l++)
				{
					if(pURL.startsWith(protokoll[l] + "://"))
					{
						return true;
					}
				}
			}
		}

		return false;
	}
}
