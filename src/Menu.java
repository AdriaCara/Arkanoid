import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu {

	public Rectangle playButton = new Rectangle(	(int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.6)), (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 3)), (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 14)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
	public Rectangle howToPlayButton = new Rectangle((int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5.5)), (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.7)), (int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.5)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
	public Rectangle quitButton = new Rectangle(	(int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.5)), (int) (Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.2)), (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 17)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
	public BufferedImage imagen;
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("ARKANOID.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 8)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 1000)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 4))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 5))), null);
		
		Font fontButton = new Font("arial", Font.BOLD, 30);
		g.setColor(Color.WHITE);
		g.setFont(fontButton);
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("JUGAR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5.7)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 15)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 7))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.3))), null);
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("COMO JUGAR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 8)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 5.5)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 4))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.3))), null);
		
		g.drawString("Salir", quitButton.x + (Toolkit.getDefaultToolkit().getScreenSize().width / 150), ((int) (quitButton.y + (Toolkit.getDefaultToolkit().getScreenSize().height / 28))));
		g2d.draw(quitButton);
		
	}
	
}
