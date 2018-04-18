/**
 * @author Jonas N. Henle, 25.01.2018
 * @description Beschreibung: Dient der Eingabe von neuen Vorurteilen.
 */

package vorurteile.ui;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import fakten.Fakt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.stage.Window;
import vorurteile.Verbinder;
import vorurteile.Vorurteil;
import vorurteile.VorurteilManager;
import vorurteile.VorurteileStart;


public class EingabeVorurteilController implements Initializable
{
   @FXML
   private DatePicker dpDatum;

	@FXML
	private TextField tfTitel, tfFaktensuche, tfVorurteilssuche, tfAutor, tfQuelle, tfVeröffentlichung;

	@FXML
   private TextArea taHauptaussage;

	@FXML
   private Button btSpeichernVorurteil, btFaktensuche, btFaktHinzufügen, btFaktAuswählen, btFaktNichtAuswählen,
   					btRefreshF, btVorurteilssuche, btVorurteilAuswählen, btVorurteilNichtAuswählen, btRefreshV;

	@FXML
   private TableView<Fakt> tvFaktenliste, tvFaktenlisteAusgewählt;
	
	@FXML
   private TableView<Vorurteil>	tvVorurteilliste, tvVorurteillisteAusgewählt;

	@FXML
   private TableColumn<Fakt, String> tcTitelFaktenliste, tcTitelFaktenlisteAusgewählt;
	
	@FXML
   private TableColumn<Vorurteil, String> tcTitelVorurteilsliste, tcTitelVorurteilslisteAusgewählt;
	

	@FXML
	private MenuButton mbSprachenliste;
	
	@FXML
   private Label lbErrorF, lbSafeError, lbErrorV;

	@FXML
	private CheckBox cbLink;

	@FXML
   private TabPane tpFaktVorurteil;

	/**
	 * Erstellt eine observable List für Vorurteile und gibt diese zurück.
	 * @return lListe
	 */
	public ObservableList<Vorurteil> getVorurteil()
	{
		ObservableList<Vorurteil> lListe = FXCollections.observableArrayList();
   		
   		return lListe;
   	}

	/**
	 * Erstellt eine observable List für Fakten und gibt diese zurück.
	 * @return lListe
	 */
	public ObservableList<Fakt> getFakten()
	{
		ObservableList<Fakt> lListe = FXCollections.observableArrayList();
		
		return lListe;
	}
	
	/**
     * Erstellt alle Tabellen, um die Items verwalten zu können.
     */
	private void erstellenTabellen()
	{
	   	tcTitelFaktenliste.setCellValueFactory(new PropertyValueFactory<>("titel"));
	   	tvFaktenliste.setItems(getFakten());
	
	   	tcTitelFaktenlisteAusgewählt.setCellValueFactory(new PropertyValueFactory<>("titel"));
	   	tvFaktenlisteAusgewählt.setItems(getFakten());
	
	   	tcTitelVorurteilsliste.setCellValueFactory(new PropertyValueFactory<>("titel"));
	   	tvVorurteilliste.setItems(getVorurteil());
	
	   	tcTitelVorurteilslisteAusgewählt.setCellValueFactory(new PropertyValueFactory<>("titel"));
	   	tvVorurteillisteAusgewählt.setItems(getVorurteil());
	}

	@FXML
	private void suchenFakt(ActionEvent event)
	{
		tvFaktenliste.getItems().clear();
		String lTitel = tfFaktensuche.getText().trim();
		Fakt lFakt = new Fakt(null, null, null, null, null,	null);
		ResultSet lFakten = lFakt.suchenFakt("WHERE Titel LIKE '%"+ lTitel +"%'");
		try
		{
			while(lFakten.next())
			{
				Fakt lFakto = new Fakt(lFakten.getInt(1), lFakten.getString(2), null, null, null, null, null);
				tvFaktenliste.getItems().add(lFakto);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
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
		Fakt lFakt = tvFaktenliste.getSelectionModel().getSelectedItem();

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
		Fakt
		lFakt = tvFaktenlisteAusgewählt.getSelectionModel().getSelectedItem();

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


	/**
	 * Erstellt ein neues Vorurteil und speichert es in der Datenbank ab.
	 */
   @FXML
   void speichernVorurteil(ActionEvent event) throws Exception
   {
   	if(überprüfenFelder())
   	{
   		List<Vorurteil> lVorurteile = VorurteilManager.getVorurteile(this.tfTitel.getText());
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
        	 lVorurteile = this.tvVorurteillisteAusgewählt.getItems();

        	 if ((!lVorurteile.isEmpty()) /*|| (!lFakten.isEmpty())*/)
        	 {
        		 Verbinder lVerbinder = new Verbinder();

      			 try
      			 {
      				 /*for (Fakt lUnterfakt : lFakten)
      				 {
      					 PreparedStatement lStatement;
      					 lStatement = (PreparedStatement) lVerbinder.getConnection().prepareStatement("INSERT INTO `vorurteile_f_v` (`ID_Untergeordneter_Fakt`, `ID_Verbindung_v_f`) VALUES (?, ?);");
      					 lStatement.setInt(1, lUnterfakt.getID());
      					 lStatement.setInt(2, lVorurteil.getID());
      					 lStatement.executeUpdate();
        		 	 }*/

      				 for (Vorurteil lUntervorurteil : lVorurteile)
      				 {
      					 PreparedStatement lStatement;
      					 lStatement = (PreparedStatement) lVerbinder.getConnection().prepareStatement("INSERT INTO `vorurteile_v_v` (`ID_Untergeordnetes_Vorurteil`, `ID_Verbindung_v_v`) VALUES (?, ?);");
      					 lStatement.setInt(1, lUntervorurteil.getID());
      					 lStatement.setInt(2, lVorurteil.getID());
      					 lStatement.executeUpdate();
        		 	 	 }
      			 }
      			 catch (SQLException e)
      			 {
      				 e.printStackTrace();
      			 }
        	    }

      		 this.leerenEingaben();
   	}
   	anzeigenSpeicherFenster(null);
   }

	/**
	 * Leert alle Eingaben.
	 */
   private void leerenEingaben()
   {
  	 	/* 「Vorurteil」  */
  	 	this.tfTitel.clear();
     	this.taHauptaussage.clear();
     	this.tfAutor.clear();
     	this.cbLink.setSelected(false);
     	this.tfQuelle.clear();
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

   public void bearbeitenVorurteil(String pVorurteil)
   {
   	if(!pVorurteil.isEmpty())
   	{
   		//Gebe Fehler aus o.Ä.
   	}
   	else
   	{
   		//Importiere die ganzen Felder
   	}
   }

   private void setzenFelder(Vorurteil pAusgewähltesVorurteil)
   {
   	tfTitel.setText(pAusgewähltesVorurteil.getTitel());
   	taHauptaussage.setText(pAusgewähltesVorurteil.getHauptaussage());
   	tfAutor.setText(pAusgewähltesVorurteil.getAutor());
   	dpDatum.setValue(pAusgewähltesVorurteil.getZeitstempel().toLocalDate());
   	tfQuelle.setText(pAusgewähltesVorurteil.getLink());
   	cbLink.setSelected(pAusgewähltesVorurteil.getInternetquelle());
   }
   
   /**
    * Ändert die Sprache des Programmes.
    */
   @FXML
   private void auswählenSprache(ActionEvent event)
   {
   	this.mbSprachenliste.setText("BAUM");
   }
   
   private void erstellenSprachauswahl()
   {
   	ImageView lBildDeutsch = new ImageView("http://www.geonames.org/flags/x/de.gif");
   	ImageView lBildEnglisch = new ImageView("http://www.geonames.org/flags/x/uk.gif");
   	
   	lBildDeutsch.setFitHeight(12);
   	lBildDeutsch.setFitWidth(16);
   	
   	lBildEnglisch.setFitHeight(12);
   	lBildEnglisch.setFitWidth(16);
   	
   	MenuItem lSpracheDeutsch = new MenuItem("Deutsch", lBildDeutsch);
   	MenuItem lSpracheEnglisch = new MenuItem("English", lBildEnglisch);

   	lSpracheDeutsch.setOnAction(new EventHandler<ActionEvent>() 
   	{
          @Override
          public void handle(ActionEvent event) 
          {
         	 VorurteileStart.getInstance().loadView(Locale.GERMAN);
          }
      });
   	
   	lSpracheEnglisch.setOnAction(new EventHandler<ActionEvent>() 
   	{
          @Override
          public void handle(ActionEvent event) 
          {
         	 VorurteileStart.getInstance().loadView(Locale.ENGLISH);
          }
      });

   	this.mbSprachenliste.getItems().addAll(lSpracheDeutsch, lSpracheEnglisch);
   }

   /**
    * Ruft nach Start des Programmes erstellenTabellen() auf.
    */
	@Override
   public void initialize(URL location, ResourceBundle resources)
   {
   	//bearbeitenVorurteil();
   	
   	//Ruft das Objekt "ausgewähltesVorurteil" aus dem PrototypController auf
   	Vorurteil lAusgewähltesVorurteil = PrototypController.getAusgewähltesVorurteil();
   	
   	if(lAusgewähltesVorurteil != null)
   	{
   		this.setzenFelder(lAusgewähltesVorurteil);
   	}
   	
   	this.erstellenTabellen();
   	this.erstellenSprachauswahl();
   }

	public void anzeigenSpeicherFenster(Window primaryStage)
	{
   	final Stage dialog = new Stage();
      dialog.initModality(Modality.APPLICATION_MODAL);
      dialog.initOwner(primaryStage);
      VBox dialogVbox = new VBox(20);
      dialogVbox.setAlignment(Pos.CENTER);
      Label lText = new Label("Gespeichert");
      dialogVbox.getChildren().add(lText);
      lText.setFont(new Font(20));
      Scene dialogScene = new Scene(dialogVbox, 150, 100);
      dialog.setScene(dialogScene);
      Button lButton = new Button("Ok");
      dialogVbox.getChildren().add(lButton);
      lButton.setFont(new Font(15));
      dialog.show();
      lButton.setOnAction(e -> dialog.hide());

	}

}