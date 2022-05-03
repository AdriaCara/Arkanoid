import javax.swing.JFrame;

public class main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		main M = new main();
		M.principal();

	}
	
	public void principal() throws InterruptedException {
		
		JFrame frame = new JFrame("Arkanoid");
		Game game = new Game();
		frame.add(game);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			
			game.moveBall();
			game.repaint();
			Thread.sleep(5);
			
		}
		
	}

}
