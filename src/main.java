import javax.swing.JFrame;

public class main {

	//Main function.
	public static void main(String[] args) throws InterruptedException {
		
		main M = new main();
		M.principal();

	}
	
	//Principal function.
	public void principal() throws InterruptedException {
		
		GameScore datos = new GameScore("Scores.json");
		String[] names = datos.getNames();
		for (int i = 0; i < names.length; i++) {
			
			String nom = names[i];
			int score = datos.getScore(nom);
			
			System.out.print("Nom: " + nom + " Puntuació: " + score);
			
		}
		
	}

}
