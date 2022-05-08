import java.awt.Color;
import java.awt.Graphics2D;

public class BrickYellow extends Brick {

	public BrickYellow(double X, double Y, Game game) {
		super(0, X, Y, game);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics2D g) {

		g.setColor(Color.YELLOW);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}

	public void action(int i) {

		Game.bricks.remove(i);
		if (Game.Ballspeed > 30) {

			Game.Ballspeed += 5;

		}
		
		

	}

}
