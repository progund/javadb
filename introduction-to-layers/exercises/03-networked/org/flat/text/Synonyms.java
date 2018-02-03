package org.flat.text;

import java.util.ArrayList;
import java.util.List;

public class Synonyms {

  /* We changed from the SynonymsLoader which used a file,
   * to a SynonymsNetworkLoader.
   *
   * Next, we'll look at how to make this class
   * ignorant of what kind of synonyms object it is using.
   */
  
  //private static SynonymsLoader synLoader = new SynonymsLoader();
  private static SynonymsNetworkLoader synLoader = new SynonymsNetworkLoader();

  /* Returns a list of synonyms or an empty list
   * if no synonyms could be found.
   */
  static List<String> getSynonyms(String word) {
    return synLoader.getSynonyms(word);
    /*
    List<String> result = null;
    if(synLoader.hasLoadedSynonyms()){
      result = synLoader.dictionary().get(word);
    }else{
      throw new RuntimeException("Couldn't load synonyms from source");
    }
    if(result!=null){
      return result;
    }
    return new ArrayList<String>();
    */
  }
}
