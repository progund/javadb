package org.flat.text;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

public class SynonymsLoader{
  private Map<String, List<String>> map;
  private void load(){
    try{
      map=new HashMap<>();
      //Map<String, List<String>>map=new HashMap<>();
      List<String>lines=Files.lines(Paths.get("files/synonyms.csv")).collect(Collectors.toList());
      for(String line : lines){
        String first  = line.split(";")[0];
        String second = line.split(";")[1];
        /* If the key is a new key, put it in the dictionary
         * and use a new list with only the value.
         */
        if(!map.containsKey(first)){
          List<String> list=new ArrayList<>();
          list.add(second);
          map.put(first, list);
          /* If the key already exists, add 
           * the value to its list.
           */
        }else{
          map.get(first).add(second);
        }
      }
    }catch(IOException e){
      System.err.println("Couldn't read synonyms: " + e.getMessage());
      e.printStackTrace();
    }
  }
  public SynonymsLoader(){
    load();
  }
  public boolean hasLoadedSynonyms(){
    return map.size()!=0;
  }
  
  /* Returns a list of word - synonyms pairs. 
   */
  public Map<String, List<String>>dictionary(){
    return map;
  }
}
