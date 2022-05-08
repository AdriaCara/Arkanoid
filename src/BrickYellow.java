import java.awt.Color;
import java.awt.Graphics2D;
import java.util.TimerTask;

import javax.management.timer.Timer;

public class BrickYellow extends Brick {

	public BrickYellow(double X, double Y, Game game) {
		super(0, X, Y, game, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics2D g) {

		g.setColor(Color.YELLOW);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}

	@Override
	public void action(int i) {

		Game.bricks.remove(i);

    	Game.Ballspeed += 5;
        	
        Game.Ballspeed -= 5;
        	



	}

}
