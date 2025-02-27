package baseDonnees.bases;

import java.util.Arrays;

/**
 * Ce fichier impl�mente la colonne index�e qui utilise la fouille binaire comme
 * technique de recherche. Il s'agit d'une classe d�riv� de colonne.
 * 
 * La description des requis se trouve dans l'�nonc� du devoir, section 2.3.
 * 
 * La classe interne ValIndexee est fournie.
 * 
 * @author Fred Simard | ETS
 * @version Hiver 2025
 *
 * @param <V> le type de l'attribut contenue dans la colonne
 */


@SuppressWarnings("rawtypes")
public class ColonneIndexee<V extends Comparable<V>> extends Colonne<V> {

    public ColonneIndexee() {
    }

    private class ValIndexee<V extends Comparable<V>> {
		
		public int index;
		public V valeur;
		
		public ValIndexee(int index, V valeur2) {
			this.index = index;
			this.valeur = valeur2;
		}

		public int comparer(V valeur) {
			return this.valeur.compareTo(valeur);
		}
	}
	
	public static final int PAS_UNIQUE = -1;
	public static final int ELEMENT_ABSENT = -1;
	
	private ValIndexee[] valIndexee;
    private V[] tab;
    private int nbElements;

    public ColonneIndexee(int tailleInitiale){
        tab = (V[]) new Comparable[tailleInitiale];
        valIndexee = new ValIndexee[tailleInitiale];
        nbElements = 0;
    }

    @Override
    public void ajouterValeur(V valeur){

        if(estUnique(valeur)){
            if(nbElements == tab.length){
                tab = Arrays.copyOf(tab , tab.length * 2);
                valIndexee = Arrays.copyOf(valIndexee , valIndexee.length*2);
            }

            tab[nbElements] = valeur;

            valIndexee[nbElements] = new ValIndexee<>(nbElements, valeur);

            nbElements++;

            Arrays.sort(valIndexee , 0 , nbElements,(v1 , v2) -> v1.valeur.compareTo(v2.valeur));
        }

    }

    @Override
    public int obtenirIndex(V valeur){
        int gauche = 0;
        int droite = nbElements -1;

        while (gauche <= droite){
            int milieu = gauche + (droite - gauche) /2;
            int compare = valIndexee[milieu].comparer(valeur);

            if(compare == 0){
                return  valIndexee[milieu].index;
            }else if(compare < 0){
                gauche = milieu + 1;
            }else {
                droite = milieu -1;
            }
        }
        return ELEMENT_ABSENT;
    }

    public boolean estUnique(V valeur){
        return  obtenirIndex(valeur) == ELEMENT_ABSENT;
    }

    @Override
    public void changerValeur(int index ,V valeur){
        throw  new UnsupportedOperationException("La modification devaleurs dans une ColonneIndexee n'est pas autorisée.");
    }

    @Override
    public void afficherContenu(){
        for (int i=0 ; i < nbElements; i++){
            System.out.println("Index: " + i + " , Valeur: " + tab[i]);
        }
    }

    @Override
    public int getNbElements(){
        return nbElements;
    }
}
