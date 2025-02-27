package baseDonnees.tests;

import baseDonnees.bases.Colonne;

public class Test {

    public String testColonne(){

        StringBuilder contenu = new StringBuilder();


        Colonne<Integer> colonne = new Colonne<>();
        colonne.ajouterValeur(442588);
        colonne.ajouterValeur(589585);
        colonne.ajouterValeur(256369);
        colonne.ajouterValeur(5858847);

        colonne.afficherContenu();

        contenu.append(" Affiche (3) l'index de la valeur ").append(colonne.obtenirIndex(5858847));
        contenu.append(" Affiche (1) l'Index de la valeur ").append(colonne.obtenirIndex(442588));
        contenu.append(" Affiche (-1) la valeur n'existe pas dans le tableau ").append(colonne.obtenirIndex(452367));

        colonne.changerValeur(2,8958741);
        colonne.afficherContenu();

        return contenu.append("Nombre d'éléments: ").append(colonne.getNbElements()).toString();
    }
}
