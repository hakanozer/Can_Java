package appPack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

   private String driver = "com.mysql.cj.jdbc.Driver";
   private String url = "jdbc:mysql://localhost/can_db";
   private String userName = "root";
   private String password = "";

   public Connection conn = null;

   public void connection() {
       try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println( "Connection Success" );
       }catch (Exception ex) {
           System.err.println("Connection Error :" + ex);
       }
   }

   public DB() {
       connection();
   }


   // close db
    public void close() {
       try {
        if ( conn != null && !conn.isClosed() ) {
            conn.close();
            conn = null;
            System.out.println("Close Success");
        }
       }catch (Exception ex) {
           System.err.println("Close Error :" + ex );
       }
    }




}
