package db.main;
import db.app.MunicipalityDB;
import db.app.MyMunicipalities;
import db.app.Municipality;
public class Main{
  public static void main(String[] args){
    MunicipalityDB db = new MyMunicipalities();
    Municipality m 
      = new Municipality("Teststad",
                         "http://teststad.se",
                         "Apache Superserver",
                         false);

    /*
      if(args.length==1){
      m = db.getByName(args[0]);
      System.out.println("Looking up "+args[0]+" got:\n"+m);
      System.out.println("=========================");
      System.out.println("Setting "+args[0]+" to HTTPS true");
      int rows = db.updateHTTPSbyName(args[0], true);
      System.out.println(rows + " rows were updated (should be one)");
      m = db.getByName(args[0]);
      System.out.println("Looking up "+args[0]+" again, got:\n"+m);
      System.out.println("=========================");
      }else{
      //System.out.println(db.getAllCities());
      System.out.println("=========================");
      System.out.println("Adding city: " + m);
      db.addCity(m);
      System.out.println("What ID did the city get? " + m.id());
      //System.out.println(db.getAllCities());
      System.out.println("=========================");
      System.out.println("Deleting city: " + m);
      db.deleteCity(m);
      System.out.println("Trying to get: " + m + "\n" +db.getByName(m.name()));
      System.out.println("=========================");
      System.out.println("Get Stockholm stad (by name)");
      m = db.getByName("Stockholms stad");
      System.out.println(m);
      System.out.println("=========================");
      }
    */
    //String name="'; drop table municipalities;--";
    String name="' or 1=1;--";
    //System.out.println(db.updateHTTPSbyNameSafe(name, false));
    System.out.println(db.updateHTTPSbyName(name, false));
  }
}
