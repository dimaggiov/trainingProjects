package com.mthree.foundations.classesAndObjects.classModeling;



public class House { //house as part of a gps system

    private String address;
    private double latitude;
    private double longitude;


    public House(){
        address = "";
        latitude = 0;
        longitude = 0;
    }


    public House(String address, double latitude, double longitude){
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }




    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}

/*
public class House { //house as part of 3-D design system
    private int rooms;
    private int bedrooms;
    private int bathrooms;
    private double sqFt;

    public House(){
        rooms = 0;
        bedrooms = 0;
        bathrooms = 0;
        sqFt = 0;
    }

    public House(int rooms, int bedrooms, int bathrooms, double sqFt) {
        this.rooms = rooms;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sqFt = sqFt;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public double getSqFt() {
        return sqFt;
    }

    public void setSqFt(double sqFt) {
        this.sqFt = sqFt;
    }
}
*/


