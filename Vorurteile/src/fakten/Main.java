package fakten;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application
{
//Hier FXML Datei eingeben (ohne .fxml)
	String FXML = "InternetFaktenView";

    private Stage grundStage;
    private AnchorPane grundPane;

    @Override
	public void start(Stage pPrimaryStage) throws IOException
	{
    	this.grundStage = pPrimaryStage;
	 	FXMLLoader lLoader = new FXMLLoader();
        lLoader.setLocation(Main.class.getResource( FXML + ".fxml"));
        grundPane = lLoader.load();
        Scene lScene = new Scene(grundPane);
        grundStage.setScene(lScene);
        grundStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
