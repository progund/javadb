import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class BookApplication {
  
  static Connection con;
  static {
    try {
      con = DriverManager.getConnection("jdbc:sqlite:books.db");
    } catch (SQLException e) {
      System.err.println("Something went wrong, when creating con:" + e.getMessage());
      System.exit(1);
    }
  }

  static int getPagesByTitle(String title) throws SQLException {
    String SQL = "SELECT pages FROM books WHERE title = '" + title + "';"  ;
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(SQL);
    if (rs.next() ) {
      return rs.getInt("pages");
    }
    return 0;
  }
  
  public static void main(String[] args) {
    try {
      String title1 = "Java for students";
      String title2 = "Java for professors";
      String title3 = "Birds - the coolest animals";
      int javaPages = getPagesByTitle(title1);
      int profPages =getPagesByTitle(title2);
      if (javaPages != 0 && profPages !=0) {
        if (javaPages > profPages) {
          System.out.println(title1 + " has more pages");
        } else if (profPages > javaPages) {
          System.out.println(title2 + " has more pages");
        } else {
          System.out.println("The books have equal amount of pages.");
        }
      } else {
        System.out.println("Either " + title1 + " or " + title2 + " was not found.");
      }
      System.out.println(title3 + " has " + getPagesByTitle(title3) + " pages.");
    } catch (SQLException e) {
      System.err.println("Error counting books: " + e.getMessage());
    } finally {
      try {
        con.close();
      } catch (Exception e) {
        ;
      }
    }
  }
}
