/**
 * @author Nico Fliskowski, 14. März 2018
 * @description Dient der Anzeige von allen Vorurteilen in einer Tabelle.
 * @changelog
 * | 14. März 2018: Nico Fliskowski "erstellenTabellen(); initialize(); füllenTabelle();"
 * | 11. April 2018: Nico Fliskowski "getAusgewähltesVorurteil(); setAusgewähltesVorurteil(); btBearbeiten();"
 */

package vorurteile.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vorurteile.Vorurteil;

public class PrototypController implements Initializable
{
	@FXML
   private Label lbError;
	
   @FXML
   private TableView<Vorurteil> tvVorurteilliste;

   @FXML
   private TableColumn<Vorurteil, String> tcTitelVorurteilsliste;
   
   @FXML
   private Button btBearbeiten;
   
   /**
	 * Erstellt eine observable List und gibt diese zurück.
	 * @return lListe
	 */
	public ObservableList<Vorurteil> getVorurteil()
   {
   	ObservableList<Vorurteil> lListe = FXCollections.observableArrayList();

		return lListe;
   }
	
	/**
    * Erstellt eine Tabelle, um die Items verwalten zu können.
    */
   private void erstellenTabelle()
   {

   	tcTitelVorurteilsliste.setCellValueFactory(new PropertyValueFactory<>("titel"));
   	tvVorurteilliste.setItems(getVorurteil());
   }

   /**
    * Ruft nach Start des Programmes erstellenTabellen() auf.
    */
	@Override
	public void initialize(URL pLocation, ResourceBundle pResources)
	{
		erstellenTabelle();
		füllenTabelle();
	}
	
	/**
	 * 
	 */
	private static Vorurteil ausgewähltesVorurteil = null;
	
	public static Vorurteil getAusgewähltesVorurteil()
	{
		return ausgewähltesVorurteil;
	}

	public static void setAusgewähltesVorurteil(Vorurteil pAusgewähltesVorurteil)
	{
		ausgewähltesVorurteil = pAusgewähltesVorurteil;
	}

	/**
	 * Öffnet nach Klick auf "Bearbeiten" das Fenster EingabeVorurteilView
	 * @param event
	 */
	@FXML
   private void btBearbeiten(ActionEvent event)
	{
		Vorurteil lVorurteil = tvVorurteilliste.getSelectionModel().getSelectedItem();

    	if(lVorurteil != null)
    	{
    		setAusgewähltesVorurteil(lVorurteil);
    		
    		new FensterÖffnen();
    	}
    	else
    	{
    		lbError.setText("Erst auswählen");
    	}
   }
	
	/**
    * Liest die Datenbank aus und füllt die Tabelle mit allen Vorurteilen
    */
   private void füllenTabelle()
   {
		ArrayList<Vorurteil> lVorurteile = vorurteile.VorurteilManager.getVorurteile("");
		
		for(Vorurteil lVorurteil : lVorurteile)
		{
			tvVorurteilliste.getItems().add(lVorurteil);
		}
   }
}
