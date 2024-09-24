public class exercice3 {
    public static void main(String[] args) {
      /*
      3) Créer un tableau de 100 cases de type booléen; initialisez chaque case à true;
    A partir de la 2è case, mettez à false toutes les cases qui sont un multiple de votre position actuelle;
    Avancez à la case suivante et répétez l'opération */

        boolean[] tableau = new boolean[100];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = true;
        }
        for (int i = 2; i < tableau.length; i++) {
            if (tableau[i]) {
                for (int j = i; j < tableau.length; j += i) {
                    if ((j % i) == 0) {
                        tableau[j] = false;
                    }

                }

            }
        }
        for (int i = 0; i < tableau.length; i++) {
            System.out.println(" case" + (i + 1) + ":" + tableau[i]);
        }
    }
}
