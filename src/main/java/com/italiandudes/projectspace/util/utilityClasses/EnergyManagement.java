package com.italiandudes.projectspace.util.utilityClasses;

//This class manages the energy used in the mod.
public class EnergyManagement {

    private int volt=0;
    private int ampere=0;
    private int watt=0;

    public int calculateWatt(int volt, int ampere){
        watt=volt*ampere;
        return watt;
    }

    //setters
    public void setVolt(int volt) {
        this.volt = volt;
    }

    public void setAmpere(int ampere) {
        this.ampere = ampere;
    }

    public void setWatt(int watt) {
        this.watt = watt;
    }

    //getters
    public int getVolt() {
        return volt;
    }

    public int getAmpere() {
        return ampere;
    }

    public int getWatt() {
        return watt;
    }
}
