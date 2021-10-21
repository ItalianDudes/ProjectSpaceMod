package com.italiandudes.projectspace.items.energyContainer;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.energy.GenericEnergyItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BasicBattery extends GenericEnergyItem {

    public BasicBattery() {
        super(new Item.Properties()
                .tab(ProjectSpace.ENERGY_TAB));

        double capacity=200.0;
        double chargeRate=20.0;
        double dischargeRate=20.0;
        setCapacity(capacity);                             //Maximum amount of energy that can be stored in this battery.
        setActualCharge(220.0);                             //If the given charge exceeds the battery's capacity, then the battery is equal to its capacity.
        setChargeRate(chargeRate);
        setDischargeRate(dischargeRate);
    }

    //This method adds the lore/description to the item.
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> toolTip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, toolTip, flagIn);
        toolTip.add(new StringTextComponent("\u00A76Energy:"));
        toolTip.add(new StringTextComponent("\u00A76" + getActualCharge() + "[W]/" + getCapacity() + "[W]"));
    }
}
