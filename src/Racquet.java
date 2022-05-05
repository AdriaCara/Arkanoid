import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Racquet extends JPanel{

	private static final double Y = 550;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 15;
	double x = 0;
	double xa = 0;
	private Game game;
	
	public Racquet(Game game) {
		
		this.game = game;
		
	}
	
	public void move() {
		
		if (x + xa > 0 &&  x + xa < game.getWidth() - WIDTH) {
			
			x = x + xa;
			
		}
		
	}
	
	public void paint(Graphics2D g) {
		
		g.setColor(Color.black);
		g.fillRect((int)x, (int)Y, WIDTH, HEIGHT);
		
	}
	
	public void KeyReleased(KeyEvent e) {
		
		xa = 0;
		
	}
	
	public void KeyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			xa = -game.RacquetSpeed;
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			xa = game.RacquetSpeed;
			
		}
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)Y, WIDTH, HEIGHT);
		
	}
	
	public int getTopY()  {
		
		return (int)Y - HEIGHT;
		
	}
	
}
