package com.example.othello;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
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
import java.util.*;

public class HelloApplication extends Application {

    boolean isComputer = true;
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root,800,800);

    Box[][] boxes = new Box[8][8];

    final OthelloBoard othelloBoard = new OthelloBoard(8);
    public void eventCall(int x, int y){

        OthelloBoard.row = x;
        OthelloBoard.col = y;

        othelloBoard.getValue();
        othelloBoard.gameNotFinished();
        updateBoard();
    }

    Stage stage = null;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage  = stage;
        updateBoard();

    }

    public void fncCheckValid() {
        Set<String> sets = othelloBoard.checkValid();
        Set<Move> moves = new HashSet<>();
        for( String item : sets ) {
            if ( !item.equals("") ) {
                String[] arr = item.split(",");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                Move move = new Move(x, y);
                Box b = new Box(move, EBoard.suggestion);
                boxes[x][y] = b;
                moves.add(move);
            }
        }

        if ( isComputer == true && getTurn().equals("White")) {
            int size = moves.size();
            Random random = new Random();
            int rnd = random.nextInt(size);
            Move move = (Move) moves.toArray()[rnd];
            eventCall(move.x, move.y);
            System.out.println(move.x + ", " + move.y);
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

    public String getTurn(){
        if (Othello.whosTurn == OthelloBoard.blackPlayer){
            return "Black";
        }else {
            return "White";
        }
    }




    public void updateBoard() {
        try {
            checkBoxes();
            fncCheckValid();


            //InputStream os = new FileInputStream("/Users/cankale/Desktop/othello/src/main/resources/image/whitecircle.png" );
            InputStream os = new FileInputStream("src/main/resources/image/whitecircle.png");
            Image imgo = new Image(os);

            //InputStream xs = new FileInputStream("/Users/cankale/Desktop/othello/src/main/resources/image/black.png");
            InputStream xs = new FileInputStream("src/main/resources/image/black.png");
            Image imgx = new Image(xs);


            GridPane pane = new GridPane();
            for (int i = 0; i < boxes.length; i++) {
                for (int j = 0; j < boxes[i].length; j++) {
                    Box b = boxes[i][j];
                    final int fi = i;
                    final int fj = j;
                    //System.out.println( b.getCoordinate().x + " " + b.getCoordinate().y + " " + b.getType() );

                    int t = 90;
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



            Label labelTurn = new Label();


            labelTurn.setText("                    " + "Black: " + othelloBoard.blackScore() + "            " + getTurn() + "'s turn" +"            " + "White: " + othelloBoard.whiteScore());
            labelTurn.setStyle("-fx-font: 32 Avenure;");


            labelTurn.setTextFill(Color.WHITE);

            pane.setPrefSize(600,600);
            pane.setAlignment(Pos.BOTTOM_CENTER);


            root.setTop(labelTurn);
            root.setStyle("-fx-background-color: black;");
            root.setCenter(pane);


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