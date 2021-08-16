package com.italiandudes.projectspace.container;

import com.italiandudes.projectspace.init.ModBlocks;
import com.italiandudes.projectspace.init.ModContainerTypes;
import com.italiandudes.projectspace.tileEntity.DebugDisplayCaseTileEntity;
import com.italiandudes.projectspace.tileEntity.DebugFurnaceTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class DebugFurnaceContainers extends Container {

    public final DebugFurnaceTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;

    public DebugFurnaceContainers(final int windowId, final PlayerInventory playerInv, final DebugFurnaceTileEntity te){
        super(ModContainerTypes.DEBUG_DISPLAY_CASE_CONTAINERS_TYPE.get(),windowId);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.create(Objects.requireNonNull(te.getLevel()),te.getBlockPos());

        //Actual GUI slots
        this.addSlot(new Slot((IInventory) te,0,80,35));

        //Main Player Inventory
        for(int row=0; row<3; row++){
            for(int col=0;col<9;col++){
                this.addSlot(new Slot(playerInv, col+row*9+9,8+col*18,166-(4-row)*18-10));
            }
        }

        //Player Hotbar
        for(int col=0;col<9;col++){
            this.addSlot(new Slot(playerInv,col,8+col*18,142));
        }
    }

    public DebugFurnaceContainers(final int windowId, final PlayerInventory playerInv, final PacketBuffer data){
        this(windowId,playerInv,getTileEntity(playerInv,data));
    }

    private static DebugFurnaceTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data){
        Objects.requireNonNull(playerInventory, "Player Inventory cannot be null.");
        Objects.requireNonNull(data,"Packet Buffer cannot be null.");
        final TileEntity te = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if (te instanceof DebugFurnaceTileEntity){
            return (DebugFurnaceTileEntity) te;
        }
        throw new IllegalStateException("Tile Entity Is Not Correct");
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn) {
        return stillValid(canInteractWithCallable,playerIn, ModBlocks.DEBUG_DISPLAY_CASE.get());
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot!=null && slot.hasItem()){
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if(index < DebugFurnaceTileEntity.slots
                    && !this.moveItemStackTo(stack1, DebugFurnaceTileEntity.slots,this.slots.size(),true)){
                return ItemStack.EMPTY;
            }
            if(!this.moveItemStackTo(stack1,0, DebugFurnaceTileEntity.slots,false)){
                return ItemStack.EMPTY;
            }

            if (stack1.isEmpty()){
                slot.set(ItemStack.EMPTY);
            }else{
                slot.setChanged();
            }
        }
        return stack;
    }
}
