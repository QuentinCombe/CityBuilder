package modele;

import vue.CityBuilder;

/**
 * Classe Zone.
 */
public class Zone {

	/** Le nom de la zone. */
	private String nom;
	
	/** La matrice des zones. */
	static int Zones[][] = null;
	
	/**
	 * Initialise la matrice des zones.
	 */
	public static void initTabZones(){
		int c = CityBuilder.getCases();
		Zones = new int[c][c];
		for(int i = 0; i < c; i++){
			for(int j = 0; j < c; j++){
				Zones[i][j] = 0;
			}
		}
	}
	
	/**
	 * Constructeur.
	 */
	public Zone(){
		nom ="";
	}
	
	/**
	 * Lire le nom.
	 *
	 * @return le nom de la zone
	 */
	public String lireNom() {
		return nom;
	}

	/**
	 * Modifier le nom.
	 *
	 * @param nom : le nom de la zone
	 */
	public void modifierNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Lire la matrice des zones.
	 *
	 * @return la matrice zones
	 */
	public static int[][] getZones(){
		if(Zones == null)initTabZones();
		return Zones;
	}
	
	/**
	 * Ajouter une zone dans la matrice
	 *
	 * @param x coordonnee de la case de départ
	 * @param y coordonnee de la case de départ
	 * @param lar coordonnee de la case opposée du rectangle en fonction de la largeur et hauteur saisie
	 * @param lon coordonnee de la case opposée du rectangle en fonction de la largeur et hauteur saisie
	 * @param val entier représentant le type de zone
	 */
	public static void setZone(int x, int y, int lar, int lon,int val) {
		if(Zones == null)initTabZones();
		for(int i=x; i<lar;i++){
			for(int j=y; j<lon;j++){
				//la matrice des zones est modifiée sur la zone définie
				Zones[i][j] = val;
			}
		}
	}
	
	/**
	 * Verifie si la zone correpond au type de zone.
	 *
	 * @param x coordonnee de la case de départ
	 * @param y coordonnee de la case de départ
	 * @param lar largeur de la zone
	 * @param hau hauteur de la zone
	 * @param zone le type de zone
	 * @return true, si la zone correspond au type de zone, false sinon
	 */
	public static boolean verifZone(int x, int y, int lar, int hau,int zone) {
		int zones[][] = Zone.getZones();
		for(int i=x;i<(x+lar);i++){
			for(int j=y;j<(y+hau);j++){
				if(zones[i][j] != zone) return false;
			}
		}
		return true;
	}
	
	/**
	 * Verifie si la zone n'est pas occupee par un batiment dont le type est incompatible avec la zone en parametre
	 *
	 * @param x coordonnee de la case de départ
	 * @param y coordonnee de la case de départ
	 * @param lar coordonnee de la case opposée du rectangle en fonction de la largeur et hauteur saisie
	 * @param lon coordonnee de la case opposée du rectangle en fonction de la largeur et hauteur saisie
	 * @param val entier representant le type de zone
	 * @return true, si la zone est libre
	 */
	public static boolean zoneLibre(int x, int y, int lar, int lon,int val){
		for(int i=x;i<lar;i++){
			for(int j=y;j<lon;j++){
				Batiments bat = Batiments.getBatiments(i,j);
				if(bat != null && bat.lireZone() != val) return false;
			}
		}
		return true;
	}
}
