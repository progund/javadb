package db.app;

import java.sql.*;

public class DatabaseTest {
  
  private final static String DB_CONN_STR="jdbc:sqlite:my_municipalities";
  private static Connection con;

  static {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException cnfe) {
      System.err.println("Could not load driver: "+cnfe.getMessage());
    }
  }
  
  public DatabaseTest() {
    getConnection();
  }
  
  private void getConnection() {
    
    try {
      con = DriverManager.getConnection(DB_CONN_STR);
    } catch (Exception e) {
      System.err.println("Error getting connection to " + 
                         DB_CONN_STR);
    }
  }
  
  public boolean hasConnection() {
    return con != null;
  }
  
  public void testQuery() {
    
    if (hasConnection()) {

      Statement stm = null;
      ResultSet rs  = null;

      try {
        String query = "SELECT Name, HTTPS FROM municipalities LIMIT 5";
        stm = con.createStatement();
        rs = stm.executeQuery(query);
        
        while (rs.next()) {
          System.out.println(rs.getString("Name") +
                             " " +
                             ( rs.getBoolean("HTTPS") ?
                               "HTTPS support" :
                               "HTTP only" )
                             );
        }
        
      } catch (SQLException sqle) {
        System.err.println(sqle.getMessage());
      } finally {
        closeBoth(rs, stm);
      }
    }
  }
  
  private void closeIt(AutoCloseable it) {
    
    try {
      it.close();
    } catch (Exception e) {
      System.err.println("Exception closing: " + e.getMessage());
    }
    
  }
  
  private void closeBoth(AutoCloseable a1, AutoCloseable a2) {

    try {
      closeIt(a1);          
      closeIt(a2);
    } catch (Exception e) {
      System.err.println("Exception closing: " + e.getMessage());
    }
    
  }
  
}
