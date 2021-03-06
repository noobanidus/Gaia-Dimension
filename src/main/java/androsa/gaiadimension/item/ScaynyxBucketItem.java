package androsa.gaiadimension.item;

import androsa.gaiadimension.registry.GaiaItemGroups;
import androsa.gaiadimension.registry.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fluids.*;

import java.util.function.Supplier;

public class ScaynyxBucketItem extends BucketItem {

    public ScaynyxBucketItem(Supplier<? extends Fluid> fluid) {
        super(fluid, new Properties().maxStackSize(1).group(GaiaItemGroups.GAIA_ITEMS));
    }

    @Override
    protected ItemStack emptyBucket(ItemStack stack, PlayerEntity entity) {
        return !entity.abilities.isCreativeMode ? new ItemStack(ModItems.scaynyx_bucket.get()) : stack;
    }

    /*
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (!this.isInCreativeTab(tab))
            return;

        subItems.add(empty);

        for (final Fluid fluid : FluidRegistry.getRegisteredFluids().values()) {
            // Add all fluids that the bucket can be filled with
            final FluidStack fStack = new FluidStack(fluid, getCapacity());
            final ItemStack stack = new ItemStack(this);
            final IFluidHandlerItem fluidHandler = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);

            if (fluidHandler != null && fluidHandler.fill(fStack, true) == fStack.amount) {
                final ItemStack filled = fluidHandler.getContainer();
                subItems.add(filled);
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        final ItemStack heldItem = player.getHeldItem(hand);
        final FluidStack fluidStack = getFluid(heldItem);

        // If the bucket is full, call the super method to try and empty it
        if (fluidStack != null)
            return super.onItemRightClick(world, player, hand);

        // If the bucket is empty, try and fill it
        final RayTraceResult target = this.rayTrace(world, player, true);

        if (target == null || target.typeOfHit != RayTraceResult.Type.BLOCK) {
            return new ActionResult<>(ActionResultType.PASS, heldItem);
        }

        final BlockPos pos = target.getBlockPos();
        final ItemStack singleBucket = heldItem.copy();
        singleBucket.setCount(1);
        final FluidActionResult filledResult = FluidUtil.tryPickUpFluid(singleBucket, player, world, pos, target.sideHit);

        if (filledResult.isSuccess()) {
            final ItemStack filledBucket = filledResult.result;

            if (player.isCreative())
                return new ActionResult<>(ActionResultType.SUCCESS, heldItem);

            heldItem.shrink(1);
            if (heldItem.isEmpty())
                return new ActionResult<>(ActionResultType.SUCCESS, filledBucket);

            ItemHandlerHelper.giveItemToPlayer(player, filledBucket);

            return new ActionResult<>(ActionResultType.SUCCESS, heldItem);
        }

        return new ActionResult<>(ActionResultType.PASS, heldItem);
    }*/

    /*
    @Nullable
    @Override
    public FluidStack getFluid(ItemStack container) {
        return FluidUtil.getFluidContained(container);
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        // FluidBucketWrapper only works with Forge's UniversalBucket instance, use a different IFluidHandlerItem implementation instead
        return new GDFluidHandlerBucket(stack, getCapacity());
    }*/
}
