import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Game extends JPanel{
	
	static Ball ball = new Ball();
	
	private void move() {
		
		ball.moveBall();
		
	}
	
	public static void StartGame() throws InterruptedException {
		
		JFrame frame = new JFrame("Arkanoid");
		frame.add(ball);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			
			ball.moveBall();
			ball.repaint();
			Thread.sleep(5);
			
		}
		
	}

}
