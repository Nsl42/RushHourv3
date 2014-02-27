import java.util.Hashtable;
/** La classe Parking
  * @author Partie 1 : HAUTIER, JOSSERAND, LEBLOND, LUZ RIBEIRO.
  * @author Partie 2 : DAVID Zoé.
  */
public class Parking implements Constants {
	/**Hashtable contenant les Véhicules du Parking*/
	private Hashtable<String, Vehicule> ht = new Hashtable<String, Vehicule>();
	
	/** Constructeur de Parking. Crée un Grid vide.
	  */
	public Parking()
	{
		// Cr�e la map d�s l'instanciation de la classe
		new Grid();		
	}
	
	/** La méthode add crée et ajoute un Véhicule au Parking courant.
	  * @param nom Le nom du Véhicule
	  * @param couleur La couleur du Véhicule.
	  * @param direction La direction du Véhicule.
	  * @param positionX La position X du Véhicule.
	  * @param positionY La position Y du Véhicule.
	  * @param type Le type du Véhicule.
	  */
	public void add(String nom, String couleur, String direction, int positionX, int positionY, String type)
	{
		// L'image rectangle est cr�e en instanciant la classe v�hicule
		Vehicule vehicule = new Vehicule(nom, direction, positionX, positionY, couleur, type);

		// Ici on stock le v�hicule dans un Hashtable pour pouvoir l'utiliser plus tard (il suffira d'appeler ht.get(lettreAssocierAuVehicule)
		ht.put(nom, vehicule);
	}

	/** Surcharge de la méthode add permettant l'ajout d'un Véhicule déjà créé.
	  *
	  */
	public void add(Vehicule vehicule){
		ht.put(vehicule.getNom(),vehicule);
	}
	
	/** METHODE INUTILE POUR LA SUITE
	  * Cette méthode déplace les Véhicules du Parking en prenant en paramètre l'intégralité des déplacements d'une partie.
	  * @param listeDeplacement Une chaîne de caractères avec plusieurs déplacements.
	  */
	public void deplacement(String listeDeplacement)
	{
		/*
		 * D�coupe la chaine en plusieurs parties pour g�rer les d�placements un � un.
		 * La premi�re lettre permettra d'appeler le v�hicule stock� dans le Hashtable.
		 * Les 2 derniers caract�res serviront � d�placer le v�hicule
		 * 
		 */
		
		String tabDeplacement[] = listeDeplacement.split(", ");
		
		for(int i=0; i<tabDeplacement.length; i++)
		{
			String vehiculeADeplacer = tabDeplacement[i].substring(0, 1);
			String directionDeplacement = tabDeplacement[i].substring(1, 2);
			int nombreDeDeplacement = Integer.parseInt(tabDeplacement[i].substring(2, 3));
			
			ht.get(vehiculeADeplacer).deplacer(directionDeplacement, nombreDeDeplacement);
		}
	}
	
	/** Accesseur
	  * @param nom Le nom du Véhicule.
	  * @return Le Véhicule dont le nom est passé en paramètre.
	  */
	public Vehicule getVehicule(String nom) {
		return ht.get(nom);
	}

	/** La méthode move permet le déplacement d'un Véhicule.
	  * La méthode fait appel a checkOutBounds de ParkingController pour vérifier
	  * si le déplacement souhaité ne va pas faire sortir le Véhicule du Grid en calculant les positions
	  * après l'éventuel déplacement.
	  * @param deplacement La chaîne de caratères spécifiant le déplacement souhaité.
	  */
	public void move(String deplacement){
		Vehicule v = getVehicule(deplacement.substring(0,1));
		int postX = v.getX();
		int postY = v.getY();
		if(deplacement.substring(1,2).equals("L")){
			postX -= Integer.parseInt(deplacement.substring(2));
			postX = 4+postX*30;
		}
		else if(deplacement.substring(1,2).equals("R")){
			postX += Integer.parseInt(deplacement.substring(2));
			postX = 4+postX*30+v.getLongueur()*30;
		}
		else if(deplacement.substring(1,2).equals("D")){
			postY += Integer.parseInt(deplacement.substring(2));
			postY = 4+postY*30+v.getLongueur()*30;
		}
		else if(deplacement.substring(1,2).equals("U")){
			postY -= Integer.parseInt(deplacement.substring(2));
			postY = 4+postY*30;
		}
		if(ParkingController.checkOutBounds(v.getNom(),postX,postY)){
    		getVehicule(deplacement.substring(0,1)).deplacer(deplacement.substring(1,2),Integer.parseInt(deplacement.substring(2))); 
    	}	
    }
}
