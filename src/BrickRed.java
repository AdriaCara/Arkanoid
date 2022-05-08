import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class BrickRed extends Brick{

	public BrickRed(double X, double Y, Game game) {
		super(1, X, Y, game, true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics2D g) {

		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}
	
	@Override
	public void action(int i) {
		
		Alive = false;
		
	}
	
}
