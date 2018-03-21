package vorurteile.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FensterÖffnen extends Stage
{
	private Stage bühne;
	
	
	
   public FensterÖffnen()
   {
   	bühne = this;
      Parent lRoot = null;
      
		try
		{
			lRoot = FXMLLoader.load(getClass().getResource("EingabeVorurteilView.fxml"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
      
      Scene lSzene = new Scene(lRoot);
      
      bühne.setScene(lSzene);
      bühne.show();
   }
}	