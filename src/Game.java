import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Game extends JPanel{
	
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	
	public void moveBall() {
		
		if (x + xa < 0) {
			
			xa = 1;
			
		}
		if (x + xa > getWidth() - 30) {
			
			xa = -1;
			
		}
		
		if (y + ya < 0) {
			
			ya = 1;
			
		}
		if (y + ya > getHeight() - 30) {
			
			ya = -1;
			
		}
		
		x = x + xa;
		y = y + ya;
		
	}
	
	@Override
	public void paint (Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.fillOval(x, y, 30, 30);
		
	}

}
