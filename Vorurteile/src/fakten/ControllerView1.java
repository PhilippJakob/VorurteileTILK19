//Maximilian Schöbel
package fakten;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class ControllerView1
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
   private Text tfInternetquelle;

   @FXML
   private Button btBuch;

   @FXML
   private Button btInternet;



   @FXML
   void ändernOberfläche(ActionEvent event)
   	{
   		btInternet.setText("Buch");

   	}


}

