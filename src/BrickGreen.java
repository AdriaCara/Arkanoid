import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BrickGreen extends Brick {

	public BrickGreen(double X, double Y, Game game) {
		super(3, X, Y, game, true);
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("GreenBrick3lifes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void paint(Graphics2D g) {
		
		try {
			
			if (LIVES == 2) {
				
				imagen = ImageIO.read(BrickBlue.class.getResource("GreenBrick2lifes.png"));
				
			} else if (LIVES == 1) {
				
				imagen = ImageIO.read(BrickBlue.class.getResource("GreenBrick1life.png"));
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.setColor(Color.GREEN);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(imagen, (int)x, (int)y, WIDTH, HEIGHT, null);
		
	}

	@Override
	public void action(int i) {
		
		Game.Score += 3;
		Game.bricks.remove(i);
		
	}}
