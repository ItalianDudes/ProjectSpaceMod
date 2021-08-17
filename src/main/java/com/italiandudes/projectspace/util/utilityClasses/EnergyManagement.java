package com.italiandudes.projectspace.util.utilityClasses;

//This class manages the energy used in the mod.
public class EnergyManagement {

    private double volt=0.0;
    private double ampere=0.0;
    private double watt=0.0;

    public double calculateWatt(double volt, double ampere){
        watt=volt*ampere;
        return watt;
    }

    //setters
    public void setVolt(double volt) {
        this.volt = volt;
    }

    public void setAmpere(double ampere) {
        this.ampere = ampere;
    }

    public void setWatt(double watt) {
        this.watt = watt;
    }

    //getters
    public double getVolt() {
        return volt;
    }

    public double getAmpere() {
        return ampere;
    }

    public double getWatt() {
        return watt;
    }
}
