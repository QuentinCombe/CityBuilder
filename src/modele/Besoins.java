package modele;

/**
 * Classe Besoins.
 */
public class Besoins {

	/** Le nom du besoin. */
	private String nom;
	
	/**
	 * Constructeur.
	 */
	public Besoins(){
		nom = "";
	}
	
	/**
	 * Constructeur avec un param�tre.
	 * @param nom du besoin
	 */
	public Besoins(String nom){
		this.nom = nom;
	}
	
	/**
	 * Lire le nom.
	 *
	 * @return le nom du besoin
	 */
	public String lireNom() {
		return nom;
	}

	/**
	 * Modifier le nom.
	 *
	 * @param nom : le nom du besoin
	 */
	public void modifierNom(String nom) {
		this.nom = nom;
	}
}
