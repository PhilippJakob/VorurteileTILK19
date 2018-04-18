/**
 * @author Jonas, 31. Januar 2018
 * @description Startklasse der Vorurteile
 */

package vorurteile;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class VorurteileStart extends Application
{
	private static volatile VorurteileStart instanz;
	private static Object object = new Object();
	
	public static VorurteileStart getInstance() 
	{
		if (VorurteileStart.instanz != null)
		{
			return VorurteileStart.instanz;
		}
		
		synchronized (VorurteileStart.object) 
		{
			if (VorurteileStart.instanz == null)
			{
				VorurteileStart.instanz = new VorurteileStart();
			}
			
			return VorurteileStart.instanz;
		}
	}
	
	public void Initialize(Stage pPrimaryStage)
	{
		this.setBühne(pPrimaryStage);

		try
		{
			this.loadView(Locale.GERMAN);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private Stage bühne;
	private AnchorPane pane = new AnchorPane();

	@Override
	public void start(Stage pPrimaryStage)
	{
		VorurteileStart.getInstance().Initialize(pPrimaryStage);
	}
	
	public void loadView(Locale pLocale)
	{
		ResourceBundle lBundle;
		FXMLLoader lLoader = new FXMLLoader();
			
		try
		{				
			lBundle = ResourceBundle.getBundle("vorurteile/ui/resources/oberfläche", pLocale);
			lLoader.setResources(lBundle);
			lLoader.setLocation(this.getClass().getResource("ui/EingabeVorurteilView.fxml"));
			this.setPane(lLoader.load(lLoader.getLocation().openStream()));
				
			Scene lSzene = new Scene(this.getPane());
			this.getBühne().setScene(lSzene);
			this.getBühne().show();
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