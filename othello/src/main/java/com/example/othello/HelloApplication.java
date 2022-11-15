package com.example.othello;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import szte.mi.Move;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class HelloApplication extends Application {



    Box[][] boxes = new Box[8][8];

    final OthelloBoard othelloBoard = new OthelloBoard(8);
    public void eventCall(int x, int y){

        OthelloBoard.row = x;
        OthelloBoard.col = y;

        othelloBoard.getValue();
        othelloBoard.gameNotFinished();
        tableGenerator();
    }

    Stage stage = null;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage  = stage;
        tableGenerator();
        /*
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


       try{
           String path = new File("/Users/cankale/Desktop/othello/src/main/resources/gameSong.mp3").toURI().toString();
           MediaPlayer mediaPlayer = new MediaPlayer(new Media(path));
           mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
           mediaPlayer.play();

       }catch (Exception e){
           System.err.println("Error: " + e);
       }

        Scene scene = new Scene(pane);
        stage.setTitle("Othello");
        stage.getIcons().add(new Image("othelloLogo.jpeg"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
         */
    }

    public void fncCheckValid() {
        Set<String> sets = othelloBoard.checkValid();
        for( String item : sets ) {
            if ( !item.equals("") ) {
                String[] arr = item.split(",");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                Move move = new Move(x, y);
                Box b = new Box(move, EBoard.suggestion);
                boxes[x][y] = b;
            }
        }
    }

    public void checkBoxes() {
        int dimension = 8;
        for (int i = 0; i < dimension ; i++) {
            for (int j = 0; j < dimension; j++) {

                if (othelloBoard.board[i][j] == OthelloBoard.EMPTY){
                    Move move = new Move(i, j);
                    Box bEmpty = new Box(move, EBoard.empty);
                    boxes[i][j] = bEmpty;

                }if (othelloBoard.board[i][j] == OthelloBoard.whitePlayer){
                    Move move = new Move(i, j);
                    Box bWhite = new Box(move, EBoard.white);
                    boxes[i][j] = bWhite;

                }if (othelloBoard.board[i][j] == OthelloBoard.blackPlayer){
                    Move move = new Move(i, j);
                    Box bBlack = new Box(move, EBoard.black);
                    boxes[i][j] = bBlack;
                }

            }

        }
    }


    public void tableGenerator() {
        try {
        checkBoxes();
        fncCheckValid();

        InputStream os = new FileInputStream( "/Users/hakan/Documents/Can_Java/othello/src/main/resources/image/o.png" );
        Image imgx = new Image(os);

        InputStream xs = new FileInputStream( "/Users/hakan/Documents/Can_Java/othello/src/main/resources/image/x.png");
        Image imgo = new Image(xs);


        GridPane pane = new GridPane();
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                Box b = boxes[i][j];
                final int fi = i;
                final int fj = j;
                System.out.println( b.getCoordinate().x + " " + b.getCoordinate().y + " " + b.getType() );
                int t = 100;
                Rectangle r = new Rectangle(t,t,t,t);
                r.setFill(Color.GREEN);
                r.setStroke(Color.BLACK);

                r.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        eventCall(fi , fj);
                    }
                });

                if (b.getType() == EBoard.black) {
                    r.setFill(new ImagePattern(imgx));
                    //r.setFill(Color.BLACK);
                }
                if (b.getType() == EBoard.white) {
                    r.setFill(new ImagePattern(imgo));
                    //r.setFill(Color.WHITE);
                }
                if (b.getType() == EBoard.suggestion) {
                    r.setFill(Color.YELLOW);
                }

                pane.add(r, j, i);
            }
        }
        Scene scene = new Scene(pane);
        stage.setTitle("Othello");
        stage.getIcons().add(new Image("othelloLogo.jpeg"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        }catch (Exception ex) {
            System.err.println("Error : " + ex);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}