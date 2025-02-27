package baseDonnees.tables;

import baseDonnees.bases.Colonne;
import baseDonnees.bases.ColonneIndexee;
import baseDonnees.modeles.Utilisateur;

public class TableUtilisateurs  {

    private ColonneIndexee<String> nomsUtilisateurs;
    private ColonneIndexee<String> numerosDeCompte;
    private Colonne<Double> soldes;
    private Colonne<byte[]> hashMotDePasse;
    private Colonne<byte[]> salts;


    public TableUtilisateurs() {
        nomsUtilisateurs = new ColonneIndexee<>();
        numerosDeCompte = new ColonneIndexee<>();
        soldes = new Colonne<>();
        hashMotDePasse = new Colonne<>();
        salts = new Colonne<>();
    }

    public boolean ajouterUtilisateur(Utilisateur utilisateur){

        if (!nomsUtilisateurs.estUnique(utilisateur.getNomUtilisateur()) || !numerosDeCompte.estUnique(utilisateur.getNumeroCompte())){
            return  false;
        }

        nomsUtilisateurs.ajouterValeur(utilisateur.getNomUtilisateur());
        numerosDeCompte.ajouterValeur(utilisateur.getNumeroCompte());
        soldes.ajouterValeur(utilisateur.getSolde());
        hashMotDePasse.ajouterValeur(utilisateur.getHashModeDePasse());
        salts.ajouterValeur(utilisateur.getSalt());

        return  true;
    }

    public Utilisateur obtenirUtilisateurParNom(String nomUtilisateur){
        try {
            int index = nomsUtilisateurs.obtenirIndex(nomUtilisateur);
            String nom = nomsUtilisateurs.obtenirValeur(index);
            String numeroCompte = numerosDeCompte.obtenirValeur(index);
            double solde = soldes.obtenirValeur(index);
            byte[] hash = hashMotDePasse.obtenirValeur(index);
            byte[] salt = salts.obtenirValeur(index);

            return new Utilisateur(nom, hash, salt, numeroCompte, solde);

        } catch (Exception e){
            return null;
        }
    }

    public Utilisateur obtenirUtilisateurParNumeroDCompte(String numeroCompte){
        try {
            int index = numerosDeCompte.obtenirIndex(numeroCompte);
            String nom = nomsUtilisateurs.obtenirValeur(index);
            String numeroDeCompte = numerosDeCompte.obtenirValeur(index);
            double solde = soldes.obtenirValeur(index);
            byte[] hash = hashMotDePasse.obtenirValeur(index);
            byte[] salt = salts.obtenirValeur(index);

            return new Utilisateur(nom, hash, salt, numeroDeCompte, solde);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public void mettreAJourSolde(Utilisateur utilisateur,double solde){

        try {
            int index = numerosDeCompte.obtenirIndex(utilisateur.getNumeroCompte());
            soldes.changerValeur(index , solde);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
