import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.management.timer.Timer;

public class BrickYellow extends Brick {

	public BrickYellow(double X, double Y, Game game) {
		super(0, X, Y, game, true);
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("YellowBrick.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics2D g) {

		g.setColor(Color.YELLOW);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(imagen, (int)x, (int)y, WIDTH, HEIGHT, null);

	}

	@Override
	public void action(int i) {

		Game.Score += 1;
		Game.bricks.remove(i);

    	Game.RacquetSpeed+= 5;
        	
        Game.RacquetSpeed -= 5;

	}

}
