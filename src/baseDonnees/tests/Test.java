package baseDonnees.tests;

import baseDonnees.BaseDonnees;
import baseDonnees.bases.Colonne;
import baseDonnees.modeles.Transaction;

import java.util.List;

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


    public String testTableTransactions() {
        StringBuilder contenu = new StringBuilder();

        // Création d'une instance de BaseDonnees
        BaseDonnees bd = new BaseDonnees();

        // Ajout de transactions
        System.out.println("\n=== Test TableTransactions ===");
        bd.ajouterTransaction(new Transaction("CPT-001", "CPT-002", 100.0, "Accepte"));
        bd.ajouterTransaction(new Transaction("CPT-002", "CPT-003", 50.0, "Refuse"));
        bd.ajouterTransaction(new Transaction("CPT-001", "CPT-003", 25.0, "A_Determiner"));

        // Vérification des transactions pour CPT-001
        contenu.append("\nTransactions enregistrées pour CPT-001 :\n");
        List<Transaction> transactionsCPT001 = bd.obtenirTransactionsPourCompte("CPT-001");
        for (Transaction t : transactionsCPT001) {
            contenu.append("✔ ").append(t.getNoCompteSource()).append(" → ")
                    .append(t.getNoCompteDestination())
                    .append(", Montant: ").append(t.getMontant())
                    .append(", Statut: ").append(t.getStatus()).append("\n");
        }

        // Vérification des transactions pour CPT-002
        contenu.append("\nTransactions enregistrées pour CPT-002 :\n");
        List<Transaction> transactionsCPT002 = bd.obtenirTransactionsPourCompte("CPT-002");
        for (Transaction t : transactionsCPT002) {
            contenu.append("✔ ").append(t.getNoCompteSource()).append(" → ")
                    .append(t.getNoCompteDestination())
                    .append(", Montant: ").append(t.getMontant())
                    .append(", Statut: ").append(t.getStatus()).append("\n");
        }

        // Vérification des transactions pour un compte inexistant CPT-999
        contenu.append("\nTransactions enregistrées pour CPT-999 :\n");
        List<Transaction> transactionsCPT999 = bd.obtenirTransactionsPourCompte("CPT-999");
        if (transactionsCPT999.isEmpty()) {
            contenu.append(" Aucune transaction trouvée pour CPT-999.\n");
        } else {
            contenu.append(" Erreur : Il ne devrait pas y avoir de transactions pour CPT-999 !\n");
        }

        return contenu.toString();
    }


    // Méthode main pour exécuter les tests
    public static void main(String[] args) {
        Test test = new Test();

        // Test de Colonne
        System.out.println(test.testColonne());

        // Test de TableTransactions
        System.out.println(test.testTableTransactions());

        System.out.println("\n TESTS TERMINÉS !");
        }
}
