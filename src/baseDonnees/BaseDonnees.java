package baseDonnees;

import baseDonnees.tables.TableUtilisateurs;
import baseDonnees.tables.TableTransactions;
import baseDonnees.modeles.Utilisateur;
import baseDonnees.modeles.Transaction;
import java.util.List;

public class BaseDonnees {

    private TableUtilisateurs tableUtilisateurs;
    private TableTransactions tableTransactions;

    /**
     * Constructeur qui initialise les tables.
     */
    public BaseDonnees() {
        this.tableUtilisateurs = new TableUtilisateurs();
        this.tableTransactions = new TableTransactions();
    }

    /**
     * Réinitialise complètement la base de données en recréant les tables.
     */
    public void viderLaBd() {
        this.tableUtilisateurs = new TableUtilisateurs();
        this.tableTransactions = new TableTransactions();
    }
--------------------------------------

    /**
     * Ajoute un utilisateur dans la base de données.
     * @param nouvelUtilisateur Utilisateur à ajouter
     * @return true si l'utilisateur a été ajouté, false sinon (déjà existant).
     */
    public boolean ajouterUtilisateur(Utilisateur nouvelUtilisateur) {
        return tableUtilisateurs.ajouterUtilisateur(nouvelUtilisateur);
    }

    /**
     * Recherche un utilisateur par son nom d'utilisateur.
     * @param nomUtilisateur Nom d'utilisateur à rechercher.
     * @return L'utilisateur correspondant ou null si non trouvé.
     */
    public Utilisateur obtenirUtilisateurParNom(String nomUtilisateur) {
        return tableUtilisateurs.obtenirUtilisateurParNom(nomUtilisateur);
    }

    /**
     * Recherche un utilisateur par son numéro de compte.
     * @param numeroDeCompte Numéro de compte à rechercher.
     * @return L'utilisateur correspondant ou null si non trouvé.
     */
    public Utilisateur obtenirUtilisateurPourCompte(String numeroDeCompte) {
        return tableUtilisateurs.obtenirUtilisateurParNumeroDCompte(numeroDeCompte);
    }

    /**
     * Met à jour le solde d'un utilisateur.
     * @param utilisateur L'utilisateur concerné.
     * @param nouveauSolde Le nouveau solde à attribuer.
     */
    public void mettreAJourSoldeUtilisateur(Utilisateur utilisateur, double nouveauSolde) {
        tableUtilisateurs.mettreAJourSolde(utilisateur, nouveauSolde);
    }

    /**
     * Ajoute une transaction dans la base de données.
     * @param transaction Transaction à ajouter.
     */
    public void ajouterTransaction(Transaction transaction) {
        tableTransactions.ajouterUneTransaction(transaction);
    }

    /**
     * Récupère toutes les transactions associées à un compte.
     * @param numeroDeCompte Numéro de compte pour lequel récupérer les transactions.
     * @return Liste des transactions associées au compte.
     */
    public List<Transaction> obtenirTransactionsPourCompte(String numeroDeCompte) {
        return tableTransactions.obtenirTransactionsPourCompte(numeroDeCompte);
    }
}
