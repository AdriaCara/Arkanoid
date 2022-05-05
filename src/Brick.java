import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {
	
	private static final int WIDTH = 120;
	private static final int HEIGHT = 45;
	int x = 300;
	int y = 200;
	private int lives;
	private Game game;
	
	public Brick(Game game) {
		
		this.game = game;
		
	}
	
	public void paint (Graphics2D g) {
		
		g.setColor(Color.PINK);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
		
	}
	
	public int getTopY()  {
		
		return y - HEIGHT;
		
	}
	public int getBottomY()  {
		
		return y + HEIGHT;
		
	}
	
	public int getRigthX()  {
		
		return x - WIDTH;
		
	}
	public int getLeftX()  {
		
		return x + WIDTH;
		
	}

}
