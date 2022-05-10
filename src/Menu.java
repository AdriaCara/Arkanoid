import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {

	public Rectangle playButton = new Rectangle(	Game.WIDTH / 2 + 100, 150, 100, 50);
	public Rectangle howToPlayButton = new Rectangle(Game.WIDTH / 2 + 100, 250, 215, 50);
	public Rectangle quitButton = new Rectangle(	Game.WIDTH / 2 + 100, 350, 100, 50);
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font fontTitle = new Font("arial", Font.BOLD, 50);
		g.setFont(fontTitle);
		g.setColor(Color.WHITE);
		g.drawString("ARKANOID", Game.WIDTH / 2 + 200, Game.HEIGHT + 50);
		
		Font fontButton = new Font("arial", Font.BOLD, 30);
		g.setFont(fontButton);
		g.drawString("Jugar", playButton.x + 8, playButton.y + 32);
		g2d.draw(playButton);
		g.drawString("¿Como jugar?", howToPlayButton.x + 8, howToPlayButton.y + 32);
		g2d.draw(howToPlayButton);
		g.drawString("Salir", quitButton.x + 8, quitButton.y + 32);
		g2d.draw(quitButton);
		
	}
	
}
