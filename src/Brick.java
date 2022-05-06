import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Brick {
	
	static final int WIDTH = 135;
	static final int HEIGHT = 45;
	double x;
	double y;
	private static Game game;
	
	public Brick(double X, double Y, Game game) {
		
		this.x = X;
		this.y = Y;
		this.game = game;
		
	}
	
	public void paint (Graphics2D g) {
		
		g.setColor(Color.PINK);
		g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
		
	}
	
	public static void createBricks(ArrayList<Brick> bricks, Brick brick) {

		int spaceX = 5;
		int spaceY = 5;

		for (int i = 0; i < 0; i++) {

			brick = new Brick(spaceX, spaceY, game);

			bricks.add(brick);

			spaceX += 140;
			
			if (i%5 == 1 && i != 1) {
				
				spaceX = 5;
				spaceY += 50;
				
			}

		}

	}

}
