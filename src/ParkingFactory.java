import java.util.ArrayList;
import java.util.HashMap;
/** La classe ParkngFactory permet la création de Parkings et de les remplir en fonction
  * du niveau et de la configuration choisie.
  * @author DAVID Zoé.
  */
public class ParkingFactory{

	/**HashMap qui contient tous les Véhicules utilisables.*/
	private HashMap<String,Vehicule> vroum;
	/**ArrayList contenant les niveaux beginner*/
	private ArrayList<String> beginner;
	/**ArrayList contenant les niveaux intermediate*/
	private ArrayList<String> intermediate;
	/**ArrayList contenant les niveaux advanced*/
	private ArrayList<String> advanced;
	/**ArrayList contenant les niveaux expert*/
	private ArrayList<String> expert;
	/**ArrayList contenant les niveaux grandmaster*/
	private ArrayList<String> grandmaster;

	/** Constructeur de ParkingFactory.
	  * Initialise tous les attributs de ParkingFactory.
	  */
	public ParkingFactory(){

		this.vroum = new HashMap<String,Vehicule>();
		ArrayList<String> data_vehicule = RWFile.readArrayList("../data/vehicles.dat");
		for (String line : data_vehicule){
			Vehicule v = new Vehicule(line.substring(0,1),Integer.parseInt(line.substring(1,2)),line.substring(2));
			vroum.put(line.substring(0,1),v);				
		}

		this.beginner = RWFile.readArrayList("../data/1-beginner.cfg");
		this.intermediate = RWFile.readArrayList("../data/2-intermediate.cfg");
		this.advanced = RWFile.readArrayList("../data/3-advanced.cfg");
		this.expert = RWFile.readArrayList("../data/4-expert.cfg");
		this.grandmaster = RWFile.readArrayList("../data/5-grandmaster.cfg");

	}
	/** La méthode renvoie un Parking créé selon le niveau et la configuration passés en paramètre.
	  * Elle fait appel à la méthode fillParking. Si le num_config n'est pas valide, la config 1 est sélectionnée par défaut.
	  * @param niveau Le niveau de difficulté
	  * @param num_config La configuration choisie.
	  * @return Un Parking rempli de Véhicules selon les paramètres niveau et num_config.
	  */
	public Parking createParking(int niveau, int num_config){
		Parking ret;
		switch(niveau)
		{
			case 1:
				if (num_config > beginner.size() || num_config <= 0){
					System.out.println("Ce niveau n'existe pas. Sélection du niveau 1.");
					ret = fillParking(beginner.get(0));
				}
				else{
					ret = fillParking(beginner.get(num_config-1));
				}	
				break;	
			case 2:
				if (num_config > intermediate.size() || num_config <= 0){
					System.out.println("Ce niveau n'existe pas. Sélection du niveau 1.");
					ret = fillParking(intermediate.get(0));
				}
				else{
					ret = fillParking(intermediate.get(num_config-1));
				}	
				break;
			case 3:
				if (num_config > advanced.size() || num_config <= 0){
					System.out.println("Ce niveau n'existe pas. Sélection du niveau 1.");
					ret = fillParking(advanced.get(0));
				}
				else{
				ret = fillParking(advanced.get(num_config-1));
				}
				break;
			case 4:
				if (num_config > expert.size() || num_config <= 0){
					System.out.println("Ce niveau n'existe pas. Sélection du niveau 1.");
					ret = fillParking(expert.get(0));
				}
				else{
					ret = fillParking(expert.get(num_config-1));
				}	
				break;
			case 5:
				if (num_config > grandmaster.size() || num_config <= 0){
					System.out.println("Ce niveau n'existe pas. Sélection du niveau 1.");
					ret = fillParking(grandmaster.get(0));
				}
				else{
					ret = fillParking(grandmaster.get(num_config-1));	
				}	
				break;
			default:
				System.out.println("Ce niveau de difficulté n'existe pas."+'\n'+"Création d'un Parking débutant niveau 1");	
				ret = fillParking(beginner.get(0));
		}
		return ret;
	}
	 /** La méthode fillParking rempli un Parking selon la configuration passée en paramètre.
	   * @param configuration Le numéro de la configuration choisie.
	   * @return Un Parking rempli selon la configuration passée en paramètre.
	   */
	public Parking fillParking(String configuration){
		Parking ret = new Parking();
		String[] placement = configuration.split(" ");
		for(int i = 0 ; i < placement.length ; i++){
			Vehicule v = vroum.get(placement[i].substring(0,1));
			if(placement[i].substring(1,2).equals("H")){
				v.setDirection("horizontale");
			}
			else{v.setDirection("verticale");}
			v.setPosition(Integer.parseInt(placement[i].substring(2,3)),Integer.parseInt(placement[i].substring(3)));
			ret.add(v);
			v.makeVisible();	
		}
		return ret;
	}

	/** La méthode size renvoie le nombre de configuration possible pour un niveau de difficulté donné.
	  * @param niveau Le niveau de difficulté
	  * @return le nombre de configuration possible pour le niveau en paramètre.
	  */
	public int size(int niveau){
		int size = 0;
		switch(niveau){
			case 1:
				size = beginner.size();
				break;
			case 2:
				size = intermediate.size();
				break;
			case 3:
				size = advanced.size();
				break;
			case 4:
				size = expert.size();
				break;
			case 5:
				size = grandmaster.size();
				break;
			default:
				System.out.println("ERROR ! size = 0 !");					
		}
		return size;
	}
}