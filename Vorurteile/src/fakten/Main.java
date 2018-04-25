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
    static private Main mainObject;
 	 private Scene auswahlSuchen, auswahlHinzufügen, auswahlBearbeiten, auswahlLöschen;
 	 private Stage primaryStage;
    @Override
 	public void start(Stage pPrimaryStage) throws IOException
 	{
    	 mainObject = this;
    	 primaryStage = pPrimaryStage;
    	 auswahlSuchen = 		new Scene(FXMLLoader.load(getClass().getResource	("AuswahlSuchenView.fxml"		)));
    	 auswahlHinzufügen = new Scene(FXMLLoader.load(getClass().getResource	("EingabeFaktView.fxml"			)));
    	 auswahlBearbeiten = new Scene(FXMLLoader.load(getClass().getResource	("BearbeitenFaktView.fxml"		)));
    	 auswahlLöschen = 	new Scene(FXMLLoader.load(getClass().getResource	("AuswahlLöschenView.fxml"		)));
    	 primaryStage.setScene(auswahlHinzufügen);
    	 primaryStage.show();
 	}

     public static void wechselnSceneSuchen()
     {
    	 mainObject.primaryStage.setScene(mainObject.auswahlSuchen);
     }

     public static void wechselnSceneHinzufügen()
     {
    	 mainObject.primaryStage.setScene(mainObject.auswahlHinzufügen);
     }

     public static void wechselnSceneBearbeiten()
     {
    	 mainObject.primaryStage.setScene(mainObject.auswahlBearbeiten);
     }

     public static void wechselnSceneLöschen()
     {
    	 mainObject.primaryStage.setScene(mainObject.auswahlLöschen);
     }

	public static void main(String[] args) {
		launch(args);
	}
}
