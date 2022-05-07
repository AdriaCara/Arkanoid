import java.awt.Color;
import java.awt.Graphics2D;

public class BrickYellow extends Brick {

	private Game game;

	public BrickYellow(double X, double Y, Game game) {
		super(0, X, Y, game);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics2D g) {

		g.setColor(Color.YELLOW);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}

	public void action(int i) {

		game.bricks.remove(i);
		if (game.Ballspeed > 30) {
			
			game.Ballspeed += 5;
			
		}
		
		
	}

}
