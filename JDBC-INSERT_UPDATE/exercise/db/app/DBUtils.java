package db.app;

import java.sql.*;

/**
 * Utility class for handling jdbc towards the my_municipality database.
 * <br />
 * On loading of this class, the SQLite driver is loaded.
 * <br />
 * This class is a Singleton. To get hold of the instance of this class,
 * call the static method getInstance(). The instance is guaranteed to
 * have a working Connection to the database my_municipalities.
 */
public class DBUtils {
  
  private final static String DB_CONN_STR="jdbc:sqlite:my_municipalities";
  private static Connection con;
  private static DBUtils instance = new DBUtils();

  static {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException cnfe) {
      System.err.println("Could not load driver: "+cnfe.getMessage());
    }
  }
  
  private DBUtils() {
    getConnection();
  }
  
  /**
   * Singleton method to get the instance of this class. 
   * @return The only instance of this class
   */
  public static DBUtils getInstance() {
    return instance;
  }
  
  private void getConnection() {
    try {
      con = DriverManager.getConnection(DB_CONN_STR);
    } catch (Exception e) {
      System.err.println("Error getting connection to " + 
                         DB_CONN_STR);
    }
  }
  
  /**
   * Checks that the instance has a Connection to the database.
   * @return true if the instance has a connection, false otherwise
   */
  public boolean hasConnection() {
    return con != null;
  }

  private void error(String msg) { System.err.println(msg); }

  /**
   * Executes a query (from the argument sql, which is a String) and returns a ResultSet.
   * @return A ResultSet from the query
   * @param sql The String representing the SQL query to be executed
   */
  public ResultSet executeQuery(String sql) {

    Statement stm=null;

    if (hasConnection()) {
      try {
        stm=con.createStatement();
        return stm.executeQuery(sql);
      } catch (Exception e) {
        error("executeQuery: " + e.getMessage());
        closeIt(stm);
      }
    }
    return null;
  }
  
  /**
   * Executes an SQL update statement, provided as the String argument
   * @param sql The SQL update statement as a String
   * @return An int representing how many rows were updated or -1 if the statement fails
   *
   */
  public int executeUpdate(String sql) {

    Statement stm=null;

    if (hasConnection()) {
      try {
        stm=con.createStatement();
        return stm.executeUpdate(sql);
      } catch (Exception e) {
        error("executeUpdate: " + e.getMessage());
      } finally {
        closeIt(stm);
      }
    }
    return -1;
  }
  
  /**
   * Closes an AutoCloseable, for instance a ResultSet or a Statement.
   * @param it The AutoCloseable to be closed
   */
  public void closeIt(AutoCloseable it) {     
    try {
      it.close();
    } catch (Exception e) {
      error("Exception closing: "+e.getMessage());
    }
  }
  
  /* 
  //What is this? Try to figure out!
  public PreparedStatement preparedStatement(String sql){
  try{
  return con.prepareStatement(sql);
  }catch(Exception e){
  System.err.println("DBUtils: Error getting prepared stm: " + e.getMessage());
  e.printStackTrace();
  return null;
  }
  }
  */
}
