package vorurteile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SucheVorurteilController {

    @FXML
    private TableView<?> tvVorurteillisteAusgewählt;

    @FXML
    private TextField tfVorurteilssuche;

    @FXML
    private TableView<?> tvVorurteilliste;

    @FXML
    private TableColumn<?, ?> tcIDVorurteilsliste;

    @FXML
    private TableColumn<?, ?> tcIDVorurteilslisteAusgewählt;

    
    @FXML
    private Button btRefresh;

    @FXML
    private TableColumn<?, ?> tcTitelVorurteilslisteAusgewählt;

    @FXML
    private TableColumn<?, ?> tcTitelVorurteilsliste;

    @FXML
    private Button btVorurteilssuche;

    @FXML
    private Label lbError;

    @FXML
    private Button btVorurteilHinzufügen;

    @FXML
    private Button btVorurteilAuswählen;

    @FXML
    private Button btVorurteilNichtAuswählen;

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
    void neuladenFenster(ActionEvent event) {

    }

    @FXML
    void hinzufügenVorurteil(ActionEvent event) {

    }

}
