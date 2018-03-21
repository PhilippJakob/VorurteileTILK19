/**
 * @author Jonas, 31. Januar 2018
 * @description Startklasse der Vorurteile
 */

package vorurteile;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class VorurteileStart extends Application
{
	private Stage bühne;
	private AnchorPane pane;

	@Override
	public void start(Stage pPrimaryStage)
	{
		ResourceBundle lBundle;
		FXMLLoader lLoader = new FXMLLoader();
		this.setBühne(pPrimaryStage);

		try
		{
			lBundle = ResourceBundle.getBundle("vorurteile/ui/resources/oberfläche");
			lLoader.setResources(lBundle);
			lLoader.setLocation(this.getClass().getResource("ui/EingabeVorurteilView.fxml"));
			this.setPane(lLoader.load(lLoader.getLocation().openStream()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		Scene lSzene = new Scene(this.getPane());
		this.getBühne().setScene(lSzene);
		this.getBühne().show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

	/** Getter & Setter **/

	public Stage getBühne() {
		return bühne;
	}


	public void setBühne(Stage bühne) {
		this.bühne = bühne;
	}

	public AnchorPane getPane() {
		return pane;
	}


	public void setPane(AnchorPane pane) {
		this.pane = pane;
	}
}