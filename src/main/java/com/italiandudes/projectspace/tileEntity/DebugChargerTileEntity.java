package com.italiandudes.projectspace.tileEntity;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.container.DebugChargerContainers;
import com.italiandudes.projectspace.init.ModItems;
import com.italiandudes.projectspace.init.ModTileEntityTypes;
import com.italiandudes.projectspace.items.DebugBattery;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class DebugChargerTileEntity extends LockableLootTileEntity {

    private final double maxCharge = 20000.0; //maximum charge that can be stored.
    private final double charge = 20000.0; //actual charge.
    public static int slots = 1;
    protected NonNullList<ItemStack> items = NonNullList.withSize(slots,ItemStack.EMPTY);

    protected DebugChargerTileEntity(TileEntityType<?> typeIn){super(typeIn);}

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container."+ ProjectSpace.MOD_ID + ".debug_charger");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new DebugChargerContainers(id,player,this);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public ItemStack getItem(){
        return this.items.get(0);
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }

    public DebugChargerTileEntity(){
        this(ModTileEntityTypes.DEBUG_CHARGER_TILE_ENTITY_TYPE.get());
    }

    @Override
    public int getContainerSize() {
        return slots;
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        if(!this.trySaveLootTable(compound)){
            ItemStackHelper.saveAllItems(compound,this.items);
        }
        return compound;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(getContainerSize(),ItemStack.EMPTY);
        if (this.tryLoadLootTable(nbt)){
            ItemStackHelper.loadAllItems(nbt,this.items);
        }
    }

    //Logic section:
    public boolean isCharging(Item item){

        if(item == ModItems.DEBUG_BATTERY.get()){
            DebugBattery dBattery = (DebugBattery) item;
            return dBattery.getCharge() < dBattery.getMaxBatteryPower();
        }

        return false;
    }

    public void charging(DebugBattery dBattery){
        dBattery.chargeIncrease(this.charge);
    }
}
