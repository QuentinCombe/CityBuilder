package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import controleur.ControleurBatiment;
import modele.Batiments;
import modele.Besoins;
import modele.Habitation;

/**
 * Classe DetailBatiment.
 */
@SuppressWarnings("serial")
public class DetailBatiment extends JFrame{

    /** La jauge de satisfaction. */
    public JProgressBar pbar = new JProgressBar();
    
    /** Le batiment actuel. */
    private Batiments batActuel = ControleurBatiment.returnBatiments();
    
    /** Copie du batiment de reference correpondant au batiment. */
    private Batiments tmp = Batiments.getRightBatiment(batActuel.lireNom()).copie();
    
    /** JTextArea besoin entree. */
    public JTextArea besoinEntree = new JTextArea("Necessite : ");
    
    /** JTextArea besoin sortie. */
    public JTextArea besoinSortie = new JTextArea("Genere : ");
    
    /** JTextArea zone influence. */
    public JTextArea zoneInfluence = new JTextArea("Zone d'influence : ");
    
    /** JTextArea niveau. */
    public JTextArea niveau = new JTextArea("Niveau : "+batActuel.getNiveau());
    
    /** JTextArea seuil des besoins en entrée. */
    public JTextArea seuilEntree = new JTextArea();
    
    /** JTextArea des besoins en entrée initiaux. */
    public JTextArea besoinEntreeInit = new JTextArea();
    
    /** Affichage des besoins en entrée. */
    public JTextArea affbesoinEntree = new JTextArea();
    
    /** JTextArea des besoins en sortie initiaux. */
    public JTextArea besoinSortieInit = new JTextArea();
    
    /** JTextArea seuil des besoins en sortie. */
    public JTextArea seuilSortie = new JTextArea();
    
    /** Affichage des besoins en sortie. */
    public JTextArea affbesoinSortie = new JTextArea();
    
    /** Affichage de la zone d'influence. */
    public JTextArea affzoneInfluence = new JTextArea();
    
    /** Le panel en bas de page. */
    public JPanel footpan = new JPanel();
    
    /** Le boutton supprimer. */
    public JButton suppr = new JButton("Supprimer");

    /**
     * Constructeur.
     */
    public DetailBatiment(){

        super("Details du batiment");
        setSize(700,400);
        JPanel global = new JPanel(new BorderLayout());
        JPanel details = new JPanel();
        setContentPane(global);
        TitledBorder border = BorderFactory.createTitledBorder("Details du batiment :");
        details.setBorder(border);
        details.setLayout(new GridLayout(3,5));

        /** On met au jour le niveau du batiment de reference **/
        while(tmp.getNiveau() < batActuel.getNiveau()){
            tmp.updateNiveau(15,false);
        }

        /** Entete **/

        besoinEntree.setBackground(getForeground());
        besoinSortie.setBackground(getForeground());
        zoneInfluence.setBackground(getForeground());
        niveau.setBackground(getForeground());

        /** Seuil besoin entree **/

        seuilEntree.setBackground(getForeground());

        /** Affichage besoin entree **/

        besoinEntreeInit.setBackground(getForeground());
        affbesoinEntree.setBackground(getForeground());
        float sommeSeuilEntree = 0;
        int nbEntree = 0;
        if(batActuel.lireEntree().isEmpty()==true){
            affbesoinEntree.append("Ce batiment n'a pas de besoins en entree \n");
        }
        for (Entry<Besoins, Integer> entry : tmp.lireEntree().entrySet())
        {
            float valeurSeuilEntree = 0;
            if(entry.getValue()<batActuel.compterBesoin(entry.getKey(),batActuel.posX(),batActuel.posY()))
            {
                affbesoinEntree.append(entry.getKey().lireNom()+" : "+entry.getValue()+"\n");
                valeurSeuilEntree = entry.getValue();
                sommeSeuilEntree += 100;
                besoinEntreeInit.append(" / "+entry.getValue()+"\n");
                seuilEntree.append("Seuil : 100% \n");
            }
            else {
                affbesoinEntree.append(entry.getKey().lireNom()+" : "+batActuel.compterBesoin(entry.getKey(),batActuel.posX(),batActuel.posY())+"\n");
                valeurSeuilEntree = Batiments.getSeuil(batActuel.compterBesoin(entry.getKey(),batActuel.posX(),batActuel.posY()), entry.getValue());
                sommeSeuilEntree += valeurSeuilEntree*100;
                besoinEntreeInit.append(" / "+entry.getValue()+"\n");
                seuilEntree.append("Seuil : "+valeurSeuilEntree*100+"% \n");
            }
            nbEntree++;
        }

        /** Affichage besoin initiaux sortie **/

        besoinSortieInit.setBackground(getForeground());
        seuilSortie.setBackground(getForeground());
        affbesoinSortie.setBackground(getForeground());

        /** Affichage besoin actuel sortie **/

        //taux satisfaction
        int tauxSatisf = (int) (sommeSeuilEntree/nbEntree);
        if(batActuel instanceof Habitation){
        	tauxSatisf = Math.max(tauxSatisf-CityBuilder.getChomage()/10,0);
        }
        if(batActuel.lireSortie().isEmpty()==true){
            affbesoinSortie.append("Ce batiment n'a pas de besoins en sortie \n");
        }
        for (Entry<Besoins, Integer> entry : tmp.lireSortie().entrySet())
        {
        	int prod;
        	//la production des habitations (habitants et employés) ne dépendent pas du taux de satisfaction
        	if(batActuel instanceof Habitation){
        		prod = entry.getValue();
        		seuilSortie.append("Seuil : 100 % \n");
        		
        	}else{
        		prod = (int) (entry.getValue()*tauxSatisf/100);
        		seuilSortie.append("Seuil : "+tauxSatisf+" % \n");
        	}
            affbesoinSortie.append(entry.getKey().lireNom()+" : "+prod+"\n");
            besoinSortieInit.append(" / "+entry.getValue()+"\n");            
        }

        /** Affichage zone **/

        affzoneInfluence.setText(""+batActuel.lireRayon());
        affzoneInfluence.setBackground(getForeground());

        /** Ajout des JTextarea dans le panel**/

        details.add(besoinEntree);
        details.add(affbesoinEntree);
        details.add(besoinEntreeInit);
        details.add(seuilEntree);
        details.add(besoinSortie);
        details.add(affbesoinSortie);
        details.add(besoinSortieInit);
        details.add(seuilSortie);
        details.add(zoneInfluence);
        details.add(affzoneInfluence);
        details.add(niveau);

        /** bouton supprimer**/

        suppr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurBatiment.supprimerBatiment(batActuel);
            }
        });

        /** Seuil global **/
        JPanel seuilGlobal = new JPanel();
        JLabel seuilGlobalTexte = new JLabel("Satisfaction globale : "+(int)tauxSatisf+ " %");
        seuilGlobal.add(seuilGlobalTexte);
        seuilGlobal.add(pbar);
        seuilGlobal.setSize(30,30);
        pbar.setValue((int)tauxSatisf);
        pbar.setMaximum(100);
        pbar.setMinimum(0);

        /** JButton update batiment**/
        JButton updatebat = new JButton("Augmenter de niveau");
        updatebat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurBatiment.augmenterNiveau(batActuel);
            }
        });
        if(tauxSatisf >= 75) {
            footpan.add(updatebat);
        }
        footpan.add(suppr);
        footpan.add(seuilGlobal);
        global.add(details,BorderLayout.CENTER);
        global.add(footpan,BorderLayout.SOUTH);

        setVisible(true);
    }
}
