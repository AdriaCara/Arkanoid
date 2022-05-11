import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Racquet extends JPanel{

	static int Y;
	private static final int WIDTH = ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 15));
	private static final int HEIGHT = ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 150));
	static int LIVES = 2;
	double x = 0;
	double xa = 0;
	private Game game;
	boolean effectLeft ;
	boolean effectRight;
	boolean menuEscape = false;
	static boolean invertedControls = false;
	
	public Racquet(Game game) {
		
		Y = (((Toolkit.getDefaultToolkit().getScreenSize().height) - HEIGHT) - ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 18)));
		x = (Toolkit.getDefaultToolkit().getScreenSize().width/2/2.5);
		this.game = game;
		
	}
	
	public void move() {
		
		if (x + xa > 0 &&  x + xa < game.getWidth() - WIDTH) {
			
			x = x + xa;
			
		}
		
	}
	
	public void paint(Graphics2D g) {

		setColor(g);
		g.fillRect((int)x, (int)Y, WIDTH, HEIGHT);
		
	}
	
	public void KeyReleased(KeyEvent e) {
		
		xa = 0;
		
		effectLeft = false;
		effectRight = false;		
	}
	
	public void KeyPressed(KeyEvent e) {
		
		if (!invertedControls) {
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				
				xa = -game.RacquetSpeed;
				effectLeft = true;
				
			}
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
				xa = game.RacquetSpeed;
				effectRight = true;
				
			}
			
		} else {
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				
				xa = game.RacquetSpeed;
				effectRight = true;
				
			}
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
				xa = -game.RacquetSpeed;
				effectLeft = true;
				
			}
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			
			if (Game.State == Game.State.GAME) {
				
				Game.State = Game.State.MENUESCAPE;
				menuEscape = true;
				
			} else if (menuEscape) {
				
				menuEscape = false;
				Game.State = Game.State.GAME;
				
			}
			
		}
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, Y, WIDTH, HEIGHT);
		
	}
	
	public int getTopY()  {
		
		return Y - HEIGHT;
		
	}
	
	public boolean RacquetNoHaveLives() {
		
		boolean RacquetNoHaveLives = false;
		
		if (LIVES <= 0) {
			
			RacquetNoHaveLives = true;
			
		}
		
		return RacquetNoHaveLives;
		
	}
	
	public void setColor(Graphics2D g) {
		
		if (LIVES == 2) {
			
			g.setColor(Color.BLUE);
			
		} else if (LIVES == 1) {
			
			g.setColor(Color.ORANGE);
			
		} else if (LIVES == 0) {
			
			g.setColor(Color.RED);
			
		} else if (LIVES == 3) {
			
			g.setColor(Color.MAGENTA);
			
		} else {
			
			g.setColor(Color.BLACK);
			
		}
		
	}
	
}
