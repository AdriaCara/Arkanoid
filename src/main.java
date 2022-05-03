import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		main M = new main();
		M.principal();

	}
	
	public void principal() {
		
		JFrame frame = new JFrame("Arkanoid");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
