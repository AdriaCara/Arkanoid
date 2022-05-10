import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.management.timer.Timer;

public class BrickMagenta extends Brick {

	private Racquet racquet;

	public BrickMagenta(double X, double Y, Game game) {
		super(1, X, Y, game, true);
		try {
			
			imagen = ImageIO.read(BrickBlue.class.getResource("MagentaBrick2lifes.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics2D g) {
			
		try {
			if (LIVES == 0) {
				
				imagen = ImageIO.read(BrickBlue.class.getResource("MagentaBrick1lifes.png"));
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		g.setColor(Color.MAGENTA);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(imagen, (int)x, (int)y, WIDTH, HEIGHT, null);

	}

	@Override
	public void action(int i) {

		Game.Score += 2;
		Game.bricks.remove(i);
		if (racquet.LIVES <= 2) {
			
			Racquet.LIVES ++;
			
		}

	}

}