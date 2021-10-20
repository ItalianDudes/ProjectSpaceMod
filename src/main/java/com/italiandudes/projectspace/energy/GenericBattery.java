package com.italiandudes.projectspace.energy;

import net.minecraft.item.Item;

public class GenericBattery extends Item {
    private double capacity; //Max capacity of the battery
    private double dischargeRate; //Discharge rate of the battery (usually is the same value of chargeRate)
    private double chargeRate; //Charge rate of the battery (usually is the same value of dischargeRate)
    private double actualCharge; //Actual charge of the battery

    public GenericBattery(Properties properties) {
        super(properties);
    }
}
