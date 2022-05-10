import java.awt.Rectangle;
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
		 * */
		
		//Start game.
		if (mx >= Game.WIDTH / 2 + 100 && mx <= Game.WIDTH / 2 + 200 ) {
			
			if (my >= 150 && my <= 200) {
				
				//Pressed Play Button
				Game.State = Game.State.GAME;
				
			}
			
		}
		
		//How To Play Game.
		if (mx >= Game.WIDTH / 2 + 100 && mx <= Game.WIDTH / 2 + 315 ) {
			
			if (my >= 250 && my <= 300) {
				
				//Pressed How To Play Button
				Game.State = Game.State.HOWTOPLAY;
				
			}
			
		}
		
		//Quit Game.
		if (mx >= Game.WIDTH / 2 + 100 && mx <= Game.WIDTH / 2 + 200 ) {
			
			if (my >= 350 && my <= 400) {
				
				//Pressed Quit Button
				System.exit(1);
				
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
