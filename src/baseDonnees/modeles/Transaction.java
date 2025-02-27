package baseDonnees.modeles;

public class Transaction {

    public static String ACCEPTE = "Accepte";
    public static String REFUSE = "Refuse";
    public static String A_DETERMINER = "A_Determiner";

    private String noCompteSource;
    private String noCompteDestination;
    private double montant;
    private String status;

    public Transaction(){

    }

    public Transaction(String noCompteSource, String noCompteDestination, double montant) {
        this.noCompteSource = noCompteSource;
        this.noCompteDestination = noCompteDestination;
        this.montant = montant;
        this.status = A_DETERMINER;
    }

    public Transaction(String noCompteSource, String noCompteDestination, double montant, String status) {
        this.noCompteSource = noCompteSource;
        this.noCompteDestination = noCompteDestination;
        this.montant = montant;
        this.status = status;
    }



    public String getNoCompteSource() {
        return noCompteSource;
    }


    public String getNoCompteDestination() {
        return noCompteDestination;
    }


    public double getMontant() {
        return montant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
