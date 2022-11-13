package com.example.othello;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import szte.mi.Move;

import java.io.IOException;
import java.util.Set;

public class HelloApplication extends Application {

    Box[][] boxes = new Box[8][8];

    final OthelloBoard othelloBoard = new OthelloBoard(8);
    public void eventCall(int x, int y){

        OthelloBoard.row = x;
        OthelloBoard.col = y;

        othelloBoard.getValue();
        othelloBoard.gameNotFinished();
        System.out.println( othelloBoard.writeBoard());
        fncCheckValid();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        GridPane pane = new GridPane();

        int count = 0;
        double s = 100;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                final int ii = i;
                final int jj = j;
                Rectangle r = new Rectangle(s, s, s, s);

                    r.setFill(Color.GREEN);
                    r.setStroke(Color.BLACK);

                pane.add(r, j, i);

                r.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        eventCall(ii , jj);
                    }
                });

                count++;

            }
        }
        double t = 100;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rectangle1 = new Rectangle(t,t,t,t);
                Rectangle rectangle2 = new Rectangle(t,t,t,t);
                Rectangle rectangle3 = new Rectangle(t,t,t,t);
                Rectangle rectangle4 = new Rectangle(t,t,t,t);


                rectangle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        eventCall(3 , 4);
                    }
                });
                rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        eventCall(4 , 3);
                    }
                });
                rectangle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        eventCall(3 , 3);
                    }
                });
                rectangle4.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        eventCall(4 , 4);
                    }
                });
                pane.add(rectangle1,4,3);
                pane.add(rectangle2,3,4);
                pane.add(rectangle3,3,3);
                pane.add(rectangle4,4,4);


                rectangle3.setFill(Color.WHITE);
                rectangle4.setFill(Color.WHITE);


            }

        }


      /* try{
           String path = new File("/Users/cankale/Desktop/othello/src/main/resources/gameSong.mp3").toURI().toString();
           MediaPlayer mediaPlayer = new MediaPlayer(new Media(path));
           mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
           mediaPlayer.play();

       }catch (Exception e){
           System.err.println("Error: " + e);
       } */


        fncCheckValid();

        Scene scene = new Scene(pane);
        stage.setTitle("Othello");
        stage.getIcons().add(new Image("othelloLogo.jpeg"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void fncCheckValid() {
        Set<String> sets = othelloBoard.checkValid();
        for( String item : sets ) {
            if ( !item.equals("") ) {
                String[] arr = item.split(",");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                System.out.println("x: " + x + " y:" + y );

                Move move = new Move(x, y);
                Box b = new Box(move, EBoard.suggestion);
                boxes[x][y] = b;
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}