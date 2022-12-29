package com.example.ui_calculator;

import static java.lang.Math.abs;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(String f) {
        int slashIndex = f.indexOf("/");
        if (slashIndex != -1) {
            numerator = Integer.parseInt(f.substring(0, slashIndex));
            denominator = Integer.parseInt(f.substring(slashIndex + 1));
        } else {
            numerator = Integer.parseInt(f);
            denominator = 1;
        }
        makeCorrect();
        simplify();
    }

    public static String print(Fraction f) {
        if (f.denominator == 1) {
            return String.valueOf(f.numerator);
        } else if (f.numerator == 0) {
            return "0";
        } else if (abs(f.numerator) == abs(f.denominator)) {
            return String.valueOf(f.numerator / f.denominator);
        } else if (abs(f.numerator) > abs(f.denominator)) {
            int result = f.numerator / f.denominator;
            int newNominator = f.numerator % f.denominator;
            if (newNominator == 0) {
                return String.valueOf(result);
            } else {

                return (result + " цел." + abs(newNominator) + "/" + abs(f.denominator));
            }
        } else {
            return (f.numerator + "/" + f.denominator);
        }
        // simplify();
    }

    private void makeCorrect() {
        if ((numerator == 0 && denominator == 0) || (denominator == 0)) {
            System.out.println("Ошибка деления!");
            System.exit(0);
        }
        if (numerator < 0 && denominator < 0) {
            numerator = numerator * (-1);
            denominator = denominator * (-1);
        }
        if (denominator < 0) {
            denominator = denominator * (-1);
            numerator = numerator * (-1);
        }
    }

    private void simplify() {
        int divElement = 1;
        for (int i = denominator; i >= 1; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                divElement = i;
                break;
            }
        }
        numerator = numerator / divElement;
        denominator = denominator / divElement;
    }

    public static Fraction plus(Fraction f1, Fraction f2) {
        int numerator = f1.numerator * (f2.denominator) + f2.numerator * (f1.denominator);
        int denominator = f1.denominator * f2.denominator;
        Fraction returnedF = new Fraction(String.valueOf(numerator) + "/" + String.valueOf(denominator));
        returnedF.simplify();
        return returnedF;
    }

    public static Fraction minus(Fraction f1, Fraction f2) {
        int numerator = f1.numerator * (f2.denominator) - f2.numerator * (f1.denominator);
        int denominator = f1.denominator * f2.denominator;
        Fraction returnedF = new Fraction(String.valueOf(numerator) + "/" + String.valueOf(denominator));
        returnedF.simplify();
        return returnedF;
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        int numerator = f1.numerator * f2.numerator;
        int denominator = f1.denominator * f2.denominator;
        Fraction returnedF = new Fraction(String.valueOf(numerator) + "/" + String.valueOf(denominator));
        returnedF.simplify();
        return returnedF;
    }

    public static Fraction div(Fraction f1, Fraction f2) {
        int numerator = f1.numerator * f2.denominator;
        int denominator = f1.denominator * f2.numerator;
        Fraction returnedF = new Fraction(String.valueOf(numerator) + "/" + String.valueOf(denominator));
        returnedF.simplify();
        return returnedF;

    }
}
