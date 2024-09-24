public class exercice6 {
    public static void main(String[] args) {

/* 6) Mettez toutes les lettres de l'alphabet en minuscule et en majuscule dans un tableau
de 'char' en mettant 1 minuscule puis 1 majuscule et ainsi de suite. Les minuscules de a à z, les majuscules de Z à A */
        char[] alph_tab = new char[52];
        char lettre2 = 'Z';
        char lettre = 'a';
        for (int i = 0; i < 52; i++){
            if (i % 2 == 0){
                alph_tab[i] = lettre;
                lettre ++;
            }
            else {
                alph_tab[i] = lettre2;
                lettre2 --;
            }

        }
        System.out.println(alph_tab);
    }
}
