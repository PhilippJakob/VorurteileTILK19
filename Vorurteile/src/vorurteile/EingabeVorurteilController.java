package vorurteile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EingabeVorurteilController
{
	    @FXML
	    private TextArea taHauptaussage;

	    @FXML
	    private TextField tfFaktensuche;

	    @FXML
	    private Button btFaktensuche;

	    @FXML
	    private TableColumn<?, ?> tcIDFaktenlisteAusgewählt;

	    @FXML
	    private TableColumn<?, ?> tcTitelFaktenlisteAusgewählt;

	    @FXML
	    private TextField tfTitel;

	    @FXML
	    private Button btFaktAuswählen;

	    @FXML
	    private Button btRefresh;

	    @FXML
	    private Label lbError;

	    @FXML
	    private Button btFaktHinzufügen;

	    @FXML
	    private TabPane tpFaktVorurteil;

	    @FXML
	    private TableColumn<?, ?> tcTitelFaktenliste;

	    @FXML
	    private TableView<?> tvFaktenliste;

	    @FXML
	    private TableView<?> tvFaktenlisteAusgewählt;

	    @FXML
	    private Button btSpeichernVorurteil;

	    @FXML
	    private TableColumn<?, ?> tcIDFaktenliste;

	    @FXML
	    private Button btFaktNichtAuswählen;

	    @FXML
	    void suchenFakt(ActionEvent event) {

	    }

	    @FXML
	    void auswählenFakt(ActionEvent event) {

	    }

	    @FXML
	    void nichtAuswählenFakt(ActionEvent event) {

	    }

	    @FXML
	    void neuladenFenster(ActionEvent event) {

	    }

	    @FXML
	    void hinzufügenFakt(ActionEvent event) {

	    }

	}


