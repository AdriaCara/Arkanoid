import java.awt.Color;
import java.awt.Graphics2D;

public class BrickYellow extends Brick {

	public BrickYellow(int lives, double X, double Y, Game game) {
		super(lives, X, Y, game);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics2D g) {

		g.setColor(Color.YELLOW);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}

}
