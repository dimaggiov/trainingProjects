package com.mthree.foundations.classesAndObjects.classModeling;
/*
public class Car { // as part of inventory for dealership

    private String make;
    private String model;
    private int year;
    private int stock;


    public Car() {
        make = "";
        model = "";
        year = 0;
        stock = 0;
    }

    public Car(String make, String model, int year, int stock) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.stock = stock;
    }

    public void sell(){
        stock--;
    }

    public void buy(int num){
        stock += num;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
*/

public class Car{ //as part of video game
    private String make;
    private String model;
    private int year;
    private int topSpeed;
    private int handling;
    private int acceleration;

    public Car() {
        make = "";
        model = "";
        year = 0;
        topSpeed = 0;
        handling = 0;
        acceleration = 0;
    }

    public Car(String make, String model, int year, int topSpeed, int handling, int acceleration) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.topSpeed = topSpeed;
        this.handling = handling;
        this.acceleration = acceleration;
    }

    public void drive(){
        //drives car around in game
    }

    public void modCar(String mods){
        //changes cars stats based on what mods are added
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getHandling() {
        return handling;
    }

    public void setHandling(int handling) {
        this.handling = handling;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }
}
