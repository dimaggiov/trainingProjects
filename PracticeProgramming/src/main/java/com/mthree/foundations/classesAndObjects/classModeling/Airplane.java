package com.mthree.foundations.classesAndObjects.classModeling;

/*
public class Airplane { //as part of air traffic control system

    private double latitude;
    private double longitude;
    private double altitude;
    private int planeID;

    public Airplane() {
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;
        this.planeID = 0;
    }

    public Airplane(double latitude, double longitude, double altitude, int planeID) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.planeID = planeID;
    }

    public void fly(){
        //do something to fly and then change all position values to new ones
    }

    public String getPosition(){
        //put lat long and alt together to make one easy to read position
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public int getPlaneID() {
        return planeID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }
}
*/

public class Airplane { //as part of a flight simulator

    private double latitude;
    private double longitude;
    private double altitude;
    private double speed;


    public Airplane() {
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;
    }

    public double getLatitude() {
        return latitude;
    }

    public Airplane(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public void fly(){
        //calls things like accelerate and decelerate
        // to fly and change position and speed of plane
    }

    public void accelerate(){
        //speeds up plane
    }

    public void decelerate(){
        //slows down plane
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
}
