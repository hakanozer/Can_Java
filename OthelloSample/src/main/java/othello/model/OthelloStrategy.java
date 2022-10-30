package othello.model;

public interface OthelloStrategy {
	public void move();
	public Move getLatest();
}
