package vorurteile.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EingabeVorurteilController{

	    @FXML
	    private TextField tfFaktensuche;

	    @FXML
	    private TableColumn<?, ?> tcTitelFaktenlisteAusgewählt;

	    @FXML
	    private TextField tfTitel;

	    @FXML
	    private Button btFaktAuswählen;

	    @FXML
	    private TextField tfVorurteilssuche;

	    @FXML
	    private TableView<?> tvVorurteilliste;

	    @FXML
	    private Button btRefresh;

	    @FXML
	    private TabPane tpFaktVorurteil;

	    @FXML
	    private Button btVorurteilAuswählen;

	    @FXML
	    private TableView<?> tvFaktenliste;

	    @FXML
	    private Button btSpeichernVorurteil;

	    @FXML
	    private TableColumn<?, ?> tcIDFaktenliste;

	    @FXML
	    private TextArea taHauptaussage;

	    @FXML
	    private Button btFaktensuche;

	    @FXML
	    private TableView<?> tvVorurteillisteAusgewählt;

	    @FXML
	    private TableColumn<?, ?> tcIDFaktenlisteAusgewählt;

	    @FXML
	    private Label lbError1;

	    @FXML
	    private TableColumn<?, ?> tcIDVorurteilsliste;

	    @FXML
	    private TableColumn<?, ?> tcIDVorurteilslisteAusgewählt;

	    @FXML
	    private TableColumn<?, ?> tcTitelVorurteilslisteAusgewählt;

	    @FXML
	    private TableColumn<?, ?> tcTitelVorurteilsliste;

	    @FXML
	    private Label lbError;

	    @FXML
	    private Button btVorurteilssuche;

	    @FXML
	    private Button btRefresh1;

	    @FXML
	    private Button btFaktHinzufügen;

	    @FXML
	    private TableColumn<?, ?> tcTitelFaktenliste;

	    @FXML
	    private Button btVorurteilNichtAuswählen;

	    @FXML
	    private TableView<?> tvFaktenlisteAusgewählt;

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
	    void neuladenFensterF(ActionEvent event) {

	    }

	    @FXML
	    void hinzufügenFakt(ActionEvent event) {

	    }

	    @FXML
	    void suchenVorurteil(ActionEvent event) {

	    }

	    @FXML
	    void auswählenVorurteil(ActionEvent event) {

	    }

	    @FXML
	    void nichtAuswählenVorurteil(ActionEvent event) {

	    }

	    @FXML
	    void neuladenFensterV(ActionEvent event) {

	    }

}