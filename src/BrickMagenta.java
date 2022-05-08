import java.awt.Color;
import java.awt.Graphics2D;
import java.util.TimerTask;

import javax.management.timer.Timer;

public class BrickMagenta extends Brick {

	private Racquet racquet;

	public BrickMagenta(double X, double Y, Game game) {
		super(1, X, Y, game, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {

		g.setColor(Color.MAGENTA);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}

	@Override
	public void action(int i) {

		Game.bricks.remove(i);
		if (racquet.LIVES <= 2) {
			
			Racquet.LIVES ++;
			
		}

	}

}