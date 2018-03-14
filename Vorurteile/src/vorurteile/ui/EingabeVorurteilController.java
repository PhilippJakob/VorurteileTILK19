/**
 * @author Jonas N. Henle, 25.01.2018
 * @description Beschreibung: Dient der Eingabe von neuen Vorurteilen.
 * @changelog
 * | 07. Mrz 2018: Nico Fliskowski "getVorurteil(); erstellenTabellen(); auswählenFakt(); nichtAuswählenFakt(); auswählenVorurteil(); nichtAuswählenVorurteil(); initialize();"
 * | 07. Mrz 2018: Dimaa "speichernVorurteil()"
 */

package vorurteile.ui;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vorurteile.MySqlConnector;
import vorurteile.VorurteilManager;
import vorurteile.items.Vorurteil;

public class EingabeVorurteilController implements Initializable
{
	@FXML
	private TextField tfTitel, tfFaktensuche, tfVorurteilssuche, tfAutor, tfQuelle, tfVeröffentlichung;

	@FXML
   private TextArea taHauptaussage;

	@FXML
   private Button btSpeichernVorurteil, btFaktensuche, btFaktHinzufügen, btFaktAuswählen, btFaktNichtAuswählen,
   					btRefreshF, btVorurteilssuche, btVorurteilAuswählen, btVorurteilNichtAuswählen, btRefreshV;

	@FXML
   private TableView<Vorurteil> tvFaktenliste, tvFaktenlisteAusgewählt, tvVorurteilliste, tvVorurteillisteAusgewählt;

	@FXML
   private TableColumn<Vorurteil, String> tcTitelFaktenliste, tcTitelFaktenlisteAusgewählt, tcTitelVorurteilsliste,
   													tcTitelVorurteilslisteAusgewählt;

	@FXML
   private Label lbErrorF, lbSafeError, lbErrorV;

	@FXML
	private CheckBox cbLink;

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
	private void suchenFakt(ActionEvent event)
	{

	}

	/**
	 * Erkennt den ausgewählten Tabelleneintrag (lFakt).
	 * Entfernt lFakt aus tvFaktenliste.
	 * Fügt lFakt tvFaktenlisteAusgewählt hinzu.
	 * @param event
	 */
	@FXML
	private void auswählenFakt(ActionEvent event)
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
	private void machenNichtAuswählenFakt(ActionEvent event)
	{
		Vorurteil lFakt = tvFaktenlisteAusgewählt.getSelectionModel().getSelectedItem();

    	if(lFakt != null)
    	{
	    	tvFaktenlisteAusgewählt.getItems().remove(lFakt);
	    	tvFaktenliste.getItems().add(lFakt);
    	}
	}

	@FXML
	private void neuladenFensterF(ActionEvent event)
	{

	}

	@FXML
	private void hinzufügenFakt(ActionEvent event)
	{

	}

	@FXML
	void suchenVorurteil(ActionEvent event)
	{
		tvVorurteilliste.getItems().clear();
		String lTitel = tfVorurteilssuche.getText().trim();
		ArrayList<Vorurteil> lVorurteile = vorurteile.VorurteilManager.getVorurteile(lTitel);
		ArrayList<Integer>	lVorurteileIDs = new ArrayList<>();

		for (Vorurteil lVorurteil : tvVorurteillisteAusgewählt.getItems())
		{
			lVorurteileIDs.add(lVorurteil.getID());
		}

		for(Vorurteil lVorurteil : lVorurteile)
		{
			if (!lVorurteileIDs.contains(lVorurteil.getID()))
			{
			  tvVorurteilliste.getItems().add(lVorurteil);
			}
		}
	}

	/**
	 * Erkennt den ausgewählten Tabelleneintrag (lVorurteil).
	 * Entfernt lVorurteil aus tvFaktenliste.
	 * Fügt lVorurteil tvFaktenlisteAusgewählt hinzu.
	 * @param event
	 */
	@FXML
	private void auswählenVorurteil(ActionEvent event)
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
	private void machenNichtAuswählenVorurteil(ActionEvent event)
	{
		Vorurteil lVorurteil = tvVorurteillisteAusgewählt.getSelectionModel().getSelectedItem();

    	if(lVorurteil != null)
    	{
    		tvVorurteillisteAusgewählt.getItems().remove(lVorurteil);
    		tvVorurteilliste.getItems().add(lVorurteil);
    	}
	}

	@FXML
	private void neuladenFensterV(ActionEvent event)
	{

	}

	/*@FXML
	private void speichernVorurteil(ActionEvent event)
	{
		überprüfenFelder();
	}*/

	/**
	 * Erstellt ein neues Vorurteil und speichert es in der Datenbank ab.
	 */
   @FXML
   void speichernVorurteil(ActionEvent event) throws Exception
   {
   	if(überprüfenFelder())
   	{
   		ArrayList<Vorurteil> lVorurteile = VorurteilManager.getVorurteile(this.tfTitel.getText());

     	 	for (Vorurteil lVorurteil : lVorurteile)
     	 	{
     	 		if (lVorurteil.getTitel().equals(this.tfTitel.getText()))
     	 		{
        			 lbSafeError.setText("Titel ist bereits vorhanden");
        			 return;
        		}
     	 	}

        	 Vorurteil lVorurteil = VorurteilManager.erstellenVorurteil(this.tfTitel.getText(), this.tfAutor.getText(), LocalDateTime.now(), this.cbLink.isSelected(), this.tfQuelle.getText(), this.taHauptaussage.getText());

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

   private boolean überprüfenFelder()
   {
     	if (taHauptaussage.getText().isEmpty() || tfTitel.getText().isEmpty())
     	{
     		lbSafeError.setText("Error: Bitte alle Felder ausfüllen");
     		return false;
     	}
     	else
     	{
     		lbSafeError.setText("");
     		return true;
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