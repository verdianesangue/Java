package DevoirConge;

import java.util.Optional;

public class Queue extends SQStructure {

    public int last;
    public int first;

    public Queue(int taille){
        super(taille);
        this.last = -1;
        this.first = 0;
    }

    public void Push(int valeur) {
        if (indice == taille) {
            Resize(); // Agrandit le tableau si nécessaire
        }
        last = (last + 1) % taille; // Calcul circulaire pour ajouter l'élément
        tableau[last] = valeur; // Ajoute la valeur à la fin
        indice++;
    }

    @Override
    public Optional<Integer> Pop() {
        if (indice > 0) {
            int valeur = tableau[first]; // Obtient la valeur à l'avant
            first = (first + 1) % taille; // Calcul circulaire pour avancer l'indice
            tableau[first - 1] = 0;// met 0 a l'endroit ou un element a ete retirer
            indice--; // Décrémente le compteur
            return Optional.of(valeur); // Retourne la valeur retirée
        } else {
            System.out.println("La file est vide. Impossible de retirer une valeur.");
            return Optional.empty(); // Retourne un Optional vide
        }
    }

    public int Count() {
        return indice;
    }
    public int Size(){
        return tableau.length;
    }

}
