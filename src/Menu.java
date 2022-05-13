import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Menu {

	public Rectangle playButton = new Rectangle(	(int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.6)), (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 3)), (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 14)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
	public Rectangle howToPlayButton = new Rectangle((int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5.5)), (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.7)), (int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.5)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
	public Rectangle quitButton = new Rectangle(	(int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.5)), (int) (Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.2)), (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 17)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font fontTitle = new Font("arial", Font.BOLD, 50);
		g.setFont(fontTitle);
		g.setColor(Color.WHITE);
		g.drawString("ARKANOID", (Game.WIDTH / 2) + (Toolkit.getDefaultToolkit().getScreenSize().width / 6), Toolkit.getDefaultToolkit().getScreenSize().width / 25);
		
		Font fontButton = new Font("arial", Font.BOLD, 30);
		g.setFont(fontButton);
		g.drawString("Jugar", (playButton.x + (Toolkit.getDefaultToolkit().getScreenSize().width / 150)), ((int) (playButton.y + (Toolkit.getDefaultToolkit().getScreenSize().height / 30))));
		g2d.draw(playButton);
		g.drawString("�Como jugar?", (howToPlayButton.x + (Toolkit.getDefaultToolkit().getScreenSize().width / 160)), ((int) (howToPlayButton.y + (Toolkit.getDefaultToolkit().getScreenSize().height / 30))));
		g2d.draw(howToPlayButton);
		g.drawString("Salir", quitButton.x + (Toolkit.getDefaultToolkit().getScreenSize().width / 150), ((int) (quitButton.y + (Toolkit.getDefaultToolkit().getScreenSize().height / 28))));
		g2d.draw(quitButton);
		
	}
	
}
