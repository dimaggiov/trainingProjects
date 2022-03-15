package com.mthree.foundations.classesAndObjects.stateCapitals3;

public class Capital {
    private String name;
    private int population;
    private double sqMiles;

    public Capital() {
        this.name = "";
        this.population =0;
        this.sqMiles = 0;
    }

    public Capital(String name, int population, double sqMiles) {
        this.name = name;
        this.population = population;
        this.sqMiles = sqMiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSqMiles() {
        return sqMiles;
    }

    public void setSqMiles(double sqMiles) {
        this.sqMiles = sqMiles;
    }
}
