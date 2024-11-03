package DevoirConge;

import java.util.Arrays;
import java.util.Optional;

public abstract class SQStructure {

    public int[] tableau;
    public int indice;
    public int taille;


    /* constructeur de la classe SQStructure*/

    public SQStructure(int taille){
        this.taille = taille;
        this.indice = 0;
        this.tableau = new int[taille];

    }

    public void Push(int valeur){ // ajoute un element dans le tableau
        if (indice >= tableau.length) {
            Resize();
        }

        // Incrémente l'indice et ajoute la nouvelle valeur.
        tableau[indice] = valeur;
        indice += 1 ;

    }

    public  void Resize() {
        int newSize = tableau.length + 10; // augmente la taille du tableau de 10 cases
        tableau = Arrays.copyOf(tableau, newSize);
    }


    public abstract Optional<Integer> Pop();

    public abstract int Count();

    public abstract int Size();

    public void Clear() {
        this.indice = 0;  // Réinitialise l'indice pour vider la structure.
    }

}


