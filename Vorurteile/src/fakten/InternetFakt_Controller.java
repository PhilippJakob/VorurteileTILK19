package fakten;

import java.beans.EventHandler;

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
    		textausgabe("Link ist g�ltig!");
    	}
    	else
    	{
    		textausgabe("Link nicht g�ltig! https:// oder http:// hinzuf�gen, oder Endung �ndern!");
    	}

    }

  //Fehlerzeile Ergebnis ausgeben
    void textausgabe(String URLErgebnis)
    {
    	tfFehler.setText("Ergebnis: '" + URLErgebnis + "' - Eingabe: '" + tfURL.getText() + "'");
    }
}
