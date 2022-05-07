import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class BrickRed extends Brick{
	
	private Game game;

	public BrickRed(double X, double Y, Game game) {
		super(3, X, Y, game);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics2D g) {

		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);

	}
	
	public void action(int i) {
		
		if (!(game.bricks.get(i).y >= Toolkit.getDefaultToolkit().getScreenSize().height)) {
			
			game.bricks.remove(i);
			
		}
		
		game.bricks.get(i).y += 1;
	}
	
}
