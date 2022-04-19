package com.endava.calculator.basic;

public class Basic implements BasicOperations {

    protected int decimals;

    public Basic() {
        decimals = 2;
    }

    public Basic(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public long add(int... no) {
        long sum = 0;
        for (long n : no) {
            sum += n;
        }
        return sum;
    }

    @Override
    public long add(long... no) {
        long sum = 0;
        for (long n : no) {
            sum += n;
        }
        return sum;
    }

    @Override
    public double add(double... no) {
        double sum = 0;
        for (double n : no) {
            sum += n;
        }
        return formatNumber(sum);
    }

    @Override
    public int subtract(int... no) {
        int result = no[0];
        for (int i = 1; i < no.length; i++) {
            result -= no[i];
        }
        return result;
    }

    @Override
    public long subtract(long... no) {
        long result = no[0];
        for (int i = 1; i < no.length; i++) {
            result -= no[i];
        }
        return result;
    }

    @Override
    public double subtract(double... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result -= no[i];
        }
        return formatNumber(result);
    }

    @Override
    public long multiply(int... no) {
        long result = 1;
        for (int i : no) {
            result *= i;
        }
        return result;
    }

    @Override
    public double multiply(long... no) {
        double result = 1;
        for (long i : no) {
            result *= i;
        }
        return result;
    }

    @Override
    public double multiply(double... no) {
        double result = 1;
        for (double i : no) {
            result *= i;
        }
        return formatNumber(result);
    }

    @Override
    public double divide(int... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result /= no[i];
        }
        return formatNumber(result);

    }

    @Override
    public double divide(long... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result /= no[i];
        }
        return formatNumber(result);
    }

    @Override
    public double divide(double... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result /= no[i];
        }
        return formatNumber(result);
    }

    protected double formatNumber(double n) {
    String s = String.format("%."+ decimals + "f", n);
    return Double.parseDouble(s);
}
}
