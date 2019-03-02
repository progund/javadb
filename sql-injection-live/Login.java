import java.sql.*;

public class Login {

  private static Connection con;
  private String welcomeMsg = "Wrong username or password";
  
  private final static String URL="jdbc:sqlite:login.db";
  
  static {
    try {
      con = DriverManager.getConnection(URL);
    } catch (SQLException e) {
      System.err.println("Error getting connection to " + URL);
      e.printStackTrace();
    }
  }

  public String message() {
    return welcomeMsg;
  }
  
  public boolean verifyLogin(String username, String password)
    throws SQLException {

    if (con == null) {
      System.err.println("No connection to db.");
      return false;
    }
    
    String SQL =
      "SELECT real_name FROM user NATURAL JOIN login " +
      " WHERE username = '" + username + "'" +
      "   AND password = '" + password + "'";

    Statement stm = con.createStatement();
    ResultSet rs = stm.executeQuery(SQL);
    try {
      if (rs.next()) {
        welcomeMsg = "Welcome " + rs.getString("real_name");
        return true;
      }
      return false;
    } finally {
      con.close();
    }
  }
}
