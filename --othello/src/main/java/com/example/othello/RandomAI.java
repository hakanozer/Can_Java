package com.example.othello;

import szte.mi.Move;
import szte.mi.Player;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomAI implements Player {

    OthelloBoardData data = new OthelloBoardData();
    long computerTime = 0l;

    @Override
    public void init(int order, long t, Random rnd) {
        computerTime = t;
        data.random = rnd;
        if (order == 0) {
            data.isComputer = true;
        }else {
            data.isComputer = false;
        }
    }


    @Override
    public Move nextMove(Move prevMove, long tOpponent, long t) {

        Move m = null;
        data.eventCall(prevMove.x, prevMove.y);
        Box[][] boxes = data.boxes;
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                if ( i == prevMove.x && j == prevMove.y) {
                    m = boxes[i][j].getCoordinate();
                }
            }
        }
        return m;
    }


    public static void main(String[] args) {
        RandomAI ai = new RandomAI();
        ai.init(0, 10000, new Random());

        Move m = new Move(2,3);
        ai.nextMove( m, 1000, 2000 );
    }
}
