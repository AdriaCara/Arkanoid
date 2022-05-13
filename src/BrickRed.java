import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;

public class BrickRed extends Brick{

	public BrickRed(double X, double Y, Game game) {
		super(2, X, Y, game, true);
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("RedBrick2lifes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paint(Graphics2D g) {
		
		try {
			
			if (LIVES == 1) {
				
				imagen = ImageIO.read(BrickBlue.class.getResource("RedBrick1life.png"));
				
			} else if (LIVES <= 0 && Alive) {
				
				imagen = ImageIO.read(BrickBlue.class.getResource("RedBrick0life.png"));
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.setColor(Color.RED);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(imagen, (int)x, (int)y, WIDTH, HEIGHT, null);

	}
	
	@Override
	public void action(int i) {

		new Thread(new Runnable() {
			public void run() {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				Alive = false;
				
				for (int i = 2; i < 9; i++) {
					
					System.out.println(i);
					
					try {
						imagen = ImageIO.read(BrickBlue.class.getResource("RedBrick0lifse_" + i + "fase.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (i == 8) {
						
						i = 2;
						
					}
					
					if (y > Racquet.Y) {
						
						i = 100;
						
					}
					
				}
				
				Game.Score += 2;

			}
		}).start();
		
	}
	
}
