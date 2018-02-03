package org.muni.util;

import java.sql.*;

public class DatabaseUtil {

  private Connection con;
  private static final String URL = "jdbc:sqlite:my_municipalities";

  static {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException cnfe) {
      System.err.println("Critical: couldn't load driver: " + cnfe.getMessage());
    }
  }
  
  public boolean hasConnection() {
    return con!=null;
  }
  
  public PreparedStatement getPS(String sql) {
    
    try {
      return con.prepareStatement(sql);
    } catch (SQLException e) {
      System.err.println("Critical: couldn't create prepared statement: " +
                         e.getMessage());
    }
    return null;
  }
  
  public DatabaseUtil() {

    try {
      con = DriverManager.getConnection(URL);
    } catch (SQLException e) {
      System.err.println("Critcal: Couldn't get connection: " + e);
    }
    
  }

  public void setAutoCommit(boolean b) {

    try {
      
      if (con != null) {
        con.setAutoCommit(b);
      } else {
        System.err.println("Critical: no connection.");
      }
      
    } catch (SQLException e) {
      System.err.println("Critical: couldn't commit: " + e.getMessage());
    }
  }
  
  public void commit() {

    try {
      
      if (! con.getAutoCommit()) {
        con.commit();
      }

    } catch (SQLException e) {
      System.err.println("Critical: couldn't commit: " + e.getMessage());
    }
      
  }

  public void rollback() {

    try {

      if (! con.getAutoCommit()) {
        con.rollback();
      } else {
        System.err.println("Autocommit is on, can't rollback");
      }
      
    } catch (SQLException e) {
      System.err.println("Critical: couldn't rollback: " +
                         e.getMessage());
    }
    
  }
  
}
