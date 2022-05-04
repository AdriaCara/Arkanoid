import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Game extends JPanel{
	
	Ball ball = new Ball(this);
	Racquet racquet =  new Racquet(this);
	
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.KeyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.KeyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		
		ball.move();
		racquet.move();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
	}
	
	public void gameOver() {
		
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
		
	}
	
	public static void StartGame() throws InterruptedException {
		
		JFrame frame = new JFrame("Arkanoid");
		Game game = new Game();
		frame.add(game);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			
			game.move();
			game.repaint();
			Thread.sleep(10);
			
		}
		
	}

}
