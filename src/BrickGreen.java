import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BrickGreen extends Brick {

	public BrickGreen(double X, double Y, Game game) {
		super(2, X, Y, game, true);
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("GreenBrick3lifes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void paint(Graphics2D g) {
		
		g.setColor(Color.GREEN);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(imagen, (int)x, (int)y, WIDTH, HEIGHT, null);
		
	}

	@Override
	public void action(int i) {
		
		Game.bricks.remove(i);
		
	}}
