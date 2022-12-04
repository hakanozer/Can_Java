package com.example.othello;

import szte.mi.Move;
import szte.mi.Player;


import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class HumanPlayer implements Player {

    static OthelloBoard board;
    static Random rnd = new Random();

    int order = 0;

    char myPlayer = ' ';
    char oppPlayer = ' ';


    @Override
    public void init(int order, long t, Random rnd) {
        this.order = order;
        this.rnd = rnd;
        board = new OthelloBoard(8);


        if (order == 0) {
            myPlayer = OthelloBoard.blackPlayer;
            oppPlayer = OthelloBoard.whitePlayer;
        } else {
            myPlayer = OthelloBoard.whitePlayer;
            oppPlayer = OthelloBoard.blackPlayer;


        }


    }

    @Override
    public Move nextMove(Move prevMove, long tOpponent, long t) {
       Move m = null;

        if (prevMove != null){
           board.flipper(prevMove.x,prevMove.y,oppPlayer);

           int x = 0;
           int y = 0;
           board.checkValid(x,y,myPlayer);

           System.out.println(OthelloBoard.blackPlayer + ":" + board.blackScore() + " " +OthelloBoard.whitePlayer
                   + ":" + board.whiteScore() );


           try {
               Scanner sc = new Scanner(System.in);
               System.out.print("row: ");
               x = sc.nextInt();
               System.out.print("col: ");
               y = sc.nextInt();
               if (board.check(x,y,myPlayer)){
                   board.flipper(x,y,myPlayer);
               }else {
                   System.out.println("Please enter a valid index");
               }

           }catch (Exception ex){
               System.err.println(ex);
               Scanner sc = new Scanner(System.in);
               System.out.print("row: ");
               x = sc.nextInt();
               System.out.print("col: ");
               y = sc.nextInt();
           }


           m = new Move(x,y);
           return m;


       }else {
            int x = 0;
            int y = 0;
            board.checkValid(x,y,myPlayer);

            System.out.println(OthelloBoard.blackPlayer + ":" + board.blackScore() + " " +OthelloBoard.whitePlayer
                    + ":" + board.whiteScore() );

            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("row: ");
                x = sc.nextInt();
                System.out.print("col: ");
                y = sc.nextInt();
                if (board.check(x,y,myPlayer)){
                    board.flipper(x,y,myPlayer);
                }else {
                    System.out.print("row: ");
                    x = sc.nextInt();
                    System.out.print("col: ");
                    y = sc.nextInt();
                }


            }catch (Exception ex){
                System.err.println(ex);
                Scanner sc = new Scanner(System.in);
                System.out.print("row: ");
                x = sc.nextInt();
                System.out.print("col: ");
                y = sc.nextInt();

            }


            m = new Move(x,y);
            return m;

        }

    }

   /* public static void main(String[] args) {
        Player p1 = new HumanPlayer();
        Player p2 = new HumanPlayer();
        for (int i = 0; i < 10; i++) {
            p1.init(0, 8000, new Random());
            p2.init(1, 8000, new Random());
            Move last = null;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    while (board.gameNotFinished()) {
                        System.out.println(board.writeBoard());
                        last = p1.nextMove(last, 8000, 8000);
                        System.out.println("p1 played: " + last);
                        System.out.println(board.writeBoard());
                        last = p2.nextMove(last, 8000, 8000);
                        System.out.println("p2 played: " + last);

                    }
                }
            }
        }
    }
    */

}

