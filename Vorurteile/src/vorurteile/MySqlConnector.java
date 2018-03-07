package vorurteile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySqlConnector
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
       if (connection == null) 
       {
           try 
           {
               Class.forName(cDatabaseDriver).newInstance();
               connection = DriverManager.getConnection(cDatabaseURL, this.getProperties());
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
      if (properties == null) 
      {
          properties = new Properties();
          properties.setProperty("user", cBenutzername);
          properties.setProperty("password", cPasswort);
          properties.setProperty("MaxPooledStatements", "250");
          properties.setProperty("useSSL", "false");
      }
      
      return properties;
   }
}
