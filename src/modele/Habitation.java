package modele;

import java.util.HashMap;

/**
 * Classe Habitation.
 */
public class Habitation extends Batiments{
	
	/** Le nombre d'habitants. */
	private int nbHabitant;

	/**
	 * Constructeur.
	 */
	public Habitation(){
		super();
		nbHabitant = 0;
	}
	
	/**
	 * Constructeur à plusieurs paramètres.
	 *
	 * @param nom le nom
	 * @param x la coordonée x
	 * @param y la coordonée y
	 * @param entree la liste des besoins en entree
	 * @param sortie la liste des besoins en sortie
	 * @param zone la zone
	 * @param nbHab le nombre d'habitants
	 * @param rayon le rayon d'influence
	 */
	public Habitation(String nom,int x, int y, HashMap<Besoins,Integer> entree,HashMap<Besoins,Integer> sortie,int zone, int nbHab, int rayon){
		super(nom,x,y,entree,sortie,zone,rayon);
		nbHabitant = nbHab;
	}
	
	/**
	 * Lire le nombre d'habitants.
	 *
	 * @return le nombre d'habitants
	 */
	public int lireNbHabitant() {
		return nbHabitant;
	}

	/**
	 * Modifier le nombre d'habitants.
	 *
	 * @param nbHabitant : le nombre d'habitants
	 */
	public void modifierNbHabitant(int nbHabitant) {
		this.nbHabitant = nbHabitant;
	}
}
