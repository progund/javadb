import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class BookApplication {

  private static Connection con;

  static {
    try {
      con = DriverManager.getConnection("jdbc:sqlite:books.db");
    } catch (Exception e) {
      System.err.println("Error getting connection: " + e.getMessage());
      System.exit(1);
    }
  }
  
  // args - not used
  // Compile and run:
  // javac BookApplication.java
  // on Mac OS or GNU/Linux:
  // java -cp ".:sqlite.jar" BookApplicaion
  // on Windows/Cygwin:
  // java -cp ".;sqlite.jar" BookApplication
  public static void main(String[] args) {
    try { // we can get SQLException when dealing with JDBC...
      
      // How many pages does the book "Java for students" have?
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("SELECT pages FROM books WHERE title='Java for students'");
      rs.next(); // Move cursor to the first row in the result (even if there's only one row)
      // to get a value from the result set into Java, we can choose
      // the type we want it as. The getInt() method gives us an int!
      int javaPages = rs.getInt("pages");
      System.out.println("The Java book has " + javaPages + " pages.");

      rs = st.executeQuery("SELECT pages FROM books WHERE title='SQL for beginners'");
      rs.next();
      int sqlPages = rs.getInt("pages");
      System.out.println("The SQL book has " + sqlPages + " pages.");

      // Good that we have the pages as int-variables!
      // now we can do this:
      if (javaPages > sqlPages) {
        System.out.println("The Java book has more pages.");
      } else if (sqlPages > javaPages) {
        System.out.println("The SQL book has more pages.");
      } else {
        System.out.println("Both books have the same number of pages.");
      }
    } catch (SQLException e) {
      System.err.println("Database exception: " + e.getMessage());
    }
  }
}
