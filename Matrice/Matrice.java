package Matrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MatrixException extends Exception {
    public MatrixException(String message) {
        super(message);
    }
}

class Fraction {
    public final int numerateur;
    public final int denominateur;

    /**
     *
     * @param numerateur: numerateur de la fraction de type entier
     * @throws MatrixException: la classe des exceptions
     */
    public Fraction(int numerateur) throws MatrixException {
        this(numerateur, 1);
    }

    /***
     *
     * @param numerateur: nombre de type entier
     * @param denominateur: nombre de type entier qui doit etre different de 0
     * @throws MatrixException: la classe des exceptions
     */

    public Fraction(int numerateur, int denominateur) throws MatrixException {
        if(denominateur == 0){
            throw new MatrixException("le denominateur doit etre different de 0");
        }
        this.denominateur = denominateur;
        this.numerateur = numerateur;
        //simplifier();
    }

    /**
     *
     * @param nouvelle: objet de type fraction, qu'on va additionner avec la premiere fraction
     * @return : le resultat de l'addition des deux fractions
     * @throws MatrixException: la classe des exceptions
     */
    public Fraction additionner(Fraction nouvelle) throws MatrixException {
        return new Fraction(numerateur * nouvelle.denominateur + denominateur * nouvelle.numerateur,
                denominateur * nouvelle.denominateur);
    }



    /***
     *
     * @param nouvelle:objet de type fraction, qu'on va soustraire avec la premiere fraction
     * @return: le resultat de la soustraction de deux  fractions
     * @throws MatrixException: la classe des exceptions
     */
    public Fraction soustraire(Fraction nouvelle) throws MatrixException {
        return new Fraction(numerateur * nouvelle.denominateur - denominateur * nouvelle.numerateur,
                denominateur * nouvelle.denominateur);
    }

    /***
     *
     * @param nouvelle:objet de type fraction, qu'on va multiplier avec la premiere fraction
     * @return: le resultat de la multiplication de deux  fractions
     * @throws MatrixException: la classe des exceptions
     */
    public Fraction multiplier(Fraction nouvelle) throws MatrixException {
        return new Fraction(numerateur * nouvelle.numerateur,
                denominateur * nouvelle.denominateur);
    }

    /***
     *
     * @param nouvelle:objet de type fraction, qu'on va diviser avec la premiere fraction
     * @return: le resultat de la division de deux  fractions
     * @throws MatrixException: la classe des exceptions
     */
    public Fraction diviser(Fraction nouvelle) throws MatrixException {
        if(nouvelle.numerateur == 0) {
            System.out.println("le numerateur de la deuxieme fraction doit etre different de 0");
        }
        return new Fraction(numerateur * nouvelle.denominateur,
                denominateur * nouvelle.denominateur);
    }

    /*/**8
     *
     * @return: une fraction simplifier a l'aide de son pgcd
     * @throws MatrixException: la classe des exceptions
     *//*
    public Fraction simplifier() throws MatrixException {
        int resultat_pgcg = pgcd(numerateur,denominateur);
        return new Fraction(numerateur/resultat_pgcg, denominateur/resultat_pgcg);
    }

    /***
     *
     * @param a: nombre de type entier
     * @param b : nombre de type entier qui doit etre different de 0
     * @return: le pgcd de a et b
     *//*
    public static int pgcd(int a, int b) {
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }*/

    public String toString(){
        return numerateur + "/" + denominateur;
    }
}

class Matrix {
    private List<List<Fraction>> matrice; // liste de liste de type fraction
    private int lignes; // lignes
    private int colonnes; // colonnes

    /**8
     *
     * @param matrice: liste contenant une liste donc les element sont de type fraction
     */
    public Matrix(List<List<Fraction>> matrice) {
        this.matrice = matrice; // ensembles des lignes et colonnes
        this.lignes = matrice.size();
        this.colonnes = matrice.get(0).size();
    }

    /**
     *
     * @param matrix2: de type Matrixpour effectuer une addition
     * @return : retourne la matrice contenant le resultat
     * @throws MatrixException: la classe des exceptions
     */
    public Matrix add(Matrix matrix2) throws MatrixException {
        if (this.lignes != matrix2.lignes || this.colonnes != matrix2.colonnes) {
            throw new MatrixException("Les matrices doivent avoir les mêmes dimensions pour l'addition.");
        }
        List<List<Fraction>> resultat = new ArrayList<>();
        for (int i = 0; i < lignes; i++) {
            List<Fraction> ligne = new ArrayList<>();
            for (int j = 0; j < colonnes; j++) {
                ligne.add(this.matrice.get(i).get(j).additionner(matrix2.matrice.get(i).get(j)));
            }
            resultat.add(ligne);
        }
        return new Matrix(resultat);
    }

    /**
     *
     * @param matrix2: de type Matrix pour effectuer une soustraction
     * @return: retourne la matrice contenant le resultat
     * @throws MatrixException: la classe des exceptions
     */
    public Matrix subtract(Matrix matrix2) throws MatrixException {
        if (this.lignes != matrix2.lignes || this.colonnes != matrix2.colonnes) {
            throw new MatrixException("Les matrices doivent avoir les mêmes dimensions pour la soustraction.");
        }
        List<List<Fraction>> resultat = new ArrayList<>();
        for (int i = 0; i < this.lignes; i++) {
            List<Fraction> ligne = new ArrayList<>();
            for (int j = 0; j < this.colonnes; j++) {
                ligne.add(this.matrice.get(i).get(j).soustraire(matrix2.matrice.get(i).get(j)));
            }
            resultat.add(ligne);
        }
        return new Matrix(resultat);
    }

    /***
     *
     * @param scalar: de type fraction
     * @return; la matrice contenant le resultat
     * @throws MatrixException: la classe des exceptions
     */
    public Matrix multiplyByScalar(Fraction scalar) throws MatrixException {
        List<List<Fraction>> resultat = new ArrayList<>();
        for (int i = 0; i < this.lignes; i++) {
            List<Fraction> ligne = new ArrayList<>();
            for (int j = 0; j < this.colonnes; j++) {
                ligne.add(this.matrice.get(i).get(j).multiplier(scalar));
            }
            resultat.add(ligne);
        }
        return new Matrix(resultat);
    }

    public Matrix multiply(Matrix matrix2) throws MatrixException {
        if (this.colonnes != matrix2.lignes) {
            throw new MatrixException("Le nombre de colonnes de la première matrice doit être égal au nombre de lignes de la seconde.");
        }
        List<List<Fraction>> resultat = new ArrayList<>();
        for (int i = 0; i < this.lignes; i++) {
            List<Fraction> ligne = new ArrayList<>();
            for (int j = 0; j < matrix2.colonnes; j++) {
                Fraction sum = new Fraction(0);
                for (int k = 0; k < this.colonnes; k++) {
                    sum = sum.additionner(this.matrice.get(i).get(k).multiplier(matrix2.matrice.get(k).get(j)));
                }
                ligne.add(sum);
            }
            resultat.add(ligne);
        }
        return new Matrix(resultat);
    }

    /***
     *
     * @return: la matrice contenant le resultat de la transposé
     */
    public Matrix transpose() {
        List<List<Fraction>> resultat = new ArrayList<>();
        for (int i = 0; i < this.colonnes; i++) {
            List<Fraction> ligne = new ArrayList<>();
            for (int j = 0; j < this.lignes; j++) {
                ligne.add(this.matrice.get(j).get(i));
            }
            resultat.add(ligne);
        }
        return new Matrix(resultat);
    }

    /**
     *
     * @return: retourne le determinant de la matrice
     * @throws MatrixException: la classe des exceptions
     */
    public Fraction determinant() throws MatrixException {
        if (this.lignes != this.colonnes) {
            throw new MatrixException("Le déterminant n'est défini que pour les matrices carrées.");
        }
        if (this.lignes == 1) {
            return this.matrice.get(0).get(0);
        }
        if (this.lignes == 2) {
            return this.matrice.get(0).get(0).multiplier(this.matrice.get(1).get(1))
                    .soustraire(this.matrice.get(0).get(1).multiplier(this.matrice.get(1).get(0)));
        }

        Fraction det = new Fraction(0);
        for (int c = 0; c < this.colonnes; c++) {
            det = det.additionner(this.matrice.get(0).get(c).multiplier(SousMatrice(0, c)
                    .determinant()).multiplier(new Fraction((c % 2 == 0) ? 1 : -1)));
        }
        return det;
    }

    private Matrix SousMatrice(int ligne, int colonne) {
        List<List<Fraction>> sousMatriceDonnees = new ArrayList<>();
        for (int i = 0; i < this.lignes; i++) {
            if (i != ligne) {
                List<Fraction> nouvelleLigne = new ArrayList<>();
                for (int j = 0; j < this.colonnes; j++) {
                    if (j != colonne) {
                        nouvelleLigne.add(this.matrice.get(i).get(j));
                    }
                }
                sousMatriceDonnees.add(nouvelleLigne);
            }
        }
        return new Matrix(sousMatriceDonnees);
    }

    /**
     *
     * @return: la matrice inverse
     * @throws MatrixException: la classe des exceptions
     */
    public Matrix inverse() throws MatrixException {
        Fraction det = this.determinant();
        if (det.equals(new Fraction(0))) {
            throw new MatrixException("La matrice est singulière et n'a pas d'inverse.");
        }

        List<List<Fraction>> cofacteurs = new ArrayList<>();
        for (int l = 0; l < this.lignes; l++) {
            List<Fraction> ligneCofacteur = new ArrayList<>();
            for (int c = 0; c < this.colonnes; c++) {
                Matrix subMatrix = SousMatrice(l, c);
                Fraction cofactor = subMatrix.determinant().multiplier(new Fraction((l + c) % 2 == 0 ? 1 : -1));
                ligneCofacteur.add(cofactor);
            }
            cofacteurs.add(ligneCofacteur);
        }

        Matrix cofactorMatrix = new Matrix(cofacteurs);
        Matrix adjugateMatrix = cofactorMatrix.transpose();
        return adjugateMatrix.multiplyByScalar(new Fraction(1).diviser(det));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Fraction> ligne : matrice) {
            for (Fraction value : ligne) {
                builder.append(value).append("\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}



class Test {
    public static void main(String[] args) {
        try {
            // Générer des matrices aléatoires
            Matrix mat1 = generateRandomMatrix(3, 3);
            Matrix mat2 = generateRandomMatrix(3, 3);

            System.out.println("Matrice 1:");
            System.out.println(mat1);

            System.out.println("Matrice 2:");
            System.out.println(mat2);
            System.out.println("-------------------------------------------------");
            System.out.println("Addition des deux matrices:");
            System.out.println(mat1.add(mat2));

            System.out.println("-------------------------------------------------");
            System.out.println("Soustraction des deux matrices:");
            System.out.println(mat1.subtract(mat2));

            System.out.println("-------------------------------------------------");
            System.out.println("Multiplication par un scalaire (2):");
            System.out.println(mat1.multiplyByScalar(new Fraction(2)));

            System.out.println("-------------------------------------------------");
            System.out.println("Multiplication de matrices:");
            System.out.println(mat1.multiply(mat2));

            System.out.println("-------------------------------------------------");
            System.out.println("Transposée de la matrice 1:");
            System.out.println(mat1.transpose());

            System.out.println("-------------------------------------------------");
            System.out.println("Déterminant de la matrice 1:");
            System.out.println(mat1.determinant());

            System.out.println("-------------------------------------------------");
            System.out.println("Inverse de la matrice 1:");
            System.out.println(mat1.inverse());

        } catch (MatrixException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    /***
     *
     * @param lignes: nombres de lignes de la matrices de type entier
     * @param colonnes : nombres de colonnes de la matrice de type entier
     * @return: retourne une matrice avec des lignes et des colonnes
     * @throws MatrixException
     */
    public static Matrix generateRandomMatrix(int lignes, int colonnes) throws MatrixException {
        Random random = new Random();
        List<List<Fraction>> matrice = new ArrayList<>();
        for (int i = 0; i < lignes; i++) {
            List<Fraction> ligne = new ArrayList<>();
            for (int j = 0; j < colonnes; j++) {
                // Générer des entiers aléatoires pour le numérateur et un dénominateur fixe
                int numerateur = random.nextInt(5); // Entiers entre 0 et 9
                int denumerateur = random.nextInt(9) + 1; // Entiers entre 1 et 5 pour éviter la division par zéro
                //int denumerateur = random.nextInt(9) + 1; // Entiers entre 1 et 5 pour éviter la division par zéro
                ligne.add(new Fraction(numerateur));
            }
            matrice.add(ligne);
        }
        return new Matrix(matrice);
    }
}