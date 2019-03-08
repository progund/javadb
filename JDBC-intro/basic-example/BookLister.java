import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookLister {

  private static Connection con;

  static {
    try {
      con = DriverManager.getConnection("jdbc:sqlite:books.db");
    } catch (Exception e) {
      System.err.println("Error getting connection: " + e.getMessage());
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    try {
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM books");

      // Let's store the books in a list
      List<Book> bookShelf = new ArrayList<>();
      
      // We don't know how many rows we get, but we do
      // know that we have to move the cursor to each
      // available row:
      while (rs.next()) { // while rs.next() returns true, there's one more row

        // A book is created with a string title and an int pages:
        Book book = new Book(rs.getString("title"), rs.getInt("pages"));
        bookShelf.add(book);
      }

      System.out.println("The whole book shelf: ");
      System.out.println(bookShelf);
      System.out.println("==========");
      // Books printed on separate lines:
      for (Book aBook : bookShelf) {
        System.out.println(aBook);
      }
    } catch (SQLException e) {
      System.err.println("Database exception: " + e.getMessage());
    }
  }
}
