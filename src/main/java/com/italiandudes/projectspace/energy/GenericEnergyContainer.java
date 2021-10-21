package com.italiandudes.projectspace.energy;

import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;

import java.awt.*;

public class GenericEnergyContainer extends Container {
    private double capacity=0.0; //Max capacity of the block.
    private double dischargeRate=0.0; //Discharge rate of the block (usually it's the same value of chargeRate).
    private double chargeRate=0.0; //Charge rate of the block (usually it's the same value of dischargeRate).
    private double actualCharge=0.0; //Actual charge of the block.

    //Inputs/Outputs (DEFAULT INITIALIZATION)
    private boolean primaryInput=false;         //Cable
    private boolean secondaryInput=false;       //Item
    private boolean primaryOutput=false;        //Item
    private boolean secondaryOutput=false;      //Cable

    //Utility.
    //These methods actually add or sub energy from the storage.
    //Items
    public void increaseChargeViaItem(double amount, GenericEnergyItem item){
        boolean isEmpty= item.getActualCharge() == 0;

        if(amount>chargeRate && !isEmpty){
            while(amount>0 && !isEmpty){
                if(actualCharge+chargeRate<capacity){
                    if(amount>=chargeRate) {
                        actualCharge += chargeRate;
                        isEmpty=item.decreaseCharge(chargeRate);
                        amount-=chargeRate;
                    }else{
                        isEmpty=item.decreaseCharge(chargeRate);
                        actualCharge+=amount;
                        amount=0.0;
                    }
                }else{
                    if(amount<chargeRate){
                        isEmpty=item.decreaseCharge(amount);
                        actualCharge+=amount;
                    }else{
                        isEmpty=item.decreaseCharge(chargeRate);
                        actualCharge=capacity;
                    }
                    amount=0.0;
                }
            }
        }else{
            item.decreaseCharge(amount);
            actualCharge+=amount;
        }
    }

    public void decreaseChargeViaItem(double amount, GenericEnergyItem item){
        boolean isFull= !(item.getActualCharge() ==0);

        while(amount>0 && !isFull){
            if(actualCharge>=dischargeRate){
                if(amount<dischargeRate){
                    isFull=item.increaseCharge(dischargeRate);
                    actualCharge-=amount;
                    amount=0.0;
                }else{
                    isFull=item.increaseCharge(dischargeRate);
                    actualCharge -= dischargeRate;
                    amount -= dischargeRate;
                }
            }else if(amount<actualCharge){
                isFull=item.increaseCharge(amount);
                actualCharge-=amount;
                amount=0.0;
            }else{
                actualCharge=0.0;
                amount=0.0;
            }
        }
    }

    //These methods check the priority levels and play with them.
    //Items
    public void increaseChargeManagerItem(Item item, double amount){
        GenericEnergyItem energyItem = (GenericEnergyItem) item;
        if(!primaryInput){
            if(!secondaryInput){
                itemInputManager();
            }
            increaseChargeViaItem(amount, energyItem);
        }
    }

    public void decreaseChargeManagerItem(Item item, double amount){
        GenericEnergyItem energyItem = (GenericEnergyItem) item;
        if(!primaryInput){
            itemOutputManager();
        }
        decreaseChargeViaItem(amount,energyItem);
    }

    //Management (Inputs/Outputs).
    //Cables.
    public void cableInputManager(){
        primaryInput= !primaryInput;
    }

    public void cableOutputManager(){
        secondaryOutput= !secondaryOutput;
    }
    //Items.
    public void itemInputManager(){
        secondaryInput= !secondaryInput;
    }

    public void itemOutputManager(){
        primaryOutput= !primaryOutput;
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
