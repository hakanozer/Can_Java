package com.example.othello;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {

    Stage stage = null;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage  = stage;
        GridPane pane = new GridPane();

        BorderPane root = new BorderPane();
        Label lbl = new Label();
        lbl.setText("Select Player");
        lbl.setStyle("-fx-font: 22 Avenure;");
        lbl.setTextFill(Color.BLACK);
        lbl.setAlignment(Pos.TOP_CENTER);

        pane.setPrefSize(200,200);
        pane.setAlignment(Pos.CENTER);
        pane.add(lbl, 50,30);

        String arrPlayer[] = { "Human", "AI" };

        // Create a combo box
        ComboBox playerCombobox = new ComboBox(FXCollections.observableArrayList(arrPlayer));
        // Create action event
        EventHandler<ActionEvent> eventSelect =
        new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                HelloApplication.selectPlayer = playerCombobox.getValue().toString();
                HelloApplication helloApplication = new HelloApplication();
                try {
                    helloApplication.start(stage);
                    helloApplication.stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        };

        playerCombobox.setOnAction(eventSelect);
        pane.add(playerCombobox, 50, 50);

        root.setCenter(pane);

        Scene scene = new Scene(root,300,200);
        stage.setTitle("Select Player");
        stage.getIcons().add(new Image("othelloLogo.jpeg"));
        stage.setScene(scene);

        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
