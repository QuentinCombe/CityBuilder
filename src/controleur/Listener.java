package controleur;
 
 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import vue.AffichageBatiments;
import vue.CityBuilder;
import vue.DetailBatiment;
import vue.VueAjout;
import modele.Batiments;
import modele.Zone;
 
/**
 * Classe Listener : gestion du clic 
 */
public class Listener implements MouseListener{
    /**
     * Case sur laquelle on a clique
     */
    public static JLabel caseDepart;
    /**
     * fenetre ouverte au clic
     */
    public static JFrame frame = null;
    @Override
    public void mouseClicked(MouseEvent e) {
    	if (frame != null) frame.dispose();
        //on récupère la case du clic et ses coordonnées x et y
        caseDepart = (JLabel)e.getSource();
        String depart = Listener.getDepart();
        int x = Integer.parseInt(depart.split(",")[0]);
        int y = Integer.parseInt(depart.split(",")[1]);
        //On regarde dans la matrice des type de zone, 
        if(Zone.getZones()[x][y] == 0){
            //si = 0 pas de zone non définie --> on ouvre la fenetre des zones
            frame = new vue.Zones();
        }else{
            //Si rien dans la matrice des batiments --> on ouvre la fenetre des batiments
            if(Batiments.getBatiments()[x][y] == null){
            	if(e.getButton() == MouseEvent.BUTTON3){
            		frame = new vue.Zones();
            	}else{
            		frame = new VueAjout();
            	}
            }
            else{
                //sinon y a un batiment --> on ouvre les détails du batiment
            	frame = new DetailBatiment();
            	if(Batiments.getBatiments()[x][y].lireNom() != "H"){
            		CityBuilder.noFiltre();
            		AffichageBatiments.afficherRayon(x,y);
            	}
            }
        }
             
    }
 
    @Override
    public void mouseEntered(MouseEvent e) {
         
         
    }
 
    @Override
    public void mouseExited(MouseEvent e) {
         
         
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
         
    }
 
    @Override
    public void mouseReleased(MouseEvent a) {
    }
     
    /**
     * @return le nom de la case cliquee correpondant a ses coordonnees
     */
    public static String getDepart(){
        return caseDepart.getName();
    }
}