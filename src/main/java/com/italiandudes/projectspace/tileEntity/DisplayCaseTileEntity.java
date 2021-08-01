package com.italiandudes.projectspace.tileEntity;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.init.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import com.italiandudes.projectspace.container.DisplayCaseContainers;

//This class manages the TileEntity "DisplayCase".
public class DisplayCaseTileEntity extends LockableLootTileEntity {

    public static int slots = 1;
    protected NonNullList<ItemStack> items = NonNullList.withSize(slots,ItemStack.EMPTY);

    protected DisplayCaseTileEntity(TileEntityType<?> typeIn){
        super(typeIn);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container."+ ProjectSpace.MOD_ID + ".display_case");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new DisplayCaseContainers(id,player,this);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }

    public DisplayCaseTileEntity(){
        this(ModTileEntityTypes.DISPLAY_CASE_TILE_ENTITY_TYPE.get());
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
}
