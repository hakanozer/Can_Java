package com.example.othello;


import szte.mi.Move;
import szte.mi.Player;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class OthelloController {

    static OthelloBoard board;
    static Player p1,p2;

    static char myPlayer = ' ';
    static char oppPlayer = ' ';
    static int order = 0;





    public static void main(String[] args) {
        board = new OthelloBoard(8);
        int start1;



        if (order == 0) {
            myPlayer = OthelloBoard.blackPlayer;
            oppPlayer = OthelloBoard.whitePlayer;
        } else {
            myPlayer = OthelloBoard.whitePlayer;
            oppPlayer = OthelloBoard.blackPlayer;


        }





            Scanner sc= new Scanner(System.in);
            System.out.print("1.Human vs Human \n2.Human vs RandomAI \n3.Human vs SmartAI \n4.Random vs Smart \nPick:");
            start1 = sc.nextInt();
            int a = -1;
            int b = -1;
            if (start1 == 1){
                p1 = new HumanPlayer();
                p2 = new HumanPlayer();
                p1.init(0,8000,new Random());
                p2.init(1,8000,new Random());

            } else if (start1 == 2) {
                p1 = new HumanPlayer();
                p2 = new RandomAI();
                System.out.println("Who starts? (1-Human, 2-Random Player) : ");
                 a = sc.nextInt();
                try{
                    if (a == 1){
                        p1.init(0,8000,new Random());
                        p2.init(1,8000,new Random());
                    }if (a == 2){
                        p1.init(1,8000,new Random());
                        p2.init(0,8000,new Random());
                    }
                }catch (InputMismatchException e){
                    System.err.println(e);
                    System.out.println("Who starts? (1-Human, 2-Random Player) : ");
                }

            }else if (start1 == 3){
                p1 = new HumanPlayer();
                p2 = new SmartAI();

                System.out.println("Who starts? (1-Human, 2-Smart Player) : ");
                b = sc.nextInt();

                try {
                    if (b == 1){
                        p1.init(0,8000,new Random());
                        p2.init(1,8000,new Random());
                    }if (b == 2){
                        p1.init(1,8000,new Random());
                        p2.init(0,8000,new Random());
                    }

                }catch (InputMismatchException e){
                    System.err.println(e);
                    System.out.println("Who starts? (1-Human, 2-Smart Player) : ");

                }



            } else if (start1 == 4) {
                p1 = new RandomAI();
                p2 = new SmartAI();

                p1.init(0,8000,new Random());
                p2.init(1,8000,new Random());

            }

            Move last = null;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    while (board.gameNotFinished()) {
                        if (start1 == 1){
                            System.out.println(board.writeBoard());
                            System.out.println(myPlayer + "'s Turn");
                            last = p1.nextMove(last, 8000, 8000);

                            if (board.check(last.x, last.y,myPlayer)){
                                System.out.println("p1 played: " + last);
                                board.flipper(last.x,last.y,myPlayer);
                            }

                            System.out.println(board.writeBoard());
                            System.out.println(oppPlayer + "'s Turn");



                            last = p2.nextMove(last, 8000, 8000);

                            if (board.check(last.x, last.y,oppPlayer)){
                                System.out.println("p2 played: " + last);
                                board.flipper(last.x,last.y,oppPlayer);
                            }



                        }


                        if ((start1 == 2 || start1 == 3) && ( a == 1 || b == 1)){
                            System.out.println(board.writeBoard());
                            System.out.println(myPlayer + "'s Turn");
                            last = p1.nextMove(last, 8000, 8000);
                            System.out.println("p1 played: " + last);
                            board.flipper(last.x,last.y,myPlayer);
                            System.out.println(board.writeBoard());
                            try {
                                Thread.sleep(3000);
                            }catch (Exception e ){
                                System.err.println(e);
                            }
                            if (board.gameNotFinished()){
                                last = p2.nextMove(last, 8000, 8000);
                                System.out.println("p2 played: " + last);
                                board.flipper(last.x,last.y,oppPlayer);
                            }else {
                                System.out.println(board.getWinner());
                            }


                        }else if ((start1 == 2 || start1 == 3) && (a ==2 || b == 2)){

                            System.out.println(board.writeBoard());
                            try {
                                Thread.sleep(3000);
                            }catch (Exception e ){
                                System.err.println(e);
                            }

                            last = p2.nextMove(last, 8000, 8000);
                            System.out.println("p1 played: " + last);
                            board.flipper(last.x,last.y,myPlayer);
                            System.out.println(board.writeBoard());
                            System.out.println(oppPlayer + "'s Turn");
                            last = p1.nextMove(last, 8000, 8000);
                            System.out.println("p2 played: " + last);
                            board.flipper(last.x,last.y,oppPlayer);

                        } else if (start1 == 4) {
                            System.out.println(board.writeBoard());
                            System.out.println(myPlayer + "'s Turn");
                            last = p1.nextMove(last, 8000, 8000);
                            System.out.println("p1 played: " + last);
                            board.flipper(last.x,last.y,myPlayer);
                            System.out.println(board.writeBoard());
                            System.out.println(oppPlayer + "'s Turn");

                            if (board.gameNotFinished()){
                                last = p2.nextMove(last, 8000, 8000);
                                System.out.println("p2 played: " + last);
                                board.flipper(last.x,last.y,oppPlayer);
                            }
                            if (!board.gameNotFinished()){
                                if (board.getWinner().equals("White")){
                                    System.out.println("Smart Wins");

                                } if ( board.getWinner().equals("Black")){
                                    System.out.println("Random Wins");

                                }
                            }

                        }

                    }
                }
            }

    }



}
