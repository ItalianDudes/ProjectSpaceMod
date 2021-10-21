package com.italiandudes.projectspace.energy;

import net.minecraft.item.Item;

public class GenericEnergyItem extends Item {
    private double capacity=0.0; //Max capacity of the battery.
    private double dischargeRate=0.0; //Discharge rate of the battery (usually it's the same value of chargeRate).
    private double chargeRate=0.0; //Charge rate of the battery (usually it's the same value of dischargeRate).
    private double actualCharge=0.0; //Actual charge of the battery.


    public GenericEnergyItem(Properties properties) {
        super(properties);
    }

    //Getters
    public double getActualCharge() {
        return actualCharge;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getDischargeRate() {
        return dischargeRate;
    }

    public double getChargeRate() {
        return chargeRate;
    }

    //Setters
    public void setCapacity(double capacity){
        this.capacity=capacity;
    }

    public void setActualCharge(double actualCharge){
        if(actualCharge>capacity){
            this.actualCharge=capacity;
        }else{
            this.actualCharge=actualCharge;
        }
    }

    public void setChargeRate(double chargeRate){
        this.chargeRate=chargeRate;
    }

    public void setDischargeRate(double dischargeRate){
        this.dischargeRate=dischargeRate;
    }

    public void decreaseActualCharge(double amount){
        while(amount>0){
            if(actualCharge>=dischargeRate) {
                actualCharge -= dischargeRate;
                amount -= dischargeRate;
            }else{
                actualCharge=0.0;
                amount=0.0;
            }
        }
    }
}
