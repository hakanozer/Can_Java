package com.example.othello;
import java.util.*;

public class OthelloBoard {

	int rowEntry = 0;
	int colEntry = 0;

	public final char[][] board;
	private int dimension = 8;

	public static final char EMPTY = ' ', blackPlayer = 'X', whitePlayer = 'O', possible = 'p';

	public OthelloBoard(int dim) {
		this.dimension = dim;
		board = new char[this.dimension][this.dimension];
		for (int row = 0; row < this.dimension; row++) {
			for (int col = 0; col < this.dimension; col++) {
				this.board[row][col] = EMPTY;
			}
		}


		this.board[3][3] = whitePlayer;
		this.board[4][4] = whitePlayer;
		this.board[4][3] = blackPlayer;
		this.board[3][4] = blackPlayer;






	}

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


	public boolean gameNotFinished() {
		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				if (board[row][col] == EMPTY) {
					return true;
				}

			}
		}
		return false;
	}




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

	public Set<String> checkValid(){
		Set<String> set = new HashSet<>();
		String s = "";

		for ( r = 0; r < dimension; r++) {
			for ( c = 0; c < dimension; c++) {
				if (board[r][c] == EMPTY ) {
					if (bottomCheck()){
                        s =  r + "," + c ;
					}if (rightCheck()){
                        s =  r + "," + c ;
					}if (leftCheck()){
                        s =  r + "," + c ;
					}if (topCheck()){
                        s =  r + "," + c ;
					}if (dRTopBottomCheck()){
                        s =  r + "," + c ;
					}if (dRBottomTopCheck()){
                        s =  r + "," + c ;
					}if (dLTopBottomCheck()){
                        s =  r + "," + c ;
					}if (dLBottomTopCheck()){
						s =  r + "," + c ;
					}
				}
				set.add(s);

			}
		}


		for (String item : set){
			System.out.println("Possible move (" +item+ ")");
		}

		return set;
	}






	private boolean bottomSet(){
		ls4.clear();

		int a = rowEntry + 1;
		if (a > dimension-1){
			return false;
		}
		while (board[a][colEntry] != EMPTY  && board[a][colEntry] != Othello.whosTurn && a < dimension -1){

			ls4.add(a);

			a++;
		}if (a > rowEntry+1 && ls4.size() > 0 && board[a][colEntry] == Othello.whosTurn){
			board[rowEntry][colEntry] = Othello.whosTurn;
			for (int i = 1; i < ls4.size() + 1; i++) {
				board[rowEntry + i][colEntry] = Othello.whosTurn;
			}
			return true;

		}

		return  false;}




	private boolean bottomCheck(){
		ls4.clear();

		int a = r + 1;
		if (a > dimension-1){
			return false;
		}
		while (board[a][c] != EMPTY  && board[a][c] != Othello.whosTurn && a < dimension -1){

			ls4.add(a);

			a++;
		}if (a > r+1 && ls4.size() > 0 && board[a][c] == Othello.whosTurn){

			return true;

		}

		return  false;}


	private boolean rightSet(){
		ls2.clear();
		int a = colEntry +1;
		if (a > dimension-1){
			return false;
		}
		while (board[rowEntry][a] != EMPTY  && board[rowEntry][a] != Othello.whosTurn && a < dimension-1 ) {
			ls2.add(a);
			a++;

		}if (a > colEntry + 1 && ls2.size() > 0 && board[rowEntry][a] == Othello.whosTurn){
			board[rowEntry][colEntry] = Othello.whosTurn;
			for (int i = 1; i < ls2.size() + 1; i++) {
				board[rowEntry][colEntry + i] = Othello.whosTurn;
			}
			return true;

		}
		return false;}

	private boolean rightCheck(){
		ls2.clear();
		int a = c +1;
		if (a > dimension-1){
			return false;
		}
		while (board[r][a] != EMPTY  && board[r][a] != Othello.whosTurn && a < dimension-1 ) {
			ls2.add(a);
			a++;

		}if (a > c + 1 && ls2.size() > 0 && board[r][a] == Othello.whosTurn){

			return true;

		}
		return false;}


	private boolean leftSet(){
		ls1.clear();
		int a = colEntry -1;
		if (a < 0){
			return false;
		}
		while(board[rowEntry][a] != EMPTY  && board[rowEntry][a] != Othello.whosTurn && a > 0 ){
			ls1.add(a);
			a--;
		}if (a < colEntry -1 && ls1.size() > 0 && board[rowEntry][a] == Othello.whosTurn){
			board[rowEntry][colEntry] = Othello.whosTurn;
			for (int i = 1; i < ls1.size() + 1; i++) {
				board[rowEntry][colEntry -i] = Othello.whosTurn;
			}
			return true;


		}
		return false; }

	private boolean leftCheck(){
		ls1.clear();
		int a = c -1;
		if (a < 0){
			return false;
		}
		while(board[r][a] != EMPTY  && board[r][a] != Othello.whosTurn && a > 0 ){
			ls1.add(a);
			a--;
		}if (a < c -1 && ls1.size() > 0 && board[r][a] == Othello.whosTurn){

			return true;


		}
		return false; }


	private boolean topSet(){
		ls3.clear();
		int a = rowEntry -1;
		if (a < 0 ){
			return false;
		}
		while(board[a][colEntry] != EMPTY && board[a][colEntry] != Othello.whosTurn && a > 0){
			ls3.add(a);
			a--;
		}if (a < rowEntry && ls3.size() > 0  && board[a][colEntry] == Othello.whosTurn ){
			board[rowEntry][colEntry] = Othello.whosTurn;
			for (int i = 1; i < ls3.size() + 1 ; i++) {
				board[rowEntry - i][colEntry] = Othello.whosTurn;
			}

			return true;


		}



		return false; }


	private boolean topCheck(){
		ls3.clear();
		int a = r -1;
		if (a < 0 ){
			return false;
		}
		while(board[a][c] != EMPTY && board[a][c] != Othello.whosTurn && a > 0){
			ls3.add(a);
			a--;
		}if (a < r && ls3.size() > 0  && board[a][c] == Othello.whosTurn ){


			return true;


		}



		return false; }



	private boolean dRTopBottomSet(){
		ls5.clear();
		ls6.clear();
		int a = rowEntry +1;
		int b = colEntry +1;
		if (a > dimension-1 || b > dimension-1){
			return false;
		}

		while (board[a][b] != EMPTY  && board[a][b] != Othello.whosTurn && a < dimension-1 && b< dimension-1){
			ls5.add(a);
			ls6.add(b);
			a++;
			b++;

		}if (a > rowEntry + 1 && b > colEntry + 1 && ls5.size() > 0 && ls6.size() > 0 && board[a][b] == Othello.whosTurn){
			board[rowEntry][colEntry] = Othello.whosTurn;
			for (int i = 1; i < ls5.size() + 1; i++) {
				for (int j = 1; j < ls6.size() + 1; j++) {
					if (i == j){
						board[rowEntry + i][colEntry+j] = Othello.whosTurn;
					}

				}
			}
			return true;


		}


		return false;}
	private boolean dRTopBottomCheck(){
		ls5.clear();
		ls6.clear();
		int a = r +1;
		int b = c +1;
		if (a > dimension-1 || b > dimension-1){
			return false;
		}

		while (board[a][b] != EMPTY  && board[a][b] != Othello.whosTurn && a < dimension-1 && b< dimension-1){
			ls5.add(a);
			ls6.add(b);
			a++;
			b++;

		}if (a > r + 1 && b > c + 1 && ls5.size() > 0 && ls6.size() > 0 && board[a][b] == Othello.whosTurn){

			return true;


		}


		return false;}


	private boolean dRBottomTopSet(){
		ls7.clear();
		ls8.clear();

		int a = rowEntry -1;
		int b = colEntry -1;
		if (a < 0 || b < 0 ){
			return false;
		}
		while (board[a][b] != EMPTY  && board[a][b] != Othello.whosTurn && a > 0 && b > 0){
			ls7.add(a);
			ls8.add(b);
			a--;
			b--;

		}if (a < rowEntry -1 && b < colEntry -1 && ls7.size() > 0 && ls8.size() > 0 && board[a][b] == Othello.whosTurn){
			board[rowEntry][colEntry] = Othello.whosTurn;
			for (int i = 1; i < ls7.size() + 1; i++) {
				for (int j = 1; j < ls8.size() + 1; j++) {
					if (i == j){
						board[rowEntry -i][colEntry-j] = Othello.whosTurn;
					}

				}
			}


			return true;

		}



		return false;}
	private boolean dRBottomTopCheck(){
		ls7.clear();
		ls8.clear();

		int a = r -1;
		int b = c -1;
		if (a < 0 || b < 0 ){
			return false;
		}
		while (board[a][b] != EMPTY  && board[a][b] != Othello.whosTurn && a > 0 && b > 0){
			ls7.add(a);
			ls8.add(b);
			a--;
			b--;

		}if (a < r -1 && b < c -1 && ls7.size() > 0 && ls8.size() > 0 && board[a][b] == Othello.whosTurn){


			return true;

		}



		return false;}

	private boolean dLTopBottomSet(){
		ls9.clear();
		ls10.clear();
		int a = rowEntry + 1;
		int b = colEntry -1;
		if (a > dimension-1 || b < 0){
			return false;
		}
		while (board[a][b] != EMPTY  && board[a][b] != Othello.whosTurn && a <dimension-1 && b > 0){
			ls9.add(a);
			ls10.add(b);
			a++;
			b--;

		}if (a > rowEntry && b < colEntry  && ls9.size() > 0 && ls10.size() > 0 && board[a][b] == Othello.whosTurn){
			board[rowEntry][colEntry] = Othello.whosTurn;
			for (int i = 1; i < ls9.size() + 1; i++) {
				for (int j = 1; j < ls10.size() + 1; j++) {
					if (i == j)
						board[rowEntry + i][colEntry -j] = Othello.whosTurn;

				}
			}


			return true;

		}


		return  false;}

	private boolean dLTopBottomCheck(){
		ls9.clear();
		ls10.clear();
		int a = r + 1;
		int b = c -1;
		if (a > dimension-1 || b < 0){
			return false;
		}
		while (board[a][b] != EMPTY  && board[a][b] != Othello.whosTurn && a <dimension-1 && b > 0){
			ls9.add(a);
			ls10.add(b);
			a++;
			b--;

		}if (a > r && b < c  && ls9.size() > 0 && ls10.size() > 0 && board[a][b] == Othello.whosTurn){



			return true;

		}


		return  false;}

	private boolean dLBottomTopCheck(){
		ls11.clear();
		ls12.clear();
		int a = r -1;
		int b = c + 1;
		if (a < 0 || b > dimension-1){
			return false;
		}
		while (board[a][b] != EMPTY && board[a][b] != Othello.whosTurn && a > 0 && b < dimension-1){
			ls11.add(a);
			ls12.add(b);
			a--;
			b++;
		}if (a < r && b > c && ls11.size() > 0 && ls12.size() > 0 && board[a][b] == Othello.whosTurn){


			return true;

		}


		return false;}

	private boolean dLBottomTopSet(){
		ls11.clear();
		ls12.clear();
		int a = rowEntry -1;
		int b = colEntry + 1;
		if (a < 0 || b > dimension-1){
			return false;
		}
		while (board[a][b] != EMPTY && board[a][b] != Othello.whosTurn && a > 0 && b < dimension-1){
			ls11.add(a);
			ls12.add(b);
			a--;
			b++;
		}if (a < rowEntry && b > colEntry && ls11.size() > 0 && ls12.size() > 0 && board[a][b] == Othello.whosTurn){
			board[rowEntry][colEntry] = Othello.whosTurn;

			for (int i = 1; i < ls11.size() + 1; i++) {
				for (int j = 1; j < ls12.size() + 1; j++) {
					if (i == j){
						board[rowEntry -i][colEntry + j] = Othello.whosTurn;
					}
				}
			}
			return true;

		}

		return false;}


	public static int row = 0;
	public static int col = 0;

	public char getValue() {
		if (gameNotFinished()){
			checkValid();
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

			if (rowEntry < 0 || rowEntry > 7 || colEntry < 0 || colEntry > 7){
				System.out.println("Please enter a valid index!");
				System.out.println(writeBoard());
				System.out.println(getValue());
			}

			if (board[rowEntry][colEntry] == EMPTY){
				bottomSet();
				rightSet();
				leftSet();
				topSet();
				dRTopBottomSet();
				dRBottomTopSet();
				dLTopBottomSet();
				dLBottomTopSet();
			}

			if (board[rowEntry][colEntry] ==  Othello.whosTurn){
				System.out.println(Othello.whosTurn + " has played " + "(" + rowEntry + "," + colEntry + ")");
				Othello.changePlayer();
			}

		}
		if (!gameNotFinished()){

			System.out.println("GAME OVER!");
			System.out.println(OthelloBoard.blackPlayer + ":" + blackScore() + " " +OthelloBoard.whitePlayer
					+ ":" +  whiteScore());
			if (blackScore() > whiteScore()){
				System.out.println("The winner is: " + blackPlayer);
			} else if (whiteScore() > blackScore()) {
				System.out.println("The winner is: " + whitePlayer);
			}else {
				System.out.println("It's a Tie!");
			}

		}



		return EMPTY;
	}

}



