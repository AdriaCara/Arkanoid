import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Racquet extends JPanel{

	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
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
		
		g.fillRect(x, Y, WIDTH, HEIGHT);
		
	}
	
	public void KeyReleased(KeyEvent e) {
		
		xa = 0;
		
	}
	
	public void KeyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			xa = -2;
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			xa = 2;
			
		}
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(x, Y, WIDTH, HEIGHT);
		
	}
	
	public int getTopY()  {
		
		return Y - HEIGHT;
		
	}
	
}
