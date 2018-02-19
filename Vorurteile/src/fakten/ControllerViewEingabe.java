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
    private TextField tfDatum;

    @FXML
    private Text txQuellenAussage;

    @FXML
    private Button btSpeichern;

    @FXML
    private TextField tfTitel;

    @FXML
    private Label txHinzufügen;

    @FXML
    private Text txBuchquelle;

    @FXML
    private Text txTitel;

    @FXML
    private TextField tfQuellenAussage;

    @FXML
    private Text txAutor;

    @FXML
    private TextField tfAutor;

    @FXML
    private Text txDatum;

    @FXML
    private TextField tfLink;

    @FXML
    private Button btAndere;

    @FXML
    private Button btBuch;

    @FXML
    private Button btInternet;

    @FXML
    private TextField tfZeitstempel;

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
   	}

	@FXML
   public void auswählenBuch(ActionEvent event)
   	{
   		btBuch.setVisible(false);
   		btInternet.setVisible(true);
   		setQuellentyp("Buch");
   	}

   @FXML
   public  void auswählenAndere(ActionEvent event)
   	{
   		btBuch.setVisible(true);
   		btAndere.setVisible(false);
   		setQuellentyp("Andere");
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
