package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
//import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import modele.Batiments;
import modele.Commerce;

/**
 * Classe CityBuilder.
 */
@SuppressWarnings("serial")
public class CityBuilder extends JFrame{
	
	/** Le nombre de cases. */
	static int cases;
	
	/** La matrice de Jlabel. */
	static JLabel[][] tabCases;
	
	/** Le panel qui contient la grille de jeu. */
	public static JPanel grille;
	
	/** Le panel qui contient l'onglet filtre. */
	public static JPanel filtres;
	
	/** Le nombre d'habitant. */
	private static int nbHabitant = 0;
	
	/** Le label qui affiche le nombre d'habitant. */
	public static JLabel nbHab = new JLabel("Nombre d'habitant dans votre ville :"+nbHabitant);
	
	/** Le nombre d'employes disponibles. */
	private static int nbEmployeedispo = 0;
	
	/** Le nombre d'employes. */
	private static int nbEmployee = 0;
	
	/** Le taux de chomage. */
	private static int chomage = 0;
	
	/** Le label qui affiche le nombre d'employes. */
	public static JLabel nbEmp = new JLabel("Nombre d'employes dans votre ville :"+nbEmployee);
	
	/** Le label qui affiche le taux de chomage */
	public static JLabel chom = new JLabel("Chomage : 0 %");
	
	/** Quantite d'éléctricité demandee. */
	private static int elecUtil = 0;
	
	/** Quantite d'electricite disponible. */
	private static int elecDispo = 0;
	
	/** Liste des batiments en attente d'employes */
	private static ArrayList<Batiments> attenteEmp = new ArrayList<Batiments>();
	
	/**
	 * Constructeur.
	 */
	public CityBuilder(){
		/*System.out.println("Saisir le nombre de cases :");
		int cases = new Scanner(System.in).nextInt();*/
		cases = 30;
		tabCases = new JLabel[cases][cases];
		this.setName("CityBuilder");
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//Zone des filtres
		filtres = new JPanel();
		TitledBorder border = BorderFactory.createTitledBorder("Filtres :");
		filtres.setBorder(border);
		filtres.setBackground(new Color(109,184,204));
		filtres.setPreferredSize(new Dimension(300,400));			
		drawFiltres();

		//Zone de la grille
		grille = new JPanel(new GridLayout(cases,cases));
		grille.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		drawGrille();
		
		this.getContentPane().add(filtres,BorderLayout.LINE_START);
		this.getContentPane().add(grille,BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	/**
	 * Lire le nombre de cases.
	 *
	 * @return le nombre de cases
	 */
	public static int getCases(){
		return cases;
	}
	
	/**
	 * Lire la grille.
	 *
	 * @return la grille
	 */
	public static JLabel[][] getGrille(){
		return tabCases;
	}
	
	/**
	 * Afficher la grille.
	 */
	public static void drawGrille(){
		//On dessine la grille avec des JLabel placÃ©s dans un GridBagLayout
		grille = new JPanel(new GridLayout(cases,cases));
		for (int i =0; i<cases; i++){
			//case aux coordonnÃ©es (i,j) = tabCases[i][j]
			for(int j=0;j<cases; j++){
				final JLabel label = new JLabel("",SwingConstants.CENTER);
				label.setVerticalTextPosition(SwingConstants.CENTER);
			    label.setName(i+","+j);
			    label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			    label.setOpaque(true);
			    label.addMouseListener(new controleur.Listener()); //Listener est lancï¿½ au clic sur une case
			    grille.add(label);
			    tabCases[i][j] = label;
			}    
		}
	}
	
	/**
	 * Afficher la zone des filtres.
	 */
	public static void drawFiltres(){
		JButton aucun = new JButton("Aucun");
		aucun.addActionListener(new controleur.filtres("aucun"));
		JButton satisfaction = new JButton("Satisfaction");
		satisfaction.addActionListener(new controleur.filtres("satisfaction"));
		JButton zones = new JButton("Zones");
		zones.addActionListener(new controleur.filtres("zones"));
		JButton habitants = new JButton("Habitants");
		habitants.addActionListener(new controleur.filtres("habitants"));
		JButton pain = new JButton("Pain");
		pain.addActionListener(new controleur.filtres("pain"));
		JButton nourriture = new JButton("Nourriture");
		nourriture.addActionListener(new controleur.filtres("nourriture"));
		JButton voitures = new JButton("Voitures");
		voitures.addActionListener(new controleur.filtres("voitures"));
		JButton electricite = new JButton("Electricite");
		electricite.addActionListener(new controleur.filtres("electricite"));
		JButton presse = new JButton("Presse");
		presse.addActionListener(new controleur.filtres("presse"));
		JButton argent = new JButton("Argent");
		argent.addActionListener(new controleur.filtres("argent"));
		JButton boisson = new JButton("Boisson");
		boisson.addActionListener(new controleur.filtres("boisson"));
		JButton papeterie = new JButton("Papeterie");
		papeterie.addActionListener(new controleur.filtres("papeterie"));
		JButton vetements = new JButton("Vetements");
		vetements.addActionListener(new controleur.filtres("vetements"));
		JButton electromenager = new JButton("Electromenager");
		electromenager.addActionListener(new controleur.filtres("electromenager"));
		JButton communication = new JButton("Communication");
		communication.addActionListener(new controleur.filtres("communication"));
		JButton soins = new JButton("Soins");
		soins.addActionListener(new controleur.filtres("soins"));
		JButton securite = new JButton("Securite");
		securite.addActionListener(new controleur.filtres("securite"));
		JButton culture = new JButton("Culture");
		culture.addActionListener(new controleur.filtres("culture"));
		JButton divertissements = new JButton("Divertissements");
		divertissements.addActionListener(new controleur.filtres("divertissements"));
		JButton education = new JButton("Education");
		education.addActionListener(new controleur.filtres("education"));
		JButton carburant = new JButton("Carburant");
		carburant.addActionListener(new controleur.filtres("carburant"));
		JButton serviceCommuns = new JButton("Services Communs");
		serviceCommuns.addActionListener(new controleur.filtres("serviceCommuns"));
		JButton transport = new JButton("Transport");
		transport.addActionListener(new controleur.filtres("transport"));
		JButton information = new JButton("Information");
		information.addActionListener(new controleur.filtres("information"));
		JButton employee = new JButton("Employee");
		employee.addActionListener(new controleur.filtres("employee"));
		filtres.add(aucun);
		filtres.add(zones);
		filtres.add(satisfaction);
		filtres.add(habitants);
		filtres.add(pain);
		filtres.add(nourriture);
		filtres.add(voitures);
		filtres.add(electricite);
		filtres.add(presse);
		filtres.add(argent);
		filtres.add(boisson);
		filtres.add(papeterie);
		filtres.add(vetements);
		filtres.add(electromenager);
		filtres.add(communication);
		filtres.add(soins);
		filtres.add(securite);
		filtres.add(culture);
		filtres.add(divertissements);
		filtres.add(education);
		filtres.add(carburant);
		filtres.add(serviceCommuns);
		filtres.add(transport);
		filtres.add(information);
		filtres.add(employee);
		filtres.add(nbHab);
		filtres.add(nbEmp);
		filtres.add(chom);
	}
	
	/**
	 * Supprimer les couleurs correpondant aux filtres.
	 */
	public static void noFiltre() {
		for(int i=0;i<cases;i++){
			for(int j=0;j<cases;j++){
				tabCases[i][j].setBackground(null);
			}
		}
	}
	
	/**
	 * Modifier le nombre d'habitants.
	 *
	 * @param nbHabitant le nombre d'habitants
	 */
	public static void setNbHabitant(int nbHabitant) {
		CityBuilder.nbHabitant = nbHabitant;
		nbHab.setText("Nombre d'habitants dans votre ville : "+CityBuilder.nbHabitant);
		
	}

	/**
	 * Modifier le nombre d'employes.
	 *
	 * @param nbEmployee le nombre d'employes
	 */
	public static void setNbEmployee(int nbEmployee) {
		CityBuilder.nbEmployee = nbEmployee;
		nbEmp.setText("Nombre d'employes dans votre ville : "+CityBuilder.nbEmployee);
		setChomage();
	}

	/**
	 * Lire le nombre d'habitants.
	 *
	 * @return le nombre d'habitants
	 */
	public static int getNbHabitant() {

		return nbHabitant;
	}

	/**
	 * Lire le nombre d'employes.
	 *
	 * @return le nombre d'employes
	 */
	public static int getNbEmployee() {
		return nbEmployee;
	}
	
	/**
	 * Lire l'electricite disponible.
	 *
	 * @return l'electricite disponible
	 */
	public static Integer getElecDispo() {
		return elecDispo;
	}
	
	/**
	 * Modifier l'electricite disponible.
	 *
	 * @param i la quantité d'electricite disponible
	 */
	public static void setElecDispo(int i) {
		elecDispo = i;
		
	}
	
	/**
	 * Lire l'electricite demandee.
	 *
	 * @return l'electricite demandee
	 */
	public static Integer getElecUtil() {
		return elecUtil;
	}
	
	/**
	 * Modifier la quantite d'electricite demandee.
	 *
	 * @param i la quantite d'electricite demandee
	 */
	public static void setElecUtil(int i) {
		elecUtil = i;
		
	}
	
	/**
	 * Lire le nombre d'employes disponibles.
	 *
	 * @return le nombre d'employes disponibles
	 */
	public static Integer getNbEmployeeDispo() {
		return nbEmployeedispo;
	}
	
	/**
	 * Modifier le nombre d'employes disponibles.
	 *
	 * @param i le nombre d'employes disponibles
	 */
	public static void setNbEmployeeDispo(int i) {
		nbEmployeedispo = i;
		setChomage();
	}
	
	/**
	 * Lire le taux de chomage.
	 *
	 * @return le taux de chomage
	 */
	public static int getChomage(){
		return chomage;
	}
	
	/**
	 * Mettre a jour le taux de chomage.
	 */
	public static void setChomage() {
		chomage = (int)(((float)(nbEmployeedispo-nbEmployee)/nbEmployeedispo)*100);	
		chom.setText("Chomage : "+ chomage+" %");
	}
	
	/**
	 * Lire la liste des batiments en attente d'employes
	 *
	 * @return la liste des batiments en attente d'employes
	 */
	public static ArrayList<Batiments> getAttenteEmp() {
		return attenteEmp;
	}
	
	/**
	 * met a jour le nombre d'employes des batiments en attente d'employes lors de l'arrivee de nouveaux employes
	 */
	public static void embauche(){
		while(attenteEmp.size()>0 && nbEmployeedispo > nbEmployee){
			Commerce c  = ((Commerce)attenteEmp.get(0));
			int nb = c.compterBesoin(Main.employee, c.posX(), c.posY());
			setNbEmployee(getNbEmployee()-c.lireNbEmployee()+nb);
			c.modifierNbEmployee(nb);
			attenteEmp.remove(0);
		}
	}
	
	/**
	 * Supprime des employees des batiments lors du départ d'employes
	 *
	 * @param x coordonée x d'ou les employes sont partis
	 * @param y coordonée y d'ou les employes sont partis
	 */
	public static void debauche(int x, int y){
		int rayon = 1;
		while(nbEmployee > nbEmployeedispo){
			int nbCases = 0;
			for(int i = Math.max(0,x-rayon); i < Math.min(cases,x+rayon); i++){
				for(int j = Math.max(0,y-rayon); j < Math.min(cases,y+rayon); j++){
					Batiments bat = Batiments.getBatiments(i, j);
					if(bat instanceof Commerce){
						int nb = bat.compterBesoin(Main.employee, i, j);
						setNbEmployee(getNbEmployee()-((Commerce) bat).lireNbEmployee()+nb);
						if(nb < ((Commerce) bat).lireNbEmployee()){
							CityBuilder.attenteEmp.add(bat);
						}
						((Commerce) bat).modifierNbEmployee(nb);
						if(nbEmployee <= nbEmployeedispo) return;
					}
					nbCases++;
					if(nbCases >= cases*cases) return;
				}
			}
			rayon++;
		}
	}
}
