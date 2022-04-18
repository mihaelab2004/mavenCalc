package com.endava.calculator.basic;

public interface BasicOperations {

    public abstract long add(int... no);
    public abstract long add(long ... no);
    public abstract double add(double... no);

    public abstract int subtract(int... no);
    public abstract long subtract(long... no);
    public abstract double subtract(double... no);

    public abstract long multiply(int ... no);
    public abstract double multiply(long ... no);
    public abstract double multiply(double ... no);

    public abstract double divide(int ... no);
    public abstract double divide(long ... no);
    public abstract double divide(double ... no);
}
