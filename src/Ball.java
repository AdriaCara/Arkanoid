import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball extends JPanel {

	private static final int DIAMETER = 20;
	double x = Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().width / 2);
	double y = (Toolkit.getDefaultToolkit().getScreenSize().height / 1.5);
	static double xa = 2;
	static double ya = 2;
	boolean down = false;
	boolean onlyLess = false;
	double brickMove = 7;
	private Game game;
	private Brick brick; 

	public Ball(Game game) {

		this.game = game;

	}

	void move() {

		boolean changeDirection = true;
		boolean down = false;

		for (int i = 0; i < game.bricks.size(); i++) {

			if (x + xa < 0) {

				xa = game.Ballspeed;

			}

			else if (x + xa > game.getWidth() - DIAMETER) {

				xa = -game.Ballspeed;

			}

			else if (y + ya < 0) {

				ya = game.Ballspeed;

			}

			else if (y + ya > game.getHeight() - DIAMETER) {

				game.gameOver();
			}

			else if (collisionRacquet()) {

				ya = -game.Ballspeed;
				y = game.racquet.getTopY() - (DIAMETER - 5);
				if (game.racquet.effectLeft) {

					if (xa > 0) {

						xa *= -game.Ballspeed;

					} else {
						
						xa *= game.Ballspeed;
						
					}

				} else if (game.racquet.effectRight) {

					if (xa < 0) {

						xa *= -game.Ballspeed;

					} else {
						
						xa *= game.Ballspeed;
						
					}

				}

				if (game.Ballspeed < 8) {

					game.Ballspeed += 0.1;

				}

				if (game.RacquetSpeed < 8.5) {

					game.RacquetSpeed += 0.1;

				}
				
			}

			else if ((x + DIAMETER + xa > game.bricks.get(i).x) && (x + xa < game.bricks.get(i).x + Brick.WIDTH)
					&& (y + DIAMETER > game.bricks.get(i).y) && (y < game.bricks.get(i).y + Brick.HEIGHT) && game.bricks.get(i).Alive) {

				breakBricks(i, down);

			}

			else if ((x + DIAMETER > game.bricks.get(i).x) && (x < game.bricks.get(i).x + Brick.WIDTH)
					&& (y + DIAMETER + ya > game.bricks.get(i).y) && (y + ya < game.bricks.get(i).y + Brick.HEIGHT) && game.bricks.get(i).Alive) {

				down = true;
				breakBricks(i, down);

			} else {

				changeDirection = false;
			}

			if (changeDirection) {

				Sounds.BallSound.play();
			}

		}
		
		for (int i = 0; i < game.bricks.size(); i++) {
			
			if (game.racquet.getBounds().intersects(game.bricks.get(i).getBounds())) {
				
				onlyLess = true;
				game.bricks.remove(i);
				game.gameOver();
				
			}
			
			if (!(game.bricks.get(i).Alive)) {
				
				game.bricks.get(i).y += brickMove;
				
				if (Game.bricks.get(i).y > game.racquet.Y) {
					
					Game.bricks.remove(i);
					
				}
				
			}
			
		}

		x = x + xa;
		y = y + ya;

		game.win();
	}

	private void breakBricks(int i, boolean down) {

		if (down && game.bricks.get(i).Alive) {
			
			ya *= -1;
			
		} else {
			
			xa *= -1;
			
		}
		Sounds.BallSound.play();
		if (game.bricks.get(i).Alive) {
			
			if (game.bricks.get(i).LIVES <= 0) {

				game.bricks.get(i).action(i);
				game.Score += 1;

			} else {

				game.bricks.get(i).LIVES--;

			}
			
		}

	}

	private boolean collisionRacquet() {
		
		return game.racquet.getBounds().intersects(getBounds());

	}

	public void paint(Graphics2D g) {

		game.racquet.setColor(g);
		g.fillOval((int) x, (int) y, DIAMETER, DIAMETER);

	}

	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, DIAMETER, DIAMETER);

	}

}