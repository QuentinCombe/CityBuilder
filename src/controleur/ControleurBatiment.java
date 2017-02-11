package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import vue.AffichageBatiments;
import vue.CityBuilder;
import vue.Main;
import modele.Batiments;
import modele.Besoins;
import modele.Commerce;
import modele.Habitation;
import modele.Zone;

/**
 * classe ControleurBatiment : ajout, modification et suppression des batiments
 */

public class ControleurBatiment implements ActionListener{

    /**
     * Le batiment
     */
    private Batiments bat;

    /**
     * Constructeur
     * @param bat le batiment selectionne
     */
    public ControleurBatiment(Batiments bat) {
        this.bat = bat;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ajoutBatiment(bat);
    }

    /**
     * Ajouter un batiment.
     * @param bat le batiment a ajouter
     */
    public void ajoutBatiment(Batiments bat){
        String caseDepart = Listener.getDepart();
        int x = Integer.parseInt(caseDepart.split(",")[0]);
        int y = Integer.parseInt(caseDepart.split(",")[1]);
        //appel methode verif conditions
        if (Zone.verifZone(x,y,bat.getX(),bat.getY(),bat.lireZone()) == false){
            JOptionPane.showMessageDialog(null,"Ce batiment ne peut etre affecte a cette zone !");
        }else if(Batiments.verifBat(x,y,bat.getX(),bat.getY())== false){
        		JOptionPane.showMessageDialog(null,"Un batiment est deja construit sur cette zone !");
        	}else if(bat.verifierBesoin(x,y) == false){
	                JOptionPane.showMessageDialog(null,"Il n'y a pas assez de ressources dans cette zone !");
	            }else{
	                //ajout du batiment dans la matrice des batiments
	                Batiments.setBatiment(x,y,bat);
	                Batiments.getBatiments(x, y).majElec(true);
	                Batiments.getBatiments(x, y).majPop(true);
	                if(bat instanceof Habitation)CityBuilder.embauche();
	                AffichageBatiments.afficherBatiment(x,y,bat);
	                Listener.frame.dispose();
	            }
    }

    /**
     * Retourne le batiment selectionne
     * @return batiment le batiment selectionne
     */
    public static Batiments returnBatiments(){
        String caseDepart = Listener.getDepart();
        int x = Integer.parseInt(caseDepart.split(",")[0]);
        int y = Integer.parseInt(caseDepart.split(",")[1]);
        return Batiments.getBatiments(x,y);
    }

    /**
     * Supprimer un batiment
     * @param bat le batiment a supprimer
     */
    public static void supprimerBatiment(Batiments bat){
        String caseDepart = Listener.getDepart();
        int x = Integer.parseInt(caseDepart.split(",")[0]);
        int y = Integer.parseInt(caseDepart.split(",")[1]);
        AffichageBatiments.supprimerAffichage(x,y,bat);
        bat.majElec(false);
        bat.majPop(false);
        if (bat instanceof Habitation) CityBuilder.debauche(x, y);
        Batiments.supprimerBatiment(x, y, bat);
        Listener.frame.dispose();
    }
    
    /**
     * Supprimer un batiment
     * @param bat : le batiment a supprimer
     * @param x : coordonnees du batiment a supprimer
     * @param y : coordonnees du batiment a supprimer
     */
    public static void supprimerBatiment(Batiments bat,int x, int y){
        AffichageBatiments.supprimerAffichage(x,y,bat);
        bat.majElec(false);
        bat.majPop(false);
        if (bat instanceof Habitation) CityBuilder.debauche(x, y);
        Batiments.supprimerBatiment(x, y, bat);
        Listener.frame.dispose();
    }
	/**
	 * Augmenter le niveau du batiment
	 * @param bat le batiment
	 */
	public static void augmenterNiveau(Batiments bat) {
		bat.updateNiveau(15,true);
		AffichageBatiments.modifierNiveau(bat.posX(), bat.posY(), bat.getNiveau(), bat.lireNom());
		if (bat instanceof Habitation){ 
			CityBuilder.embauche();
		}else{
			for(Entry<Besoins, Integer> entry : bat.lireEntree().entrySet()){
				if(entry.getKey() == Main.employee){
					if(((Commerce)bat).lireNbEmployee() < entry.getValue()&& !CityBuilder.getAttenteEmp().contains(bat)){
						CityBuilder.getAttenteEmp().add(bat);
						System.out.println(bat.posX()+" "+bat.posY()+" "+bat.lireNom()+" "+bat.getNiveau());
					}
				}
			}
			
		}

	}
}



