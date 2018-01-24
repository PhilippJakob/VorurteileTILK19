//  ___________________________________________________________________________________________________________________
//  | ####################################### |Name SucheFaktController.java | ###################################### |
//  | ####################################### |   @Author = Nico Fliskowski  | ###################################### |
//  | ####################################### |         Version 1.0          | ###################################### |
//  | ####################################### |     Date: 24.01.18   12:17   | ###################################### |
//  | ####################################### |Group Vorurteile [Ben / Ohan] | ###################################### |
//  |_________________________________________|______________________________|________________________________________|

package vorurteile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SucheFaktController
{
	//Errorlabel
	@FXML
   private Label lbError;
	
	//Faktensuche
	@FXML
	private TextField tfFaktensuche;
   
	@FXML
   private Button btFaktensuche;
	
	//Fakten auswählen
	@FXML
   private TableView<?> lvFaktenliste;

   @FXML
   private Button btFaktAuswählen;

   @FXML
   private Button btFaktNichtAuswählen;
   
   @FXML
   private TableView<?> lvFaktenlisteAusgewählt;

   //Fenster aktualisieren
   @FXML
   private Button btRefresh;
    
   //Fakt hinzufügen
   @FXML
   private Button btFaktHinzufügen;

   /**
    * Falls tfFaktensuche nicht leer ist, wird nach dem entsprechendem String in der Datenbank gesucht
    * Alle Ergebnisse werden in lvFaktenliste angezeigt
    * Ist tfFaktensuche leer, wird Fehler ausgegeben
    * @param event
    */
   @FXML
   public void suchenFakt(ActionEvent event)
   {
   	String lTFFaktensuche = tfFaktensuche.getText().trim();
   	
   	if(!lTFFaktensuche.isEmpty())
   	{
   		
   	}
   	else
   	{
   		lbError.setText("Error: Suchbegriff eingeben");
   	}
   }
   
   @FXML
   public void auswählenFakt(ActionEvent event)
   {
   	
   }

   @FXML
   public void nichtAuswählenFakt(ActionEvent event)
   {

   }

   @FXML
   public void neuladenFenster(ActionEvent event)
   {
   	
   }

   @FXML
   public void hinzufügenFakt(ActionEvent event)
   {

   }
}
