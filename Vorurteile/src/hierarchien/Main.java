/**
 *  bearbeitet von Gracjan Flik und Tobias Neubert am 22.01.2018
 */
package hierarchien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			AnzeigeVorurteilsHierarchieController controller = new AnzeigeVorurteilsHierarchieController();
			FXMLLoader lLoader = new FXMLLoader(getClass().getResource("AnzeigeVorurteilsHierarchieView.fxml"));
			lLoader.setController(controller);
			AnchorPane lPane = lLoader.load();
			Scene lSzene = new Scene(lPane);
			primaryStage.setScene(lSzene);
			primaryStage.show();
			controller.hinzufügenZuArrays();
//			controller.test();
			String[] string = {"hey", "hi", "ho"};
			controller.anzeigenVorurteile(string);
			controller.anzeigenVorVorurteile(string);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}//end
