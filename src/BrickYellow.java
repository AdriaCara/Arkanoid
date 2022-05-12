import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.management.timer.Timer;

public class BrickYellow extends Brick {

	public BrickYellow(double X, double Y, Game game) {
		super(1, X, Y, game, true);
		try {
			imagen = ImageIO.read(BrickBlue.class.getResource("YellowBrick.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics2D g) {

		g.setColor(Color.YELLOW);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(imagen, (int)x, (int)y, WIDTH, HEIGHT, null);

	}

	@Override
	public void action(int i) {

		Game.Score += 1;
		Game.bricks.remove(i);
		
		  if (Game.RacquetSpeed < 8.5) {
			  
		      Ball.yellowEfect = false;
			  Game.RacquetSpeed += 5;
			  
		  }
		
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture<?> efect = exec.scheduleAtFixedRate(new Runnable() {
		  @Override
		  public void run() {
			  
			  Game.RacquetSpeed -= 5;
		      exec.shutdown();
		    
		  }
		}, (long) 10, 1, TimeUnit.SECONDS);
		
	}

}
