package baseDonnees.modeles;

import baseDonnees.utils.UtilitairesDB;
import java.util.Arrays;

/**
 * La classe Utilisateur représente un utilisateur dans le système bancaire.
 */
public class Utilisateur {

    private String nomUtilisateur;
    private String numeroDeCompte;
    private double solde;
    private byte[] hashModeDePasse;
    private byte[] salt;

    /**
     * Constructeur de la classe Utilisateur.
     * @param nomUtilisateur Le nom d'utilisateur
     * @param motDePasse Le mot de passe de l'utilisateur
     * @param numeroDeCompte Le numéro de compte de l'utilisateur
     * @param solde Le solde initial du compte
     */
    public Utilisateur(String nomUtilisateur , String motDePasse , String numeroDeCompte , double solde){
        this.nomUtilisateur = nomUtilisateur;
        this.salt = UtilitairesDB.obtenirSalt();
        this.hashModeDePasse = UtilitairesDB.hashMotDePasse(motDePasse ,salt);
        this.numeroDeCompte = numeroDeCompte;
        this.solde =  solde;
    }

    /**
     * Constructeur pour créer un utilisateur à partir de données déjà existantes.
     * @param nomUtilisateur Le nom d'utilisateur
     * @param hashModeDePasse Le hash du mot de passe
     * @param salt Le salt utilisé lors du hachage
     * @param numeroDeCompte Le numéro de compte
     * @param solde Le solde du compte
     */
    public Utilisateur(String nomUtilisateur, byte[] hashModeDePasse, byte[] salt, String numeroDeCompte, double solde) {
        this.nomUtilisateur = nomUtilisateur;
        this.hashModeDePasse = hashModeDePasse;
        this.salt = salt;
        this.numeroDeCompte = numeroDeCompte;
        this.solde = solde;
    }

    /**
     * Méthode pour authentifier un utilisateur en comparant son nom d'utilisateur et son mot de passe.
     * @param nomUtilisateur Le nom d'utilisateur saisi
     * @param motDePasse Le mot de passe saisi
     * @return true si l'authentification est réussie, false sinon
     */
    public boolean authentifier(String nomUtilisateur , String motDePasse){
        if(nomUtilisateur.equals(this.nomUtilisateur)){
            byte[] hash =  UtilitairesDB.hashMotDePasse(motDePasse , salt);
            return Arrays.equals(hash, hashModeDePasse);
        }
       return  false;
    }

    /**
     * Méthode pour effectuer une transaction qui modifie le solde de l'utilisateur.
     * @param differentiel Le montant à ajouter ou soustraire du solde (valeur négative pour retirer de l'argent)
     * @return Le nouveau solde après la transaction
     */
    public double transactionSurSolde(double differentiel){
        solde = solde - differentiel;
        return solde;
    }

    public String getNomUtilisateur(){
        return nomUtilisateur;
    }

    public byte[] getHashModeDePasse(){
        return  hashModeDePasse;
    }

    public byte[] getSalt(){
        return  salt;
    }

    public String getNumeroCompte(){
        return numeroDeCompte;
    }

    public double getSolde(){
        return solde;
    }



    /**
     * Cette méthode permet de visualiser rapidement les informations d'un utilisateur,
     * @return Une chaîne de caractères représentant l'utilisateur
     */
    @Override
    public String toString() {
        return "Utilisateur{" +
                "nomUtilisateur='" + nomUtilisateur + '\'' +
                ", numeroCompte=" + numeroDeCompte +
                ", solde='" + solde + '\'' +
                ", hashModeDePasse='" + Arrays.toString(hashModeDePasse) + '\'' +
                ", salt='" + Arrays.toString(salt) + '\'' +
                '}';
    }
}
