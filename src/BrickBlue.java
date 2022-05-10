import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BrickBlue extends Brick {

	private Racquet racquet;
	
	public BrickBlue(double X, double Y, Game game) {
		super(0, X, Y, game, true);
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("BlueBrick.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics2D g) {

		g.setColor(Color.BLUE);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(imagen, (int)x, (int)y, WIDTH, HEIGHT, null);

	}
	
	@Override
	public void action(int i) {
		
		Game.Score += 1;
		Game.bricks.remove(i);
        
		if (racquet.invertedControls) {

			racquet.invertedControls = false;

		} else {

			racquet.invertedControls = true;

		}
		
	}

}
