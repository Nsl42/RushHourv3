/** Main class de RushHour pour la partie 2
  * @author DAVID Zoé
  */
public class RushHour2{

	public static void main(String[] args) {
		ParkingFactory pk = new ParkingFactory();

		System.out.println("#############################");
		System.out.println("# Bienvenue dans RushHour ! #");
		System.out.println("#############################");
		
		//On demande son pseudo au joueur. 
		System.out.println('\n'+"Veuillez entrer votre pseudo.");
		String pseudo = Console.readLine();

		//On crée un nouveau joueur. Si un fichier de sauvegarde existe, ses scores sont chargés.
		Player player = new Player(pseudo);	

		String again="O";
		while (!(again.equals("O")) || !(again.equals("N"))){
			if (again.equals("O")){
				//On demande ensuite le niveau de difficulté.
				System.out.println('\n'+"Choisissez un niveau de difficulté :");
				System.out.println("1 pour débutant");
				System.out.println("2 pour intermédiaire");
				System.out.println("3 pour avancé");
				System.out.println("4 pour expert");
				System.out.println("5 pour grand maître");

				int niveau = Console.readInt();
				while(niveau !=1 && niveau !=2 && niveau!=3 && niveau!=4 && niveau !=5){
				System.out.println("Ce niveau n'existe pas");
				niveau = Console.readInt();
				}	

				//on affiche pour le niveau de difficulté sélectionné combien de configuration sont disponibles.
				switch(niveau){
					case 1:
						System.out.println("Il y a "+pk.size(1)+" configurations");
						break;
					case 2:
						System.out.println("Il y a "+pk.size(2)+" configurations");
						break;
					case 3:
						System.out.println("Il y a "+pk.size(3)+" configurations");
						break;
					case 4:
						System.out.println("Il y a "+pk.size(4)+" configurations");		
						break;
					case 5:
						System.out.println("Il y a "+pk.size(5)+" configurations");
							break;
					default:
						System.out.println("ERROR !");	
				}
			
			//On demande le numéro de la configuration souhaité. Si le numéro n'est pas conforme, le numéro 1 est sélectionné par défaut.
			System.out.println("Choisissez une configuration");
			int num_config = Console.readInt();
			//Ensuite on effectue les déplacements de Véhicules.
			int score = player.play(pk,niveau,num_config);
			System.out.println("Score sur le niveau "+niveau+"-"+num_config+" : "+score+" mouvements");
			//Quand une partie est terminée on propose le choix d'effectuer une nouvelle partie.
			System.out.println("Commencer une nouvelle partie ? O/N");
			again = Console.readLine();
			}
			else if(again.equals("N")){
				System.out.println("Bye bye !");	
				System.exit(0);	
			}
			else{
				System.out.println("Commencer une nouvelle partie ? O/N");
				again = Console.readLine();
			}	
		}
	}	
}