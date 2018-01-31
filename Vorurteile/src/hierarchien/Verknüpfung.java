package hierarchien;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import datenbank.Datenbankverbindung;
import vorurteile.Vorurteile;

public class Verknüpfung
{

	public ArrayList<Vorurteile> suchenUntergeordneteVorurteile(int pVorurteilID){

		ArrayList<Vorurteile> lListeVorurteile = new ArrayList<>();

		try
		{
			Connection lConnection = Datenbankverbindung.getConnection();
			Statement lBefehl = lConnection.createStatement();
			ResultSet lResult = lBefehl.executeQuery("SELECT vo.Titel FROM dbo_vorurteile.vorurteile vo, dbo_vorurteile.vorurteile vu, dbo_vorurteile.verbindung_v_v vv WHERE vv.ID_Untergeordnetes_Vorurteil = vu.ID_Vorurteile AND vv.ID_Vorurteil = vo.ID_Vorurteile AND vo.ID_Vorurteile=" + pVorurteilID + ";");
			if(lResult.first())
			{
				//for(:)
			}
			else
				System.out.println("Nein");
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return lListeVorurteile;

	}


}
