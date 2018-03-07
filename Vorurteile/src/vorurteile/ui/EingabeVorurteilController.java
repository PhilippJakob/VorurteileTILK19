package vorurteile.ui;

import java.sql.SQLException;
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
	   	 ArrayList<Vorurteil> lVorurteile = VorurteilManager.getVorurteile(this.tfTitel.getText());
	   	 
	   	 for (Vorurteil lVorurteil : lVorurteile)
	   	 {
	   		 if (lVorurteil.getTitel().equals(this.tfTitel.getText()))
	   		 {
	   			 lbError.setText("Titel ist bereits vorhanden");
	   			 return;
	   		 }
	   	 }
	   	 
	   	 Vorurteil lVorurteil = VorurteilManager.erstellenVorurteil(this.tfTitel.getText(), null, LocalDateTime.now(), false, null, this.taHauptaussage.getText());
	   	 
	   	 //ArrayList<Fakt> lFakten = tvFaktenlisteAusgewählt.getItems();
	   	 lVorurteile = (ArrayList<Vorurteil>) this.tvVorurteillisteAusgewählt.getItems();
	   		 
	   	 if ((!lVorurteile.isEmpty()) /*|| (!lFakten.isEmpty())*/) 
	   	 {
	   		 MySqlConnector lConnector = new MySqlConnector();

				 try
				 {
					 /*for (Fakt lUnterfakt : lFakten)
					 {
						 PreparedStatement lStatement;
						 lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("INSERT INTO `vorurteile_f_v` (`ID_Untergeordneter_Fakt`, `ID_Verbindung_v_f`) VALUES (?, ?);");
						 lStatement.setInt(1, lUnterfakt.getID());
						 lStatement.setInt(2, lVorurteil.getID());
						 lStatement.executeUpdate();
	   		 	 }*/
					 
					 for (Vorurteil lUntervorurteil : lVorurteile)
					 {
						 PreparedStatement lStatement;
						 lStatement = (PreparedStatement) lConnector.getConnection().prepareStatement("INSERT INTO `vorurteile_v_v` (`ID_Untergeordnetes_Vorurteil`, `ID_Verbindung_v_v`) VALUES (?, ?);");
						 lStatement.setInt(1, lUntervorurteil.getID());
						 lStatement.setInt(2, lVorurteil.getID());
						 lStatement.executeUpdate();
	   		 	 }
				 } 
				 catch (SQLException e)
				 {
				 	 // TODO Auto-generated catch block
					 e.printStackTrace();
				 }
	   		 
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