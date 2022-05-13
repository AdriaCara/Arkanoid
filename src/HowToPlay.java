import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HowToPlay {

	public Rectangle backButton = new Rectangle((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 70)), (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 50)), (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 20)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
	public BufferedImage imagen;
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font fontTitle = new Font("arial", Font.BOLD, 50);
		g.setFont(fontTitle);
		g.setColor(Color.WHITE);
		g.drawString("¿Como jugar?", (Game.WIDTH / 2) + (Toolkit.getDefaultToolkit().getScreenSize().width / 7), Game.HEIGHT + 50);
		
		Font fontButton = new Font("arial", Font.BOLD, 30);
		g.setFont(fontButton);
		g.drawString("<<", (backButton.x + (Toolkit.getDefaultToolkit().getScreenSize().width / 85)), ((int) (backButton.y + (Toolkit.getDefaultToolkit().getScreenSize().height / 28))));
		g2d.draw(backButton);
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("YellowBrick.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 70)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 9)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 12.9))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 26.6))), null);
		g.drawString("1v", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 9)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 7.1)));
		g.drawString("Por 10s raqueta +10vel", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5.8)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 7.1)));
		g.drawString("+ 1p", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 2.4)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 7.1)));
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("GreenBrick3lifes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 70)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 5)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 12.9))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 26.6))), null);
		g.drawString("3v", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 9)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 4.3)));
		g.drawString("Duro de pelar", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 4.3)));
		g.drawString("+ 3p", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 2.4)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 4.3)));
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("RedBrick2lifes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 70)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.4)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 12.9))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 26.6))), null);
		g.drawString("2v", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 9)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.05)));
		g.drawString("Caer sin parar", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.05)));
		g.drawString("+ 2p", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 2.4)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.05)));
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("BlueBrick.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 70)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2.6)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 12.9))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 26.6))), null);
		g.drawString("1v", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 9)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2.4)));
		g.drawString("Invertir control", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2.4)));
		g.drawString("+ 1p", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 2.4)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2.4)));
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("MagentaBrick2lifes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 70)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2.1)), ((int) ((Game.WIDTH) + (Toolkit.getDefaultToolkit().getScreenSize().width / 12.9))), ((int) ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 26.6))), null);
		g.drawString("1v", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 9)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 1.97)));
		g.drawString("Una vida más", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 1.97)));
		g.drawString("+ 1p", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 2.4)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 1.97)));
		
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("Ball3lifes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 25)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 1.75)), ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 30)), ((Game.HEIGHT) + (Toolkit.getDefaultToolkit().getScreenSize().height / 30)), null);
		g.drawString("3v", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 9)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 1.67)));
		g.drawString("Pelota", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.2)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 1.67)));
		g.drawString("Perder", (int)(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 2.5)), (int)(Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 1.67)));
		
	}

}
