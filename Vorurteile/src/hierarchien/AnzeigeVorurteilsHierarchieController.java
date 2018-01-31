package hierarchien;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AnzeigeVorurteilsHierarchieController
{

	@FXML
	TextField tfFakt1, tfFakt2, tfFakt3, tfFakt4,tfFakt5,tfFakt6,tfFakt7,tfFakt8,tfFakt9;
	@FXML
	TextField tfVorurteil1,tfVorurteil2,tfVorurteil3;
	@FXML
	TextField tfVorVorurteil1, tfVorVorurteil2, tfVorVorurteil3;

	private ArrayList<TextField> vorVorurteile = new ArrayList<TextField>();
	private ArrayList<TextField> vorurteile = new ArrayList<TextField>();
	private ArrayList<TextField> fakten = new ArrayList<TextField>();

	public void hinzufügenZuArrays()
	{
		vorVorurteile.add(tfVorVorurteil1);
		vorVorurteile.add(tfVorVorurteil2);
		vorVorurteile.add(tfVorVorurteil3);

		vorurteile.add(tfVorurteil1);
		vorurteile.add(tfVorurteil2);
		vorurteile.add(tfVorurteil3);

		fakten.add(tfFakt1);
		fakten.add(tfFakt2);
		fakten.add(tfFakt3);
		fakten.add(tfFakt4);
		fakten.add(tfFakt5);
		fakten.add(tfFakt6);
		fakten.add(tfFakt7);
		fakten.add(tfFakt8);
		fakten.add(tfFakt9);
	}

	public void anzeigenVorurteile(String[] pString)
	{
		for(int i =0; i<3;i++)
		{
			vorurteile.get(i).setText(pString[i]);
		}
	}

	public void anzeigenVorVorurteile(String[] pString)
	{
		for(int i =0; i<3;i++)
		{
			vorVorurteile.get(i).setText(pString[i]);
		}
	}

	public void anzeigenFakten(String[] pString)
	{
	}

}
