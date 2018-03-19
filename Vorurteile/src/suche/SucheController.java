package suche;
import javafx.event.ActionEvent;
/** 
  * Angelegt: 05.03.2018, Chantal Mielenz, Controller für die Suchleiste
  */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
/**
 * Angelegt: 05.03.2018, Chantal Mielenz
 * Geändert: 07.03.2018, Chantal Mielenz, Methode hinzugefügt
 * Geändert: 19.03.2018, Chantal Mielenz, Methode verändert / erweitert
 */
public class SucheController 
{

    @FXML
    private TextField tfSuchleiste;

    @FXML
    private Button btSuche;

    @FXML
    private TableView<?> tvVorurteilsliste;

    @FXML
    private TableColumn<?, ?> tcVorurteilsliste;
    
    @FXML
    void suchenVorurteile(ActionEvent event) 
    {
   	 
   	 if(tfSuchleiste.getText() == null)
   	 {		
   		 //sinnvolle Fehlermeldung hier hinzufügen 
   		 tcVorurteilsliste.setText("Fehler!");
   	 }
   	 else
   	 {
   		 String lSuche = tfSuchleiste.getText();
   		 String[] lSuchwörter = lSuche.split(" ");
   		 
   		 for(String s : lSuchwörter){
   			 
   			 
   		 }
   		 
   	 }
   	 
   	 
    }
    
}
