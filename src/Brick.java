import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Brick {

	static final int WIDTH = 135;
	static final int HEIGHT = 45;
	int LIVES;
	double x;
	double y;
	private static Game game;

	public Brick(int lives, double X, double Y, Game game) {

		this.LIVES = lives;
		this.x = X;
		this.y = Y;
		this.game = game;

	}

	public void paint(Graphics2D g) {

		setColor(g);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}

	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);

	}

	public static void createBricks(ArrayList<Brick> bricks, Brick brick) {

		int PosX = 5;
		int PosY = 5;
		int lives;

		for (int i = 0; i < 50; i++) {

			lives = (int) (Math.random() * 4);

			if (lives >= 3) {

				lives = 3;

			} else if (lives == 2) {

				lives = 1;

			} else {

				lives = 0;

			}

			brick = new Brick(lives, PosX, PosY, game);

			bricks.add(brick);

			PosX += (WIDTH + 5);

			if ((i + 2)%5 == 1 && 1%(i + 2) == 1) {

				PosX = 5;
				PosY += (HEIGHT + 5);

			}

		}

	}

	public void setColor(Graphics2D g) {

		if (LIVES == 3) {

			g.setColor(Color.green);

		} else if (LIVES == 2) {

			g.setColor(Color.blue);

		} else if (LIVES == 1) {

			g.setColor(Color.ORANGE);

		} else if (LIVES == 0) {

			g.setColor(Color.RED);

		} else if (LIVES > 3) {

			g.setColor(Color.magenta);

		}

	}

}
