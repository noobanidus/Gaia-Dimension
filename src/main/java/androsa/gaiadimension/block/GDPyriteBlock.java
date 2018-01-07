package androsa.gaiadimension.block;

import androsa.gaiadimension.registry.GDTabs;
import androsa.gaiadimension.registry.ModelRegisterCallback;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class GDPyriteBlock extends Block implements ModelRegisterCallback {

    public GDPyriteBlock() {
        super(Material.IRON);

        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setLightLevel(1.0F);
        this.setSoundType(SoundType.METAL);
        this.setCreativeTab(GDTabs.tabBlock);
    }
}
