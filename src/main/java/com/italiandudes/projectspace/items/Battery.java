package com.italiandudes.projectspace.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Battery extends Item {

    double maxBatteryPower = Double.MAX_VALUE;
    double charge;

    public Battery() {
        super(new Item.Properties()
                .tab(ItemGroup.TAB_MATERIALS)
        );
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    //This method is called whenever you need to increase the amount of energy stored in the battery
    public int chargeIncrease(double chargeIncrease){
        if((this.charge+chargeIncrease)<this.maxBatteryPower){
            this.charge+=chargeIncrease;
            return 1;
        }else{
            return 0;
        }
    }

    //This method is called whenever you need to decrease the amount of energy stored in the battery
    public int chargeDecrease(double chargeDecrease){
        if((this.charge>0)&&(this.charge<chargeDecrease)){
            this.charge=0;
            return -1;  //Operation completed unsuccessfully
        }else if(this.charge>chargeDecrease){
            this.charge-=chargeDecrease;
            return 1;   //Operation completed successfully
        }else{
            return 0;   //The battery is already empty
        }
    }
}
