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
		
		if (x + xa < 0){
			
			xa = game.Ballspeed;
			
		} else if (x + xa > game.getWidth() - DIAMETER) {
			
			xa = -game.Ballspeed;
			
		} else if (y + ya < 0) {
			
			ya = game.Ballspeed;
			
		} else if (y + ya > game.getHeight() - DIAMETER)  {
			
			game.gameOver();
			
		} else if (collision()) {
			
			game.Ballspeed += 0.1;
			game.RacquetSpeed += 0.1;
			
		} else {
			
			changeDirection = false;
			
		}
		
		if (changeDirection) {
			
			Sounds.BallSound.play();
			
		}
		
		x = x + xa;
		y = y + ya;
		
	}
	
	private boolean collision() {
		
		boolean collision = false;
		
		if (collision = game.racquet.getBounds().intersects(getBounds())) {
			
			collision = game.racquet.getBounds().intersects(getBounds());
			y = game.racquet.getTopY() - (DIAMETER - 7);
			
			ya = -game.Ballspeed;
			
		} else if (collision =  game.brick.getBounds().intersects(getBounds())) {
			
			collision =  game.brick.getBounds().intersects(getBounds());
			
			if (game.brick.y < game.ball.y) {
				
				y = game.brick.getTopY() - (DIAMETER - 40);
				ya = -game.Ballspeed;
				
			}
			
			if (game.brick.y > game.ball.y) {
				
				y = game.brick.getBottomY() + (DIAMETER + 40);
				ya = game.Ballspeed;
				
			}
			
			if (game.brick.y > game.ball.y) {
				
				x = game.brick.getRigthX() - (DIAMETER - 40);
				xa = -game.Ballspeed;
				
			}
			
			if (game.brick.x < game.ball.x) {
				
				x = game.brick.getLeftX() + (DIAMETER + 40);
				xa = game.Ballspeed;
				
			}
			
		}
		
		return collision;
		
	}
	
	public void paint (Graphics2D g) {
		
		g.setColor(Color.blue);
		g.fillOval((int)x, (int)y, DIAMETER, DIAMETER);
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, DIAMETER, DIAMETER);
		
	}

}