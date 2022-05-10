import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;

public class BrickRed extends Brick{

	public BrickRed(double X, double Y, Game game) {
		super(1, X, Y, game, true);
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("RedBrick2lifes.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paint(Graphics2D g) {
		
		try {
			
			if (LIVES == 0) {
				
				imagen = ImageIO.read(BrickBlue.class.getResource("RedBrick1life.png"));
				
			} else if (!Alive) {
				
				imagen = ImageIO.read(BrickBlue.class.getResource("RedBrick0life.png"));
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.setColor(Color.RED);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(imagen, (int)x, (int)y, WIDTH, HEIGHT, null);

	}
	
	@Override
	public void action(int i) {
		
		Game.Score += 2;
		Alive = false;
		
	}
	
}
