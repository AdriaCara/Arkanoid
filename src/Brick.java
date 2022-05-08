import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Brick {

	static final int WIDTH = 135;
	static final int HEIGHT = 45;
	int LIVES;
	double x;
	double y;
	boolean Alive = true;
	private static Game game;
	
	public abstract void paint(Graphics2D g);
	public abstract void action(int i);

	public Brick(int lives, double X, double Y, Game game, boolean alive) {

		this.LIVES = lives;
		this.x = X;
		this.y = Y;
		this.Alive = alive;
		this.game = game;

	}

	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);

	}

	public static void createBricks(ArrayList<Brick> bricks, Brick brick) {

		int PosX = 5;
		int PosY = 5;
		int lives;

		for (int i = 0; i < 50; i++) {

			lives = (int) (Math.random() * 5);

			if (lives >= 4) {
				
				brick = new BrickGreen(PosX, PosY, game);
				
			} else if (lives >= 3) {

				brick = new BrickYellow(PosX, PosY, game);

			} else if (lives == 2) {

				brick = new BrickBlue(PosX, PosY, game);

			} else {

				brick = new BrickRed(PosX, PosY, game);

			}

			bricks.add(brick);

			PosX += (WIDTH + 5);

			if ((i + 2)%5 == 1 && 1%(i + 2) == 1) {

				PosX = 5;
				PosY += (HEIGHT + 5);

			}

		}

	}

}
