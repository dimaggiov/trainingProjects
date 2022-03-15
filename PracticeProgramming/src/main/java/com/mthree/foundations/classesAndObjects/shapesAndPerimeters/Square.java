package com.mthree.foundations.classesAndObjects.shapesAndPerimeters;

public class Square extends Shape{

    private double length;

    public Square() {
        this.length = 0;
    }

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * length;
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
