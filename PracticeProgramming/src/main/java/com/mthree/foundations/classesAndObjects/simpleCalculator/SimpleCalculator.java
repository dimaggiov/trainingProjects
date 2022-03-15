package com.mthree.foundations.classesAndObjects.simpleCalculator;

public class SimpleCalculator {
    private double value1;
    private double value2;


    public SimpleCalculator() {
        value1 = 0;
        value2 = 0;
    }

    public SimpleCalculator(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public double add(){
        return value1 + value2;
    }

    public double subtract(){
        return value1 - value2;
    }

    public double multiply(){
        return value1 * value2;
    }

    public double divide(){
        return value1 / value2;
    }



    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }
}
