package vorurteile.ui;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vorurteile.items.Vorurteil;

public class EingabeVorurteilController
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
   private Label lbErrorV;
	
	@FXML
   private TabPane tpFaktVorurteil;

	@FXML
	void suchenFakt(ActionEvent event)
	{

	};

	@FXML
	void auswählenFakt(ActionEvent event)
	{

	};

	@FXML
	void nichtAuswählenFakt(ActionEvent event)
	{

	};

	@FXML
	void neuladenFensterF(ActionEvent event)
	{

	};

	@FXML
	void hinzufügenFakt(ActionEvent event)
	{

	};

	@FXML
	void suchenVorurteil(ActionEvent event)
	{
		erstellenTabelle();
		String lTitel = tfVorurteilssuche.getText().trim();
		ArrayList<Vorurteil> lVorurteil = vorurteile.VorurteilManager.getVorurteile(lTitel);
		for(Vorurteil l : lVorurteil )
		{
			//System.out.println(l.getID() + " " + l.getTitel());
			tvVorurteilliste.getItems().add(l);
		};
	};

	private ObservableList<Vorurteil> getVorurteil()
	{
		ObservableList<Vorurteil> getVorurteil = FXCollections.observableArrayList();
		return getVorurteil;
	};

	public void erstellenTabelle()
	{
		tcTitelVorurteilsliste.setCellValueFactory(new PropertyValueFactory<>("titel"));
		tvVorurteilliste.setItems(getVorurteil());

	};

	@FXML
	void auswählenVorurteil(ActionEvent event)
	{

	};

	@FXML
	void nichtAuswählenVorurteil(ActionEvent event)
	{

	};

	@FXML
	void neuladenFensterV(ActionEvent event)
	{

	};

	@FXML
	void speichernVorurteil(ActionEvent event)
	{
		überprüfenFelder();
	};

	private void überprüfenFelder()
	{
		if (taHauptaussage.getText().isEmpty() || tfTitel.getText().isEmpty())
		{
			lbErrorF.setText("Error: Bitte alle Felder ausfüllen");
			//System.out.println("Error: Bitte die Hauptaussage ausfüllen");
		}
		else
		{
			lbErrorF.setText("");
		};
	};
};