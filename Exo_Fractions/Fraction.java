package Exo_Fractions;
/*
* Pour le prochain cours, je vous demande d'écrire une classe Fraction immuable.
Vous devez créer un constructeur
Une méthode additionner qui permet de faire l'addition de fractions
Une méthode soustraire qui permet de faire la soustraction de fractions
Une méthode multiplier qui permet de faire la multiplication de fractions
Une méthode diviser qui permet de faire la division de fractions
Une méthode simplifier qui permet de simplifier la fraction (exemple 6/14 donnera 3/7)
Une méthode pgcd qui permet de trouver le plus grand commun diviseur de 2 fractions
Une méthode ppcm qui permet de trouver le plus petit commun multiple de 2 fractions */

import java.util.function.Function;

public  class Fraction {
    public final int numerateur;
    public final int denominateur;

    /***
     *
     * @param numerateur: nombre de type entier
     * @param denominateur: nombre de type entier qui doit etre different de 0
     */
    public Fraction(int numerateur, int denominateur) {
        if(denominateur ==0){
            System.out.println("le denominateur doit etre different de 0");
        }
        this.denominateur = denominateur;
        this.numerateur = numerateur;
    }

    /**
     *
     * @param nouvelle: objet de type fraction, qu'on va additionner avec la premiere fraction
     * @return : le resultat de l'addition des deux fractions
     */
    public Fraction additionner(Fraction nouvelle){
        int nouveauNumrateur = (numerateur * nouvelle.denominateur) + (denominateur * nouvelle.numerateur);
        int nouveauDenominateur = denominateur * nouvelle.denominateur;

        return new Fraction(nouveauNumrateur,nouveauDenominateur);

    }

    /***
     *
     * @param nouvelle:objet de type fraction, qu'on va soustraire avec la premiere fraction
     * @return:le resultat de la soustraction de deux  fractions
     */
    public Fraction soustraire(Fraction nouvelle){
        int nouveauNumerateur = (numerateur * nouvelle.denominateur) - (denominateur * nouvelle.numerateur);
        int nouveauDenominateur = denominateur * nouvelle.denominateur;

        return new Fraction(nouveauNumerateur,nouveauDenominateur);

    }

    /***
     *
     * @param nouvelle:objet de type fraction, qu'on va multiplier avec la premiere fraction
     * @return:le resultat de la multiplication de deux  fractions
     */
    public Fraction multiplier(Fraction nouvelle){
        int nouveauNumerateur = numerateur * nouvelle.numerateur;
        int nouveauDenominateur = denominateur * nouvelle.denominateur;

        return new Fraction(nouveauNumerateur,nouveauDenominateur);
    }

    /***
     *
     * @param nouvelle:objet de type fraction, qu'on va diviser avec la premiere fraction
     * @return:le resultat de la division de deux  fractions
     */
    public Fraction diviser(Fraction nouvelle){
        if(nouvelle.numerateur == 0) {
            System.out.println("le numerateur de la deuxieme fraction doit etre different de 0");
        }

        int nouveauNumerateur = numerateur * nouvelle.denominateur;
        int nouveauDenominateur = denominateur * nouvelle.numerateur;

        return new Fraction(nouveauNumerateur,nouveauDenominateur);
    }

    /**8
     *
     * @return: une fraction simplifier a l'aide de son pgcd
     */
    public Fraction simplifier(){
        int resultat_pgcg = pgcd(numerateur,denominateur);
        return new Fraction(numerateur/resultat_pgcg, denominateur/resultat_pgcg);
    }

    /***
     *
     * @param a: nombre de type entier
     * @param b : nombre de type entier qui doit etre different de 0
     * @return: le pgcd de a et b
     */
    public static int pgcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    /***
     *
     * @param a : nombre de type entier
     * @param b: nombre de type entier != 0
     * @return: le plus petit commun multiple de deux nombres
     */
    public static int ppcm(int a, int b){
        return (a * b) / pgcd(a, b);
    }

    /***
     *
     * @param nouvelle: objet de type fraction, qu'on va utiliser pour calculer le pgcd avec la premiere fraction
     * @return le pgcd de deux fractions sous forme de fraction
     */
    public Fraction pgcd(Fraction nouvelle){
        int nouveauNumerateur = pgcd(numerateur,nouvelle.numerateur);
        int nouveauDenominateur = ppcm(denominateur, nouvelle.denominateur);

        return new Fraction(nouveauNumerateur,nouveauDenominateur);

    }

    /***
     *
     * @param nouvelle:objet de type fraction, qu'on va utiliser pour calculer le ppcm avec la premiere fraction
     * @return le ppcm de deux fractions sous forme de fraction
     */
    public Fraction ppcm(Fraction nouvelle){
        int nouveauNumerateur = ppcm(numerateur, nouvelle.numerateur);
        int nouveauDenominateur = pgcd(denominateur, nouvelle.denominateur);


        return new Fraction(nouveauNumerateur, nouveauDenominateur);
    }

    public String toString(){
        return numerateur + "/" + denominateur;
    }

}


