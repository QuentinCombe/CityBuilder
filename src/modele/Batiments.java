package modele;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;

import controleur.Listener;
import vue.CityBuilder;
import vue.Main;

/**
 * Classe Batiments.
 */
public class Batiments {

	/** Nom des batiments. */
	private String nom;

	/** Taille des batiments. */
	private int x;
	
	/** Taille des batiments. */
	private int y;

	/** Niveau des batiments *. */
	private int niveau;

	/** Liste des besoins en entree. */
	private HashMap<Besoins,Integer> entree;

	/** Liste des besoins en sortie. */
	private HashMap<Besoins,Integer> sortie;

	/** Zone ou le batiment peut s'implenter. */
	private int zone;

	/** La coordonee X de la position du batiment**/
	private int posX;

	/** La coordonee Y de la position du batiment **/
	private int posY;

	/** Matrice des batiments **/
	static Batiments tabBat[][] = null;

	/** Le rayon d'influence d'un batiment. */
	private int rayon;

	/** la variable etat**/
	private double etat;
	/**
	 * Constructeur.
	 */
	public Batiments(){
		nom = "";
		x= 0;
		y=0;
		niveau = 0;
		entree = new HashMap<Besoins, Integer>();
		sortie = new HashMap<Besoins, Integer>();
		zone = 0;
		setEtat(100);
	}

	/**
	 * Contructeur Ã  7 parametres.
	 *
	 * @param nom le nom du batiment
	 * @param x la taille du batiment
	 * @param y la taille du batiment
	 * @param entree la liste des besoins en entrees du batiment
	 * @param sortie la liste des besoins en sortie du batiment
	 * @param zone le type de zone ou le batiment peut s'implenter
	 * @param rayon le rayon d'influence du batiment
	 */
	public Batiments(String nom,int x, int y, HashMap<Besoins,Integer> entree,HashMap<Besoins,Integer> sortie,int zone, int rayon){
		this.nom = nom;
		this.x = x;
		this.y = y;
		niveau = 1;
		this.entree = entree;
		this.sortie = sortie;
		this.zone = zone;
		this.rayon = rayon;
		setEtat(100);
	}

	/**
	 * Lire le nom
	 *
	 * @return le nom du batiment
	 */
	public String lireNom() {
		return nom;
	}

	/**
	 * Modifier le nom.
	 *
	 * @param nom : le nom du batiment
	 */
	public void modifierNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Lire le niveau
	 *
	 * @return le niveau du batiment
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * Modifier le niveau.
	 *
	 * @param niveau : le niveau du batiment
	 */
	public void modifierNiveau(int niveau) {
		this.niveau = niveau;
	}

	/**
	 * Lire rayon.
	 *
	 * @return le rayon
	 */
	public int lireRayon() {
		return rayon;
	}

	/**
	 * Modifier rayon.
	 *
	 * @param rayon : le rayon
	 */
	public void modifierRayon(int rayon) {
		this.rayon = rayon;
	}

	/**
	 * Lire les entrees.
	 *
	 * @return la liste des besoin en entrees 
	 */
	public String getEntree() {

		if(entree.isEmpty()==true){
			return "Ce batiment n'a pas de besoins en entree";
		}
		for (Entry<Besoins, Integer> entry : entree.entrySet())
		{
			return entry.getKey().lireNom()+" : "+entry.getValue();
		}
		return null;
	}

	/**
	 * Lire la liste des besoins en entree
	 *
	 * @return entree : la HashMap des besoin en entree
	 */
	public HashMap<Besoins,Integer> lireEntree(){
		return entree;
	}

	/**
	 * Lire la liste des besoins en sortie
	 *
	 * @return sortie : la HashMap des besoin en sortie
	 */
	public HashMap<Besoins,Integer> lireSortie(){
		return sortie;
	}

	/**
	 * ajouter des besoin en entree.
	 *
	 * @param nb : un nombre 
	 * @param besoin : un besoin
	 */
	public void ajouterEntree(int nb, Besoins besoin) {
		entree.put(besoin,nb);
	}

	/**
	 * Lire la longueur .
	 *
	 * @return x : la longueur du batiment
	 */
	public int getX() {
		return x;
	}

	/**
	 * Modifier la longueur.
	 *
	 * @param x : la longueur d'un batiment
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Lire hauteur.
	 *
	 * @return y : la hauteur
	 */
	public int getY(){
		return y;
	}

	/**
	 * Modifier taille.
	 *
	 * @param y : la taille d'un batiment
	 */
	public void setY(int y){
		this.y = y;
	}

	/**
	 * ajouter un besoin en sortie.
	 *
	 * @param nb : un nombre 
	 * @param besoin :  un besoin
	 */
	public void ajouterSortie(int nb, Besoins besoin) {
		sortie.put(besoin, nb);
	}

	/**
	 * Lire zone.
	 *
	 * @return zone : la zone
	 */
	public int lireZone() {
		return zone;
	}

	/**
	 * Initialiser la matrice des batiments
	 */
	public static void initTabBat(){
		int c = CityBuilder.getCases();
		tabBat = new Batiments[c][c];
		for(int i = 0; i < c; i++){
			for(int j = 0; j < c; j++){
				tabBat[i][j] = null;
			}
		}
	}

	/**
	 * Retourne une copie du batiment
	 * @return une copie du batiment
     */
	public Batiments copie() {
		HashMap<Besoins,Integer> entree = new HashMap<Besoins, Integer>();
		for(Entry<Besoins, Integer> entry : this.entree.entrySet()){
			entree.put(entry.getKey(), entry.getValue());
		}
		HashMap<Besoins,Integer> sortie = new HashMap<Besoins, Integer>();
		for(Entry<Besoins, Integer> entry : this.sortie.entrySet()){
			sortie.put(entry.getKey(), entry.getValue());
		}
		if(this instanceof Habitation){
			return new Habitation(this.nom,this.x,this.y,entree,sortie,this.niveau,((Habitation)this).lireNbHabitant(),this.rayon);
		}
		else{
			return new Commerce(this.nom,this.x,this.y,entree,sortie,this.niveau,((Commerce)this).lireNbEmployee(),((Commerce)this).lireRayon());
		}
	}

	/**
	 * Ajouter un batiment dans la matrice
	 * @param x : sa coordonee x
	 * @param y : sa coordonee y
	 * @param bat : un batiment
     */
	public static void setBatiment(int x, int y, Batiments bat) {

		Batiments leBat = bat.copie();
		leBat.posX = x;
		leBat.posY = y;
		if(tabBat == null)initTabBat();
		for(int i=x; i<bat.getX()+x;i++){
			for(int j=y; j<bat.getY()+y;j++){
				//la matrice des batiments est modifiee sur la zone definie
				tabBat[i][j] = leBat;
			}
		}
		if(leBat instanceof Commerce){
			((Commerce) leBat).modifierNbEmployee(leBat.compterBesoin(Main.employee, x, y));
		}
	}

	/**
	 * Supprimer un batiment
	 * @param x : coordonee x du batiment
	 * @param y : coordonee y du batiment
	 * @param bat : un batiment a  supprimer
     */
	public static void supprimerBatiment(int x, int y, Batiments bat){
		for(int i=x; i<bat.getX()+x;i++){
			for(int j=y; j<bat.getY()+y;j++){
				tabBat[i][j] = null;
			}
		}
	}

	/**
	 * Retourne la matrice des batiments
	 * @return tabBat la matrice des batiments
     */
	public static Batiments[][] getBatiments() {
		if(tabBat == null) initTabBat();
		return tabBat;
	}

	/**
	 * Retourne un batiment a une position choisie
	 * @param x : Coordonee X du batiment
	 * @param y : Coordonee Y du batiment
     * @return tabBat[x][y] : Le batiment a  la position x,y dans la matrice des batiments
     */
	public static Batiments getBatiments(int x, int y){
		if(tabBat == null) initTabBat();
		return tabBat[x][y];

	}

	/**
	 * Retourne la coordonee x du batiment
	 * @return posX
     */
	public int posX() {
		return posX;
	}

	/**
	 * Retourne la coordonee y du batiment
	 * @return posY
     */
	public int posY() {
		return posY;

	}

	/**
	 * retourne nombre actuel du besoin
	 * @param x : la coordonee x du batiment
	 * @param y : la coordonee y du batiment
	 * @param b : le besoin teste
     * @return nb le nombre correpondant au besoin reel
     */
	public int compterBesoin(Besoins b, int x, int y){
		int nb = 0;
		if(b == Main.electricite){
			for (Entry<Besoins, Integer> entry : entree.entrySet()){
				if(entry.getKey() == b){
					if(CityBuilder.getElecDispo()-CityBuilder.getElecUtil() < 0){
						return entry.getValue()/2;
					}else{
						return entry.getValue();
					}
				}
			}
			return nb;
		}
		if(b == Main.employee){
			for (Entry<Besoins, Integer> entry : entree.entrySet()){
				if(entry.getKey() == b){
					int emp = ((Commerce)this).lireNbEmployee();
					nb = Math.min(entry.getValue(),Math.max(0,CityBuilder.getNbEmployeeDispo()-(CityBuilder.getNbEmployee()-emp)));
					/*if(nb < entry.getValue()){
						CityBuilder.getAttenteEmp().add(this);
						System.out.println(posX+" "+posY+" "+nom+" "+niveau);
					}*/
					return nb;
				}
			}
			return nb;
		}
		int rayon = this.lireRayon();
		int xBat = this.getX(); int yBat = this.getY(); //taille du batiment
		int xMin = Math.max(x-rayon,0); int xMax = Math.min(x+rayon+xBat,CityBuilder.getCases()); //debut rayon
		int yMin =Math.max(y-rayon,0); int yMax =Math.min(y+rayon+yBat,CityBuilder.getCases()); // fin rayon
		for(int i = xMin; i<xMax; i++){
			for(int j = yMin; j<yMax; j++){
				if((i<x || i>=(x+xBat) || j<y || j>=(y+yBat))&& i >= 0 && j >= 0){
					//pour chaque case dans le rayon :
					if(tabBat[i][j] != null && tabBat[i][j].posX() == i && tabBat[i][j].posY() == j){
						for (Entry<Besoins, Integer> entryS : Batiments.tabBat[i][j].sortie.entrySet()){
							if (entryS.getKey() == b){
								nb += entryS.getValue();
							}
						}
					}
				}
			}
		}
	return nb;
	}

	/**
	 * Verifie si un besoin est satisfait
	 * @param x : la coordonee x du batiment
	 * @param y : la coordonee y du batiment
	 * @param b : le besoin teste
     * @return true si besoin est satisfait sinon false
     */
	public boolean verifierBesoin(Besoins b, int x, int y){
		for (Entry<Besoins, Integer> entry : this.entree.entrySet()){
			if (entry.getKey() == b){
				if(compterBesoin(b,x,y)>=entry.getValue()-(entry.getValue()/10)){
					return true;
				}else{
					return false;
				}
			}
		}
		//si besoin pas dans les entrees besoin respecte
		return true;
	}

	/**
	 * Verifie si tous les besoins sont satisfaits
	 * @param x : la coordonee x du batiment
	 * @param y : la coordonee y du batiment
     * @return true si les besoins sont satisfaits sinon false
     */
	public boolean verifierBesoin(int x, int y){
		for (Entry<Besoins, Integer> entry : this.entree.entrySet()){
			//si besoin bloquant
			if(bloquant(entry.getKey())){
				//on compte
				if(compterBesoin(entry.getKey(),x,y)< entry.getValue()*0.9){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Augmenter de niveau un batiment
	 * @param p % d'augmentation des valeurs des besoins
	 * @param simu true si c'est un batiment de la carte false si c'est un batiment servant de référence
	 */
	public void updateNiveau(int p, boolean simu){
		niveau++;
		etat = 100;
		//augmentation des besoins en entree
		for (Entry<Besoins, Integer> entry : this.entree.entrySet()){
			int val = (int)(entry.getValue()*(1+((float)p/100)));
			//si la valeur ne change pas ï¿½ cause des arrondis on augmente de 1
			//ex : 3*1.15 = 3.45 --> (int)3.45 = 3 --> pas de changement donc 3 + 1 = 4 : augmentation
			if (val == entry.getValue()) val++;
			int nb = entry.getValue();
			entry.setValue(val);
			if(entry.getKey() == Main.employee && simu == true){
				((Commerce)this).modifierNbEmployee(compterBesoin(Main.employee,posX, posY));
				CityBuilder.setNbEmployee(Math.min(CityBuilder.getNbEmployee()+(val-nb),CityBuilder.getNbEmployeeDispo()));
			}	
		}
		//augmentation des besoins en sortie
		for (Entry<Besoins, Integer> entry : this.sortie.entrySet()){
			int val = (int)(entry.getValue()*(1+((float)p/100)));
			//si la valeur ne change pas ï¿½ cause des arrondis on augmente de 1
			//ex : 3*1.15 = 3.45 --> (int)3.45 = 3 --> pas de changement donc 3 + 1 = 4 : augmentation
			if (val == entry.getValue()) val++;
			if(entry.getKey() == Main.habitants && simu == true){
				CityBuilder.setNbHabitant(CityBuilder.getNbHabitant()+(val-entry.getValue()));
			}else if(entry.getKey() == Main.employee && simu == true){
					CityBuilder.setNbEmployeeDispo(CityBuilder.getNbEmployeeDispo()+(val-entry.getValue()));
				}	
			entry.setValue(val);
		}
		if(nom == "H"){
			switch(niveau){
				case 2:
					ajouterEntree(50,Main.electricite);
					break;
				case 3:
					ajouterEntree(1,Main.education);
					break;
				case 4:
					ajouterEntree(2,Main.divertissements);
					break;
				case 5:
					ajouterEntree(50,Main.securite);
					break;
			}
		}
		Listener.frame.dispose();
	}

	/**
	 * Retourne le batiment de reference en fonction du nom
	 * @param chaine : nom du batiment
	 * @return le batiment de reference
     */
	public static Batiments getRightBatiment(String chaine){
		switch(chaine){
			case "H":
				return Main.uneHabitation;
			case "BP":
				return Main.uneBoulangerie;
			case "U":
				return Main.uneUsine;
			case "C":
				return Main.unCinema;
			case "S":
				return Main.unSupermarche;
			case "SS":
				return Main.uneStation;
			case "B":
				return Main.uneBibliotheque;
			case "CP":
				return Main.uneCaserne;
			case "M":
				return Main.uneMairie;
			case "A":
				return Main.unAeroport;
			case "CN":
				return Main.uneCentrale;
			case "E":
				return Main.uneEcole;
			case "HP":
				return Main.unHopital;
			case "PS":
				return Main.unPalais;
			case "BQ":
				return Main.uneBanque;
			case "CM":
				return Main.unCommissariat;
			case "P":
				return Main.unePoste;
			case "R":
				return Main.unRestaurant;
			case "FF":
				return Main.unFastFood;
			case "L":
				return Main.uneLibrairie;
			case "CA":
				return Main.uneConcession;
			default : return null;
		}
	}

	/**
	 * verifie si le besoin est bloquant
	 * @param b le besoin
	 * @return true si le besoin est bloquant, false sinon
     */
	public boolean bloquant(Besoins b){
		if(nom == "H" || b == Main.electricite || b == Main.carburant ) return false;
		return true;
	}

	/**
	 * Retourne le seuil de satisfaction d'un besoin d'un batiment
	 * @param valeur : valeur du besoin actuel
	 * @param besoinInit : valeur du besoin initial
     * @return le pourcentage de satisfaction
     */
	public static float getSeuil(float valeur, float besoinInit){
		float valeurSeuil = valeur / besoinInit;
		return valeurSeuil;
	}

	/**
	 * Calcul le taux de satisfaction globale
	 * @return le taux de satisfaction globale
	 */
	public float calculSatisfaction(){
		Batiments base = Batiments.getRightBatiment(lireNom()).copie();
        /** On met au jour le niveau du batiment **/
        while(base.getNiveau() < getNiveau()){
            base.updateNiveau(15, false);
        }
		float sommeSeuilEntree = 0;
		int nbBesoins = 0;
		for (Entry<Besoins, Integer> entry : base.lireEntree().entrySet())
        {            
			if(entry.getValue()<compterBesoin(entry.getKey(),posX,posY))
            { 
                sommeSeuilEntree += 100;          
            }
            else 
            {
                sommeSeuilEntree += Batiments.getSeuil(compterBesoin(entry.getKey(),posX,posY), entry.getValue())*100;
            }
			nbBesoins++;
        }
		if(this instanceof Habitation){
			return Math.max(sommeSeuilEntree/nbBesoins - CityBuilder.getChomage()/10,0);
		}else{
			return sommeSeuilEntree/nbBesoins;
		}
	}

	/**
	 * Met a jour les compteurs d'electricite
	 * @param add true si c'est un ajout de batiment, false si c'est une suppression
	 */
	public void majElec(boolean add) {
		if(add){
			for (Entry<Besoins, Integer> entry : sortie.entrySet()){
				if(entry.getKey() == Main.electricite){
					CityBuilder.setElecDispo(CityBuilder.getElecDispo()+entry.getValue());
				}
			}
			CityBuilder.setElecUtil(CityBuilder.getElecUtil()+compterBesoin(Main.electricite,posX,posY));
		}else
		{
			for (Entry<Besoins, Integer> entry : sortie.entrySet()){
				if(entry.getKey() == Main.electricite){
					CityBuilder.setElecDispo(CityBuilder.getElecDispo()-entry.getValue());
				}
			}
			CityBuilder.setElecUtil(CityBuilder.getElecUtil()-compterBesoin(Main.electricite,posX,posY));
		}
	}
	/**
	 * Met a jour les compteurs de population
	 * @param add true si c'est un ajout de batiment, false si c'est une suppression
	 */
	public void majPop(boolean add) {
		if(add){
			for (Entry<Besoins, Integer> entry : sortie.entrySet()){
				if(entry.getKey() == Main.habitants){
					CityBuilder.setNbHabitant(CityBuilder.getNbHabitant()+entry.getValue());
				}
				if(entry.getKey() == Main.employee){
					CityBuilder.setNbEmployeeDispo(CityBuilder.getNbEmployeeDispo()+entry.getValue());
				}
			}
			if(this instanceof Commerce){
				CityBuilder.setNbEmployee(CityBuilder.getNbEmployee()+((Commerce)this).lireNbEmployee());
			}
		}else{
			for (Entry<Besoins, Integer> entry : sortie.entrySet()){
				if(entry.getKey() == Main.habitants){
					CityBuilder.setNbHabitant(CityBuilder.getNbHabitant()-entry.getValue());
				}
				if(entry.getKey() == Main.employee){
					CityBuilder.setNbEmployeeDispo(CityBuilder.getNbEmployeeDispo()-entry.getValue());
				}
			}
			if(this instanceof Commerce){
				CityBuilder.setNbEmployee(CityBuilder.getNbEmployee()-((Commerce)this).lireNbEmployee());
			}
		}
	}
	
	/**
	 * Construit le texte affiche dans les bulles d'aide dans la fenetre ajout batiment
	 * @return le texte affiche dans les bulles d'aide dans la fenetre ajout batiment
	 */
	public String info(){
		String txt = "<html><u>Entrees :</u><br>";
		for (Entry<Besoins, Integer> entry : entree.entrySet()){
			if(bloquant(entry.getKey())){
				txt+="<b> - "+entry.getKey().lireNom()+ " : "+entry.getValue()+"</b><br>";
			}
			else
			{
				txt+=" - "+entry.getKey().lireNom()+ " : "+entry.getValue()+"<br>";
			}
		}
		txt += "<u>Sorties :</u><br>";
		for (Entry<Besoins, Integer> entry : sortie.entrySet()){
			txt+=" - "+entry.getKey().lireNom()+ " : "+entry.getValue()+"<br>";
		}
		txt += "<u>Rayon :</u> "+lireRayon()+"</html>";
		return txt;
	}
	
	/**
	 * @param b le besoin
	 * @return la couleur correpondant au taux de satisfaction du besoin
	 */
	public Color getColorFiltre(Besoins b){
		for (Entry<Besoins, Integer> entry : entree.entrySet()){
			if(entry.getKey() == b){
				float cpt =(compterBesoin(b,posX,posY)/(float)entry.getValue());
				if(cpt >= 1)
				{
					return Color.GREEN;
				}else if(cpt >= 0.75)
					{
						return Color.YELLOW;
					}else if(cpt >= 0.5)
						{
							return Color.ORANGE;	
						}else if(cpt >= 0.25)
							{
								return Color.RED;
							}else{
								return Color.BLACK;
							}
			}
		}
		return null;
	}

	/**
	 * Retourne l'etat du batiment
	 * @return l'etat du batiment
	 */
	public double getEtat() {
		return etat;
	}

	/**
	 * Modifie l'etat du batiment
	 * @param etat du batiment
	 */
	public void setEtat(double etat) {
		this.etat = etat;
	}

	/**
	 * Verifie si une zone n'est pas occupee par un batiment
	 * @param x coordonnee x de depart
	 * @param y coordonnee y de depart
	 * @param lar largeur de la zone a tester
	 * @param hau hauteur de la zone a tester
	 * @return true si la zone est libre sinon false
	 */
	public static boolean verifBat(int x, int y, int lar, int hau) {
		for(int i = x; i<x+lar;i++){
			for(int j = y; j<y+hau;j++){
				if(tabBat[i][j] != null) return false;
			}
		}
		return true;
	}
}
