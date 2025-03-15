package baseDonnees.tests;

import baseDonnees.bases.ColonneIndexee;

import java.util.Random;

/**
 * Ce fichier implémente les tests de validation des méthodes de la classe ColonneIndexee
 */
public class TestColonneIndexee {

    public static boolean testColonneIndexee() {
        // résultat tu test
        boolean resultat = true;

        // instanciation d'une colonne indexée d'Integer
        ColonneIndexee<Integer> colonneIndexee = new
                ColonneIndexee<Integer>();

        // prépare la valeur témoin et sa position aléatoire
        Random rand = new Random();
        int valeurTest = 0;
        int posValeurTest = rand.nextInt(5) + 5;
        int i = 0;

        // entre des valeurs aléatoires
        for (; i < posValeurTest; i++) {
            colonneIndexee.ajouterValeur(rand.nextInt());
        }
        // insère la valeur témoin
        colonneIndexee.ajouterValeur(valeurTest);
        // complète avec d'autres valeurs
        for (; i < 10; i++) {
            colonneIndexee.ajouterValeur(rand.nextInt());
        }

        // vérifie que la valeur témoin est dans le tableau à
        // l'index trouvé
        int index = colonneIndexee.obtenirIndex(valeurTest);
        try {
            if (colonneIndexee.obtenirValeur(index) != valeurTest) {
                resultat = false;
            }
        } catch (Exception e) {
            resultat = false;
        }

        // affiche le contenu de la colonne indexée
        colonneIndexee.afficherContenu();

        return resultat;
    }
}
