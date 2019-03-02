import java.util.Scanner;

public class TestLogin {
  
  public static void main(String[] args) {
    String username;
    String password;
    System.out.print("Username: ");
    Scanner sc = new Scanner(System.in);
    username = sc.nextLine();
    System.out.print("Password: ");
    password = sc.nextLine();

    Login login = new Login();

    try {
    
      if (login.verifyLogin(username, password)) {
        System.out.println(login.message());
        System.out.println("You are now logged in.");
      } else {
        System.out.println("Sorry, we could not verify your login.");
        System.out.println(login.message());
      }
    } catch (Exception e) {
      System.err.println("Something went wrong: " + e.getMessage());
    }
  }
}
