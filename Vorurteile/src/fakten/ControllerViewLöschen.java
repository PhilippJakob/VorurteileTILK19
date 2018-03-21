/**
 * Angelegt von Adrian Schupke am 14.03.2018
 */
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
   void ändernOberfläche(ActionEvent event)
   {

   }

   @FXML
   void wechselnSceneHinzufügen(ActionEvent event)
   {
  	 	EingabeStart.wechselnSceneHinzufügen();
   }

   @FXML
   void wechselnSceneBearbeiten(ActionEvent event)
   {
   	EingabeStart.wechselnSceneBearbeiten();
   }

   @FXML
   void wechselnSceneSuchen(ActionEvent event)
   {
   	EingabeStart.wechselnSceneSuchen();
   }

   @FXML
   void wechselnSceneLöschen(ActionEvent event)
   {
   	EingabeStart.wechselnSceneLöschen();
   }

}
