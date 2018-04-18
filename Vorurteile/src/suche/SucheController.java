package suche;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import datenbank.Datenbankverbindung;
import hierarchie.Hierarchie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import vorurteile.Vorurteil;
import vorurteile.VorurteilManager;

/**
 * Angelegt: 05.03.2018, Chantal Mielenz
 * Geändert: 07.03.2018, Chantal Mielenz, Methode hinzugefügt
 * Geändert: 19.03.2018, Chantal Mielenz, Methode verändert / erweitert
 * Geändert: 21.03.2018, Florian Henderkes & Chantal Mielenz, Methoden suchenVorurteile und suchenVorurteileNachSuchwörter verändert / erweitert
 * Geändert: 11.03.2018, Florian Henderkes & Chantal Mielenz, Metode verändert
 */

public class SucheController 
{
	int lRückgabeID;
	boolean lVorvorurteil;
	
	@FXML
	private TextField tfSuchleiste;

	@FXML
	private Button btSuche;

	@FXML
	private TableView<Vorurteil> tvVorurteilsliste;

	@FXML
	private TableColumn<Vorurteil, String> tcVorurteilsliste;
	
	
	/**
	 * Bei betätigen des Suche Buttons "btSuche" wird diese Methode ausgeführt.
	 * Bei Eingabe eines Satzes in der Suchleiste wird jedes Wort einzeln in der Datenbank gesucht und
	 * passende Vorurteile in einer Tabelle angezeigt. Zu jedem Vorurteil werden passend noch alle Untergeordneten 
	 * Vorurteile darunter angezeigt.
	 * @param event
	 */
	@FXML
	void suchenVorurteile(ActionEvent event)
	{
		if(tfSuchleiste.getText().isEmpty())
			tcVorurteilsliste.setText("Fehler!");
		else
		{
			System.out.println(tfSuchleiste.getText());
			String lSuche = tfSuchleiste.getText();
			ObservableList<Vorurteil> lVorurteile = FXCollections.observableArrayList();
			String[] lSuchwörter = lSuche.split(" ");
			for(String suchwort : lSuchwörter)
			{
				for(Vorurteil gesuchtesVorurteil : VorurteilManager.getVorurteile(suchwort))
				{
					if(!lVorurteile.contains(gesuchtesVorurteil))
					{
						lVorurteile.add(gesuchtesVorurteil);
//						System.out.println(v.getTitel());
//						for(Vorurteil untergeordnetesVorurteil : Hierarchie.suchenUntergeordneteVorurteile(v.getID())){
//							lVorurteile.add(untergeordnetesVorurteil);
//							System.out.println(untergeordnetesVorurteil.getTitel());
//						}
					}
					
				}
			}
			
			
			ObservableList<Vorurteil> lVorurteilsListe = FXCollections.observableArrayList();
			
			for(Vorurteil vorurteile : lVorurteile){
				lVorurteilsListe.add(vorurteile);
				for(Vorurteil untergeordnetesVorurteil : Hierarchie.suchenUntergeordneteVorurteile(vorurteile.getID())){
					untergeordnetesVorurteil.setTitel("	" + untergeordnetesVorurteil.getTitel());
					lVorurteilsListe.add(untergeordnetesVorurteil);
				}
				
			}
			
			tcVorurteilsliste.setCellValueFactory(new PropertyValueFactory<Vorurteil, String>("titel"));
			tvVorurteilsliste.setItems(lVorurteilsListe);
		}
	}
	
	
	
	@FXML
    void auswählenVorurteil(MouseEvent event) {
		if(event.getClickCount() == 2){
			int lVorurteilsID = tvVorurteilsliste.getSelectionModel().getSelectedItem().getID();    
			String lVorurteilsTitel = tvVorurteilsliste.getSelectionModel().getSelectedItem().getTitel();
			lRückgabeID = lVorurteilsID;
			if(lVorurteilsTitel.startsWith("	")){
				lVorvorurteil = false;
				
			}else{
				lVorvorurteil = true;
				
			}
			
		}
		
		
		
	}
	
}
