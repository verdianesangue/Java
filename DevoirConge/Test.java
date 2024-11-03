package DevoirConge;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Stack pile = new Stack(20);
        Queue file = new Queue(6);


        file.Push(32);
        file.Push(34);
        file.Push(38);



        System.out.println(Arrays.toString(file.tableau));
        System.out.println("Valeur retirée : " + file.Pop().orElse(null));
        System.out.println(Arrays.toString(file.tableau));
        System.out.println("La taille de la pille est : " + file.Size());
        System.out.println("Le nombre d'element de la pille est : " + file.Count());
        System.out.println("Valeur retirée : " + file.Pop().orElse(null));
        System.out.println(Arrays.toString(file.tableau));
        System.out.println("La taille de la pille est : " + file.Size());
        file.Push(66);
        System.out.println(Arrays.toString(file.tableau));
        /*
        pile.push(45);
        pile.push(45);
        pile.push(45);
        pile.push(45);
        pile.push(45);

        pile.push(46);

        System.out.println(Arrays.toString(pile.tableau));
        System.out.println("Nombre d'elements dans la pile : " + pile.Count());
        System.out.println("Valeur retirée : " + pile.Pop().orElse(null));
        System.out.println(Arrays.toString(pile.tableau));
        System.out.println("La taille de la pille est : " + pile.Size());
        System.out.println("Nombre d'elements dans la pile : " + pile.Count());
        pile.push(60);
        System.out.println(Arrays.toString(pile.tableau));
        System.out.println("La taille de la pille est : " + pile.Size());
        System.out.println("valeur retirée : " + pile.Pop().orElse(null));
        System.out.println("La taille de la pille est : " + pile.Size());
        System.out.println(Arrays.toString(pile.tableau));
      */
    }
}
