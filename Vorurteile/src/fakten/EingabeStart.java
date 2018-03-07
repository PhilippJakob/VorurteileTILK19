package fakten;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class EingabeStart extends Application
  {

	static private EingabeStart mainObject;
	private Scene auswahlSuchen, auswahlHinzufügen, auswahlBearbeiten, auswahlLöschen;
	private Stage primaryStage;

	@Override
	public void  start(Stage pGrundStage) throws IOException
	 {
		 try
		 {
			 AnchorPane lGrundPane = (AnchorPane)FXMLLoader.load(getClass().getResource("EingabeFaktView.fxml"));
			 Scene lScene = new Scene(lGrundPane,565,545);
			 pGrundStage.setScene(lScene);
			 pGrundStage.show();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

		 mainObject = this;
   	 primaryStage = pGrundStage;
   	 /*auswahlSuchen = 	new Scene(FXMLLoader.load(getClass().getResource	("AuswahlSuchenView.fxml"		)));*/
   	 auswahlHinzufügen = new Scene(FXMLLoader.load(getClass().getResource	("EingabeFaktView.fxml"	)));
   	 auswahlBearbeiten = new Scene(FXMLLoader.load(getClass().getResource	("BearbeitenFaktView.fxml"	)));
   	 /*auswahlLöschen = 	new Scene(FXMLLoader.load(getClass().getResource	("AuswahlLöschenView.fxml"		)));*/
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

}