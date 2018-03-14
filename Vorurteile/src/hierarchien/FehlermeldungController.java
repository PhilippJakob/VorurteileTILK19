// Autor Hr Dr. Prof. J. Jason, Prinz Emil 14.02.2018
package hierarchien;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FehlermeldungController
{

	@FXML
	private Button btOk;
	@FXML
	private void fensterSchliessen()
	{
		Stage stage = (Stage) btOk.getScene().getWindow();
		stage.close();
	}

	@FXML
	private TextField tfFehlermeldung;

	public void ausgebenFehlermeldung(String pFehlermeldung)
	{
		tfFehlermeldung.setText(pFehlermeldung);
	}
}