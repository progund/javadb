package org.flat.text;

import java.util.ArrayList;
import java.util.List;

public class Synonyms {

  private static SynonymsLoader synLoader = new SynonymsLoader();

  /* Returns a list of synonyms or an empty list
   * if no synonyms could be found.
   */
  static List<String>getSynonyms(String word) {

    List<String> result = null;

    if (synLoader.hasLoadedSynonyms()) {
      result = synLoader.dictionary().get(word);
    } else {
      throw new RuntimeException("Couldn't load synonyms from source");
    }
    
    if (result != null) {
      return result;
    }
    return new ArrayList<String>();
  }
}
