/**
 * angelegt von Maximilian am 14.03.2018
 */
package fakten;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ControllerViewEingabe
	{
	 @FXML
    private Text txQuelle;

    @FXML
    private Button btSpeichern;

    @FXML
    private TextField tfTitel;

    @FXML
    private Text txMeldungen;

    @FXML
    private Label txHinzufügen;

    @FXML
    private Button btInternet;

    @FXML
    private Text txTitel;

    @FXML
    private Text txDatum;

    @FXML
    private Text txLink;

    @FXML
    private Text txQuellenAussage;

    @FXML
    private TextField tfFaktid;

    @FXML
    private Button btBuch;

    @FXML
    private DatePicker dpDatum;

    @FXML
    private Button btLöschen;

    @FXML
    private TextField tfQuellenAussage;

    @FXML
    private Text txAutor;

    @FXML
    private TextField tfAutor;

    @FXML
    private Button btAndere;

    @FXML
    private TextField tfLink;
    
    @FXML
    private String Quellentyp;

 	@FXML
   private Button btWechselnHinzufügen;

   @FXML
   private Button btWechselnBearbeiten;

   @FXML
   private Button btWechselnSuchen;

   @FXML
   private Button btWechselnLöschen;
   
   @FXML
   private TextField tfFaktID;
   

    private boolean istInternetquelle = false;


   @FXML
   void ändernOberfläche(ActionEvent event)
   {

   }
   
   @FXML
   void wechselnSceneHinzufügen(ActionEvent event)
   {
  	   Main.wechselnSceneHinzufügen();
   }

   @FXML
   void wechselnSceneBearbeiten(ActionEvent event)
   {
   	Main.wechselnSceneBearbeiten();
   }

   @FXML
   void wechselnSceneSuchen(ActionEvent event)
   {
   	Main.wechselnSceneSuchen();
   }

   @FXML
   void wechselnSceneLöschen(ActionEvent event)
   {
   	Main.wechselnSceneLöschen();
   }

    //Methode zum Speichern der eingegebenen Daten.
	@FXML
	 public void speichernDaten(ActionEvent event)
		{
		   if(prüfenEingabe() ==true)
		   {
		   	// FIXME: im constructor istInternetquelle als boolean machen.
			Fakt lFakt = new Fakt(tfTitel.getText(),tfAutor.getText(),dpDatum.getValue(),
						String.valueOf(istInternetquelle),tfLink.getText(),tfQuellenAussage.getText());
         lFakt.anlegen();
	   	txMeldungen.setStyle("-fx-fill: green");
	   	txMeldungen.setText("Speichern erfolgreich");
	   	txMeldungen.setVisible(true);

		   }
		   else
		   {
		   	txMeldungen.setStyle("-fx-fill: red");
		   	txMeldungen.setText("Bitte tätigen sie eine Eingabe beim Titel und der Aussage");
	   		txMeldungen.setVisible(true);
		   }
		}
	
	@FXML
   void entfernenFakt(ActionEvent event)
	{
    Fakt lFakt = new Fakt(tfFaktID.getText());
    lFakt.entfernenFakt();
    
   }
  
	@FXML
   public void auswählenInternet(ActionEvent event)
   	{
   		btAndere.setVisible(true);
   		btInternet.setVisible(false);
   		istInternetquelle = true;
   		txQuelle.setText("Internetquelle");
   		txLink.setVisible(true);
   		tfLink.setVisible(true);
   	}

   public boolean prüfenEingabe()
   {
   	if(tfTitel.getText().length() == 0 || tfQuellenAussage.getText().length() == 0 || falschesDatum()== true )
   	{
   		return false;
   	}
   	else
   	{
   		return true;
   	}
   }
   
   public boolean falschesDatum()
   {
   	if(dpDatum.getValue().toString().length() == 0)
   	{
   		return true;
   	}
   	   return false;
   }

  /* public boolean prüfenLink()
   {
   	if(tfLink.getText().startsWith("http"))
   	{
   		return true;
   	}
   	else
   	{
   		return false;
   	}

   }
*/
	@FXML
   public void auswählenBuch(ActionEvent event)
   	{
   		btBuch.setVisible(false);
   		btInternet.setVisible(true);
   		istInternetquelle = false;
   		txQuelle.setText("Buchquelle");
   		txLink.setVisible(false);
   		tfLink.setVisible(false);
   	}

   @FXML
   public  void auswählenAndere(ActionEvent event)
   	{
   		btBuch.setVisible(true);
   		btAndere.setVisible(false);
   		istInternetquelle = false;
   		txQuelle.setText("Andere Quelle");
   		txLink.setVisible(false);
   		tfLink.setVisible(false) ;
   	}

	}