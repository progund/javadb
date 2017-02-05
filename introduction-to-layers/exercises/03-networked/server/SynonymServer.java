package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

public class SynonymServer {
  public static void main(String[] args) throws Exception{
    int port = 1234;
    Map<String,List<String>>map = getSynonyms(args[0]);
    System.out.println(map.keySet().size() + " words loaded.");
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Listening on " + serverSocket);
      /*
      System.out.println("Listening on " +
                         InetAddress.getLocalHost().getHostAddress() +
                         " " + serverSocket.getLocalPort());
      */
      while (true) {
        Socket client = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String word=in.readLine();
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        System.out.println("client said: "+word);
        List<String> response = map.get(word);
        String resp=response==null?"not found":response.toString();
        System.out.println("word synonyms: " + resp);
        out.println(resp);
        out.close();
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  private static Map<String, List<String>>getSynonyms(String file){
    Map<String, List<String>> map;
    try{
      map=new HashMap<>();
      //Map<String, List<String>>map=new HashMap<>();
      List<String>lines=Files.lines(Paths.get(file)).collect(Collectors.toList());
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
      return map;
    }catch(IOException e){
      System.err.println("Couldn't read synonyms: " + e.getMessage());
      e.printStackTrace();
      return null;
    }
  }
}

