public class exercice4 {
    public static void main(String[] args) {
/*
4) Afficher les 100 premiers nombres premier à partir du nombre 50

 */     short cpt = 0;
        for (int i = 50; cpt <= 100; i++){
            for (int j = 2; j < i; j++){
                if ((i % j) == 0){
                    break;
                } else if (j == (i - 1) ) {
                    cpt += 1;
                    System.out.println(i);
                }


            }

        }

    }
}
