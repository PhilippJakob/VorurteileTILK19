//22.01.2018 Erstellt von Gracjan und Tobias
package hierarchien;

import java.util.ArrayList;

import fakten.Fakt;
import hierarchie.Hierarchie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import vorurteile.items.Vorurteil;

public class AnzeigeVorurteilsHierarchieController
{

	@FXML
	TextField tfFakt1, tfFakt2, tfFakt3, tfFakt4,tfFakt5,tfFakt6,tfFakt7,tfFakt8,tfFakt9;
	@FXML
	TextField tfVorurteil1;
	@FXML
	TextField tfVorVorurteil1, tfVorVorurteil2, tfVorVorurteil3;
	@FXML
	Label lbFakten;
	@FXML
	VBox vbFakten;
	


	private ArrayList<TextField> vorVorurteile = new ArrayList<TextField>();
	private ArrayList<TextField> vorurteile = new ArrayList<TextField>();

	public void hinzufügenZuArrays()
	{
		vorVorurteile.add(tfVorVorurteil1);
		vorVorurteile.add(tfVorVorurteil2);
		vorVorurteile.add(tfVorVorurteil3);

		vorurteile.add(tfVorurteil1);
	}

	
	
	public void anzeigenVorurteil(int pVorurteilsID)
	{
		ArrayList<Vorurteil> lVorurteilsListe = Hierarchie.suchenVorurteil(pVorurteilsID);
		try{
			vorurteile.get(0).setText(lVorurteilsListe.get(0).getTitel());
			
			anzeigenVorVorurteile2(lVorurteilsListe.get(0).getID());
			anzeigenFakten2(lVorurteilsListe.get(0).getID(), false);
			
		}catch(IndexOutOfBoundsException e)
		{
			
		}
		ausblendenUngenutztesTextFeld();
	}

	public void anzeigenVorVorurteile(int pVorVorurteilsID)
	{
		ArrayList<Vorurteil> lVorVorurteilsListe = Hierarchie.suchenÜbergeordneteVorurteile(pVorVorurteilsID);
		try{
   			for(int i =0;i<3;i++)
      		{
      			vorVorurteile.get(i).setText(lVorVorurteilsListe.get(i).getTitel());
      		}
		}catch(IndexOutOfBoundsException e)
		{
			System.out.println("Es wurden keine Vorgesetzten Vorurteile gefunden");
		}
		
		try
		{
			anzeigenVorurteilÜberVorVorurteil(lVorVorurteilsListe.get(0).getID());
   		anzeigenFakten2(pVorVorurteilsID, true);
		}catch(IndexOutOfBoundsException e)
		{
		}
		
		ausblendenUngenutztesTextFeld();
	}

	public void anzeigenFakten(int pFaktenID)
	{
		vbFakten.getChildren().clear();
		ArrayList<Fakt> lFaktenListe = Hierarchie.suchenUntergeordneteFakten(pFaktenID);
		try
		{
			for(int i = 0;i<lFaktenListe.size();i++)
			{
				TextField tf = new TextField();
				tf.setText(lFaktenListe.get(i).getTitel());
				vbFakten.getChildren().add(tf);
			}
		}catch(IndexOutOfBoundsException e)
		{		
		}
		
		try{
			anzeigenVorurteil2(pFaktenID);
			anzeigenVorVorurteile2(pFaktenID);
		}catch(IndexOutOfBoundsException e)
		{		
			e.printStackTrace();
		}
		ausblendenUngenutztesTextFeld();
	}

	
	
	private void anzeigenVorurteilÜberVorVorurteil(int pVorurteilsID)
	{
		ArrayList<Vorurteil> lVorurteilsListe = Hierarchie.suchenUntergeordneteVorurteile(pVorurteilsID);
		
		vorurteile.get(0).setText(lVorurteilsListe.get(0).getTitel());
	}
	
	private void anzeigenVorurteil2(int pVorurteilsID)
	{
		ArrayList<Vorurteil> lVorurteilsListe = Hierarchie.suchenVorurteil(pVorurteilsID);
		
		vorurteile.get(0).setText(lVorurteilsListe.get(0).getTitel());
	}
	
	private void anzeigenVorVorurteile2(int pVorVorurteilsID)
	{
		ArrayList<Vorurteil> lVorurteilsListe = Hierarchie.suchenVorurteil(pVorVorurteilsID);
		ArrayList<Vorurteil> lVorVorurteilsListe = Hierarchie.suchenÜbergeordneteVorurteile(lVorurteilsListe.get(0).getID());
		
		
		try
		{
			for(int i=0;i<3;i++)
   		{
   			vorVorurteile.get(i).setText(lVorVorurteilsListe.get(i).getTitel());
   		}
		}catch(IndexOutOfBoundsException e)
		{
			System.out.println("Es konnten keine weiteren Vorgesetzten Vorurteile gefunden werden");
		}
//			ArrayList<Vorurteil> lVorVorurteilsListe = Hierarchie.suchenÜbergeordneteVorurteile(pVorVorurteilsID);
//			try
//   		{
//				for(int i=0;i<3;i++)
//   			{
//   				vorVorurteile.get(i).setText(lVorVorurteilsListe.get(i).getTitel());
//   			}
//				
//			}catch(IndexOutOfBoundsException e)
//			{
//				System.out.println("Es konnten keine weiteren Vorgesetzten Vorurteile gefunden werden");
//			}
			
	}
	
	private void anzeigenFakten2(int pFaktenID, boolean überVorVorurteil)
	{
		vbFakten.getChildren().clear();
		if(überVorVorurteil)
		{
			ArrayList<Vorurteil> lVorurteilsListe = Hierarchie.suchenVorurteil(pFaktenID);
			
			ArrayList<Vorurteil> lUntergeordnetesVorurteilListe = Hierarchie.suchenUntergeordneteVorurteile(lVorurteilsListe.get(0).getID());
   		if(lUntergeordnetesVorurteilListe.isEmpty())
   		{
   			lbFakten.setText("Fakten");
   			ArrayList<Fakt> lFaktenListe = Hierarchie.suchenUntergeordneteFakten(lVorurteilsListe.get(0).getID());
   			
   			try
   			{
   				for(int i=0;i<lFaktenListe.size();i++)
   				{
   					TextField tf = new TextField();
   					tf.setText(lFaktenListe.get(i).getTitel());
   					vbFakten.getChildren().add(tf);
   				}
   				
   			}catch(IndexOutOfBoundsException e)
   			{
   				System.out.println("es wurden keine weiteren fakten gefunden");
   			}
   			
   		}
   		else
   		{
   			lbFakten.setText("Untergeordnete Vorurteile");
   			try{
   				
   				for(int i=0;i<lUntergeordnetesVorurteilListe.size();i++)
   				{
   					TextField tf = new TextField();
   					tf.setText(lUntergeordnetesVorurteilListe.get(i).getTitel());
   					vbFakten.getChildren().add(tf);
   				}
   			}catch(IndexOutOfBoundsException e)
   			{
   				System.out.println("keine weiteren untergeordenten Vorurteile gefunden");
   			}
   		}
			
		}else
		{		
   		ArrayList<Vorurteil> lUntergeordnetesVorurteilListe = Hierarchie.suchenUntergeordneteVorurteile(pFaktenID);
   		if(lUntergeordnetesVorurteilListe.isEmpty())
   		{
   			lbFakten.setText("Fakten");
   			ArrayList<Fakt> lFaktenListe = Hierarchie.suchenUntergeordneteFakten(pFaktenID);
   			
   			try
   			{
   				for(int i=0;i<lFaktenListe.size();i++)
   				{
   					TextField tf = new TextField();
   					tf.setText(lFaktenListe.get(i).getTitel());
   					vbFakten.getChildren().add(tf);
   				}
   				
   			}catch(IndexOutOfBoundsException e)
   			{
   				System.out.println("es wurden keine weiteren fakten gefunden");
   			}
   			
   		}
   		else
   		{
   			lbFakten.setText("Untergeordnete Vorurteile");
   			try{
   				
   				for(int i=0;i<lUntergeordnetesVorurteilListe.size();i++)
   				{
   					TextField tf = new TextField();
   					tf.setText(lUntergeordnetesVorurteilListe.get(i).getTitel());
   					vbFakten.getChildren().add(tf);
   				}
   			}catch(IndexOutOfBoundsException e)
   			{
   				System.out.println("keine weiteren untergeordenten Vorurteile gefunden");
   			}
   		}
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
	}
	
	
	public void start()
	{
		
	}
	
}