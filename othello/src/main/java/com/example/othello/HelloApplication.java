package com.example.othello;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import szte.mi.Move;
import szte.mi.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class HelloApplication extends Application {


    static Player p1,p2;
    Box[][] boxes = new Box[8][8];
    public static String selectPlayer = "";
    final OthelloBoard othelloBoard = new OthelloBoard(8);



    public void eventCall(int x, int y){

        OthelloBoard.row = x;
        OthelloBoard.col = y;

        othelloBoard.getValue();
        fncCheckValid(x,y,Othello.whosTurn);

        othelloBoard.gameNotFinished();
        updateBoard();

        if (othelloBoard.gameNotFinished()){

            updateBoard();

        }else if (!othelloBoard.gameNotFinished()){
            Othello.changePlayer();
            othelloBoard.checkValid(othelloBoard.rowEntry,othelloBoard.colEntry,Othello.whosTurn);
            System.out.println("No possible Moves. Turn skipped" );
        }
        fncCheckValid(x,y,Othello.whosTurn);

        if ( selectPlayer.equals("AI") && Othello.whosTurn == 'X' ) {
            p1 = new SmartAI();
            p1.init(0, 8000, new Random());
            last = p1.nextMove(last, 8000, 8000);
            eventCall(last.x, last.y);
        }
    }



    Move last = null;
    Stage stage = null;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage  = stage;
        updateBoard();
        p1 = new SmartAI();
        p1.init(0, 8000, new Random());
        last = p1.nextMove(last, 8000, 8000);
        if ( selectPlayer.equals("AI") ) {
            eventCall(last.x, last.y);
        }
    }


    /*
    Checks the possible moves and send the coordinates of those positions to previously declared Box 2d array.
    Which will eventually show us the boxes that are available by coloring them orange. Since the drawing of the board
    will be made by this Box 2d Array.
     */
    public void fncCheckValid(int x, int y , char color) {
        Set<String> sets = othelloBoard.checkValid(x,y,color);
        for( String item : sets ) {
            if ( !item.equals("") ) {
                String[] arr = item.split(",");
                x = Integer.parseInt(arr[0]);
                y = Integer.parseInt(arr[1]);
                Move move = new Move(x, y);
                Box b = new Box(move, EBoard.suggestion);
                boxes[x][y] = b;
            }
        }


    }

    /*
    Checks the other possible positions(White,Black,Empty) and similar to fncCheckValid method, it assigns the values to
    the Box 2d array.
     */
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

    /*
    This method is for the visuals. It gets who's turn it is and returns it as a String so that it can be
    shown as a label while playing the game.
     */
    public String getTurn(){
        if (Othello.whosTurn == OthelloBoard.blackPlayer){
            return "Black";
        }else {
            return "White";
        }
    }


    /*
    This method gets the values from the Box 2d Array and draws it. It also gets the mouse event value
    and checks it. If the clicked box is a valid position the board is updated. This method also has all of the
    size values of the declared scene, GridPane, Hbox, Vbox, Labels etc. At the end of the game an another
    stage is shown and the game stage is hidden. This second stage shows the player who the winner of the game is.

     */
    public void updateBoard() {
        System.out.println( HelloApplication.selectPlayer );
        try {
            checkBoxes();
            fncCheckValid(othelloBoard.rowEntry, othelloBoard.colEntry,Othello.whosTurn);



            InputStream os = new FileInputStream("src/main/resources/whitecircle.png" );
            Image imgo = new Image(os);

            InputStream xs = new FileInputStream("src/main/resources/black.png");
            Image imgx = new Image(xs);



            GridPane pane = new GridPane();
            for (int i = 0; i < boxes.length; i++) {
                for (int j = 0; j < boxes[i].length; j++) {
                    Box b = boxes[i][j];
                    final int fi = i;
                    final int fj = j;
                    // System.out.println( b.getCoordinate().x + " " + b.getCoordinate().y + " " + b.getType() );

                    int t = 75;
                    Rectangle r = new Rectangle(t,t,t,t);
                    r.setFill(Color.rgb(56, 154, 34));
                    r.setStroke(Color.BLACK);

                    r.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            eventCall(fi , fj);
                        }
                    });


                    if (b.getType() == EBoard.black) {
                        r.setFill(new ImagePattern(imgx));
                    }

                    if (b.getType() == EBoard.white) {
                        r.setFill(new ImagePattern(imgo));

                    }

                    if (b.getType() == EBoard.suggestion) {
                        r.setFill(Color.rgb(253 ,185 ,18));
                        r.setStroke(Color.BLACK);
                    }

                    pane.add(r, j, i);

                }
            }

            BorderPane root = new BorderPane();

            Label labelTurn = new Label();

            if (othelloBoard.gameNotFinished())
            {
                labelTurn.setText("                " + "Black: " + othelloBoard.blackScore() + "            " + getTurn() + "'s turn" +"            " + "White: " + othelloBoard.whiteScore());
            } else if (!othelloBoard.gameNotFinished() && !othelloBoard.getWinner().equals(" ")) {
                labelTurn.setText("                   " + "Black: " + othelloBoard.blackScore() + "            " + othelloBoard.getWinner() + " Wins" +"            " + "White: " + othelloBoard.whiteScore());

            }else if (!othelloBoard.gameNotFinished() && othelloBoard.getWinner().equals(" ")){
                labelTurn.setText("                   " + "Black: " + othelloBoard.blackScore() + "              " + "It's a Tie!" +"              " + "White: " + othelloBoard.whiteScore());

            }



            HBox hBox = new HBox();

            hBox.getChildren().add(labelTurn);

            labelTurn.setAlignment(Pos.TOP_CENTER);

            root.setTop(hBox);
            labelTurn.setStyle("-fx-font: 32 Avenure;");
            labelTurn.setTextFill(Color.WHITE);





            pane.setPrefSize(600,600);
            pane.setAlignment(Pos.BOTTOM_CENTER);




            root.setStyle("-fx-background-color: black;");
            root.setCenter(pane);
            pane.setAlignment(Pos.CENTER);


            Scene scene = new Scene(root,750,750);

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
