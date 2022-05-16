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

	public BufferedImage imagen;
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("ARKANOID.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.5)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 90)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))), null);
		
		Font fontButton = new Font("arial", Font.BOLD, 30);
		g.setColor(Color.WHITE);
		g.setFont(fontButton);
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("JUGAR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.9)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 7)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 10))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 30))), null);
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("COMO JUGAR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.3)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 4)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 30))), null);
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("SALIR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.9)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2.8)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 10))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 30))), null);
		
	}
	
}
