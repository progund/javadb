package org.iths.main;
import org.iths.gui.SmallGui;
import org.iths.db.DBStorage;
public class GUI{
  public static void main(String[] args){
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          new SmallGui(new DBStorage()).run();
        }
      });
  }
}
