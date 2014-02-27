/** Classe Grid qui crée la grille.
  * @author Partie 1 : HAUTIER Ludovic, JOSSERAND Sebastien, LEBLOND Xavier, LUZ RIBEIRO Eliezer
  */
public class Grid implements Constants {

	public Grid()
	{
		/*
		 * Affichage de la map 
		 * 
		 */
		// Bordure
		Rectangle bordure = new Rectangle("", SIZE, SIZE, 0, 0, "dark_grey");
		bordure.makeVisible();
		
		// Fond
		Rectangle fond = new Rectangle("", SIZE-BORDER*2, SIZE-BORDER*2, BORDER, BORDER, "white");
		fond.makeVisible();	
		
		// Cases
		for (int i=0;i<6;i++) {
			for (int j=0; j<6; j++) {
				new Rectangle("", 26, 26, i*30+6, j*30+6, "grey").makeVisible();
			}
		}
				
		// Sortie
		Rectangle sortie = new Rectangle("", 4, 30, BORDER+6*SQUARE, BORDER+2*SQUARE, "white");
		sortie.makeVisible();	
	}
}
