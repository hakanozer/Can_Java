package com.example.othello;

import szte.mi.Move;
import szte.mi.Player;


import java.util.*;


public class SmartAI implements Player {


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

            int x = 0 ;
            int y = 0;

            Set<Move> nextMoves = board.fncCheckValid(x,y,myPlayer);
            if (nextMoves.size() > 0) {
                int[][] arr = aiData.aiData();

                List<Integer> scorelist = new ArrayList<>();
                for (Move item : nextMoves) {
                    int i = arr[item.x][item.y];
                    scorelist.add(i);
                }
                Integer max = Collections.max(scorelist);
                int count = -1;
                for (int i = 0; i < scorelist.size(); i++) {
                    int item = scorelist.get(i);
                    if (item == max) {
                        count = i;
                    }
                }
                if (count > -1) {
                    m = (Move) nextMoves.toArray()[count];
                    board.flipper(m.x,m.y,myPlayer);
                    return m;
                }
            }
        }
        if (prevMove == null) {
            int x = 0;
            int y = 0;
            Set<Move> nextMoves = board.fncCheckValid(x, y, myPlayer);
            if (nextMoves.size() > 0) {
                int[][] arr = aiData.aiData();

                List<Integer> scorelist = new ArrayList<>();
                for (Move item : nextMoves) {
                    int i = arr[item.x][item.y];
                    scorelist.add(i);
                }
                Integer max = Collections.max(scorelist);
                int count = -1;
                for (int i = 0; i < scorelist.size(); i++) {
                    int item = scorelist.get(i);
                    if (item == max) {
                        count = i;
                    }
                }
                if (count > -1) {
                    m = (Move) nextMoves.toArray()[count];
                    board.flipper(m.x,m.y,myPlayer);
                    return m;
                }
            }


        }



        return m;
    }

  /* public static void main(String[] args) {
        Player p1 = new SmartAI();
        Player p2 = new SmartAI();

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
      if (!board.gameNotFinished()){
          System.out.println("Game Over");
          System.out.println(board.getWinner() + " wins");
      }

    }

   */


}