import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Racquet extends JPanel{

	//Declare zone
	static int Y; //The y position
	static int WIDTH = (int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 12.9)); //Set the Width.
	private static final int HEIGHT = ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 150)); //Set the Height.
	static int LIVES = 3; //Set the lifes.
	static double x = 0; //Set the x position.
	private int currentKeyCode; //
	double xa = 0; //Set the moviment.
	private Game game; //Object Game.
	boolean effectLeft ; //Look if the racquet have an left effect.
	boolean effectRight; //Look if the racquet have an right effect.
	static boolean menuEscape = false; //Check if the escape is pressed.
	static boolean invertedControls = false; //Check if the controls are inverted.
	
	//Racquet constructor.
	public Racquet(Game game) {
		
		Y = (int) (((Toolkit.getDefaultToolkit().getScreenSize().height / 10) - HEIGHT) - (Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 1.35));
		x = (Toolkit.getDefaultToolkit().getScreenSize().width/2/2.4);
		this.game = game;
		
	}
	
	//Move of the racquet.
	public void move() {
		
		if (x + xa > 0 &&  x + xa < game.getWidth() - WIDTH) {
			
			x = x + xa;
			
		}
		
	}
	
	//Pain racquet.
	public void paint(Graphics2D g) {

		setColor(g);
		g.fillRect((int)x, (int)Y, WIDTH, HEIGHT);
		
	}
	
	//Key relesed (Right Left) and the right and left effect false.
	public void KeyReleased(KeyEvent e) {
		
		xa = 0;
		
		effectLeft = false;
		effectRight = false;		
	}
	
	//Key release(set moviment = 0).
	public void keyRelease(KeyEvent e) {
		
		if (e.getExtendedKeyCode() == currentKeyCode) xa = 0; 
		
	}
	
	//Key pressed.
	public void KeyPressed(KeyEvent e) {
		
		currentKeyCode = e.getKeyCode();
		
		//Check if the controls aren't inverted, else.
		if (!invertedControls) {
			
			//If keypressed is LEFT then racquetSpeed is negative and left effect true.
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				
				xa = -game.RacquetSpeed;
				effectLeft = true;
				
			}
			
			//If keypressed is LEFT then racquetSpeed is positive and Right effect true.
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
				xa = game.RacquetSpeed;
				effectRight = true;
				
			}
			
		} else {
			
			//If keypressed is LEFT then racquetSpeed is negative and left effect true.
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				
				xa = game.RacquetSpeed;
				effectRight = true;
				
			}
			
			//If keypressed is LEFT then racquetSpeed is positive and Right effect true.
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
				xa = -game.RacquetSpeed;
				effectLeft = true;
				
			}
			
		}
		
		//If keypressed is ESCAPE.
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			
			//If Game state is game then set game state to menuEscape and menuEscape true, else if menuEscape is true then change to false and change menu state to game.
			if (Game.State == Game.State.GAME) {
				
				Game.State = Game.State.MENUESCAPE;
				menuEscape = true;
				
			} else if (menuEscape) {
				
				menuEscape = false;
				Game.State = Game.State.GAME;
				
			}
			
		}
		
	}
	
	//The size of the racquet.
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)Y, WIDTH, HEIGHT);
		
	}
	
	//Get the y position of the racquet.
	public int getTopY()  {
		
		return Y - HEIGHT;
		
	}
	
	//Return bollean if the racquet have lifes or not.
	public boolean RacquetNoHaveLives() {
		
		boolean RacquetNoHaveLives = false;
		
		//If the racquet have less or 0 lifes then return true.
		if (LIVES <= 0) {
			
			RacquetNoHaveLives = true;
			
		}
		
		return RacquetNoHaveLives;
		
	}
	
	//Set the racquet color.
	public void setColor(Graphics2D g) {
		
		//If racquet have - color
		/*
		 * 
		 * +4
		 * 3
		 * 2
		 * 1
		 * -0
		 * 
		 * */
		if (LIVES >= 4) {
			
			g.setColor(Color.MAGENTA);
			
		} else if (LIVES == 3) {
			
			g.setColor(Color.BLUE);
			
		} else if (LIVES == 2) {
			
			g.setColor(Color.ORANGE);
			
		} else if (LIVES == 1) {
			
			g.setColor(Color.RED);
			
		}  else {
			
			g.setColor(Color.BLACK);
			
		}
		
	}
	
}
