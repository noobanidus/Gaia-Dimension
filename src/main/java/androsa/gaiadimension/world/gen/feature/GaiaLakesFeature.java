package androsa.gaiadimension.world.gen.feature;

import androsa.gaiadimension.block.GaiaSoilBlock;
import androsa.gaiadimension.registry.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.function.Function;

@ParametersAreNonnullByDefault
public class GaiaLakesFeature<T extends BlockStateFeatureConfig> extends Feature<T> {
    private static final BlockState AIR = Blocks.CAVE_AIR.getDefaultState();

    public GaiaLakesFeature(Function<Dynamic<?>, T> config) {
        super(config);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, T config) {
        while(pos.getY() > 5 && worldIn.isAirBlock(pos)) {
            pos = pos.down();
        }

        if (pos.getY() <= 4) {
            return false;
        } else {
            pos = pos.down(4);
            ChunkPos chunkpos = new ChunkPos(pos);
            if (!worldIn.getChunk(chunkpos.x, chunkpos.z, ChunkStatus.STRUCTURE_REFERENCES).getStructureReferences(Feature.VILLAGE.getStructureName()).isEmpty()) {
                return false;
            } else {
                boolean[] aboolean = new boolean[2048];
                int i = rand.nextInt(4) + 4;

                for(int j = 0; j < i; ++j) {
                    double d0 = rand.nextDouble() * 6.0D + 3.0D;
                    double d1 = rand.nextDouble() * 4.0D + 2.0D;
                    double d2 = rand.nextDouble() * 6.0D + 3.0D;
                    double d3 = rand.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
                    double d4 = rand.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
                    double d5 = rand.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

                    for(int l = 1; l < 15; ++l) {
                        for(int i1 = 1; i1 < 15; ++i1) {
                            for(int j1 = 1; j1 < 7; ++j1) {
                                double d6 = ((double)l - d3) / (d0 / 2.0D);
                                double d7 = ((double)j1 - d4) / (d1 / 2.0D);
                                double d8 = ((double)i1 - d5) / (d2 / 2.0D);
                                double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                                if (d9 < 1.0D) {
                                    aboolean[(l * 16 + i1) * 8 + j1] = true;
                                }
                            }
                        }
                    }
                }

                for(int k1 = 0; k1 < 16; ++k1) {
                    for(int l2 = 0; l2 < 16; ++l2) {
                        for(int k = 0; k < 8; ++k) {
                            boolean flag = !aboolean[(k1 * 16 + l2) * 8 + k] && (k1 < 15 && aboolean[((k1 + 1) * 16 + l2) * 8 + k] || k1 > 0 && aboolean[((k1 - 1) * 16 + l2) * 8 + k] || l2 < 15 && aboolean[(k1 * 16 + l2 + 1) * 8 + k] || l2 > 0 && aboolean[(k1 * 16 + (l2 - 1)) * 8 + k] || k < 7 && aboolean[(k1 * 16 + l2) * 8 + k + 1] || k > 0 && aboolean[(k1 * 16 + l2) * 8 + (k - 1)]);
                            if (flag) {
                                Material material = worldIn.getBlockState(pos.add(k1, k, l2)).getMaterial();
                                if (k >= 4 && material.isLiquid()) {
                                    return false;
                                }

                                if (k < 4 && !material.isSolid() && worldIn.getBlockState(pos.add(k1, k, l2)) != config.state) {
                                    return false;
                                }
                            }
                        }
                    }
                }

                for(int l1 = 0; l1 < 16; ++l1) {
                    for(int i3 = 0; i3 < 16; ++i3) {
                        for(int i4 = 0; i4 < 8; ++i4) {
                            if (aboolean[(l1 * 16 + i3) * 8 + i4]) {
                                worldIn.setBlockState(pos.add(l1, i4, i3), i4 >= 4 ? AIR : config.state, 2);
                            }
                        }
                    }
                }

                for(int i2 = 0; i2 < 16; ++i2) {
                    for(int j3 = 0; j3 < 16; ++j3) {
                        for(int j4 = 4; j4 < 8; ++j4) {
                            if (aboolean[(i2 * 16 + j3) * 8 + j4]) {
                                BlockPos blockpos = pos.add(i2, j4 - 1, j3);
                                if (worldIn.getBlockState(blockpos).getBlock() instanceof GaiaSoilBlock && worldIn.getLightLevel(LightType.SKY, pos.add(i2, j4, j3)) > 0) {
                                    Biome biome = worldIn.getBiome(blockpos);

                                    if (biome.getSurfaceBuilderConfig().getTop().getBlock() == ModBlocks.murky_grass.get()) {
                                        worldIn.setBlockState(blockpos, ModBlocks.murky_grass.get().getDefaultState(), 2);
                                    } else if (biome.getSurfaceBuilderConfig().getTop().getBlock() == ModBlocks.soft_grass.get()) {
                                        worldIn.setBlockState(blockpos, ModBlocks.soft_grass.get().getDefaultState(), 2);
                                    } else if (biome.getSurfaceBuilderConfig().getTop().getBlock() == ModBlocks.corrupt_grass.get()) {
                                        worldIn.setBlockState(blockpos, ModBlocks.corrupt_grass.get().getDefaultState(), 2);
                                    } else {
                                        worldIn.setBlockState(blockpos, ModBlocks.glitter_grass.get().getDefaultState(), 2);
                                    }
                                }
                            }
                        }
                    }
                }

                if (config.state.getBlock() != ModBlocks.mineral_water.get()) {
                    for(int x = 0; x < 16; ++x) {
                        for(int z = 0; z < 16; ++z) {
                            for(int y = 0; y < 8; ++y) {
                                boolean flag1 = !aboolean[(x * 16 + z) * 8 + y] && (x < 15 && aboolean[((x + 1) * 16 + z) * 8 + y] || x > 0 && aboolean[((x - 1) * 16 + z) * 8 + y] || z < 15 && aboolean[(x * 16 + z + 1) * 8 + y] || z > 0 && aboolean[(x * 16 + (z - 1)) * 8 + y] || y < 7 && aboolean[(x * 16 + z) * 8 + y + 1] || y > 0 && aboolean[(x * 16 + z) * 8 + (y - 1)]);
                                if (flag1 && (y < 4 || rand.nextInt(2) != 0) && worldIn.getBlockState(pos.add(x, y, z)).getMaterial().isSolid()) {

                                    if (config.state.getBlock() == ModBlocks.liquid_bismuth.get()) {
                                        if (rand.nextInt(4) == 0) {
                                            worldIn.setBlockState(pos.add(x, y, z), ModBlocks.active_rock.get().getDefaultState(), 2);
                                        } else {
                                            worldIn.setBlockState(pos.add(x, y, z), ModBlocks.impure_rock.get().getDefaultState(), 2);
                                        }
                                    } else if (config.state.getBlock() == ModBlocks.liquid_aura.get()) {
                                        worldIn.setBlockState(pos.add(x, y, z), ModBlocks.sparkling_rock.get().getDefaultState(), 2);
                                    } else if (config.state.getBlock() == ModBlocks.sweet_muck.get()) {
                                        worldIn.setBlockState(pos.add(x, y, z), ModBlocks.thick_glitter_block.get().getDefaultState(), 2);
                                    } else {
                                        worldIn.setBlockState(pos.add(x, y, z), ModBlocks.volcanic_rock.get().getDefaultState(), 2);
                                    }
                                }
                            }
                        }
                    }
                }

                return true;
            }
        }
    }
}
