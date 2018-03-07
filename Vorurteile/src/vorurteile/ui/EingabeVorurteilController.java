/**
 * @author Jonas N. Henle, 25.01.2018
 * Beschreibung: Dient der Eingabe von neuen Vorurteilen.
 * 
 * 07.03.2018 Nico Fliskowski: getVorurteil(); erstellenTabellen(); auswählenFakt(); nichtAuswählenFakt(); auswählenVorurteil(); nichtAuswählenVorurteil(); initialize();
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
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vorurteile.items.Vorurteil;

public class EingabeVorurteilController implements Initializable
{
	@FXML
	private TextField tfTitel;

	@FXML
   private TextArea taHauptaussage;

	@FXML
   private Button btSpeichernVorurteil;

	@FXML
   private TextField tfFaktensuche;

	@FXML
   private Button btFaktensuche;

	@FXML
   private Button btFaktHinzufügen;

	@FXML
   private TableView<Vorurteil> tvFaktenliste;

	@FXML
   private TableColumn<Vorurteil, String> tcTitelFaktenliste;

	@FXML
   private Button btFaktAuswählen;

	@FXML
   private Button btFaktNichtAuswählen;

	@FXML
   private Button btRefreshF;

	@FXML
   private TableView<Vorurteil> tvFaktenlisteAusgewählt;

	@FXML
   private TableColumn<Vorurteil, String> tcTitelFaktenlisteAusgewählt;

	@FXML
   private TextField tfVorurteilssuche;

	@FXML
   private Button btVorurteilssuche;

	@FXML
   private TableView<Vorurteil> tvVorurteilliste;

	@FXML
   private TableColumn<Vorurteil, String> tcTitelVorurteilsliste;

	@FXML
   private Button btVorurteilAuswählen;

	@FXML
   private Button btVorurteilNichtAuswählen;

	@FXML
   private Button btRefreshV;

	@FXML
   private TableView<Vorurteil> tvVorurteillisteAusgewählt;

	@FXML
   private TableColumn<Vorurteil, String> tcTitelVorurteilslisteAusgewählt;

	@FXML
   private Label lbErrorF;

   @FXML
   private Label lbSafeError;

	@FXML
   private Label lbErrorV;

	@FXML
   private TabPane tpFaktVorurteil;

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
    * Erstellt alle Tabellen, um die Items verwalten zu können.
    */
   private void erstellenTabellen()
   {
   	tcTitelFaktenliste.setCellValueFactory(new PropertyValueFactory<>("titel"));
   	tvFaktenliste.setItems(getVorurteil());

   	tcTitelFaktenlisteAusgewählt.setCellValueFactory(new PropertyValueFactory<>("titel"));
   	tvFaktenlisteAusgewählt.setItems(getVorurteil());

   	tcTitelVorurteilsliste.setCellValueFactory(new PropertyValueFactory<>("titel"));
   	tvVorurteilliste.setItems(getVorurteil());

   	tcTitelVorurteilslisteAusgewählt.setCellValueFactory(new PropertyValueFactory<>("titel"));
   	tvVorurteillisteAusgewählt.setItems(getVorurteil());
   }

	@FXML
	void suchenFakt(ActionEvent event)
	{
		
	}

	/**
	 * Erkennt den ausgewählten Tabelleneintrag (lFakt).
	 * Entfernt lFakt aus tvFaktenliste.
	 * Fügt lFakt tvFaktenlisteAusgewählt hinzu.
	 * @param event
	 */
	@FXML
	void auswählenFakt(ActionEvent event)
	{
		Vorurteil lFakt = tvFaktenliste.getSelectionModel().getSelectedItem();

    	if(lFakt != null)
    	{
	    	tvFaktenliste.getItems().remove(lFakt);
	    	tvFaktenlisteAusgewählt.getItems().add(lFakt);
    	}
	}
	
	/**
	 * Erkennt den ausgewählten Tabelleneintrag (lFakt).
	 * Entfernt lFakt aus tvFaktenlisteAusgewählt.
	 * Fügt lFakt tvFaktenliste hinzu.
	 * @param event
	 */
	@FXML
	void nichtAuswählenFakt(ActionEvent event)
	{
		Vorurteil lFakt = tvFaktenlisteAusgewählt.getSelectionModel().getSelectedItem();

    	if(lFakt != null)
    	{
	    	tvFaktenlisteAusgewählt.getItems().remove(lFakt);
	    	tvFaktenliste.getItems().add(lFakt);
    	}
	}

	@FXML
	void neuladenFensterF(ActionEvent event)
	{

	}

	@FXML
	void hinzufügenFakt(ActionEvent event)
	{

	}
	
	@FXML
	void suchenVorurteil(ActionEvent event)
	{
//		erstellenTabellen();
		tvVorurteilliste.getItems().clear();
		String lTitel = tfVorurteilssuche.getText().trim();
		ArrayList<Vorurteil> lVorurteil = vorurteile.VorurteilManager.getVorurteile(lTitel);
		for(Vorurteil l : lVorurteil )
		{
			//System.out.println(l.getID() + " " + l.getTitel());
			tvVorurteilliste.getItems().add(l);
		}
	}

	/**
	 * Erkennt den ausgewählten Tabelleneintrag (lVorurteil).
	 * Entfernt lVorurteil aus tvFaktenliste.
	 * Fügt lVorurteil tvFaktenlisteAusgewählt hinzu.
	 * @param event
	 */
	@FXML
	void auswählenVorurteil(ActionEvent event)
	{
		Vorurteil lVorurteil = tvVorurteilliste.getSelectionModel().getSelectedItem();

    	if(lVorurteil != null)
    	{
    		tvVorurteilliste.getItems().remove(lVorurteil);
    		tvVorurteillisteAusgewählt.getItems().add(lVorurteil);
    	}
	}

	/**
	 * Erkennt den ausgewählten Tabelleneintrag (lVorurteil).
	 * Entfernt lVorurteil aus tvFaktenlisteAusgewählt.
	 * Fügt lVorurteil tvFaktenliste hinzu.
	 * @param event
	 */
	@FXML
	void nichtAuswählenVorurteil(ActionEvent event)
	{
		Vorurteil lVorurteil = tvVorurteillisteAusgewählt.getSelectionModel().getSelectedItem();

    	if(lVorurteil != null)
    	{
    		tvVorurteillisteAusgewählt.getItems().remove(lVorurteil);
    		tvVorurteilliste.getItems().add(lVorurteil);
    	}
	}

	@FXML
	void neuladenFensterV(ActionEvent event)
	{

	}

	@FXML
	void speichernVorurteil(ActionEvent event)
	{
		überprüfenFelder();
	}

   private void überprüfenFelder()
   {
     	if (taHauptaussage.getText().isEmpty() || tfTitel.getText().isEmpty())
     	{
     		lbSafeError.setText("Error: Bitte alle Felder ausfüllen");
     	}
     	else
     	{
     		lbSafeError.setText("");
   	}
   }

   /**
    * Ruft nach Start des Programmes erstellenTabellen() auf.
    */
	@Override
   public void initialize(URL location, ResourceBundle resources)
   {
   	erstellenTabellen();
   }
}