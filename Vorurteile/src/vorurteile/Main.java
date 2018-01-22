//  ___________________________________________________________________________________________________________________
//  | ####################################### |      Name Main.java          | ###################################### |
//  | ####################################### | Origin = Philipp Jakob V 0.1 | ###################################### |
//  | ####################################### |   @Author = Jonas N. Henle   | ###################################### |
//  | ####################################### |        Version 0.1.1         | ###################################### |
//  | ####################################### |     Date: 18.01.18   12:58   | ###################################### |
//  | ####################################### |Group Vorurteile [Ben / Ohan] | ###################################### |
//  |_________________________________________|______________________________|________________________________________|


package vorurteile;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	private Stage bühne;
	private AnchorPane pane;

	@Override
	public void start(Stage pPrimaryStage) {

		this.setBühne(pPrimaryStage);
		this.getBühne().setTitle("Vorurteile hinzufügen");

		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			pPrimaryStage.setScene(scene);
			pPrimaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Stage getBühne()
	{
		return bühne;
	}

	public AnchorPane getPane()
	{
		return pane;
	}

	public void setBühne(Stage pBühne)
	{
		bühne = pBühne;
	}

	public void setPane(AnchorPane pPane)
	{
		pane = pPane;
	}
}
