package suche;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import datenbank.Datenbankverbindung;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vorurteile.items.Vorurteil;

/**
 * Angelegt: 05.03.2018, Chantal Mielenz
 * Geändert: 07.03.2018, Chantal Mielenz, Methode hinzugefügt
 * Geändert: 19.03.2018, Chantal Mielenz, Methode verändert / erweitert
 * Geändert: 21.03.2018, Florian Henderkes & Chantal Mielenz, Methoden suchenVorurteile und suchenVorurteileNachSuchwörter verändert / erweitert
 */

public class SucheController 
{

    @FXML
    private TextField tfSuchleiste;

    @FXML
    private Button btSuche;

    @FXML
    private TableView<?> tvVorurteilsliste;

    @FXML
    private TableColumn<?, ?> tcVorurteilsliste;
    
    @FXML
    void suchenVorurteile(ActionEvent event) 
    {
   	 	if(tfSuchleiste.getText().isEmpty())
   	 	{
   	 		tcVorurteilsliste.setText("Fehler!");
   	 	}
   	 	else
   	 	{
   	 		System.out.println(tfSuchleiste.getText());
   	 		String lSuche = tfSuchleiste.getText();
   	 		String[] lSuchwörter = lSuche.split(" ");
   	 		ObservableList<Vorurteil> lVorurteile = FXCollections.observableArrayList();
   	 		for(String suchwort : lSuchwörter)
   	 		{
   	 			lVorurteile = suchenVorurteileNachSuchwort(suchwort);
   	 		}
   	 		//tcVorurteilsliste.setCellValueFactory(new PropertyValueFactory<Vorurteil, String>("titel"));
   	 	}
    }
    
    public static ObservableList<Vorurteil> suchenVorurteileNachSuchwort(String pSuchwort)
	{
		ObservableList<Vorurteil> lListeVorurteile = FXCollections.observableArrayList();
		try
		{
			Connection lVerbindung = Datenbankverbindung.getConnection();
			Statement lBefehl = lVerbindung.createStatement();
			ResultSet lErgebnis = lBefehl.executeQuery
					("SELECT vu.Titel, vu.ID_Vorurteile, vu.Autor, vu.Internetquelle_Ja_Nein, vu.Link FROM dbo_vorurteile.vorurteile vu WHERE vu.Titel LIKE '%" + pSuchwort + "%';");
			while(lErgebnis.next())
			{
				lListeVorurteile.add(new Vorurteil(lErgebnis.getInt("vu.ID_Vorurteile"), lErgebnis.getString("vu.Titel"), lErgebnis.getString("vu.Autor"), 0, lErgebnis.getString("vu.Internetquelle_Ja_Nein"), lErgebnis.getString("vu.Link")));
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return lListeVorurteile;
	}
}
