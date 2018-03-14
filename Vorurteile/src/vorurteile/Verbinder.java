/**
 * @author Dimaa, 31. Januar 2018
 * @description Stellt eine Verbindung zur Datenbank her
 * @changelog
 * | 31. Januar 2018: Dimaa "getConnection(), getProperties()"
 * | 14. März 2018:   Dimaa "MySqlConnector -> Verbinder"
 */

package vorurteile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Verbinder
{
	private static final String cDatabaseDriver = "com.mysql.jdbc.Driver";
	
	/* || Test Database || */
	/*private static final String cDatabaseURL = "jdbc:mysql://5.189.152.131/school_vorurteile";
	private static final String cBenutzername = "school";
	private static final String cPasswort = "qDQWsEetWwTK3dpc";*/
	
	/* || School Database || */
	private static final String cDatabaseURL = "jdbc:mysql://dbserver/dbo_vorurteile";
	private static final String cBenutzername = "dbuser";
	private static final String cPasswort = "benutzer";

   private Connection connection;
   private Properties properties;
   
   public Connection getConnection() 
   {
       if (this.connection == null) 
       {
           try 
           {
               Class.forName(cDatabaseDriver).newInstance();
               this.connection = DriverManager.getConnection(cDatabaseURL, this.getProperties());
           } 
           catch (Exception e) 
           {
               e.printStackTrace();
           }
       }
      
       return connection;
   }
	
   private Properties getProperties() 
   {
      if (this.properties == null) 
      {
      	this.properties = new Properties();
      	this.properties.setProperty("user", cBenutzername);
      	this.properties.setProperty("password", cPasswort);
      	this.properties.setProperty("MaxPooledStatements", "250");
      	this.properties.setProperty("useSSL", "false");
      }
      
      return this.properties;
   }
}
