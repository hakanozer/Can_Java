package othello.viewcontroller;

import javafx.scene.control.Label;
import util.*;
import othello.model.*;

public class WhosNextLabel extends Label implements Observer {
	
	public WhosNextLabel(String s) {
		super(s);
	}
	
	public void update(Observable o) {
		char player = ((Othello)o).getWhosTurn();
		
		if (player == OthelloBoard.P1) {
			this.setText("Player 1's Turn");
		}
		else if (player == OthelloBoard.P2) {
			this.setText("Player 2's Turn");
		}
		else {
			this.setText("Game Over!");
		}
		
	}
	
	
}
