import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {
	
	private static final int WIDTH = 120;
	private static final int HEIGHT = 45;
	int x = 100;
	int y = 300;
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
