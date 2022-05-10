import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Brick {

	static final int WIDTH = 112;
	static final int HEIGHT = 35;
	int LIVES;
	double x;
	double y;
	boolean Alive = true;
	protected BufferedImage imagen;
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
		int percentage;

		for (int i = 0; i < 54; i++) {

			percentage = (int) (Math.random() * 100);

			if (game.level == 0) {
				
				if (percentage >= 60) {
					
					brick = new BrickGreen(PosX, PosY, game);
					
				} else if ((percentage < 60) && (percentage >= 30)) {

					brick = new BrickRed(PosX, PosY, game);

				} else if ((percentage < 30) && (percentage >= 1)) {

					brick = new BrickYellow(PosX, PosY, game);

				} else {
					
					brick = new BrickMagenta(PosX, PosY, game);
					
				}
				
			} else {
				
				if (percentage >= 70) {
					
					brick = new BrickGreen(PosX, PosY, game);
					
				} else if ((percentage < 70) && (percentage >= 40)) {

					brick = new BrickRed(PosX, PosY, game);

				} else if ((percentage < 40) && (percentage >= 10)) {

					brick = new BrickYellow(PosX, PosY, game);

				} else if ((percentage < 10) && (percentage >= 1)) {
					
					brick = new BrickBlue(PosX, PosY, game);
					
				} else {
					
					brick = new BrickMagenta(PosX, PosY, game);
					
				}
				
			}
			
			brick = new BrickGreen(PosX, PosY, game);
			
			bricks.add(brick);

			PosX += (WIDTH + 5);

			if ((i + 2)%6 == 1 && 1%(i + 2) == 1) {

				PosX = 5;
				PosY += (HEIGHT + 5);

			}

		}

	}

}
