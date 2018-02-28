package fakten;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private Button btSpeichern;

    @FXML
    private TextField tfTitel;

    @FXML
    private Label txHinzufügen;

    @FXML
    private Label txMeldungen;

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
    private Text txLink;

    @FXML
    private DatePicker dpDatum;

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
		   if(prüfenEingabe() ==true)
		   {
			Fakt lFakt = new Fakt(tfTitel.getText(),tfAutor.getText(),dpDatum.getValue(),getQuellentyp(),tfLink.getText(),tfQuellenAussage.getText());
         lFakt.anlegen();
	   	txMeldungen.setText("Speichern erfolgreich");
	   	txMeldungen.setVisible(true);

		   }
		   else
		   {
		   	txMeldungen.setText("Bitte tätigen sie eine Eingabe beim Titel und der Aussage");
	   		txMeldungen.setVisible(true);
		   }
		}
   @FXML
   public void auswählenInternet(ActionEvent event)
   	{
   		btAndere.setVisible(true);
   		btInternet.setVisible(false);
   		setQuellentyp("Internet");
   		txQuelle.setText("Internetquelle");
   	}

   public boolean prüfenEingabe()
   {
   	if(tfTitel.getText().length() == 0 || tfQuellenAussage.getText().length() == 0)
   	{
   		return false;
   	}
   	else
   	{
   		return true;
   	}
   }

   public boolean prüfenLink()
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

   public String getQuellentyp()
		{
			return Quellentyp;
		}

   public void setQuellentyp(String pQuellentyp)
		{
			Quellentyp = pQuellentyp;
		}
	}
