public class exercice2 {
    public static void main(String[] args) {

        /*
        2) Calculer la somme des 10 premiers nombres qui sont des carrés (4, 9, 16, ...)
        */

        int somme = 0;
        int nombremax = 10;
        for (int i = 2; i < 2 + nombremax; i++) {
            int carre = i * i;
            somme += carre;
        }
        System.out.println("La somme des 10 premiers carrés (à partir de 4) est : " + somme);



    }

}
