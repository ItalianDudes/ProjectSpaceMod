package com.italiandudes.projectspace.energy;

import net.minecraft.item.Item;

public class GenericEnergyItem extends Item {
    private double capacity=0.0; //Max capacity of the item.
    private double dischargeRate=0.0; //Discharge rate of the item (usually it's the same value of chargeRate).
    private double chargeRate=0.0; //Charge rate of the item (usually it's the same value of dischargeRate).
    private double actualCharge=0.0; //Actual charge of the item.


    public GenericEnergyItem(Properties properties) {
        super(properties);
    }

    //Utility.
    public boolean increaseCharge(double amount){
        if(amount+actualCharge > capacity){
            actualCharge=capacity;
        }else{
            actualCharge+=amount;
        }

        if(actualCharge==capacity){
            return true;
        }else{
            return false;
        }
    }

    public boolean decreaseCharge(double amount){
        if(amount>actualCharge){
            actualCharge=0.0;
            return true;
        }else{
            actualCharge-=amount;
            return false;
        }
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
}
