package org.flat.text;

import java.util.ArrayList;
import java.util.List;

public class SynonymEntry {
  
  private String word;
  private List<String> synonyms;
  private SynonymsOracle oracle;

  public SynonymEntry(String word) {
    this.word = word;
    oracle = SynonymsOracleFactory.getSynonymsOracle();
  }

  public String word() {
    return word;
  }
  
  /* Note - this returns null if no synonyms have been requested */
  public int numberOfSynonyms() {
    return synonyms.size();
  }
  
  /* This method gets the list of synonyms */
  public List<String> synonyms() {
    // First time, get synonyms and cache them
    if(synonyms == null) {
      synonyms = oracle.getSynonyms(word);
    }
    // Synonyms.getSynonyms is guaranteed not to return null
    return synonyms;
  }
}
