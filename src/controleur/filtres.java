package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.AffichageBatiments;
import vue.CityBuilder;
import vue.Main;
import vue.Zones;

/**
 * Classe filtre : gestion des filtres
 */
public class filtres implements ActionListener {
	/**
	 * Nom du filtre selectionne
	 */
	String filtre;
	public filtres(String filtre) {
		this.filtre = filtre;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CityBuilder.noFiltre();
		switch(filtre){
			case "zones":
				Zones.printZones();
			break;
			case "satisfaction":
				AffichageBatiments.satisfaction();
			break;
			case "habitants":
				AffichageBatiments.filtre(Main.habitants);
			break;
			case "pain":
				AffichageBatiments.filtre(Main.pain);
			break;
			case "nourriture":
				AffichageBatiments.filtre(Main.nourriture);
			break;
			case "voitures":
				AffichageBatiments.filtre(Main.voitures);
			break;
			case "electricite":
				AffichageBatiments.filtre(Main.electricite);
			break;
			case "presse":
				AffichageBatiments.filtre(Main.presse);
			break;
			case "argent":
				AffichageBatiments.filtre(Main.argent);
			break;
			case "boisson":
				AffichageBatiments.filtre(Main.boisson);
			break;
			case "papeterie":
				AffichageBatiments.filtre(Main.papeterie);
			break;
			case "vetements":
				AffichageBatiments.filtre(Main.vetements);
			break;
			case "electromenager":
				AffichageBatiments.filtre(Main.electromenager);
			break;
			case "communication":
				AffichageBatiments.filtre(Main.communication);
			break;
			case "soins":
				AffichageBatiments.filtre(Main.soins);
			break;
			case "securite":
				AffichageBatiments.filtre(Main.securite);
			break;
			case "culture":
				AffichageBatiments.filtre(Main.culture);
			break;
			case "divertissements":
				AffichageBatiments.filtre(Main.divertissements);
			break;
			case "education":
				AffichageBatiments.filtre(Main.education);
			break;
			case "carburant":
				AffichageBatiments.filtre(Main.carburant);
			break;
			case "serviceCommuns":
				AffichageBatiments.filtre(Main.serviceCommuns);
			break;
			case "transport":
				AffichageBatiments.filtre(Main.transport);
			break;
			case "information":
				AffichageBatiments.filtre(Main.information);
			break;
			case "employee":
				AffichageBatiments.filtre(Main.employee);
			break;
		}
	}

}
