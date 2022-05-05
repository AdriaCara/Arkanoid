import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {
	
	private static final int WIDTH = 100;
	private static final int HEIGHT = 10;
	int x = 10;
	int y = 10;
	private int width;
	private int PosHeight;
	private int lives;
	private int colaider;
	private Game game;
	
	public Brick(Game game) {
		
		this.game = game;
		
	}
	
	public void paint (Graphics2D g) {
		
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}

}
