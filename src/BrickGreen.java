import java.awt.Color;
import java.awt.Graphics2D;

public class BrickGreen extends Brick {

	public BrickGreen(double X, double Y, Game game) {
		super(2, X, Y, game, true);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void paint(Graphics2D g) {
		
		g.setColor(Color.GREEN);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		
	}

	@Override
	public void action(int i) {
		
		Game.bricks.remove(i);
		
	}}
