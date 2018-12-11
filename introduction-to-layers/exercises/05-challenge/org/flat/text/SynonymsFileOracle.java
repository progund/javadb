package org.flat.text;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class SynonymsFileOracle implements SynonymsOracle {
  
  private Map<String, List<String>> map;

  private void load() {

    try {
      map = new HashMap<>();
      List<String> lines = Files
        .lines(Paths.get("files/synonyms.csv"))
        .collect(Collectors.toList());

      for (String line : lines) {
        String first  = line.split(";")[0];
        String second = line.split(";")[1];
        /* If the key is a new key, put it in the dictionary
         * and use a new list with only the value.
         */
        if (!map.containsKey(first)) {
          List<String> list = new ArrayList<>();
          list.add(second);
          map.put(first, list);
          /* If the key already exists, add 
           * the value to its list.
           */
        } else {
          map.get(first).add(second);
        }
      }
      
    } catch (IOException e) {
      System.err.println("Couldn't read synonyms: " + e.getMessage());
      e.printStackTrace();
    }
  }
  
  public SynonymsFileOracle() {
    load();
  }
  
  @Override
  public List<String> getSynonyms(String word) {
    List<String> results = map.get(word);

    if (results != null) {
      return results;
    } else {
      return new ArrayList<String>();
    }
  }
}
