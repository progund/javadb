package org.flat.text;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class SynonymsNetworkLoader {
  
  private static final String host = "localhost";
  private static final int port = 1234;
  
  private static List<String> lookup(String word) {
    // Create an empty list to return in case
    // we get a server problem
    List<String> list = new ArrayList<>();

    try (Socket client = new Socket(host, port)) {
      PrintWriter out =
        new PrintWriter(client.getOutputStream(), true);
      out.println(word);
      String response = null;
      StringBuffer messages = new StringBuffer();
      BufferedReader in =
        new BufferedReader(new InputStreamReader
                           (client.getInputStream()));
      String input = null;
      
      while ( (input = in.readLine()) != null) {
        messages.append(input);
      }

      response = messages.toString();
      
      if (!response.startsWith("not found")) {
        String syns = response.substring(1,response.length()-1);
        list = Arrays.asList(syns.split(", "));
      }
      // Return the list, which is either still empty
      // or a list from the server response
      return list;
    } catch (IOException e) {
      System.err.println(e);
      return list; // the empty list
    }
  }

  public static List<String> getSynonyms(String word) {
    return lookup(word);
  }
  
}
