package com.italiandudes.projectspace.energy;

import net.minecraft.item.Item;

import java.awt.*;

public class GenericEnergyBlock extends Container {
    private double capacity=0.0; //Max capacity of the block.
    private double dischargeRate=0.0; //Discharge rate of the block (usually it's the same value of chargeRate).
    private double chargeRate=0.0; //Charge rate of the block (usually it's the same value of dischargeRate).
    private double actualCharge=0.0; //Actual charge of the block.

    //Utility.
    public void increaseCharge(double amount){
        if(amount>chargeRate){
            while(amount>0){
                if(actualCharge+chargeRate<capacity){
                    if(amount>=chargeRate) {
                        actualCharge += chargeRate;
                        amount-=chargeRate;
                    }else{
                        actualCharge+=amount;
                        amount=0.0;
                    }
                }else{
                    if(amount<chargeRate){
                        actualCharge+=amount;
                    }else{
                        actualCharge=capacity;
                    }
                    amount=0.0;
                }
            }
        }else{
            actualCharge+=amount;
        }
    }

    public void decreaseCharge(double amount){
        while(amount>0){
            if(actualCharge>=dischargeRate){
                if(amount<dischargeRate){
                    actualCharge-=amount;
                    amount=0.0;
                }else{
                    actualCharge -= dischargeRate;
                    amount -= dischargeRate;
                }
            }else if(amount<actualCharge){
                actualCharge-=amount;
                amount=0.0;
            }else{
                actualCharge=0.0;
                amount=0.0;
            }
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
