import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		/*
		 * 	public Rectangle playButton = new Rectangle(	Game.WIDTH / 2 + 100, 150, 100, 50);
		 * 	public Rectangle howToPlayButton = new Rectangle(Game.WIDTH / 2 + 100, 250, 215, 50);
		 * 	public Rectangle quitButton = new Rectangle(	Game.WIDTH / 2 + 100, 350, 100, 50);
		 * 
		 * 	public Rectangle playButton = new Rectangle(	(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)), (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 5.5)), (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 14)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
		 * 	public Rectangle howToPlayButton = new Rectangle((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)), (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 2.3)), (int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.5)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
		 * 	public Rectangle quitButton = new Rectangle(	(Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)), (int) (Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.5)), (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 17)), (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20)));
		 * */
		
		if (Game.State == Game.State.MENU) {
			
			//Start game.
			if ((mx >= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5.7))) && (mx <= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5.7)) + ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 7))))) {
				
				if ((my >= (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 15))) && (my <= ((int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 15))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.3))))) {
					
					//Pressed Play Button
					Game.State = Game.State.GAME;
					
				}
				
			}
			
			//How To Play Game.
			if ((mx >= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 8))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 8))) + ((int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4))))) {
				
				if ((my >= (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 5.5))) && (my <= ((int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 5.5))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.3))))) {
					
					//Pressed How To Play Button
					Game.State = Game.State.HOWTOPLAY;
					
				}
				
			}
			
			//Quit Game.
			if ((mx >= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5.7)))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5.7))) + ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 7))))) {
				
				if ((my >= (int)(Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 3))) && (my <= ((Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 3))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 3.3))))) {
					
					//Pressed Quit Button
					System.exit(1);
					
				}
				
			}
			
		} else if (Game.State == Game.State.MENUESCAPE) {
			
			//Start Game.
			if ((mx >= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6))) + ((int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.2))))) {
				
				if ((my >= (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 0.9))) && (my <= ((int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 0.9))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed How To Play Button
					Game.State = Game.State.GAME;
					
				}
				
			}
			
			//Quit Game.
			if ((mx >= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.6)))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 4.6))) + ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 17))))) {
				
				if ((my >= (int)(Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 0.75))) && (my <= ((Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 0.75))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed Quit Button
					Game.State = Game.State.MENU;
					Game.quit = true;
					Game.Ballspeed = 4;
					Game.RacquetSpeed = 6;
					Game.Score = 0;
					Game.level --;
					Racquet.LIVES = 3;
					Racquet.menuEscape = false;
					
				}
				
			}
			
		} else if (Game.State == Game.State.HOWTOPLAY) {
			
			//back Game.
			if ((mx >= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 70))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 70))) + ((int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 20))))) {
				
				if ((my >= (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 50))) && (my <= ((int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 50))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed How To Play Button
					Game.State = Game.State.MENU;
					
				}
				
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	


}
