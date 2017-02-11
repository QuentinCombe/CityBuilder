package vue;

import java.awt.Color;

import javax.swing.*;

import modele.Batiments;
import modele.Besoins;
import modele.Commerce;

/**
 * Classe AffichageBatiments.
 */
public class AffichageBatiments {
	
	/**
	 * Afficher un batiment
	 *
	 * @param x coordonee du batiment
	 * @param y coordonee du batiment
	 * @param bat le batiment a afficher
	 */
	public static void afficherBatiment(int x, int y,Batiments bat){
		JLabel[][] tabCases = CityBuilder.getGrille();
		tabCases[x][y].setText(bat.lireNom()+bat.getNiveau());
		for(int i = x+1; i<(x+bat.getX());i++){
				tabCases[i][y].setText("|");
				tabCases[i][y+bat.getY()-1].setText("|");
		}
		for(int i = y+1;i<y+bat.getY();i++){

			tabCases[x][i].setText("-");
			if (tabCases[x+bat.getX()-1][i-1].getText() == "") tabCases[x+bat.getX()-1][i-1].setText(tabCases[x+bat.getX()-1][i].getText()+"-");
		}
	}
	
	/**
	 * Supprimer l'affichage du batiment
	 *
	 * @param x coordonee du batiment
	 * @param y coordonee du batiment
	 * @param bat le batiment supprimé
	 */
	public static void supprimerAffichage(int x, int y,Batiments bat){
		JLabel[][] tabCases = CityBuilder.getGrille();
		tabCases[x][y].setText("");
		for(int i = x+1; i<(x+bat.getX());i++){
			tabCases[i][y].setText("");
			tabCases[i][y+bat.getY()-1].setText("");
		}
		for(int i = y+1;i<y+bat.getY();i++){
			tabCases[x][i].setText("");
			if (tabCases[x+bat.getX()-1][i].getText() == "") tabCases[x+bat.getX()-1][i].setText(tabCases[x+bat.getX()-1][i].getText()+"");
		}
	}
	
	/**
	 * Affiche le rayon d'influence.
	 *
	 * @param x coordonee du batiment
	 * @param y coordonee du batiment
	 */
	public static void afficherRayon(int x, int y){
		CityBuilder.noFiltre();
		JLabel[][] tabCases = CityBuilder.getGrille();
		Batiments bat = Batiments.getBatiments()[x][y];
		int rayon = ((Commerce)bat).lireRayon();
		int xPos = bat.posX(); 
		int yPos = bat.posY(); //positions haut gauche du batiment
		int xBat = bat.getX(); int yBat = bat.getY(); //taille du batiment
		int xMin = Math.max(xPos-rayon,0); int xMax = Math.min(xPos+rayon+xBat,CityBuilder.cases); //dï¿½but rayon
		int yMin =Math.max(yPos-rayon,0); int yMax =Math.min(yPos+rayon+yBat,CityBuilder.cases); // fin rayon
		for(int i = xMin; i<xMax; i++){
			for(int j = yMin; j<yMax; j++){
				if(i<x || i>=(x+xBat) || j<y || j>=(y+yBat)&& i >= 0 && j >= 0) 
					tabCases[i][j].setBackground(Color.YELLOW);}
			}
		}
	
	/**
	 * Affiche les couleurs correspondant à la satisfaction du besoin
	 *
	 * @param b le besoin
	 */
	public static void filtre(Besoins b){
		Batiments[][] tabBat = Batiments.getBatiments();
		JLabel[][] tabCases = CityBuilder.getGrille();
		for(int i = 0; i< CityBuilder.cases; i++){
			for(int j = 0; j< CityBuilder.cases; j++){
				if(tabBat[i][j] != null){
					tabCases[i][j].setBackground(tabBat[i][j].getColorFiltre(b));
				}
			}
		}
	}

	/**
	 * Affiche les couleurs correpondant à la satisfaction globale des batiments
	 */
	public static void satisfaction() {
		Batiments[][] tabBat = Batiments.getBatiments();
		JLabel[][] tabCases = CityBuilder.getGrille();
		for(int i = 0; i< CityBuilder.cases; i++){
			for(int j = 0; j< CityBuilder.cases; j++){
				if(tabBat[i][j] != null){
					float cpt = tabBat[i][j].calculSatisfaction();
					if(cpt >= 100)
					{
						tabCases[i][j].setBackground(Color.GREEN);
					}else if(cpt >= 75)
						{
						tabCases[i][j].setBackground(Color.YELLOW);
						}else if(cpt >= 50)
							{
							tabCases[i][j].setBackground(Color.ORANGE);	
							}else if(cpt >= 25)
								{
								tabCases[i][j].setBackground(Color.RED);
								}else{
									tabCases[i][j].setBackground(Color.BLACK);
								}
				}
			}
		}
	}
	
	/**
	 * Modifier l'affichage du niveau.
	 *
	 * @param x coordonee du batiment
	 * @param y coordonee du batiment
	 * @param val le niveau du batiment
	 * @param nom le nom du batiment
	 */
	public static void modifierNiveau(int x, int y,int val, String nom){
		CityBuilder.getGrille()[x][y].setText(nom+val);
	}
}
