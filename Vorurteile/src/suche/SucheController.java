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
 * Anglegt: 05.03.2018, Chantal Mielenz
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
   	 
   	 if(tfSuchleiste.getText() != null)
   	 {
   		 tcVorurteilsliste.setText("Fehler! Bitte gebe du was in die Suchleiste in.");
   	 }
   	 else
   	 {
   		 String lSuche = tfSuchleiste.getText();
   		 
   		 
   		 
   	 }
   	 
   	 
    }
    
}
