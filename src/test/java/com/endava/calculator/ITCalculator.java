package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class ITCalculator {

    public static void main(String[] args) {

        BasicOperations b = new Basic(3);
        ExpertOperations e = new Expert();

        System.out.println("Add: " + b.add( 2,3,4,56));
        System.out.println("Subtract: " + b.subtract(2,-3, -3, 8));
        System.out.println("Multiply: " + b.multiply(2,4));
        System.out.println(("Divide: " + b.divide( 10, 3)));
        System.out.println("Divide: " + b.divide(5,1));
        System.out.println("Multiply: " + b.multiply(3.5,2.3));
        System.out.println("Multiply: "+ b.multiply(5,4,2));

        System.out.println("-------------------------------------");

        System.out.println("Power: " + e.power(2,-5));
        System.out.println("Root: " + e.root(10));
        System.out.println("Factorial: " + e.fact(4));
        System.out.println("N root: " + e.nthRoot(27,3));

        System.out.println("-------------------------------------");

        //System.out.println(e.calculate("25.5 * 3 + 5"));
      //  System.out.println(e.calculate("-3-2*4"));
       // System.out.println(e.calculate("2*(-3+2)"));
        System.out.println("Paranteze: " + e.calculate("2+(-3-5)*(-7-5)"));
        System.out.println("Paranteze: " + e.calculate("(3+2)/5*5 - (8/2)"));
    }
}
