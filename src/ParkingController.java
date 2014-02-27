
public class ParkingController implements Constants{
	
/* vérifie si le sens du déplacement est correcte
 !!!!  INUTILE  !!!! car la méthode deplacer() de Vehicule n'autorise le déplacement que si
 la direction du déplacement est conforme à la direction du Véhicule.
  
 	public static boolean checkmove(String direction,int avpositionX,int avpositionY,int appositionX,int appositionY){
		boolean ret = true;
		if(direction==UP || direction==DOWN){
		  //si la position de X change 
			if(avpositionX!=appositionX){
				
				ret = false;} 

			else{
				ret = true;
			}
			
		}
		else if(direction==LEFT || direction==RIGHT){
			//si Y change 
			if(avpositionY!=appositionY){
				ret = false;
			}
			else{
				ret = true;
			}
		}
		return ret;
	}
 */	
	
 	/** La méthode vérifie si un rectangle dépasse les limites du terrain de jeu lorsqu'il effectue un déplacement
 	  * @param name le nom du Véhicule
 	  * @param appositionX la position X du Véhicule après déplacement.
 	  * @param appositionY la position Y du Véhicule après déplacement.
 	  * @return vrai si le déplacement est correct. faux sinon.
 	  */
	public static boolean checkOutBounds(String name,int appositionX,int appositionY){ //apposition: position après le déplacement
		boolean ret = true;
		if(appositionX >=SIZE && name.equals("X")) {
			ret = true;
		}
		else if(appositionX < 0 || appositionX >= SIZE || appositionY < 0 || appositionY >= SIZE){ 
			System.out.println("Mouvement non valide");
			ret = false;
		}
		return ret;	
	}
	
	/** La méthode n'est pas terminée et n'est pas utilisée.
	  */
	public static boolean checkRectangleOverlap(int rectA_x,int rectA_y,int rectA_width,int rectA_height,
			int rectB_x,int rectB_y,int rectB_width,int rectB_height){
			 
			  boolean isOVerlap=( Math.abs (rectA_x - rectB_x) <(Math.abs (rectA_width + rectB_width) / 2) 
			  && (Math.abs (rectA_y - rectB_y) <(Math.abs (rectA_height + rectB_height) / 2)));
			  return isOVerlap;
	}
}