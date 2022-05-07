import java.awt.Color;
import java.awt.Graphics2D;

public class BrickBlue extends Brick {

	public BrickBlue(int lives, double X, double Y, Game game) {
		super(lives, X, Y, game);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics2D g) {

		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}
	
	public void action() {
		
		
		
	}

}
