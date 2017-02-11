/*
 * 
 */
package vue;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Classe VueAjout.
 */
@SuppressWarnings("serial")
public class VueAjout extends JFrame{

	/**
	 * Constructeur.
	 */
	public VueAjout(){

		super("Ajout d'un batiment");
		setSize(500,500);
		
		/** Création du panel principal **/
		JPanel panneau = new JPanel(new GridLayout(7,3));
		setContentPane(panneau);
		TitledBorder border = BorderFactory.createTitledBorder("Selectionner le batiment à ajouter");
		panneau.setBorder(border);		
		
		/** Création des labels à afficher **/
		JButton button1 = new JButton(" : Habitation",new ImageIcon("img/habitation.png"));
		button1.addActionListener(new controleur.ControleurBatiment(Main.uneHabitation));
		button1.setToolTipText(Main.uneHabitation.info());
		JButton button2 = new JButton(" : Boulangerie",new ImageIcon("img/boulangerie.png"));
		button2.addActionListener(new controleur.ControleurBatiment(Main.uneBoulangerie));
		button2.setToolTipText(Main.uneBoulangerie.info());
		JButton button3 = new JButton(" : Usine",new ImageIcon("img/usine.png"));
		button3.addActionListener(new controleur.ControleurBatiment(Main.uneUsine));
		button3.setToolTipText(Main.uneUsine.info());
		JButton button4 = new JButton(" : Cinema",new ImageIcon("img/cine.png"));
		button4.addActionListener(new controleur.ControleurBatiment(Main.unCinema));
		button4.setToolTipText(Main.unCinema.info());
		JButton button5 = new JButton(" : Supermarche",new ImageIcon("img/supermarcher.png"));
		button5.addActionListener(new controleur.ControleurBatiment(Main.unSupermarche));
		button5.setToolTipText(Main.unSupermarche.info());
		JButton button6 = new JButton(" : Station service",new ImageIcon("img/station.png"));
		button6.addActionListener(new controleur.ControleurBatiment(Main.uneStation));
		button6.setToolTipText(Main.uneStation.info());
		JButton button7 = new JButton(" : Bibliotheque",new ImageIcon("img/bibliotheque.png"));
		button7.addActionListener(new controleur.ControleurBatiment(Main.uneBibliotheque));
		button7.setToolTipText(Main.uneBibliotheque.info());
		JButton button8 = new JButton(" : Caserne",new ImageIcon("img/caserne.png"));
		button8.addActionListener(new controleur.ControleurBatiment(Main.uneCaserne));
		button8.setToolTipText(Main.uneCaserne.info());
		JButton button9 = new JButton(" : Hotel de ville",new ImageIcon("img/mairie.png"));
		button9.addActionListener(new controleur.ControleurBatiment(Main.uneMairie));
		button9.setToolTipText(Main.uneMairie.info());
		JButton button10 = new JButton(" : Aeroport",new ImageIcon("img/aeroport.png"));
		button10.addActionListener(new controleur.ControleurBatiment(Main.unAeroport));
		button10.setToolTipText(Main.unAeroport.info());
		JButton button11 = new JButton(" : Centrale",new ImageIcon("img/central.png"));
		button11.addActionListener(new controleur.ControleurBatiment(Main.uneCentrale));
		button11.setToolTipText(Main.uneCentrale.info());
		JButton button12 = new JButton(" : Ecole",new ImageIcon("img/ecole.png"));
		button12.addActionListener(new controleur.ControleurBatiment(Main.uneEcole));
		button12.setToolTipText(Main.uneEcole.info());
		JButton button13 = new JButton(" : Hopital",new ImageIcon("img/hopital.png"));
		button13.addActionListener(new controleur.ControleurBatiment(Main.unHopital));
		button13.setToolTipText(Main.unHopital.info());
		JButton button14 = new JButton(" : Palais des sports",new ImageIcon("img/palaisdessports.png"));
		button14.addActionListener(new controleur.ControleurBatiment(Main.unPalais));
		button14.setToolTipText(Main.unPalais.info());
		JButton button15 = new JButton(" : Banque",new ImageIcon("img/banque.png"));
		button15.addActionListener(new controleur.ControleurBatiment(Main.uneBanque));
		button15.setToolTipText(Main.uneBanque.info());
		JButton button16 = new JButton(" : Commissariat",new ImageIcon("img/police.png"));
		button16.addActionListener(new controleur.ControleurBatiment(Main.unCommissariat));
		button16.setToolTipText(Main.unCommissariat.info());
		JButton button17 = new JButton(" : Poste",new ImageIcon("img/poste.png"));
		button17.addActionListener(new controleur.ControleurBatiment(Main.unePoste));
		button17.setToolTipText(Main.unePoste.info());
		JButton button18 = new JButton(" : Restaurant",new ImageIcon("img/restaurant.png"));
		button18.addActionListener(new controleur.ControleurBatiment(Main.unRestaurant));
		button18.setToolTipText(Main.unRestaurant.info());
		JButton button19 = new JButton(" : Fast-Food",new ImageIcon("img/fast-food.png"));
		button19.addActionListener(new controleur.ControleurBatiment(Main.unFastFood));
		button19.setToolTipText(Main.unFastFood.info());
		JButton button20 = new JButton(" : Librairie",new ImageIcon("img/librairie.png"));
		button20.addActionListener(new controleur.ControleurBatiment(Main.uneLibrairie));
		button20.setToolTipText(Main.uneLibrairie.info());
		JButton button21 = new JButton(" : Concession auto",new ImageIcon("img/universite.png"));
		button21.addActionListener(new controleur.ControleurBatiment(Main.uneConcession));
		button21.setToolTipText(Main.uneConcession.info());
		
		panneau.add(button1);
		panneau.add(button2);
		panneau.add(button3);
		panneau.add(button4);
		panneau.add(button5);
		panneau.add(button6);
		panneau.add(button7);
		panneau.add(button8);
		panneau.add(button9);
		panneau.add(button10);
		panneau.add(button11);
		panneau.add(button12);
		panneau.add(button13);
		panneau.add(button14);
		panneau.add(button15);
		panneau.add(button16);
		panneau.add(button17);
		panneau.add(button18);
		panneau.add(button19);
		panneau.add(button20);
		panneau.add(button21);
		
		setVisible(true);
	}
}
