// Autor Hr Dr. Prof. J. Jason, Prinz Emil 14.02.2018
package hierarchien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Fehlermeldung_Haupt extends Application
{

	@Override
	public void start(Stage pGrundStage)
	{
		try
		{
			Parent lGrundPane = FXMLLoader.load(getClass().getResource("FehlerView.fxml"));
			Scene lScene = new Scene(lGrundPane);
			pGrundStage.setScene(lScene);
			pGrundStage.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
