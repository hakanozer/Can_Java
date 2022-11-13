package com.example.othello;

public class Othello {
    public static final int dimension=8;

    public static char whosTurn = OthelloBoard.blackPlayer;

    public static void changePlayer(){
        if (whosTurn == OthelloBoard.blackPlayer){
            whosTurn = OthelloBoard.whitePlayer;
        }else
            whosTurn = OthelloBoard.blackPlayer;
    }

    public static void main(String[] args) {
        OthelloBoard othelloBoard = new OthelloBoard(Othello.dimension);

        while (othelloBoard.gameNotFinished()) {
            System.out.println(othelloBoard.writeBoard());
            System.out.println(othelloBoard.getValue());

        }
        System.out.println(othelloBoard.getValue());

    }


}