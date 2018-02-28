package vorurteile.ui;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import vorurteile.MySqlConnector;
import vorurteile.VorurteilManager;
import vorurteile.items.Vorurteil;

public class EingabeVorurteilController
{
	    @FXML private Button btFaktAuswählen, btRefresh, btVorurteilAuswählen, btSpeichernVorurteil, btFaktensuche, btVorurteilssuche, btRefresh1, btFaktHinzufügen, btFaktNichtAuswählen, btVorurteilNichtAuswählen;
	    @FXML private Label lbError, lbError1;
	    @FXML private TableColumn<?, ?> tcTitelFaktenlisteAusgewählt, tcIDFaktenliste, tcIDFaktenlisteAusgewählt, tcIDVorurteilsliste, tcIDVorurteilslisteAusgewählt, tcTitelVorurteilslisteAusgewählt, tcTitelVorurteilsliste, tcTitelFaktenliste;
	    @FXML private TableView<?> tvVorurteilliste, tvFaktenliste, tvVorurteillisteAusgewählt, tvFaktenlisteAusgewählt;
	    @FXML private TabPane tpFaktVorurteil;
	    @FXML private TextArea taHauptaussage;
	    @FXML private TextField tfTitel, tfFaktensuche, tfVorurteilssuche;

	    @FXML
	    void suchenFakt(ActionEvent event) 
	    {

	    }

	    @FXML
	    void auswählenFakt(ActionEvent event) 
	    {

	    }

	    @FXML
	    void nichtAuswählenFakt(ActionEvent event) 
	    {

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

	    }

	    @FXML
	    void auswählenVorurteil(ActionEvent event) 
	    {

	    }

	    @FXML
	    void nichtAuswählenVorurteil(ActionEvent event) 
	    {

	    }

	    @FXML
	    void neuladenFensterV(ActionEvent event) 
	    {

	    }

	    @FXML
	    void speichernVorurteil(ActionEvent event) 
	    {
	   	 //ArrayList<Fakt> lFakten = tvFaktenlisteAusgewählt.getItems();
	   	 ArrayList<Vorurteil> lVorurteile = (ArrayList<Vorurteil>) tvVorurteillisteAusgewählt.getItems();
	   		 
	   	 if ((!lVorurteile.isEmpty()) /*|| (!lFakten.isEmpty())*/) 
	   	 {
	   		 /*MySqlConnector lConnector = new MySqlConnector();
	   		 PreparedStatement lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("INSERT INTO `vorurteile` (`ID_Vorurteile`, `Titel`, `Autor`, `Veröffentlichung`, `InternetQuelle_Ja_Nein`, `Link`, `Zeitstempel`) VALUES (?, ?, ?, ?, ?, ?, ?);");
	 			lStatement.setInt(1, lVorurteil.getID());
				lStatement.setString(2, lVorurteil.getTitel());
				lStatement.setString(3, lVorurteil.getAutor());
				lStatement.executeUpdate();*/
	   		 
	   		 this.leerenEingaben();
	   	 }
	    }
	    
	    private void leerenEingaben() 
	    {
	   	 /* 「Vorurteil」  */
	   	 this.tfTitel.clear();
	   	 this.taHauptaussage.clear();
	   	 
	   	 /* 「Fakt verknüpfen」 Tab */
	   	 this.tfFaktensuche.clear();
	   	 this.tvFaktenliste.getItems().clear();
	   	 this.tvFaktenlisteAusgewählt.getItems().clear();

	   	 /* 「Vorurteil verknüpfen」 Tab */
	   	 this.tfVorurteilssuche.clear();
	   	 this.tvVorurteilliste.getItems().clear();
	   	 this.tvVorurteillisteAusgewählt.getItems().clear();
	    }
}