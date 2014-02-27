public class RushHour1 implements Constants {
	
	public static void main(String[] args) {
		// L'instance du parking permet de cr�er la map, ajouter et d�placer les v�hicules
		Parking parking = new Parking();

		// Place les v�hicules sur la map
		parking.add("X", "rouge", "horizontale", 1, 2, "voiture");
		parking.add("A", "verte", "horizontale", 1, 3, "voiture");
		parking.add("B", "orange", "verticale", 1, 4, "voiture");
		parking.add("C", "bleue", "horizontale", 2, 5, "voiture");
		parking.add("O", "jaune", "verticale", 3, 2, "camion");
		parking.add("P", "violet", "verticale", 5, 3, "camion");
		
		// D�place les v�hicules
		parking.deplacement("PU3, OU2, CR2, AR3, OD3, XR1, BU4, XL1, OU3, CL3, AL3, PD3, OD3, XR5");
	}

}
