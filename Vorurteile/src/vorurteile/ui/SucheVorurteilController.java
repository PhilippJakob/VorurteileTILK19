package vorurteile.ui;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vorurteile.items.Vorurteil;

public class SucheVorurteilController {

    @FXML
    private TableView<?> tvVorurteillisteAusgewählt;

    @FXML
    private TextField tfVorurteilssuche;

    @FXML
    private TableView<Vorurteil> tvVorurteilliste;

    @FXML
    private Button btRefresh;

    @FXML
    private TableColumn<?, ?> tcTitelVorurteilslisteAusgewählt;

    @FXML
    private TableColumn<Vorurteil, String> tcTitelVorurteilsliste;

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
    void suchenVorurteil(ActionEvent event)
    {
   	erstellenTabelle();
   	String lTitel = tfVorurteilssuche.getText().trim();
   	ArrayList<Vorurteil> lVorurteil = vorurteile.VorurteilManager.getVorurteile(lTitel);
   	for(Vorurteil l : lVorurteil )
   	{
   		//System.out.println(l.getID() + " " + l.getTitel());
   		tvVorurteilliste.getItems().add(l);
   	}
    }

    private ObservableList<Vorurteil> getVorurteil()
    {
   	 ObservableList<Vorurteil> getVorurteil = FXCollections.observableArrayList();
   	 return getVorurteil;
    }

    public void erstellenTabelle()
    {
   	 tcTitelVorurteilsliste.setCellValueFactory(new PropertyValueFactory<>("titel"));
   	 tvVorurteilliste.setItems(getVorurteil());

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