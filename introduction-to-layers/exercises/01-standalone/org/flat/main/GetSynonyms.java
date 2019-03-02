package org.flat.main;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

/* 
   The synonyms file is created from
   Folkets synonymlexikon Synlex http://lexikon.nada.kth.se/synlex.html
   and free to use according to a comment in the xml file here:
   http://folkets-lexikon.csc.kth.se/lexikon/synpairs.xml
   "<!-- Synonymerna är helt fria. -->"
 */
public class GetSynonyms {
  
  public static void main(String[] args) {
    if (args.length != 0) {
      String word = args[0];
      List<String> synonyms = getSynonyms(word);
      System.out.println(synonyms == null ? "No synonyms found for " + word : synonyms);
    } else {
      System.err.println("Missing argument: synonym");
      System.err.println("You must provide a word to lookup, as the argument.");
      System.exit(1);
    }  
  }
  
  public static List<String>getSynonyms(String word) {
    try {
      Map<String, List<String>> map = new HashMap<>();
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
      return map.get(word);
    } catch (IOException e) {
      System.err.println("Couldn't read synonyms: " + e.getMessage());
      e.printStackTrace();
      return null;
    }
  }  
}
