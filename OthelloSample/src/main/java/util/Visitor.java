	package util;

import othello.model.Othello;
import othello.model.OthelloBoard;

public interface Visitor {
	
	public void visit(Othello othello);
	
	public void visit(OthelloBoard ob);
	
	public void visit(char[][] board);
	
}
