import java.awt.Color;
import java.awt.Graphics2D;

public class BrickBlue extends Brick {
	
	private Racquet racquet;

	public BrickBlue(double X, double Y, Game game) {
		super(0, X, Y, game);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics2D g) {

		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}
	
	@SuppressWarnings("static-access")
	public void action(int i) throws InterruptedException {
		
		Game.bricks.remove(i);
		racquet.invertedControls = true;
		
		Thread.sleep(2000);
		
		racquet.invertedControls = false;
	}

}
