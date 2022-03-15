package com.mthree.foundations.carlotservicelayer;

public class CarKey {
    private String VIN;
    private boolean laserCut;

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public boolean isLaserCut() {
        return laserCut;
    }

    public void setLaserCut(boolean laserCut) {
        this.laserCut = laserCut;
    }

    // plus getters, setters & appropriate constructors
}
