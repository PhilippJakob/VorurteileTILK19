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

	public ObservableList<Vorurteil> getVorurteil()
   {
   	ObservableList<Vorurteil> lListe =FXCollections.observableArrayList();

		return lListe;
   }

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

	@FXML
	void auswählenFakt(ActionEvent event)
	{
		Vorurteil lVorurteil = tvFaktenliste.getSelectionModel().getSelectedItem();

    	if(lVorurteil != null)
    	{
	    	tvFaktenliste.getItems().remove(lVorurteil);
	    	tvFaktenlisteAusgewählt.getItems().add(lVorurteil);
    	}
	}

	@FXML
	void nichtAuswählenFakt(ActionEvent event)
	{
		Vorurteil lVorurteil = tvFaktenlisteAusgewählt.getSelectionModel().getSelectedItem();

    	if(lVorurteil != null)
    	{
	    	tvFaktenlisteAusgewählt.getItems().remove(lVorurteil);
	    	tvFaktenliste.getItems().add(lVorurteil);
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
		erstellenTabellen();
		String lTitel = tfVorurteilssuche.getText().trim();
		ArrayList<Vorurteil> lVorurteil = vorurteile.VorurteilManager.getVorurteile(lTitel);
		for(Vorurteil l : lVorurteil )
		{
			//System.out.println(l.getID() + " " + l.getTitel());
			tvVorurteilliste.getItems().add(l);
		}
	}

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

	@Override
   public void initialize(URL location, ResourceBundle resources)
   {
   	erstellenTabellen();
   }
}