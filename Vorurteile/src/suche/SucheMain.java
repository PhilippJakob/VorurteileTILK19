package suche;
import java.io.IOException;

/*
 * Erstellt von Chantal Mielenz am 05.03.2018
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Angelegt: 07.03.2018, Chantal Mielenz, Testen der Oberfläche
 *
 */
public class SucheMain extends Application 
{
	
	@Override
	public void start(Stage pPrimaryStage) throws IOException 
	{
		Parent lParent = FXMLLoader.load(getClass().getResource("SucheView.fxml"));
		pPrimaryStage.setScene(new Scene(lParent));
		pPrimaryStage.setTitle("Suche der Vorurteile");
		pPrimaryStage.show();
	}

	public static void main(String[] args) 
	{
		launch(args);
		
	}

	
}
