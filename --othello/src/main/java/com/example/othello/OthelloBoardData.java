package com.example.othello;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import szte.mi.Move;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class OthelloBoardData {

    Random random = null;
    boolean isComputer = true;
    Box[][] boxes = new Box[8][8];
    final OthelloBoard othelloBoard = new OthelloBoard(8);

    public void eventCall(int x, int y){
        OthelloBoard.row = x;
        OthelloBoard.col = y;
        othelloBoard.getValue();
        othelloBoard.gameNotFinished();
        othelloBoard.checkValid();
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
            checkBoxes();
            fncCheckValid();
    }

    public OthelloBoardData() {
        updateBoard();
    }

}
