//  ___________________________________________________________________________________________________________________
//  | ####################################### |Name SucheFaktController.java | ###################################### |
//  | ####################################### |   @Author = Nico Fliskowski  | ###################################### |
//  | ####################################### |         Version 1.0          | ###################################### |
//  | ####################################### |     Date: 24.01.18   12:17   | ###################################### |
//  | ####################################### |Group Vorurteile [Ben / Ohan] | ###################################### |
//  |_________________________________________|______________________________|________________________________________|

package vorurteile.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vorurteile.MySqlConnector;

public class SucheFaktController
{
	//Errorlabel
	@FXML
   private Label lbError;

	//Faktensuche
	@FXML
	private TextField tfFaktensuche;

	@FXML
   private Button btFaktensuche;

	//Fakten auswählen
	@FXML
   private TableView<?> tvFaktenliste;


	@FXML
   private TableColumn<?, ?> tcTitelFaktenliste;

   @FXML
   private Button btFaktAuswählen;

   @FXML
   private Button btFaktNichtAuswählen;

   @FXML
   private TableView<?> tvFaktenlisteAusgewählt;

   @FXML
   private TableColumn<?, ?> tcTitelFaktenlisteAusgewählt;

   //Fenster aktualisieren
   @FXML
   private Button btRefresh;

   //Fakt hinzufügen
   @FXML
   private Button btFaktHinzufügen;

   /**
    * Falls tfFaktensuche nicht leer ist, wird nach dem entsprechendem String in der Datenbank gesucht
    * Alle Ergebnisse werden in tvFaktenliste angezeigt
    * Ist tfFaktensuche leer, wird Fehler ausgegeben
    * @param event
    */
   @FXML
   public void suchenFakt(ActionEvent event)
   {
   	/*
   	int lID;
   	String lTitel;

   	String lTFFaktensuche = tfFaktensuche.getText().trim();

   	if(!lTFFaktensuche.isEmpty())
   	{
   		MySqlConnector lConnector = new MySqlConnector();

   		try
			{
				Statement lStatement = lConnector.getConnection().createStatement();
				ResultSet rs = lStatement.executeQuery("SELECT ID_Fakten, Titel FROM dbo_vorurteile.fakten WHERE Titel LIKE '%" + lTFFaktensuche + "%'");

				while(rs.next())
				{
					lID = rs.getInt(1);
					lTitel = rs.getString(2);

					System.out.println(lID + "  " + lTitel);
				};
			}
   		catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
   	}
   	else
   	{
   		lbError.setText("Error: Suchbegriff eingeben");
   	};
   	*/
   };

   @FXML
   public void auswählenFakt(ActionEvent event)
   {

   };

   @FXML
   public void nichtAuswählenFakt(ActionEvent event)
   {

   };

   @FXML
   public void neuladenFenster(ActionEvent event)
   {

   };

   @FXML
   public void hinzufügenFakt(ActionEvent event)
   {

   };
};
