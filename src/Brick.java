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
	private static Game game;
	
	public abstract void paint(Graphics2D g);
	public abstract void action(int i);

	public Brick(int lives, double X, double Y, Game game) {

		this.LIVES = lives;
		this.x = X;
		this.y = Y;
		this.game = game;

	}

	public Rectangle getBounds(int i) {

		return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);

	}

	public static void createBricks(ArrayList<Brick> bricks, Brick brick) {

		int PosX = 5;
		int PosY = 5;
		int lives;

		for (int i = 0; i < 50; i++) {

			lives = (int) (Math.random() * 4);

			if (lives >= 3) {

				brick = new BrickRed(PosX, PosY, game);

			} else if (lives == 2) {

				brick = new BrickRed(PosX, PosY, game);

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
