package org.flat.text;

import java.util.List;

public interface SynonymsOracle {
  
  public List<String> getSynonyms(String word);

}
