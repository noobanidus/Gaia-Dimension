package androsa.gaiadimension.block;

import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class AgateLogBlock extends LogBlock {

    public AgateLogBlock(MaterialColor topColor, MaterialColor baseColor) {
        this(topColor, baseColor, 0);
    }

    public AgateLogBlock(MaterialColor topColor, MaterialColor baseColor, int light) {
        super(topColor, Properties.create(Material.WOOD, baseColor).hardnessAndResistance(1.5F, 2.0F).sound(SoundType.STONE).harvestTool(ToolType.AXE).harvestLevel(0).lightValue(light));
    }
}