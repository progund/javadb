package org.flat.text;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SynonymsDbOracle implements SynonymsOracle {

  private DBUtil db = DBUtil.getInstance();
  
  @Override
  public List<String> getSynonyms(String word) {
    List<String> results = new ArrayList<>();
    try {
      ResultSet rs = db.query("SELECT synonym FROM has_synonyms WHERE word='" + word + "';");
      while (rs.next()) {
        results.add(rs.getString("synonym"));
      }
      System.err.println(results.size() + " synonyms found from database.");
    } catch (SQLException e) {
      e.printStackTrace(System.err);
    }
    return results;
  }  
}
