package fakten;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerViewLöschen
{

	@FXML
   private Button btWechselnHinzufügen;
   
   @FXML
   private Button btWechselnBearbeiten;
   
   @FXML
   private Button btWechselnSuchen;
   
   @FXML
   private Button btWechselnLöschen;

   @FXML
   void wechselnSceneHinzufügen(ActionEvent event) 
   {
   	Main.wechselnSceneHinzufügen();
   }
   
   @FXML
   void wechselnSceneBearbeiten(ActionEvent event) 
   {
   	Main.wechselnSceneBearbeiten();
   }
   
   @FXML
   void wechselnSceneSuchen(ActionEvent event) 
   {
   	Main.wechselnSceneSuchen();
   }
   
   @FXML
   void wechselnSceneLöschen(ActionEvent event) 
   {
   	Main.wechselnSceneLöschen();
   }

}
