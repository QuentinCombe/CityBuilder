package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Zone;

/**
 * Classe Zones.
 */
@SuppressWarnings("serial")
public class Zones extends JFrame{
	
	/** La largeur. */
	static JTextField largeur;
	
	/** La hauteur. */
	static JTextField hauteur;
	
	/**
	 * Constructeur.
	 */
	public Zones(){
		this.setMinimumSize(new Dimension(250,200));
		this.setLayout(new BorderLayout());
		JPanel pan = new JPanel();
		this.setContentPane(pan);

		JLabel la = new JLabel("Largeur");
		JLabel lg = new JLabel("Hauteur");
		largeur = new JTextField();
		largeur.setColumns(3);
		hauteur = new JTextField();
		hauteur.setColumns(3);
		//Quand on choisi un type de zone on ouvre DefZone()

		JButton habitations = new JButton("Habitation");
		habitations.addActionListener(new controleur.DefZone(1));
		JButton petitsCommerces = new JButton("Petits commerces");
		petitsCommerces.addActionListener(new controleur.DefZone(2));
		JButton commerces = new JButton("Zone commerciale");
		commerces.addActionListener(new controleur.DefZone(3));
		JButton industries = new JButton("Zone industrielle");
		industries.addActionListener(new controleur.DefZone(4));

		this.getContentPane().add(la,BorderLayout.NORTH);
		this.getContentPane().add(largeur,BorderLayout.NORTH);
		this.getContentPane().add(lg,BorderLayout.NORTH);
		this.getContentPane().add(hauteur,BorderLayout.NORTH);
		this.getContentPane().add(habitations,BorderLayout.SOUTH);
		this.getContentPane().add(petitsCommerces,BorderLayout.SOUTH);
		this.getContentPane().add(commerces,BorderLayout.SOUTH);
		this.getContentPane().add(industries,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	/**
	 * Lire la largeur.
	 *
	 * @return la largeur
	 */
	public static int getLargeur(){
		return Integer.parseInt(largeur.getText());
	}
	
	/**
	 * Modifier la hauteur.
	 *
	 * @return la hauteur
	 */
	public static int getHauteur(){
		return Integer.parseInt(hauteur.getText());
	}
	
	/**
	 * Afficher les zones.
	 */
	public static void printZones(){
		int[][] tabZones = Zone.getZones();
		JLabel[][] tabCases = CityBuilder.getGrille();
		for(int i = 0; i<CityBuilder.getCases();i++){
			for(int j = 0; j<CityBuilder.getCases();j++){
				//pour toutes les cases de la matrice des zones tabZones[][] --> on colorie le JLabel qui correspond
				switch(tabZones[i][j]){
				case 1: //tabZones[i][j] = 1 --> tabCases[i][j] = bleu 
					tabCases[i][j].setBackground(Color.BLUE);
					break;
				case 2://tabZones[i][j] =2 --> tabCases[i][j] = orange
					tabCases[i][j].setBackground(Color.ORANGE);
					break;
				case 3://tabZones[i][j] =3 --> tabCases[i][j] = rouge
					tabCases[i][j].setBackground(Color.RED);
					break;

				case 4://tabZones[i][j] =4 --> tabCases[i][j] = vert
					tabCases[i][j].setBackground(Color.GREEN);
					break;
				}
			}
		}
	}
}
