package fakten;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ControllerViewEingabe
	{

    @FXML
    private Button btSpeichern;

    @FXML
    private TextField tfTitel;

    @FXML
    private Label txHinzufügen;

    @FXML
    private Button btInternet;

    @FXML
    private Text txTitel;

    @FXML
    private Text txDatum;

    @FXML
    private TextField tfDatum;

    @FXML
    private Text txQuellenAussage;

    @FXML
    private Button btBuch;

    @FXML
    private Text txQuelle;

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

    private String Quellentyp;

	@FXML
	 public void speichernDaten(ActionEvent event)
		{
			Fakt lFakt = new Fakt(tfTitel.getText(),tfAutor.getText(),tfDatum.getText(),getQuellentyp(),tfLink.getText(),tfQuellenAussage.getText());
         lFakt.anlegen();
		}
   @FXML
   public void auswählenInternet(ActionEvent event)
   	{
   		btAndere.setVisible(true);
   		btInternet.setVisible(false);
   		setQuellentyp("Internet");
   		txQuelle.setText("Internetquelle");
   	}

	@FXML
   public void auswählenBuch(ActionEvent event)
   	{
   		btBuch.setVisible(false);
   		btInternet.setVisible(true);
   		setQuellentyp("Buch");
   		txQuelle.setText("Buchquelle");
   	}

   @FXML
   public  void auswählenAndere(ActionEvent event)
   	{
   		btBuch.setVisible(true);
   		btAndere.setVisible(false);
   		setQuellentyp("Andere");
   		txQuelle.setText("Andere Quelle");

   	}

   @FXML
   public void speichernUhrzeit(ActionEvent event)
   	{


   	}

   public String getQuellentyp()
		{
			return Quellentyp;
		}

   public void setQuellentyp(String pQuellentyp)
		{
			Quellentyp = pQuellentyp;
		}

	}
