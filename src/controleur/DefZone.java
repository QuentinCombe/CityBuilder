package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modele.Zone;
import vue.CityBuilder;
import vue.Zones;
/**
 * Classe DefZone : definition des zones
 */
public class DefZone implements ActionListener {

	/**
	 * largeur de la zone
	 */
	private Integer lar;
	/**
	 * hauteur de la zone
	 */
	private Integer lon;
	/**
	 * Entier correpondant au type de zone
	 */
	private int val;
	/**
	 * @param i l'entier correspondant au type de zone
	 */
	public DefZone(int i) {
		val = i;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		lar = Zones.getLargeur();
		lon = Zones.getHauteur();
		if (lar != null && lon != null){
			//on r�cup�re les coordonn�es de la case de d�part
			String depart = Listener.getDepart();
			int x = Integer.parseInt(depart.split(",")[0]);
			int y = Integer.parseInt(depart.split(",")[1]);
			//On calcule le point oppos� du rectancle de la zone en fonction de la largeur et la hauteur saisie
			int xfin = Math.min((x+lon),CityBuilder.getCases());
			int yfin = Math.min((y+lar),CityBuilder.getCases());
			//on appel la m�thode qui met � jour la matrice de type de zone
			if(Zone.zoneLibre(x,y,xfin,yfin,val)){
				Zone.setZone(x,y,xfin,yfin,val);
			}else{
				JOptionPane.showMessageDialog(null,"Impossible de modifier la zone car des batiments sont deja implantes");
			}
			Listener.frame.dispose();
			Zones.printZones();
		}		
	}
}