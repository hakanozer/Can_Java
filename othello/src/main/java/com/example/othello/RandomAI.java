package com.example.othello;

import szte.mi.Move;
import szte.mi.Player;


import java.util.*;


public class RandomAI implements Player {


    static OthelloBoard board;

    AIData aiData = new AIData();
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

        if (prevMove != null) {
            board.flipper(prevMove.x,prevMove.y,oppPlayer);

            int x = 0;
            int y = 0;

            Set<Move> nextMoves = board.fncCheckValid(x,y,myPlayer);
            int size = nextMoves.size();
            if (size > 0) {
                int a = rnd.nextInt(size);
                m = (Move) nextMoves.toArray()[a];

                board.flipper(m.x, m.y, myPlayer);

                return m;
            }

        }
        if (prevMove == null) {
            int x = 0;
            int y = 0;

            Set<Move> nextMoves = board.fncCheckValid(x,y,myPlayer);

            int size = nextMoves.size();
            if (size > 0) {
                int a = rnd.nextInt(size);
                m = (Move) nextMoves.toArray()[a];
                board.flipper(m.x, m.y, myPlayer);
                return m;
            }



        }



        return m;
    }

    /* public static void main(String[] args) {
        Player p1 = new RandomAI();
        Player p2 = new RandomAI();

            p1.init(0, 8000, new Random());
            p2.init(1, 8000, new Random());
            Move last = null;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    while (board.gameNotFinished()) {
                        System.out.println(board.writeBoard());
                        last = p1.nextMove(last, 8000, 8000);
                        System.out.println("p1 played: " + last);
                        last = p2.nextMove(last, 8000, 8000);
                        System.out.println("p2 played: " + last);

                    }
                }
            }
    }

     */





}