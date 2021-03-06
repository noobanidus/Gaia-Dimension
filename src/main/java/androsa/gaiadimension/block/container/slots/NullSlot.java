package androsa.gaiadimension.block.container.slots;

import androsa.gaiadimension.block.tileentity.PurifierTileEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class NullSlot extends Slot {

    public NullSlot(IInventory iInventoryIn, int index, int xPosition, int yPosition) {
        super(iInventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return PurifierTileEntity.getThirdFuelBurnTime().getOrDefault(stack.getItem(), 0) > 0;
    }

    @Override
    public int getSlotStackLimit() {
        return 64;
    }
}
