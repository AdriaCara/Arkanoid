import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
			if ((mx >= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))) && (mx <= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)) + ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 14))))) {
				
				if ((my >= (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 5.5))) && (my <= ((int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 5.5))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed Play Button
					Game.State = Game.State.GAME;
					
				}
				
			}
			
			//How To Play Game.
			if ((mx >= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))) + ((int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.5))))) {
				
				if ((my >= (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 2.3))) && (my <= ((int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 2.3))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed How To Play Button
					Game.State = Game.State.HOWTOPLAY;
					
				}
				
			}
			
			//Quit Game.
			if ((mx >= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))) + ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 17))))) {
				
				if ((my >= (int)(Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.5))) && (my <= ((Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.5))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed Quit Button
					System.exit(1);
					
				}
				
			}
			
		} else if (Game.State == Game.State.MENUESCAPE) {
			
			//Start game.
			if ((mx >= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))) && (mx <= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)) + ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.2))))) {
				
				if ((my >= (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.10))) && (my <= ((int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 1.10))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed Play Button
					Game.State = Game.State.GAME;
					
				}
				
			}
			
			//How To Play Game.
			if ((mx >= (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))) + ((int) (Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 6.5))))) {
				
				if ((my >= (int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 0.9))) && (my <= ((int) (Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 0.9))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed How To Play Button
					Game.State = Game.State.HOWTOPLAY;
					
				}
				
			}
			
			//Quit Game.
			if ((mx >= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5)))) && (mx <= ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 5))) + ((Game.WIDTH + (Toolkit.getDefaultToolkit().getScreenSize().width / 17))))) {
				
				if ((my >= (int)(Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 0.75))) && (my <= ((Game.HEIGHT + ((int)Toolkit.getDefaultToolkit().getScreenSize().height / 2 / 0.75))) + ((Game.HEIGHT + (Toolkit.getDefaultToolkit().getScreenSize().height / 20))))) {
					
					//Pressed Quit Button
					System.exit(1);
					
				}
				
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
