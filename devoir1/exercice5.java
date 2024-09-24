public class exercice5 {
    public static void main(String[] args) {
 // 5) Afficher les lettres de l'alphabet en majuscules à l'envers en sautant 1 lettre puis 2 puis 1 puis 2 puis 1 puis ...
    char pas = '\u0003';
    for(char lettre = 'Z'; lettre >= 'A'; lettre -= pas){
       if (pas == '\u0003' ){
           System.out.println(lettre);
           pas = '\u0002';
       } else{
           System.out.println(lettre);
           pas = '\u0003';
       }
    }

    }
}

