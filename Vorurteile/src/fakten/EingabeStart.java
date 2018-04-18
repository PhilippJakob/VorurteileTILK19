package fakten;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class EingabeStart extends Application
  {

	@Override
	public void  start(Stage pGrundStage) throws IOException
	 {
		 try
		 {
			 AnchorPane lGrundPane = (AnchorPane) FXMLLoader.load(getClass().getResource("EingabeFaktView.fxml"));
			 Scene lScene = new Scene(lGrundPane,565,545);
			 pGrundStage.setScene(lScene);
			 pGrundStage.show();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

	 }
	
}