import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.text.BreakIterator;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	static double Ballspeed = 4;
	static double RacquetSpeed = 6;
	static int Score = 0;
	static int level = 0;
	static ArrayList<Brick> bricks = new ArrayList<Brick>();
	static Brick brick;
	private Menu menu = new Menu();
	private MenuEscape menuEscape = new MenuEscape();
	private HowToPlay howToPlay = new HowToPlay();
	public static STATE State = STATE.MENU;

	private int getScore() {

		return Score;

	}

	public Game() {

		setBackground(new Color(0,0,0));
		
		this.addMouseListener(new MouseInput());
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

	private void move() throws InterruptedException {

		if(State == STATE.GAME) {
			
			ball.move();
			racquet.move();
			
		}

	}

	@Override
	public void paint(Graphics g) {

		if(State == STATE.GAME) {
			
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			ball.paint(g2d);
			racquet.paint(g2d);
			for (int i = 0; i < bricks.size(); i++) {

				bricks.get(i).paint(g2d);

			}

			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("Verdana", Font.BOLD, 30));
			g2d.drawString(String.valueOf(getScore()), 10, 30);
			
		} else if (State == STATE.MENU) {
			
			menu.render(g);
			
		} else if (State == STATE.MENUESCAPE){
			
			menuEscape.render(g);
			
		}
	}

	public void gameOver() {

		if (ball.onlyLess) {

			racquet.LIVES -= racquet.LIVES;

		}

		if (racquet.RacquetNoHaveLives()) {

			Sounds.BgSound.stop();
			Sounds.GameOverSound.play();
			JOptionPane.showMessageDialog(this, "your score is: " + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
			System.exit(ABORT);

		} else {

			racquet.LIVES -= 1;
			racquet.x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 / 2.5;

			ball.x = (Toolkit.getDefaultToolkit().getScreenSize().width / 10);
			ball.y = (Toolkit.getDefaultToolkit().getScreenSize().height / 1.5);
			if (ball.xa < 0) {

				ball.xa *= -1;

			}

		}

	}

	public void win() {

		if (bricks.size() <= 0) {

			if (level == 0) {

				level++;
				Brick.createBricks(bricks, brick);

				racquet.x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 / 2.5;

				ball.x = (Toolkit.getDefaultToolkit().getScreenSize().width / 15);
				ball.y = (Toolkit.getDefaultToolkit().getScreenSize().height / 1.5);
				if (ball.xa < 0) {

					ball.xa *= -1;

				}
				if (ball.ya < 0) {
					
					ball.ya *= -1;
					
				}

			} else {

				Sounds.BgSound.stop();
				JOptionPane.showMessageDialog(this, "Well done! your Score is: " + getScore(), "GG",
						JOptionPane.YES_NO_OPTION);
				System.exit(ABORT);

			}

		}
	}
	
	public enum STATE {
		
		MENU,
		GAME,
		MENUESCAPE,
		HOWTOPLAY
		
	}

	public static void StartGame() throws InterruptedException {

		Brick.createBricks(bricks, brick);
		int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
		int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - (Toolkit.getDefaultToolkit().getScreenSize().height / 10);
		
		Game game = new Game();

		JFrame gameFrame = new JFrame("Arkanoid");
		gameFrame.add(game);
		gameFrame.setBounds(WIDTH / 2, HEIGHT, WIDTH / 2, HEIGHT);
		gameFrame.setForeground(Color.MAGENTA);
		gameFrame.setBackground(Color.BLACK);
		gameFrame.setResizable(false);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
				
				game.move();
				game.repaint();
				Thread.sleep(10);

		}

	}

}
