package com.example.othello;


import szte.mi.Move;

import java.util.*;

public class OthelloBoard {

    int rowEntry = 0;
    int colEntry = 0;

    public char[][] board;
    private int dimension = 8;

    public static final char EMPTY = ' ', blackPlayer = 'X', whitePlayer = 'O' ;


    /*
    We create a board with every position being empty
     */
    public OthelloBoard(int dim) {
        this.dimension = dim;
        board = new char[this.dimension][this.dimension];
        for (int row = 0; row < this.dimension; row++) {
            for (int col = 0; col < this.dimension; col++) {
                this.board[row][col] = EMPTY;
            }
        }


// We now add the essential starting positions of the X and O.
        this.board[3][3] = whitePlayer;
        this.board[4][4] = whitePlayer;
        this.board[3][4] = blackPlayer;
        this.board[4][3] = blackPlayer;









    }

    /*
    Prints the board for us to see
     */

    public String writeBoard() {

        String data = " ";
        data += " ";
        for (int col = 0; col < this.dimension; col++) {
            data += col + " ";
        }
        data += '\n';

        data += " +";
        for (int col = 0; col < this.dimension; col++) {
            data += "--";
        }
        data += '\n';

        for (int row = 0; row < this.dimension; row++) {
            data += row + "|";
            for (int col = 0; col < this.dimension; col++) {
                data += board[row][col] + "|";
            }
            data += row + "\n";

            data += " +";
            for (int col = 0; col < this.dimension; col++) {
                data += "--";
            }
            data += '\n';
        }
        data += "  ";
        for (int col = 0; col < this.dimension; col++) {
            data += col + " ";
        }
        data += '\n';
        return data;
    }


    /*
    Returns the score of X's
     */
    public int blackScore() {

        int blackPoints = 0;

        for (int row = 0; row < this.dimension; row++) {
            for (int col = 0; col < this.dimension; col++) {
                if (board[row][col] == blackPlayer)
                    blackPoints++;

            }
        }
        return blackPoints;
    }

    /*
    Returns the score of O's
     */
    public int whiteScore() {
        int whitePoints = 0;
        for (int row = 0; row < this.dimension; row++) {
            for (int col = 0; col < this.dimension; col++) {
                if (board[row][col] == whitePlayer)
                    whitePoints++;
            }
        }
        return whitePoints;
    }

    /*
    Checks if game is finished. Also performs the passing if a player doesn't have possible moves left
     */

    public boolean gameNotFinished() {
        int passer = 0;
        checkValid(rowEntry,colEntry,Othello.whosTurn);
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if (board[row][col] == EMPTY && set.size() > 1) {

                    return true;

                }
                if (board[row][col] == EMPTY && set.size() == 1) {
                    passer += 1;
                    System.out.println("No possible Moves. Turn skipped" + " " +  passer);
                    Othello.changePlayer();
                    checkValid(rowEntry,colEntry,Othello.whosTurn);




                    if (board[row][col] == EMPTY && set.size() == 1 && passer == 1) {
                    passer += 1;
                    System.out.println("No possible Moves. Turn skipped" + " " +  passer);
                    if (passer == 2) {
                        System.out.println("No possible moves for both, Game ends");
                        return false;
                    }
                }
            }
                }

                        }


        return false;
    }


public String gameOver() {
    if (!gameNotFinished()){
        return "Game Over";


    }else {
        return " ";
    }
}


/*
Arraylists are for the checking of the possible moves. Each arraylist is deleted after each move to prevent
complications. Each arraylist is responsible for one of the 8 directions.
 */
    List<Integer> ls1 = new ArrayList<>();
    List<Integer> ls2 = new ArrayList<>();
    List<Integer> ls3 = new ArrayList<>();
    List<Integer> ls4 = new ArrayList<>();
    List<Integer> ls5= new ArrayList<>();
    List<Integer> ls6= new ArrayList<>();
    List<Integer> ls7= new ArrayList<>();
    List<Integer> ls8= new ArrayList<>();
    List<Integer> ls9 = new ArrayList<>();
    List<Integer> ls10= new ArrayList<>();
    List<Integer> ls11= new ArrayList<>();
    List<Integer> ls12= new ArrayList<>();






    int r = 0;
    int c = 0;


/*
All the check methods are called in this method. Constructor consists of an x value, y value and the checked players
representing char value in order to help us check a certain position for a certain player.
 */
    Set<String> set = new HashSet<>();
    public Set<String> checkValid(int r, int c, char color){
        set.clear();
        String s = "";

        for ( r = 0; r < dimension; r++) {
            for ( c = 0; c < dimension; c++) {
                if (board[r][c] == EMPTY ) {
                    if (bottomCheck(r,c,color)){
                        s =  r + "," + c ;
                    }if (rightCheck(r,c,color)){
                        s =  r + "," + c ;
                    }if (leftCheck(r,c,color)){
                        s =  r + "," + c ;
                    }if (topCheck(r,c,color)){
                        s =  r + "," + c ;
                    }if (dRTopBottomCheck(r,c,color)){
                        s =  r + "," + c ;
                    }if (dRBottomTopCheck(r,c,color)){
                        s =  r + "," + c ;
                    }if (dLTopBottomCheck(r,c,color)){
                        s =  r + "," + c ;
                    }if (dLBottomTopCheck(r,c,color)){
                        s =  r + "," + c ;
                    }
                }
                set.add(s);

            }
        }


        for (String item : set){
            if (!item.isEmpty()){
               // System.out.println("Possible move (" +item+ ")");
            }

        }

        return set;
    }




/*
If the given x and y values are a possible playing position the given position and the opponent icons
between two current player icons are flipped in every ...Set method. There are in total 8 set methods
for each direction.
 */

    public boolean bottomSet(int x, int y, char color){
        ls4.clear();


        int a = x + 1;
        if (a > dimension-1){
            return false;
        }
        while (board[a][y] != EMPTY  && board[a][y] != color && a < dimension -1){

            ls4.add(a);

            a++;
        }if (a > x+1 && ls4.size() > 0 && board[a][y] == color){
            board[x][y] = color;
            for (int i = 1; i < ls4.size() + 1; i++) {
                board[x + i][y] = color;
            }
            return true;

        }

        return  false;}


/*
Check methods check every direction of the given x and y values and return a boolean value
whether the given value is playable.
 */

    public boolean bottomCheck(int x, int y,char color){
        ls4.clear();

        int a = x + 1;
        if (a > dimension-1){
            return false;
        }
        while (board[a][y] != EMPTY  && board[a][y] != color && a < dimension -1){

            ls4.add(a);

            a++;
        }if (a > x+1 && ls4.size() > 0 && board[a][y] == color){

            return true;

        }

        return  false;}


    public boolean rightSet(int x, int y,char color){
        ls2.clear();

        int a = y +1;
        if (a > dimension-1){
            return false;
        }
        while (board[x][a] != EMPTY  && board[x][a] != color && a < dimension-1 ) {
            ls2.add(a);
            a++;

        }if (a > y + 1 && ls2.size() > 0 && board[x][a] == color){
            board[x][y] = color;
            for (int i = 1; i < ls2.size() + 1; i++) {
                board[x][y + i] = color;
            }
            return true;

        }
        return false;}

    public boolean rightCheck(int x, int y,char color){
        ls2.clear();
        int a = y +1;
        if (a > dimension-1){
            return false;
        }
        while (board[x][a] != EMPTY  && board[x][a] != color && a < dimension-1 ) {
            ls2.add(a);
            a++;

        }if (a > y + 1 && ls2.size() > 0 && board[x][a] == color){

            return true;

        }
        return false;}


    public boolean leftSet(int x, int y,char color){
        ls1.clear();

        int a = y -1;
        if (a < 0){
            return false;
        }
        while(board[x][a] != EMPTY  && board[x][a] != color && a > 0 ){
            ls1.add(a);
            a--;
        }if (a < y -1 && ls1.size() > 0 && board[x][a] == color){
            board[x][y] = color;
            for (int i = 1; i < ls1.size() + 1; i++) {
                board[x][y -i] = color;
            }
            return true;


        }
        return false; }

    public boolean leftCheck(int x, int y,char color){
        ls1.clear();
        int a = y -1;
        if (a < 0){
            return false;
        }
        while(board[x][a] != EMPTY  && board[x][a] != color && a > 0 ){
            ls1.add(a);
            a--;
        }if (a < y -1 && ls1.size() > 0 && board[x][a] == color ){

            return true;


        }
        return false; }


    public boolean topSet(int x , int y,char color){
        ls3.clear();

        int a = x -1;
        if (a < 0 ){
            return false;
        }
        while(board[a][y] != EMPTY && board[a][y] != color && a > 0){
            ls3.add(a);
            a--;
        }if (a < x && ls3.size() > 0  && board[a][y] == color ){
            board[x][y] = color;
            for (int i = 1; i < ls3.size() + 1 ; i++) {
                board[x - i][y] = color;
            }

            return true;


        }



        return false; }


    public boolean topCheck(int x, int y,char color){
        ls3.clear();
        int a = x -1;
        if (a < 0 ){
            return false;
        }
        while(board[a][y] != EMPTY && board[a][y] != color && a > 0){
            ls3.add(a);
            a--;
        }if (a < x && ls3.size() > 0  && board[a][y] == color ){


            return true;


        }



        return false; }



    public boolean dRTopBottomSet(int x, int y,char color){
        ls5.clear();
        ls6.clear();

        int a = x +1;
        int b = y +1;
        if (a > dimension-1 || b > dimension-1){
            return false;
        }

        while (board[a][b] != EMPTY  && board[a][b] != color && a < dimension-1 && b< dimension-1){
            ls5.add(a);
            ls6.add(b);
            a++;
            b++;

        }if (a > x + 1 && b > colEntry + 1 && ls5.size() > 0 && ls6.size() > 0 && board[a][b] == color){
            board[x][y] = color;
            for (int i = 1; i < ls5.size() + 1; i++) {
                for (int j = 1; j < ls6.size() + 1; j++) {
                    if (i == j){
                        board[x + i][y+j] = color;
                    }

                }
            }
            return true;


        }


        return false;}

    //Checking diagonal from top left to bottom right
    public boolean dRTopBottomCheck(int x, int y,char color){
        ls5.clear();
        ls6.clear();
        int a = x +1;
        int b = y +1;
        if (a > dimension-1 || b > dimension-1){
            return false;
        }

        while (board[a][b] != EMPTY  && board[a][b] !=color && a < dimension-1 && b< dimension-1){
            ls5.add(a);
            ls6.add(b);
            a++;
            b++;

        }if (a > x + 1 && b > y + 1 && ls5.size() > 0 && ls6.size() > 0 && board[a][b] == color){

            return true;


        }


        return false;}


    public boolean dRBottomTopSet(int x , int y,char color){
        ls7.clear();
        ls8.clear();

        int a = x -1;
        int b = y -1;
        if (a < 0 || b < 0 ){
            return false;
        }
        while (board[a][b] != EMPTY  && board[a][b] != color && a > 0 && b > 0){
            ls7.add(a);
            ls8.add(b);
            a--;
            b--;

        }if (a < x -1 && b < y -1 && ls7.size() > 0 && ls8.size() > 0 && board[a][b] == color){
            board[x][y] = color;
            for (int i = 1; i < ls7.size() + 1; i++) {
                for (int j = 1; j < ls8.size() + 1; j++) {
                    if (i == j){
                        board[x -i][y-j] = color;
                    }

                }
            }


            return true;

        }



        return false;}

    //Checking diagonal from bottom right to top left
    public boolean dRBottomTopCheck(int x, int y,char color){
        ls7.clear();
        ls8.clear();

        int a = x -1;
        int b = y -1;
        if (a < 0 || b < 0 ){
            return false;
        }
        while (board[a][b] != EMPTY  && board[a][b] != color && a > 0 && b > 0){
            ls7.add(a);
            ls8.add(b);
            a--;
            b--;

        }if (a < x -1 && b < y -1 && ls7.size() > 0 && ls8.size() > 0 && board[a][b] == color){


            return true;

        }



        return false;}

    public boolean dLTopBottomSet(int x , int y,char color){
        ls9.clear();
        ls10.clear();

        int a = x + 1;
        int b = y -1;
        if (a > dimension-1 || b < 0){
            return false;
        }
        while (board[a][b] != EMPTY  && board[a][b] != color && a <dimension-1 && b > 0){
            ls9.add(a);
            ls10.add(b);
            a++;
            b--;

        }if (a > x && b < y  && ls9.size() > 0 && ls10.size() > 0 && board[a][b] == color){
            board[x][y] = color;
            for (int i = 1; i < ls9.size() + 1; i++) {
                for (int j = 1; j < ls10.size() + 1; j++) {
                    if (i == j)
                        board[x + i][y -j] =color;

                }
            }


            return true;

        }


        return  false;}

    //Checking diagonal from top right to bottom left

    public boolean dLTopBottomCheck(int x, int y,char color){
        ls9.clear();
        ls10.clear();
        int a = x + 1;
        int b = y -1;
        if (a > dimension-1 || b < 0){
            return false;
        }
        while (board[a][b] != EMPTY  && board[a][b] != color && a <dimension-1 && b > 0){
            ls9.add(a);
            ls10.add(b);
            a++;
            b--;

        }if (a > x && b < y  && ls9.size() > 0 && ls10.size() > 0 && board[a][b] == color){



            return true;

        }


        return  false;}

    //Checking diagonal from bottom left to top right
    public boolean dLBottomTopCheck(int x  , int y,char color){
        ls11.clear();
        ls12.clear();
        int a = x -1;
        int b = y + 1;
        if (a < 0 || b > dimension-1){
            return false;
        }
        while (board[a][b] != EMPTY && board[a][b] != color && a > 0 && b < dimension-1){
            ls11.add(a);
            ls12.add(b);
            a--;
            b++;
        }if (a < x && b > y && ls11.size() > 0 && ls12.size() > 0 && board[a][b] == color){


            return true;

        }


        return false;}

    public boolean dLBottomTopSet(int x, int y,char color){
        ls11.clear();
        ls12.clear();

        int a = x -1;
        int b = y + 1;
        if (a < 0 || b > dimension-1){
            return false;
        }
        while (board[a][b] != EMPTY && board[a][b] != color && a > 0 && b < dimension-1){
            ls11.add(a);
            ls12.add(b);
            a--;
            b++;
        }if (a < x && b > y && ls11.size() > 0 && ls12.size() > 0 && board[a][b] == color){
            board[x][y] = color;

            for (int i = 1; i < ls11.size() + 1; i++) {
                for (int j = 1; j < ls12.size() + 1; j++) {
                    if (i == j){
                        board[x -i][y + j] = color;
                    }
                }
            }
            return true;

        }

        return false;}


    public static int row = 0;
    public static int col = 0;

    public String getWinner(){
        if (blackScore() > whiteScore()){
            return "Black";
        } else if (whiteScore() > blackScore()) {
            return "White";
        }else {
            return " " ;
        }
    }


/*
This method takes the Set<String> value from the previous checkValid method and turns it into the type Set<Move> in
order us to play in Move type.
 */
    public Set<Move> fncCheckValid(int x, int y, char color) {
        Set<String> sets = checkValid(x, y, color);
        Set<Move> moves = new HashSet<>();
        for( String item : sets ) {
            if ( !item.equals("") ) {
                String[] arr = item.split(",");
                x = Integer.parseInt(arr[0]);
                y = Integer.parseInt(arr[1]);
                Move move = new Move(x, y);
                moves.add(move);
            }
        }
        return moves;
    }

// All set methods are in this method to ease the flipping of the chars.
    public void flipper(int x, int y,char color){
        bottomSet(x, y,color);
        rightSet(x, y,color);
         leftSet(x, y,color);
         topSet(x, y,color);
         dRTopBottomSet(x, y,color);
         dRBottomTopSet(x, y,color);
         dLTopBottomSet(x, y,color);
         dLBottomTopSet(x, y,color);

    }



    public boolean check(int r , int c,char color){
         if (bottomCheck(r,c,color) || rightCheck(r,c,color) || leftCheck(r,c,color) || topCheck(r,c,color) ||
                 dRTopBottomCheck(r,c,color) ||dRBottomTopCheck(r,c,color)||
                 dLTopBottomCheck(r,c,color)||
                 dLBottomTopCheck(r,c,color)){
             return true;

        }else{
             return false;
         }

    }




    public char getValue() {
        if (gameNotFinished()){
            checkValid(rowEntry,colEntry,Othello.whosTurn);
            System.out.println(OthelloBoard.blackPlayer + ":" + blackScore() + " " +OthelloBoard.whitePlayer
                    + ":" + whiteScore() );
            System.out.println(Othello.whosTurn + "'s turn ");

            try {
                rowEntry = OthelloBoard.row;
                colEntry = OthelloBoard.col;

            }catch (InputMismatchException ex){
                System.err.println(ex);
                System.out.println("Please enter a valid index!");
                writeBoard();
                getValue();
            }


            if (board[rowEntry][colEntry] == EMPTY) {
                bottomSet(rowEntry,colEntry,Othello.whosTurn);
                rightSet(rowEntry,colEntry,Othello.whosTurn);
                leftSet(rowEntry,colEntry,Othello.whosTurn);
                topSet(rowEntry,colEntry,Othello.whosTurn);
                dRTopBottomSet(rowEntry,colEntry,Othello.whosTurn);
                dRBottomTopSet(rowEntry,colEntry,Othello.whosTurn);
                dLTopBottomSet(rowEntry,colEntry,Othello.whosTurn);
                dLBottomTopSet(rowEntry,colEntry,Othello.whosTurn);
            }


            if (rowEntry < 0 || rowEntry > 7 || colEntry < 0 || colEntry > 7){
                System.out.println("Please enter a valid index!");
                System.out.println(writeBoard());
                System.out.println(getValue());
            }





            if (board[rowEntry][colEntry] ==  Othello.whosTurn){
                System.out.println(Othello.whosTurn + " has played " + "(" + rowEntry + "," + colEntry + ")");
                Othello.changePlayer();
            }

        }
        if (!gameNotFinished() && checkValid(rowEntry,colEntry,Othello.whosTurn).size() == 1 ){

            gameOver();
            System.out.println(OthelloBoard.blackPlayer + ":" + blackScore() + " " +OthelloBoard.whitePlayer
                    + ":" +  whiteScore());
            System.out.println(getWinner() + " Wins");


        }



        return EMPTY;
    }

}


