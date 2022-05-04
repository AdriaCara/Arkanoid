import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball extends JPanel{
	
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
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
			
			ya = -game.Ballspeed;
			y = game.racquet.getTopY() - DIAMETER;
			
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
		
		return game.racquet.getBounds().intersects(getBounds());
		
	}
	
	public void paint (Graphics2D g) {
		
		g.fillOval(x, y, DIAMETER, DIAMETER);
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, DIAMETER, DIAMETER);
		
	}

}