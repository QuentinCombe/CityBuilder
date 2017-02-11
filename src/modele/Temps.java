package modele;

import controleur.ControleurBatiment;
import vue.CityBuilder;

/**
 * Classe Temps : simule le temps, calcul l'etat des batiments et les supprime ou augmente leur niveau en fonction
 *
 */
public class Temps extends Thread{
	public void run(){
		int tours = 1;
		while(true){
			System.out.println("********"+tours);
			for(int i = 0; i < CityBuilder.getCases();i++){
				for(int j = 0; j < CityBuilder.getCases();j++){
					Batiments b = Batiments.getBatiments(i, j);
					if(b != null){
						if(b.posX() == i && b.posY() == j){
							float sante = b.calculSatisfaction();
							if(sante == 100){
								b.setEtat(b.getEtat() + 5*Math.random());
							}else if (sante >= 90){
									b.setEtat(b.getEtat() +2*Math.random());
								}else if (sante >= 80){
										b.setEtat(b.getEtat() -4*Math.random());
									}else if (sante >= 70){
											b.setEtat(b.getEtat() -6*Math.random());
										}else if (sante >= 60){
												b.setEtat(b.getEtat() -8*Math.random());
											}else if (sante >= 50){
													b.setEtat(b.getEtat() -10*Math.random());
												}else if (sante >= 50){
														b.setEtat(b.getEtat() -12*Math.random());
													}else if (sante >= 40){
															b.setEtat(b.getEtat() -14*Math.random());
														}else if (sante >= 30){
																b.setEtat(b.getEtat() -16*Math.random());
															}else if (sante >= 20){
																	b.setEtat(b.getEtat() -18*Math.random());
																}else if (sante >= 10){
																		b.setEtat(b.getEtat() -20*Math.random());
																	}else{
																		b.setEtat(b.getEtat() -22*Math.random());
																	}
							if(b.getEtat() >= 150){
								ControleurBatiment.augmenterNiveau(b);
							}else if(b.getEtat() <= 0){
								ControleurBatiment.supprimerBatiment(b,i,j);
							}
							System.out.println("("+i+","+j+") "+b.getEtat()+"\t");
						}
					}
				}
			}
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tours++;
		}
	}
}
