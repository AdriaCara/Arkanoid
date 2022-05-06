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
	Brick brick = new Brick(this);
	double Ballspeed = 2;
	double RacquetSpeed = 2.5;
	int Score = 0;
	
	private int getScore() {
		
		return Score;
		
	}
	
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
		Sounds.BgSound.loop();
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
		brick.paint(g2d);
		
		
		g2d.setColor(Color.red);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}
	
	public void gameOver() {
		
		Sounds.BgSound.stop();
		Sounds.GameOverSound.play();
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
		
	}
	
	public static void StartGame() throws InterruptedException {
		
		int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
		int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		JFrame frame = new JFrame("Arkanoid");
		Game game = new Game();
		frame.add(game);
		frame.setBounds(WIDTH/2, HEIGHT, WIDTH/2, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			
			game.move();
			game.repaint();
			Thread.sleep(10);
			
		}
		
	}

}
