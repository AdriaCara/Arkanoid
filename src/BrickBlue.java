import java.awt.Color;
import java.awt.Graphics2D;

public class BrickBlue extends Brick {
	
	private Racquet racquet;

	public BrickBlue(double X, double Y, Game game) {
		super(0, X, Y, game, true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics2D g) {

		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}
	
	@Override
	public void action(int i) {
		
		Game.bricks.remove(i);
		
		if (racquet.invertedControls) {
			
			racquet.invertedControls = false;
			
		} else {
			
			racquet.invertedControls = true;
			
		}
		
	}

}
