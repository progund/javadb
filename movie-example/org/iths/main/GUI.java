package org.iths.main;

import org.iths.db.DBStorage;
import org.iths.gui.SmallGui;

public class GUI {
  
  public static void main(String[] args) {
    
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          new SmallGui(new DBStorage()).run();
        }
      });
    
  }
  
}
