import java.util.HashMap;
import java.util.Iterator;
/** La classe Player modélise un joueur du jeu RushHour.
  * @author DAVID Zoé
  */
public class Player{
	
	/**Le nom du joueur*/
	private String nom;
	/**HashMap contenant les scores du joueur*/
	private HashMap<String,String> score;

	/** Constructeur de Player
	  * Initialise le nom du joueur et charge les scores de ce dernier.
	  * @param pseudo Le nom du joueur.
	  */
	public Player(String pseudo){
		this.nom = pseudo;
		this.score = new HashMap<String,String>();
		load();
		if (score.isEmpty()){
			System.out.println("Bienvenue "+pseudo+" ! C'est votre première partie !");	
		}
		else {
			System.out.println("Bienvenue "+pseudo+" ! Vos scores précédents ont été chargés");
			afficherScore();
		}
	}

	/** La méthode load() remplit le HashMap des scores du joueur à partir d'un fichier texte.
	  * Cette méthode fait appel à RWFile.
	  */
	public void load(){
		this.score = RWFile.readHashMap("../save/"+nom);
	}

	/** La méthode save() sauvegarde les scores du joueur dans un fichier texte.
	  * Cette méthode fait appel à RWFile.
	  */
	public void save(){
		RWFile.writeHashMap("../save/"+nom,this.score);
	}

	/** La méthode setScore vérifie si un score a déjà été entré pour un niveau donné.
	  * Si oui et si le nouveau score est meilleur, alors il remplace l'ancien score.
	  * Si non,le niveau et le score sont ajoutés.
	  * @param niveau Le niveau de difficulté.
	  * @param num_config Le numéro de la configuration
	  * @param newscore Le nouveau score effectué par le joueur.
	  */
	public void setScore(int niveau, int num_config, int newscore){
		String level = String.valueOf(niveau)+":"+String.valueOf(num_config);
		if (this.score.containsKey(level)){
			if (newscore < Integer.parseInt(this.score.get(level)) && newscore !=-1){
				this.score.put(level,Integer.toString(newscore));
			}
			else if(Integer.parseInt(this.score.get(level)) == -1){
				this.score.put(level,Integer.toString(newscore));
			}
		}
		else {this.score.put(level,Integer.toString(newscore));}
	}

	/** La méthode getScore retourne le score du niveau spécifié par niveau et num_config.
	  * @param niveau Le niveau de difficulté.
	  * @param num_config Le numéro de la configuration.
	  * @return Le score du niveau spécifié par niveau et num_config.
	  */
	public int getScore(int niveau,int num_config){
		int ret = -1;
		String level = String.valueOf(niveau)+":"+String.valueOf(num_config);
		if (this.score.containsKey(level)){
			ret = Integer.parseInt(this.score.get(level));
		}
		return ret;
	}

	/** La méthode play crée un Parking selon le niveau de difficulté spécifié et la configuration demandée.
	  * @param pk Le ParkingFactory pour créer le Parking.
	  * @param niveau Le niveau de difficulté.
	  * @param num_config Le numéro de la configuration.
	  * @return Le score effectué par le joueur.
	  */
	public int play(ParkingFactory pk,int niveau,int num_config){
		Parking current = pk.createParking(niveau,num_config);
		System.out.println("Entrez vos inputs ou tapez exit pour quitter le jeu");
		
		String input = Console.readLine();
		int newscore = 0;
		boolean victory = false;
		while(!(input.equals("exit")) && !victory){
			current.move(input);
			newscore += 1;
			if (current.getVehicule("X").getX() >= 6){
				victory = true;
				System.out.println("VICTOIRE !");
				setScore(niveau,num_config,newscore);
				save();
			}
			else{
				input = Console.readLine();		
			}
		}
		if (!victory){
			newscore = -1;
			setScore(niveau,num_config,-1);
			save();
		}
		return newscore;
	}

	/** La méthode afficherScore() affiche les scores du joueur sous la forme "niveau:configuration score"
	  */
	public void afficherScore(){
		for (String key : score.keySet()) { 
			System.out.println(key + " : " + score.get(key));

		}
	}
}