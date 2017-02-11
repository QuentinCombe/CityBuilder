package vue;
import java.util.HashMap;

import modele.Besoins;
import modele.Commerce;
import modele.Habitation;
import modele.Temps;



public class Main {
	static CityBuilder jeu;
	/**
	 * Initialisation des batiments
	 */
	public static Habitation uneHabitation = new Habitation("H",1,1,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),1,2,4);
	public static Commerce uneBoulangerie = new Commerce("BP",1,2,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),2,2,5);
	public static Commerce uneUsine = new Commerce("U",4,4,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),4,2,5);
	public static Commerce unCinema = new Commerce("C",4,4,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),3,2,5);
	public static Commerce unSupermarche = new Commerce("S",3,3,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),2,2,5);
	public static Commerce uneStation = new Commerce("SS",1,1,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),2,2,5);
	public static Commerce uneBibliotheque = new Commerce("B",2,2,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),2,2,5);
	public static Commerce uneCaserne = new Commerce("CP",2,2,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),1,2,5);
	public static Commerce uneMairie = new Commerce("M",5,5,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),1,2,5);
	public static Commerce unAeroport = new Commerce("A",7,7,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),4,2,5);
	public static Commerce uneCentrale = new Commerce("CN",4,4,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),4,2,5);
	public static Commerce uneEcole = new Commerce("E",2,2,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),1,2,5);
	public static Commerce unHopital = new Commerce("HP",5,5,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),3,2,5);
	public static Commerce unPalais = new Commerce("PS",6,6,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),1,2,5);
	public static Commerce uneBanque = new Commerce("BQ",2,2,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),3,2,5);
	public static Commerce unCommissariat = new Commerce("CM",3,3,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),1,2,5);
	public static Commerce unePoste = new Commerce("P",1,1,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),2,2,5);
	public static Commerce unRestaurant = new Commerce("R",1,2,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),2,2,5);
	public static Commerce unFastFood = new Commerce("FF",1,2,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),2,2,5);
	public static Commerce uneLibrairie = new Commerce("L",2,2,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),2,2,5);
	public static Commerce uneConcession = new Commerce("CA",2,3,new HashMap<Besoins,Integer>(),new HashMap<Besoins,Integer>(),3,2,5);
	
	/**
	 * Initialisation des besoins
	 */
	public static Besoins habitants = new Besoins("Habitants");
	public static Besoins pain = new Besoins("Pain");
	public static Besoins nourriture  = new Besoins("Nourriture ");
	public static Besoins voitures = new Besoins("Voitures");
	public static Besoins electricite = new Besoins("Electricite");
	public static Besoins presse = new Besoins("Presse");
	public static Besoins argent = new Besoins("Argent");
	public static Besoins boisson = new Besoins("Boisson");
	public static Besoins papeterie = new Besoins("Papeterie");
	public static Besoins vetements = new Besoins("Vetements");
	public static Besoins electromenager = new Besoins("Electromenager");
	public static Besoins communication = new Besoins("Communication");
	public static Besoins soins = new Besoins("Soins");
	public static Besoins securite = new Besoins("Securite");
	public static Besoins culture = new Besoins("Culture");
	public static Besoins divertissements = new Besoins("Divertissements");
	public static Besoins education = new Besoins("Education");
	public static Besoins carburant = new Besoins("Carburant");
	public static Besoins serviceCommuns  = new Besoins("Service communs ");
	public static Besoins transport  = new Besoins("transport ");
	public static Besoins information  = new Besoins("information ");
    public static Besoins employee  = new Besoins("employee ");
	
	public static void main(String[] args) throws InterruptedException {
		jeu = new CityBuilder();
		
		/** Remplissage des hashmap de besoin pour chaque batiments*/
		
		/** Boulangerie**/
		uneBoulangerie.ajouterEntree(150, electricite);
		uneBoulangerie.ajouterEntree(10, habitants);
		uneBoulangerie.ajouterSortie(500, pain);
		uneBoulangerie.ajouterEntree(3 , employee);


		/** Habitation **/
		uneHabitation.ajouterEntree(1, pain);
		uneHabitation.ajouterSortie(1, habitants);
		uneHabitation.ajouterSortie(1, employee);

		/** Usine **/ 
		uneUsine.ajouterEntree(300, electricite);
		uneUsine.ajouterEntree(50, habitants);
		uneUsine.ajouterSortie(350, electricite);
        uneUsine.ajouterEntree(20, employee);
		
		/** Cin�ma **/
		unCinema.ajouterEntree(300, electricite);
        unCinema.ajouterEntree(5, employee);
		unCinema.ajouterEntree(450, habitants);
		unCinema.ajouterSortie(150, divertissements);
		unCinema.ajouterSortie(5, employee);

		/** Supermarch� **/
		unSupermarche.ajouterEntree(100, electricite);
		unSupermarche.ajouterEntree(20, employee);
		unSupermarche.ajouterEntree(50, habitants);
		unSupermarche.ajouterSortie(500, pain);
		unSupermarche.ajouterSortie(1000, nourriture);
		unSupermarche.ajouterSortie(50, presse);
		
		/** Station-Service **/
		uneStation.ajouterEntree(250, carburant);
		uneStation.ajouterEntree(5, employee);
		uneStation.ajouterEntree(25, voitures);
		uneStation.ajouterEntree(50, electricite);
		uneStation.ajouterEntree(500, habitants);
		uneStation.ajouterSortie(500, carburant);
		
		/** Biblioth�que **/
		uneBibliotheque.ajouterEntree(100, education);
		uneBibliotheque.ajouterEntree(10, employee);
		uneBibliotheque.ajouterEntree(100, information);
		uneBibliotheque.ajouterEntree(150, electricite);
		uneBibliotheque.ajouterEntree(50, habitants);
		uneBibliotheque.ajouterSortie(300, culture);
		uneBibliotheque.ajouterSortie(100, divertissements);
		uneBibliotheque.ajouterSortie(100, education);
		
		/** Caserne **/
		uneCaserne.ajouterEntree(100, soins);
		uneCaserne.ajouterEntree(20, employee);
		uneCaserne.ajouterEntree(20, communication);
		uneCaserne.ajouterEntree(20, nourriture);
		uneCaserne.ajouterEntree(20, vetements);
		uneCaserne.ajouterEntree(50, voitures);
		uneCaserne.ajouterEntree(200, carburant);
		uneCaserne.ajouterEntree(150, electricite);
		uneCaserne.ajouterEntree(100, habitants);
		uneCaserne.ajouterSortie(250, securite);
		
		/** Mairie **/
		uneMairie.ajouterEntree(50, habitants);
		uneMairie.ajouterEntree(15, employee);

		/** Aeroport **/ 
		unAeroport.ajouterEntree(500, electricite);
		unAeroport.ajouterEntree(250, employee);
		unAeroport.ajouterEntree(250, boisson);
		unAeroport.ajouterEntree(250, communication);
		unAeroport.ajouterEntree(3500, carburant);
		unAeroport.ajouterEntree(250, nourriture);
		unAeroport.ajouterEntree(100, serviceCommuns);
		unAeroport.ajouterEntree(2500, habitants);
		unAeroport.ajouterSortie(1500, transport);
		
		/** Central **/
		uneCentrale.ajouterEntree(250, soins);
		uneCentrale.ajouterEntree(15, employee);
		uneCentrale.ajouterEntree(500, securite);
		uneCentrale.ajouterEntree(250, electricite);
		uneCentrale.ajouterEntree(25, habitants);
		uneCentrale.ajouterSortie(1500, electricite);
		
		/** Ecole **/
		uneEcole.ajouterEntree(250, electricite);
		uneEcole.ajouterEntree(15, employee);
		uneEcole.ajouterEntree(150, divertissements);
		uneEcole.ajouterEntree(200, nourriture);
		uneEcole.ajouterEntree(250, transport);
		uneEcole.ajouterEntree(150, papeterie);
		uneEcole.ajouterEntree(150, pain);
		uneEcole.ajouterEntree(150, boisson);
		uneEcole.ajouterEntree(150, culture);
		uneEcole.ajouterEntree(50, habitants);
		uneEcole.ajouterSortie(200, education);
		
		/** Hopital **/
		unHopital.ajouterEntree(500, electricite);
		unHopital.ajouterEntree(50, employee);
		unHopital.ajouterEntree(250, electromenager);
		unHopital.ajouterEntree(250, voitures);
		unHopital.ajouterEntree(250, nourriture);
		unHopital.ajouterEntree(250, boisson);
		unHopital.ajouterEntree(250, pain);
		unHopital.ajouterEntree(250, carburant);
		unHopital.ajouterEntree(850, habitants);
		unHopital.ajouterSortie(500, soins);
		
		/** Palais des Sports**/
		unPalais.ajouterEntree(300, electricite);
		unPalais.ajouterEntree(15, employee);
		unPalais.ajouterEntree(150, soins);
		unPalais.ajouterEntree(150, securite);
		unPalais.ajouterEntree(150, boisson);
		unPalais.ajouterEntree(500, habitants);
		unPalais.ajouterSortie(250, divertissements);
		
		/** Banque **/
		uneBanque.ajouterEntree(300, electricite);
		uneBanque.ajouterEntree(20, employee);
		uneBanque.ajouterEntree(150, securite);
		uneBanque.ajouterEntree(150, papeterie);
		uneBanque.ajouterEntree(100, presse);
		uneBanque.ajouterEntree(50, habitants);
		uneBanque.ajouterSortie(500, argent);
		
		/** Commissariat **/
		unCommissariat.ajouterEntree(300, electricite);
		unCommissariat.ajouterEntree(20, employee);
		unCommissariat.ajouterEntree(250, carburant);
		unCommissariat.ajouterEntree(100, voitures);
		unCommissariat.ajouterEntree(200, communication);
		unCommissariat.ajouterEntree(100, information);
		unCommissariat.ajouterEntree(100, presse);
		unCommissariat.ajouterEntree(50, vetements);
		unCommissariat.ajouterEntree(100, habitants);
		unCommissariat.ajouterSortie(200, securite);
		
		/** Poste **/
		unePoste.ajouterEntree(200, electricite);
		unePoste.ajouterEntree(15, employee);
		unePoste.ajouterEntree(300, papeterie);
		unePoste.ajouterEntree(50, voitures);
		unePoste.ajouterEntree(50, vetements);
		unePoste.ajouterEntree(200, carburant);
		unePoste.ajouterEntree(100, habitants);
		unePoste.ajouterSortie(150, information );
		
		/** Restaurant **/
		unRestaurant.ajouterEntree(250, electricite);
		unRestaurant.ajouterEntree(10, employee);
		unRestaurant.ajouterEntree(200, boisson);
		unRestaurant.ajouterEntree(250, electromenager);
		unRestaurant.ajouterEntree(200, nourriture);
		unRestaurant.ajouterEntree(200, pain);
		unRestaurant.ajouterEntree(500, habitants);
		unRestaurant.ajouterSortie(100, nourriture);
		unRestaurant.ajouterSortie(100, boisson);
		
		/** Fast-Food**/
		unFastFood.ajouterEntree(250, electricite);
		unFastFood.ajouterEntree(20, employee);
		unFastFood.ajouterEntree(200, electromenager);
		unFastFood.ajouterEntree(50, vetements);
		unFastFood.ajouterEntree(25, habitants);
		unFastFood.ajouterSortie(100, nourriture);
		unRestaurant.ajouterSortie(100, boisson);

		/** Librairie **/
		uneLibrairie.ajouterEntree(200, electricite);
		uneLibrairie.ajouterEntree(5, employee);
		uneLibrairie.ajouterEntree(10, habitants);
		uneLibrairie.ajouterSortie(200, information);
		uneLibrairie.ajouterSortie(100, papeterie);
		
		/** Concession **/
		uneConcession.ajouterEntree(250, electricite);
		uneConcession.ajouterEntree(10, employee);
		uneConcession.ajouterEntree(200, carburant);
		uneConcession.ajouterEntree(30, habitants);
		uneConcession.ajouterSortie(20, voitures);
		/**
		 * Lancement du thread de simulation du temps
		 */
		Thread tps = new Temps();
		tps.run();
	}
}
