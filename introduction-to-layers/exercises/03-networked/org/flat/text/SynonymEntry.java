package org.flat.text;
import java.util.List;
import java.util.ArrayList;

public class SynonymEntry{
  private String word;
  private List<String>synonyms;
  
  public SynonymEntry(String word){
    this.word = word;
  }

  public String word(){
    return word;
  }
  public int numberOfSynonyms(){
    return synonyms.size();
  }
  public List<String>synonyms(){
    // First time, get synonyms and cache them
    if(synonyms==null){
      synonyms = Synonyms.getSynonyms(word);
    }
    // Synonyms.getSynonyms is guaranteed not to return null
    return synonyms;
  }
}
