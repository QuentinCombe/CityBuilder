package modele;

import java.util.HashMap;

/**
 * Classe Commerce.
 */
public class Commerce extends Batiments{
		
	/** nombre d'employee travaillant dans le commmerce */
	private int nbEmployee;

	/**
	 * Constructeur.
	 */
	public Commerce(){
		super();
		nbEmployee = 0;
	}
	
	/**
	 * Constructeur � plusieurs param�tres.
	 *
	 * @param nom le nom
	 * @param x la coordon�e x
	 * @param y la coordon�e y
	 * @param entree la liste des besoins en entr�e
	 * @param sortie la liste des besoins en sortie
	 * @param zone la zone
	 * @param nbemp le nombre d'employes travaillant dans le commmerce
	 * @param rayon le rayon d'influence
	 */
	public Commerce(String nom,int x, int y, HashMap<Besoins,Integer> entree,HashMap<Besoins,Integer> sortie,int zone, int nbemp,int rayon){
		super(nom,x,y,entree,sortie,zone,rayon);
		nbEmployee = nbemp;
	}
	
	/**
	 * Lire le nombre d'employes travaillant dans le commmerce
	 *
	 * @return le nombre d'employ�s travaillant dans le commmerce
	 */
	public int lireNbEmployee() {
		return nbEmployee;
	}
	
	/**
	 * Modifier le nombre d'employ�s travaillant dans le commmerce
	 *
	 * @param nbEmployee : le nombre d'employ�s travaillant dans le commmerce
	 */
	public void modifierNbEmployee(int nbEmployee) {
		this.nbEmployee = nbEmployee;
	}
}
