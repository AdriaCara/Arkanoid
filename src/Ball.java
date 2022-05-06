import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball extends JPanel{
	
	private static final int DIAMETER = 30;
	double x = 105;
	double y = 105;
	double xa = 1;
	double ya = 1;
	private Game game;
	
	public Ball(Game game) {
		
		this.game = game;
		
	}

	void move() {
		boolean changeDirection = true;
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
			y = game.racquet.getTopY() - (DIAMETER-5);
			
			if (game.Ballspeed < 4) {
				
				game.Ballspeed += 0.1;
				
			}
			
			if (game.RacquetSpeed < 5.5) {
				
				game.RacquetSpeed += 0.1;
				
			}
		} 
		
		else if ((x + DIAMETER + xa > game.brick.x) 
				&& (x + xa < game.brick.x + Brick.WIDTH) 
				&& (y + DIAMETER > game.brick.y) 
				&& (y < game.brick.y + Brick.HEIGHT)) {
			
			xa *= -1;
		}
		
		else if ((x + DIAMETER > game.brick.x) 
				&& (x < game.brick.x + Brick.WIDTH) 
				&& (y + DIAMETER + ya > game.brick.y) 
				&& (y + ya < game.brick.y + Brick.HEIGHT)) {
			
			ya *= -1;
		}
		else {
			changeDirection = false;
		}
		
		if (changeDirection) {
			Sounds.BallSound.play();
		}
		
		x = x + xa;
		y = y + ya;
	}
	
	private boolean collisionRacquet() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	
	public void paint (Graphics2D g) {
		
		g.setColor(Color.blue);
		g.fillOval((int)x, (int)y, DIAMETER, DIAMETER);
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, DIAMETER, DIAMETER);
		
	}

}