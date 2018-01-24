/**
 * bearbeitet von Gracjan Flik und Tobias Neubert am 22.01.2018
 */

package hierarchien;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AnzeigeVorurteilsHierarchieController
{

	Testklasse tk;

	private ArrayList<TextField> vorurteile= new ArrayList<TextField>();
	private ArrayList<TextField> vorVorurteile= new ArrayList<TextField>();
	private ArrayList<TextField> fakten= new ArrayList<TextField>();

    @FXML
    private TextField tfVorurteil1, tfVorurteil2, tfVorurteil3;

    @FXML
    private TextField tfVorVorurteil1, tfVorVorurteil2, tfVorVorurteil3;

    @FXML
    private TextField tfFakt1, tfFakt2, tfFakt3, tfFakt4, tfFakt5,
    						 tfFakt6, tfFakt7, tfFakt8, tfFakt9;


//    public void test()
//    {
//   	 tk = new Testklasse("Alle Bäume sind braun");
//   	 tk.hinzufuegenFakt("Fakt 1");
//   	 tk.hinzufuegenFakt("Fakt 2");
//   	 tk.hinzufuegenFakt("Fakt 3");
//
//   	 tk.hinzufuegenVorVorurteil("Stimmt nicht");
//   	 tk.hinzufuegenVorVorurteil("Es gibt auch weiße");
//   	 tk.hinzufuegenVorVorurteil("Was, Äpfel, Eier, Plaumen?");
//
//   	 tfVorurteil1.setText(tk.getVorurteil());
//
//   	 tfFakt1.setText(tk.getFakten().get(0));
//   	 tfFakt2.setText(tk.getFakten().get(1));
//   	 tfFakt3.setText(tk.getFakten().get(2));
//
//   	 tfVorVorurteil1.setText(tk.getVorVorurteile().get(0));
//   	 tfVorVorurteil2.setText(tk.getVorVorurteile().get(1));
//   	 tfVorVorurteil3.setText(tk.getVorVorurteile().get(2));
//    }


    public void anzeigenVorurteile(String[] pVorurteile)
    {
   	 int i =0;
   	 for (String lVorurteil : pVorurteile)
   	 {
   		 vorurteile.get(i).setText(lVorurteil);
   		 ++i;
   	 }
    }

    public void anzeigenVorVorurteile(String[] pVorVorurteile)
    {
   	 int i =0;
   	 for (String lVorurteil : pVorVorurteile)
   	 {
   		 vorVorurteile.get(i).setText(lVorurteil);
   		 ++i;
   	 }
    }

    public void anzeigenFakten(String[] pFakten)
    {

    }

    public void hinzufügenZuArrays()
    {
   	 vorurteile.add(tfVorurteil1);
   	 vorurteile.add(tfVorurteil2);
   	 vorurteile.add(tfVorurteil3);

   	 vorVorurteile.add(tfVorVorurteil1);
   	 vorVorurteile.add(tfVorVorurteil2);
   	 vorVorurteile.add(tfVorVorurteil3);

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

}//end
