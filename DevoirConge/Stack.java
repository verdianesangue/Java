package DevoirConge;

import java.util.Arrays;
import java.util.Optional;



public class Stack extends SQStructure {

    // constructeur de la pile stack
    public Stack(int taille) {
        super(taille);
    }

    public void push(int valeur){
       Push(valeur);
    }

    @Override
    public Optional<Integer> Pop() {
        if (indice > 0) {
            int value = tableau[--indice]; // Récupère l'élément à la dernière position
            tableau[indice] = 0; // supprime l'element a la derniere position
            return Optional.of(value); // Retourne l'élément récupéré
        } else {
            System.out.println("Le tableau est vide. Impossible de retirer une valeur.");
        }
        if (indice <= tableau.length - indice){
            int newtaille = taille - indice; // si le nombre d'element est inferieur a la taille - l'indice on retire 10 cases
            tableau = Arrays.copyOf(tableau, newtaille);
        }
        return Optional.empty(); // Retourne un Optional vide si le tableau est vide
    }

    public int Count() {
       return indice;
    }
    public int Size(){
        return tableau.length;
    }

}
