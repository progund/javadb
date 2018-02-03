package org.iths.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import org.iths.domain.Actor;
import org.iths.domain.Movie;
import org.iths.main.Storage;

public class SmallGui {
  
  private JFrame mainFrame;
  private JTextField searchField;
  private JButton searchButton;
  private JTextArea results;
  private JLabel searchLabel;
  private JPanel top;
  private Storage storage;

  public SmallGui(Storage storage) {
    this.storage = storage;
  }
  
  private void initComponents() {
    
    mainFrame = new JFrame("Movie example");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    searchField = new JTextField(20);
    searchLabel = new JLabel("Search for movie or actor");
    searchButton = new JButton("Search");
    results = new JTextArea(10,50);
    top = new JPanel();
    
  }
  
  private void layoutComponents() {
    
    top.add(searchLabel);
    top.add(searchField);
    top.add(searchButton);
    mainFrame.add(top, BorderLayout.NORTH);
    mainFrame.add(results, BorderLayout.CENTER);

  }
  
  private void populateResults(List<String> list) {

    results.setText("");

    for(String s : list) {
      results.append(s);
      results.append("\n");
    }
    
  }
  
  private void addListeners() {
    
    ActionListener searchListener = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          
          List<Actor>actors=storage.getActorsByMovieTitle(searchField.getText());
          List<Movie>movies=storage.getMoviesByActorName(searchField.getText());
          List<String>results=new ArrayList<>();

          for (Actor a : actors) {
            results.add("Actor: " + a.toString());
          }
          
          for (Movie m : movies) {
            results.add("Played in: " + m.toString());
          }
          
          if (results.size() == 0) {
            results.add("No results for");
            results.add(searchField.getText());
          }
          
          populateResults(results);
          searchField.selectAll();
          searchField.requestFocusInWindow();

        }
      };
    
    searchField.addActionListener(searchListener);
    searchButton.addActionListener(searchListener);
    
  }
  
  /* Run this method from main() when you want
   * to setup and show this window.
   */
  public void run() {
    
    initComponents();
    layoutComponents();
    addListeners();
    mainFrame.pack();
    mainFrame.setVisible(true);

  }
  
  static {
    try {
      // Ignore this - it's a fix for Rikard's computer. Hell Dell!
      UIManager.setLookAndFeel((LookAndFeel)Class.forName("com.sun.java.swing.plaf.gtk.GTKLookAndFeel").newInstance());
    } catch (Exception dontcare) {}
  }
  
}
