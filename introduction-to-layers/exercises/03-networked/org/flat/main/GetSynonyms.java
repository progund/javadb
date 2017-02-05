package org.flat.main;
import org.flat.text.SynonymEntry;

public class GetSynonyms{
  public static void main(String[] args){
    if(args.length!=0){
      String word = args[0];
      SynonymEntry syn = new SynonymEntry(word);
      StringBuilder result = new StringBuilder("Synonyms for " + word + ":");
      for(String s : syn.synonyms()){
        result.append(" ").append(s);
      }
      if(syn.numberOfSynonyms()>0){
        result.append("\n");
        System.out.println(result);
      }else{
        System.out.println("No synonyms found for " + word);
      }
  }else{
      System.err.println("Missing argument: synonym");
      System.err.println("You must provide a word to lookup, as the argument.");
      System.exit(1);
    }  
  }
}
