//22.01.2018 Erstellt von Gracjan und Tobias
package hierarchien;

import java.util.ArrayList;

import fakten.Fakt;
import hierarchie.Hierarchie;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import vorurteile.Vorurteil;
import vorurteile.VorurteilManager;

public class AnzeigeVorurteilsHierarchieController
{

	@FXML
	TextField tfFakt1, tfFakt2, tfFakt3, tfFakt4,tfFakt5,tfFakt6,tfFakt7,tfFakt8,tfFakt9;
	@FXML
	TextField tfVorurteil1;
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

	
	
	public void anzeigenVorurteil(int pVorurteilsID)
	{
		Vorurteil lVorurteilsListe = VorurteilManager.getVorurteil(pVorurteilsID);
		vorurteile.get(0).setText(lVorurteilsListe.getTitel());
		
		anzeigenVorVorurteile2(lVorurteilsListe.getID());
		anzeigenFakten2(lVorurteilsListe.getID());
		ausblendenUngenutztesTextFeld();
		
	}

	public void anzeigenVorVorurteile(int pVorVorurteilsID)
	{
		ArrayList<Vorurteil> lVorVorurteilsListe = Hierarchie.suchenÜbergeordneteVorurteile(pVorVorurteilsID);
		for(int i =0;i<3;i++)
		{
			vorVorurteile.get(i).setText(lVorVorurteilsListe.get(i).getTitel());
		}
		
		
		anzeigenVorurteilÜberVorVorurteil(lVorVorurteilsListe.get(0).getID());
		anzeigenFakten2(lVorVorurteilsListe.get(0).getID());
		ausblendenUngenutztesTextFeld();
	}

	public void anzeigenFakten(int pFaktenID)
	{
		ArrayList<Fakt> lFaktenListe = Hierarchie.suchenUntergeordneteFakten(pFaktenID);
		for(int i = 0;i<3;i++)
		{
			fakten.get(i+3).setText(lFaktenListe.get(i).getTitel());
		}
		
		anzeigenVorurteil2(lFaktenListe.get(0).getIDFakten());
		anzeigenVorVorurteile2(lFaktenListe.get(0).getIDFakten());
		ausblendenUngenutztesTextFeld();
	}

	
	
	private void anzeigenVorurteilÜberVorVorurteil(int pVorurteilsID)
	{
		ArrayList<Vorurteil> lVorurteilsListe = Hierarchie.suchenUntergeordneteVorurteile(pVorurteilsID);
		
		vorurteile.get(0).setText(lVorurteilsListe.get(0).getTitel());
	}
	
	private void anzeigenVorurteil2(int pVorurteilsID)
	{
		Vorurteil lVorurteilsListe = VorurteilManager.getVorurteil(pVorurteilsID);
		
		vorurteile.get(0).setText(lVorurteilsListe.getTitel());
	}
	
	private void anzeigenVorVorurteile2(int pVorVorurteilsID)
	{
			ArrayList<Vorurteil> lVorVorurteilsListe = Hierarchie.suchenÜbergeordneteVorurteile(pVorVorurteilsID);
			for(int i=0;i<3;i++)
			{
				vorVorurteile.get(i).setText(lVorVorurteilsListe.get(i).getTitel());
			}
	}
	
	private void anzeigenFakten2(int pFaktenID)
	{
		ArrayList<Fakt> lFaktenListe = Hierarchie.suchenUntergeordneteFakten(pFaktenID);
		for(int i=0;i<3;i++)
		{
			fakten.get(i+3).setText(lFaktenListe.get(i).getTitel());
		}
	}
	
	private void ausblendenUngenutztesTextFeld()
	{
		for(TextField tf:vorVorurteile)
		{
			tf.setVisible(true);
			if(tf.getText().matches(""))
			{
				tf.setVisible(false);
			}
		}
		
		for(TextField tf:vorurteile)
		{
			tf.setVisible(true);
			if(tf.getText().matches(""))
			{
				tf.setVisible(false);
			}
		}
		
		for(TextField tf:fakten)
		{
			tf.setVisible(true);
			if(tf.getText().matches(""))
			{
				tf.setVisible(false);
			}
		}
	}
	
}
