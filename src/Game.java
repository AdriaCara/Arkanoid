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

	//Declare zone.
	Ball ball = new Ball(this); //Object Ball.
	Racquet racquet = new Racquet(this); //Object Racquet.
	static double Ballspeed = 4; //Set the ball Speed to 4;
	static double RacquetSpeed = 6; //Set the ball Speed to 6;
	static int Score = 0; //Set the Score to 0.
	static int level = 0; //Set the Level to 0.
	String user; //User name.
	static ArrayList<Brick> bricks = new ArrayList<Brick>();// Array of bricks.
	static Brick brick; //Object Brick.
	static boolean quit = false; //Set control of quit botton of the pause menu.
	private boolean dead = false; //Set dead control.
	private Menu menu = new Menu(); //Object Menu.
	private MenuEscape menuEscape = new MenuEscape(); //Object Menu when the game are paused.
	private HowToPlay howToPlay = new HowToPlay(); //Object option menu that shows how to play.
	private GameScore datos = new GameScore("Scores.json");
	public static STATE State = STATE.MENU; //Object menu.

	//Get the Score.
	private int getScore() {

		return Score;

	}

	//Get the keyboard action.
	public Game() {
		
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
		Sounds.BgSound.loop(); //Sound of the game.
		
	}

	//Move All.
	private void move() throws InterruptedException {

		//Move if Game is the state of the game, else move racquet if state is menuscape.
		if(State == STATE.GAME) {
			
			//If player lost 1 life then Game 1s sleep.
			if (dead) {
				
				dead = false;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			ball.move();
			racquet.move();
			
		} else if (State == STATE.MENUESCAPE) {
			
			//If the racquet width is largest than the half of the original racquet width.
			if (racquet.WIDTH > ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 12.9)) / 2)) {
				
				racquet.move();
				//If the racquet is moving then lost a little part of his width.
				if (racquet.effectLeft || racquet.effectRight) {
					
					racquet.WIDTH -= ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 1000000000)));
					
				}
				
			}
			
		}

	}

	//Paint.
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);

		//If th Game state is game then print all the objects:
		/* * * * * * * * 
		 * 
		 * Background
		 * Score
		 * Ball
		 * Racquet
		 * Brick's
		 * 
		 * * * * * * * */
		
		//If the Game state is menu then print the menu.
		
		//If the Game state is menuescape then print all objects but not thw score:
		/* * * * * * * *
		 * 
		 * Background
		 * Ball
		 * Racquet
		 * Brick's
		 * Menu
		 * 
		 * * * * * * * */
		if(State == STATE.GAME) {
			
			
			setBackground(new Color(0,0,0));
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("arial", Font.BOLD, (int) (Toolkit.getDefaultToolkit().getScreenSize().width / 10)));
			g2d.drawString("( " + getScore() + " )", (int) (Toolkit.getDefaultToolkit().getScreenSize().width / 6), (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 1.5));
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			ball.paint(g2d);
			racquet.paint(g2d);
			for (int i = 0; i < bricks.size(); i++) {

				bricks.get(i).paint(g2d);

			}
			
		} else if (State == STATE.MENU) {
			
			setBackground(new Color(0,0,0));
			menu.render(g);
			
		} else if (State == STATE.MENUESCAPE){
			
			setBackground(new Color(0,0,0));
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("arial", Font.BOLD, (int) (Toolkit.getDefaultToolkit().getScreenSize().width / 10)));
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			ball.paint(g2d);
			racquet.paint(g2d);
			for (int i = 0; i < bricks.size(); i++) {

				bricks.get(i).paint(g2d);

			}
			menuEscape.render(g);
			
		} else if (State == STATE.HOWTOPLAY) {
			
			setBackground(new Color(50,65,74));
			howToPlay.render(g);
			
		} else if (State == STATE.GAMESCORE) {
			
			setBackground(new Color(50,65,74));
			render(g);
			
		}
	}

	//Game over.
	public void gameOver() {

		//If ball only less one live.
		if (ball.onlyLess) {

			racquet.LIVES -= racquet.LIVES;

		}

		//If the racquet no have lifes then throw game over or reset the position of the ball and the racquet.
		if (racquet.RacquetNoHaveLives()) {

			Sounds.GameOverSound.play();
			user = JOptionPane.showInputDialog("Nombre Jugador Puntos: " + getScore());
			State = State.GAMESCORE;
			racquet.LIVES = 3;

		} else {

			racquet.x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 / 2.4;

			ball.x = (Toolkit.getDefaultToolkit().getScreenSize().width / 7);
			ball.y = (Toolkit.getDefaultToolkit().getScreenSize().height / 1.5);
			if (ball.xa < 0) {

				ball.xa *= -1;

			}
			
			dead = true;

		}

	}

	//Win.
	public void win() {

		//If there are less or 0 brick's or quit then level increments, generates new brick's, reset the ball and racquet.  
		if (bricks.size() <= 0 || quit) {
			
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
			quit = false;

		}
		
	}
	
	//Sate.
	public enum STATE {
		
		MENU,
		GAME,
		MENUESCAPE,
		HOWTOPLAY,
		GAMESCORE
		
	}

	//Game, generates brick's, generates the game size, the color, the fixed size.
	public static void StartGame() throws InterruptedException {

		Brick.createBricks(bricks, brick);
		int WIDTH = (Toolkit.getDefaultToolkit().getScreenSize().width / 2);
		int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - (Toolkit.getDefaultToolkit().getScreenSize().height / 10);
		
		Game game = new Game();

		JFrame gameFrame = new JFrame("Arkanoid");
		gameFrame.add(game);
		gameFrame.setBounds(WIDTH, HEIGHT, WIDTH, HEIGHT);
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
	
	public void render(Graphics g) {
		
		double y = 3.1;
		
		Font fontTitle = new Font("arial", Font.BOLD, 50);
		g.setFont(fontTitle);
		g.setColor(Color.WHITE);
		g.drawString("Puntuación Global", (WIDTH / 2) + (Toolkit.getDefaultToolkit().getScreenSize().width / 9), HEIGHT + 50);
		
		String[] names = datos.getNames();
		for (int i = 0; i < names.length; i++) {
			
			String nom = names[i];
			int score = datos.getScore(nom);
			String scoreString = Integer.toString(score);
			
			g.drawString(nom, (int)(WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 9)), (int)(HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / y)));
			g.drawString(scoreString, (int)(WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 3)), (int)(HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / y)));
			
			y += y - 2;
			
		}		

	}

}
