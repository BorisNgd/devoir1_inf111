package baseDonnees.tables;

import baseDonnees.bases.Colonne;
import baseDonnees.modeles.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TableTransactions {

    private Colonne<String> comptesSources;
    private Colonne<String> comptesDestinations;
    private Colonne<Double> montants;
    private Colonne<String> statuts;

    /**
     * Ce constructeur initialise les colonnes.
     */
    public TableTransactions() {
        this.comptesSources = new Colonne<>();
        this.comptesDestinations = new Colonne<>();
        this.montants = new Colonne<>();
        this.statuts = new Colonne<>();
    }

    /**
     * Cette méthode insère chacun des attributs de la transaction dans la base de données
     * @param transaction
     */
    public void ajouterUneTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("La transaction ne peut pas être null.");
        }
        comptesSources.ajouterValeur(transaction.getNoCompteSource());
        comptesDestinations.ajouterValeur(transaction.getNoCompteDestination());
        montants.ajouterValeur(transaction.getMontant());
        statuts.ajouterValeur(transaction.getStatus());
    }

    /**
     * Cette méthode récupère toutes les transactions associées avec le numéro de compte
     * @param numeroDeCompte
     * @return liste des transactions sur le compte dont le numéro est passé en paramètre
     */
    public List<Transaction> obtenirTransactionsPourCompte(String numeroDeCompte) {
        if (numeroDeCompte == null) {
            throw new IllegalArgumentException("Le numéro de compte ne peut pas être null.");
        }

        List<Transaction> liste = new ArrayList<>();
        int nb = comptesSources.getNbElements();

        for (int i = 0; i < nb; i++) {
            try {
                String source = comptesSources.obtenirValeur(i);
                String destination = comptesDestinations.obtenirValeur(i);
                double montant = montants.obtenirValeur(i);
                String statut = statuts.obtenirValeur(i);

                if (source.equals(numeroDeCompte) || destination.equals(numeroDeCompte)) {
                    Transaction t = new Transaction(source, destination, montant, statut);
                    liste.add(t);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de la récupération des transactions à l'index " + i, e);
            }
        }

        return liste;
    }
}
