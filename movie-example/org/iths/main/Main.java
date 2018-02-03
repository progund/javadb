package org.iths.main;

import org.iths.db.DBStorage;

public class Main {
  
  public static void main(String[] args) {

    Storage storage = new DBStorage();    

    while (true) {
      
      String choice = "";
      System.out.println("1. List all movies");
      System.out.println("2. List all actors");
      System.out.println("3. Look up an actor");
      System.out.println("4. Look up a movie");
      System.out.println("5. Quit");

      while(!(choice.equals("1") ||
              choice.equals("2") ||
              choice.equals("3") ||
              choice.equals("4") ||
              choice.equals("5"))) {
        choice = TextUtil.getReply("Your choice: ");
      }
      
      switch (choice) {
      case "1":
        System.out.println(storage.getAllMovies());
        break;
      case "2":
        System.out.println(storage.getAllActors());
        break;
      case "3":
        String actor = TextUtil.getReply("Actor: ");
        System.out.println("Movies for " + actor + ": ");
        System.out.println(storage.getMoviesByActorName(actor));
        break;
      case "4":
      String movie = TextUtil.getReply("Movie title: ");
      System.out.println("The actors in " + movie + " are:");
      System.out.println(storage.getActorsByMovieTitle(movie));
        break;
      case "5":
        System.out.println(" Bye ");
        return;
      }
      
    }
    
  }
  
}
