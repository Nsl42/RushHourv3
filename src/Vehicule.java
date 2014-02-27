/** La classe Véhicule modélise les voitures et les camions du jeu RushHour.
  * @author Partie 1 : HAUTIER Ludovic, JOSSERAND Sebastien, LEBLOND Xavier et LUZ RIBEIRO Eliezer
  * @author Partie 2 : DAVID Zoé.
  */
public class Vehicule implements Constants{
	/**Le nom du Véhicule */
	private String nom;
	/** La longueur du Véhicule, 2 ou 3*/
	private int longueur;
	/** Direction du Véhicule, horizontale ou verticale*/
	private String direction;
	/** Position sur l'axe X du Véhicule*/
	private int positionX;
	/** Position sur l'axe Y du Véhicule*/
	private int positionY;
	/** Couleur du Véhicule*/
	private String couleur;
	/** Type du Véhicule, voiture ou camion*/
	private String type;
	/** Image affichée du Véhicule*/
	private Rectangle imageVehicule;
	
	/**Construteur de Véhicule. Il initialise nom,longueur,direction,positionX,positionY,couleur et type.
	  * Il crée également l'image du Véhicule et le rend visible. 
	  * @param nom Le nom souhaité pour le Véhicule. Une seule lettre capitale.
	  * @param direction La direction souhaitée pour le Véhicule.
	  * @param positionX Position X du Véhicule.
	  * @param positionY Position Y du Véhicule.
	  * @param couleur Couleur du Véhicule.
	  * @param type Type du Véhicule.
	  */
	public Vehicule(String nom, String direction, int positionX, int positionY, String couleur, String type)
	{
		// Associe les valeurs aux attributs
		this.nom = nom;
		this.longueur = type == "voiture" ? 2 : 3;
		this.direction = direction;
		this.positionX = positionX;
		this.positionY = positionY;
		this.couleur = couleur;
		
		// Crée l'image correspondant au véhicule suivant sa longueur
		int tailleX = direction == "horizontale" ? longueur*30 : 1*30;
		int tailleY = direction == "verticale" ?   longueur*30 : 1*30;
		imageVehicule = new Rectangle(nom, tailleX, tailleY, 4+positionX*30, 4+positionY*30, couleur);
		imageVehicule.makeVisible();			
	}

	/** Constructeur de Véhicule. Il initialise le nom,la longueur,la couleur et le type du Véhicule.
	  * @param nom Le nom du Véhicule.
	  * @param size La longueur du Véhicule.
	  * @param color La couleur du Véhicule.
	  */
	public Vehicule(String nom, int size, String color){
		this.nom = nom;
		this.longueur = size;
		this.couleur = color;
		if (this.longueur == 2){this.type="voiture";}
		else {this.type="camion";}
	}
	
	/** Méthode qui déplace un Véhicule SEULEMENT si la direction du déplacement est
	  * conforme à la direction du Véhicule.
	  * @param direction La direction du déplacement.
	  * @param nombreDeDeplacement Le nombre de cases dont on veut déplacer le Véhicule.
	  */
	public void deplacer(String direction, int nombreDeDeplacement)
	{
		// Contrôle si le véhicule va bien dans le bon sens, puis le déplace dans la bonne direction, et du nombre de cases indiqué en paramètre
		
		if(direction.charAt(0) == 'U' && this.direction == "verticale"){
			imageVehicule.slowMoveVertical (nombreDeDeplacement*SQUARE*-1);
			positionY -= nombreDeDeplacement; 
		}	
		else if(direction.charAt(0) == 'D' && this.direction == "verticale"){
			imageVehicule.slowMoveVertical (nombreDeDeplacement*SQUARE);
			positionY += nombreDeDeplacement;
		}	
		else if(direction.charAt(0) == 'R' && this.direction == "horizontale"){
			imageVehicule.slowMoveHorizontal (nombreDeDeplacement*SQUARE);
			positionX += nombreDeDeplacement;
		}	
		else if(direction.charAt(0) == 'L' && this.direction == "horizontale"){
			imageVehicule.slowMoveHorizontal (nombreDeDeplacement*SQUARE*-1);
			positionX -= nombreDeDeplacement;
		}	
		
	}

	/** Accesseur
	  * @return le nom du Véhicule.
	  */
	public String getNom(){
		return this.nom;
	}

	/** Modifie la position du Véhicule. PAS CELLE DE L'IMAGE.
	  * @param x La nouvelle position X.
	  * @param y La nouvelle position Y.
	  */
	public void setPosition(int x, int y){
		this.positionX = x;
		this.positionY = y;
	}

	/** Accesseur
	  * @return la position X du Véhicule.
	  */
	public int getX(){
		return this.positionX;
	}

	/** Accesseur
	  * @return la position Y du Véhicule.
	  */
	public int getY(){
		return this.positionY;
	}

	/** Modifie la direction du Véhicule
	  * @param direction la nouvelle direction du Véhicule.
	  */
	public void setDirection(String direction){
		this.direction = direction;
	}
	
	/** Accesseur
	  * @return la direction du Véhicule.
	  */
	public String getDirection(){
		return this.direction;
	}

	/** Accesseur
	  * @return la longueur du Véhicule.
	  */
	public int getLongueur(){
		return this.longueur;
	}

	/** Méthode qui rend visible un Véhicule en créant une imageVehicule.
	  */
	public void makeVisible(){
		int tailleX = direction == "horizontale" ? longueur*30 : 1*30;
		int tailleY = direction == "verticale" ?   longueur*30 : 1*30;
		imageVehicule = new Rectangle(nom, tailleX, tailleY, 4+positionX*30, 4+positionY*30, couleur);
		imageVehicule.makeVisible();				
	}
}
