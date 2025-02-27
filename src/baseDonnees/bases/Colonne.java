package baseDonnees.bases;
import  java.util.Arrays;

public class Colonne<V> implements InterfaceColonne<V> {

    private V[] tab;
    private int nbElements;
    private static  final  int TAILLE_INITIALE = 10;

    public Colonne(){
        tab = (V[]) new Object[TAILLE_INITIALE];
        nbElements = 0;
    }
    @Override
    public void ajouterValeur(V valeur){
        if(nbElements == tab.length){
            redimensionnerTableau();
        }
        tab[nbElements] = valeur;
        nbElements++;
    }

    @Override
    public V obtenirValeur(int index) throws Exception {
        if (index < 0 || index >= nbElements){
            throw new Exception("Index invalide");
        }
        return tab[index];
    }

    @Override
    public int obtenirIndex(V valeur){
        for (int i = 0 ; i < nbElements; i++){
            if (tab[i].equals(valeur)){
                return i;
            }
    }
    return -1;
    }

    @Override
    public  void changerValeur(int index , V valeur) throws IndexOutOfBoundsException{
        if(index < 0 || index >= nbElements){
            throw  new IndexOutOfBoundsException("Index invalide: " + index);
        }
        tab[index] = valeur;
    }

    @Override
    public int getNbElements(){
        return nbElements;
    }

    @Override
    public void afficherContenu(){
        System.out.println("Contenu de la colonne : ");
        for (int i =0 ;i < nbElements; i ++){
            System.out.println("Index: " + i + "Valeur: " + tab[i]+ " ");
        }
        System.out.println();
    }

    private  void redimensionnerTableau(){
        tab = Arrays.copyOf(tab , tab.length * 2);
    }
}
