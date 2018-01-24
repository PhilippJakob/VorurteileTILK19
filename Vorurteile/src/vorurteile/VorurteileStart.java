//  ___________________________________________________________________________________________________________________
//  | ####################################### |   Name VorurteileStart.java  | ###################################### |
//  | ####################################### |Origin = Jonas N. Henle V 0.1 | ###################################### |
//  | ####################################### |   @Author = Jonas N. Henle   | ###################################### |
//  | ####################################### |        Version 0.1.1         | ###################################### |
//  | ####################################### |     Date: 18.01.18   12:58   | ###################################### |
//  | ####################################### |Group Vorurteile [Ben / Ohan] | ###################################### |
//  |_________________________________________|______________________________|________________________________________|

package vorurteile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class VorurteileStart extends Application
{
	private Stage bühne;
	private AnchorPane pane;
// 1312312 //

	@Override
	public void start(Stage pPrimaryStage)
	{
		FXMLLoader lLoader = new FXMLLoader();
		this.setBühne(pPrimaryStage);
		this.getBühne().setTitle("Hinzufügen eines Vorurteils");

		try
		{
			lLoader.setLocation(VorurteileStart.class.getResource("EingabeVorurteilView.fxml"));
			this.setPane(lLoader.load());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Scene Szene = new Scene(this.getPane());
		this.getBühne().setScene(Szene);
		this.getBühne().show();
	}
public static void main(String[] args)
{
	launch(args);
}
//Getters und Setters

	public Stage getBühne() {
		return bühne;
	}


	public void setBühne(Stage bühne) {
		this.bühne = bühne;
		//fgdfg
	}

	public AnchorPane getPane() {
		return pane;
	}


	public void setPane(AnchorPane pane) {
		this.pane = pane;
	}

}
