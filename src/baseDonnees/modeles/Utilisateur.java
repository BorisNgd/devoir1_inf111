package baseDonnees.modeles;

import baseDonnees.utils.UtilitairesDB;
import java.util.Arrays;

public class Utilisateur {

    private String nomUtilisateur;
    private String numeroDeCompte;
    private double solde;
    private byte[] hashModeDePasse;
    private byte[] salt;

    public Utilisateur(String nomUtilisateur , String motDePasse , String numeroDeCompte , double solde){
        this.nomUtilisateur = nomUtilisateur;
        this.salt = UtilitairesDB.obtenirSalt();
        this.hashModeDePasse = UtilitairesDB.hashMotDePasse(motDePasse ,salt);
        this.numeroDeCompte = numeroDeCompte;
        this.solde =  solde;
    }

    public Utilisateur(String nomUtilisateur, byte[] hashModeDePasse, byte[] salt, String numeroDeCompte, double solde) {
        this.nomUtilisateur = nomUtilisateur;
        this.hashModeDePasse = hashModeDePasse;
        this.salt = salt;
        this.numeroDeCompte = numeroDeCompte;
        this.solde = solde;
    }

    public boolean authentifier(String nomUtilisateur , String motDePasse){
        if(nomUtilisateur.equals(this.nomUtilisateur)){
            byte[] hash =  UtilitairesDB.hashMotDePasse(motDePasse , salt);
            return Arrays.equals(hash, hashModeDePasse);
        }
       return  false;
    }

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
