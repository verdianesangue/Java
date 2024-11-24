package Exo_Fractions;

public class TestFraction {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,3);
        Fraction f3 = new Fraction(0,7);
        Fraction f4 = new Fraction(8,9);
        Fraction f5 = new Fraction(15,51);
        Fraction f6 = new Fraction(15,5);
        Fraction f7 = new Fraction(90,30);

        System.out.printf("f1 + f2 = %s + %s = %s\n", f1, f2, f1.additionner(f2));
        System.out.printf("f1 - f2 = %s - %s = %s\n", f1, f2, f1.soustraire(f2));
        System.out.printf("f1 * f2 = %s * %s = %s\n", f1, f2, f1.multiplier(f2));
        System.out.printf("f1 / f2 = %s / %s = %s\n", f1, f2, f1.diviser(f2));


        System.out.printf("f3 + f4 = %s + %s = %s\n", f3, f4, f3.additionner(f4));
        System.out.printf("f3 - f4 = %s - %s = %s\n", f3, f4, f3.soustraire(f4));
        System.out.printf("f3 * f4 = %s * %s = %s\n", f3, f4, f3.multiplier(f4));
        System.out.printf("f3 / f4 = %s / %s = %s\n", f3, f4, f3.diviser(f4));

        System.out.printf("f5 = %s = %s\n", f5, f5.simplifier());
        System.out.printf("f6 = %s = %s\n", f6, f6.simplifier());

        //System.out.printf("f6 pgcd f7 = %s et %s = %s\n", f6, f7, f6.pgcd(f7));
        //System.out.printf("f6 ppcm f7 = %s et %s = %s\n", f6, f7, f6.ppcm(f7));
    }
}
