package androsa.gaiadimension.compat.jei.restructurer;

import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;

public abstract class RestructurerRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    protected static final int inputSlot = 0;
    protected static final int glitterFuelSlot = 1;
    protected static final int shineFuelSlot = 2;
    protected static final int outputSlot1 = 3;
    protected static final int outputSlot2 = 4;
}
