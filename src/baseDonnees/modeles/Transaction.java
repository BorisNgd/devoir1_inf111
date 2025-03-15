package baseDonnees.modeles;

 /**
  *  La classe Transaction représente une transaction bancaire entre deux comptes.
  *  * @author Boris Ngodie Yofang
 */
public class Transaction {

    public static String ACCEPTE = "Accepte";
    public static String REFUSE = "Refuse";
    public static String A_DETERMINER = "A_Determiner";

    private String noCompteSource;
    private String noCompteDestination;
    private double montant;
    private String status;

     /**
      * Constructeur par défaut pour une transaction.
      */
    public Transaction(){
    }

     /**
      * Constructeur de la classe Transaction pour créer une transaction avec des informations spécifiques.
      * @param noCompteSource Le numéro de compte source
      * @param noCompteDestination Le numéro de compte destination
      * @param montant Le montant de la transaction
      */
    public Transaction(String noCompteSource, String noCompteDestination, double montant) {
        this.noCompteSource = noCompteSource;
        this.noCompteDestination = noCompteDestination;
        this.montant = montant;
        this.status = A_DETERMINER;
    }

     /**
      * Constructeur de la classe Transaction permettant de spécifier également le statut de la transaction.
      *
      * @param noCompteSource Le numéro de compte source
      * @param noCompteDestination Le numéro de compte destination
      * @param montant Le montant de la transaction
      * @param status Le statut de la transaction (par exemple, "Accepte" ou "Refuse")
      */
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
