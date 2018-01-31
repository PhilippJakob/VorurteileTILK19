package fakten;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class EingabeMain extends Application
  {

	@Override
	public void start(Stage pGrundStage)
	 {
		 try
		 {
			 AnchorPane lGrundPane = (AnchorPane)FXMLLoader.load(getClass().getResource("EingabeFaktView.fxml"));
			 Scene lScene = new Scene(lGrundPane,600,600);
			 pGrundStage.setScene(lScene);
			 pGrundStage.show();
		 }
		 catch(Exception e) {e.printStackTrace();}


  }

	public static void main(String[] args) {
		launch(args);
	}
}