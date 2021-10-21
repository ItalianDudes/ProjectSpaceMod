package com.italiandudes.projectspace.energy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.world.IWorld;

public abstract class GenericEnergyCable extends Block implements {

    private double transferRate=0.0;
    private boolean isConnectedLeft=false;
    private boolean isConnectedRight=false;
    //private double maxTransferRate;

    public GenericEnergyCable(Properties properties) {
        super(properties);
    }

    //Getters.
    public double getTransferRate() {
        return transferRate;
    }
    public boolean isConnectedLeft() {
        return isConnectedLeft;
    }
    public boolean isConnectedRight() {
        return isConnectedRight;
    }

    //Setters.
    public void setTransferRate(double transferRate) {
        this.transferRate = transferRate;
    }
    public void setConnectedLeft(boolean state) {
        isConnectedLeft=state;
    }
    public void setConnectedRight(boolean state) {
        isConnectedRight=state;
    }

    //Managers.
    public void managerLeftConnection(){
        isConnectedLeft=!isConnectedLeft;
    }
    public void managerRightConnection(){
        isConnectedRight=!isConnectedRight;
    }
}
