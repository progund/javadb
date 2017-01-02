package org.muni.main;
import java.sql.*;
import org.muni.util.DatabaseUtil;

public class TestDatabase{
  public static void main(String[] args){
    DatabaseUtil database = new DatabaseUtil();
    if(! database.hasConnection()){
      System.err.println("No connection.");
      System.exit(1);
    }
    PreparedStatement ps = null;
    ResultSet rs = null;
    try{
      database.setAutoCommit(false);    
      String sql = "UPDATE municipalities SET Server=? WHERE Server LIKE ?";
      ps = database.getPS(sql);
      ps.setString(1, "Mickey Mouse");
      ps.setString(2, "microsoft%");
      ps.executeUpdate();
      try{
        ps.close();
      }catch(SQLException sqle){}
      sql = "SELECT COUNT(*) FROM municipalities WHERE Server LIKE ?";
      ps = database.getPS(sql);
      ps.setString(1, "microsoft%");
      ps.execute();
      rs = ps.getResultSet();
      if(rs.next()){
        System.out.println("Number of servers like microsoft: " + rs.getInt(1));
      }
      database.rollback();
      ps.execute();
      rs = ps.getResultSet();
      if(rs.next()){
        System.out.println("Number of servers like microsoft: " + rs.getInt(1));
      }      
    }catch(SQLException e){
      System.err.println("Database exception: " + e.getMessage());
    }finally{
      try{
        ps.close();
        rs.close();
      }catch(SQLException sqle){}
    }
  }
}
