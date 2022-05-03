import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Racquet extends JPanel{

	int x = 0;
	int xa = 0;
	private Game game;
	
	public Racquet(Game game) {
		
		this.game = game;
		
	}
	
	public void move() {
		
		if (x + xa > 0 &&  x + xa < game.getWidth() - 60) {
			
			x = x + xa;
			
		}
		
	}
	
	public void paint(Graphics2D g) {
		
		g.fillRect(x, 330, 60, 10);
		
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
	
}
