package com.example.ui_calculator;

import java.util.Arrays;
import java.util.*;
public class Calculator {

    private String usersString;
    private Stack<Fraction> myStack = new Stack<>();
    private ArrayList<String> usersArrayList;

    public Calculator(String myInput) {
        this.usersString = myInput;
    }

    public ArrayList rewriteArray() {
        usersArrayList = new ArrayList<>(Arrays.asList(usersString.split(" ")));
        return usersArrayList;
    }

    public boolean signCheck(String element) {
        boolean conditionForElements = true;
        if (element.equals("*") |
                (element.equals("+")) |
                (element.equals(":")) |
                (element.equals("-"))) {
            conditionForElements = false;
        }
        return conditionForElements;
    }

    public Fraction countPolandNotation() {
        for (int i = 0; i < usersArrayList.size(); i++) {
            if (signCheck(usersArrayList.get(i))) {
                myStack.push(new Fraction(usersArrayList.get(i)));
            } else {
                Fraction temp2 = myStack.pop();
                Fraction temp1 = myStack.pop();
                if (usersArrayList.get(i).equals("*")) {
                    myStack.push(Fraction.multiply(temp1, temp2));
                } else if (usersArrayList.get(i).equals("+")) {
                    myStack.push(Fraction.plus(temp1, temp2));
                } else if (usersArrayList.get(i).equals("-")) {
                    myStack.push(Fraction.minus(temp1, temp2));
                } else if (usersArrayList.get(i).equals(":")) {
                    myStack.push(Fraction.div(temp1, temp2));
                }
            }
        }
        if (myStack.isEmpty()) {
            System.out.println("Данные были введены некорректно. Запустите программу снова. ");
        }
        return myStack.peek();
    }
}
