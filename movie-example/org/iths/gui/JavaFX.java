package org.iths.gui;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import org.iths.db.*;
import org.iths.domain.*;
import org.iths.main.Storage;

public class JavaFX extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    Storage storage = new DBStorage();
    primaryStage.setTitle("Movie example");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.TOP_LEFT);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Text scenetitle = new Text("Movie search");
    //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
    scenetitle.setId("welcome-text");
    //   pos 0,0 colspan 2, rowspan 1 
    grid.add(scenetitle, 0, 0, 2, 1);

    Label searchLabel = new Label("Search actor or movie:");
    searchLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
    TextField searchTextField = new TextField();
    
    grid.add(searchLabel, 0, 1);
    grid.add(searchTextField, 1, 1);

    Button btn = new Button("Search");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(btn);
    grid.add(hbBtn, 1, 2);
    final TextArea results = new TextArea();
    grid.add(results,0,3,2,8);
    
    EventHandler<ActionEvent> handler =  new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
          results.clear();
          List<Actor>actors=storage.getActorsByMovieTitle(searchTextField.getText());
          List<Movie>movies=storage.getMoviesByActorName(searchTextField.getText());

          for (Actor a : actors) {
            results.appendText("Actor: " + a.toString() + "\n");
          }
          
          for (Movie m : movies) {
            results.appendText("Played in: " + m.toString() + "\n");
          }
          
          if (actors.size() == 0 &&
              movies.size() == 0 &&
              !results.getText().startsWith("No results")) {

            results.appendText("No results for ");
            results.appendText(searchTextField.getText());

          }
          
          searchTextField.selectAll();
          searchTextField.requestFocus();

        }
      };
    
    btn.setOnAction(handler);
    searchTextField.setOnAction(handler);
    Scene scene = new Scene(grid, 600, 475);
    scene.getStylesheets()
      .add(org.iths.gui.JavaFX.class.getResource("style.css")
           .toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }
  
}
