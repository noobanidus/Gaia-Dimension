package androsa.gaiadimension;

import androsa.gaiadimension.registry.*;
import androsa.gaiadimension.world.GaiaTeleporter;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static androsa.gaiadimension.registry.ModDimensions.GAIA;

@Mod(GaiaDimensionMod.MODID)
public class GaiaDimensionMod {
    public static final String MODID = "gaiadimension";

    public static final String ARMOR_DIR = "gaiadimension:textures/armor/";
    public static final String MODEL_DIR = "gaiadimension:textures/model/";

    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ModGaiaConfig.ClientConfig clientConfig;
    public static ModGaiaConfig.ServerConfig serverConfig;
    public static DimensionType gaia_dimension;
    public static GaiaTeleporter gaiaTeleporter;

    public static final CreatureAttribute GAIAN = new CreatureAttribute();
    public static final CreatureAttribute CORRUPT = new CreatureAttribute();

    public static final DamageSource CORRUPTION = new DamageSource("corruption").setDamageBypassesArmor();

    public static final Tag<Item> AGATE_PLANKS = new ItemTags.Wrapper(new ResourceLocation(MODID, "agate_planks"));
    public static final Tag<Item> GEM_POUCH_ITEMS = new ItemTags.Wrapper(new ResourceLocation(MODID, "gem_pouch_items"));

    public GaiaDimensionMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);

        ModRecipes.registerRecipeTypes();

        ModBiomes.BIOMES.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModContainers.CONTAINERS.register(modEventBus);
        ModDimensions.BIOME_PROVIDER_TYPES.register(modEventBus);
        ModDimensions.CHUNK_GENERATOR_TYPES.register(modEventBus);
        ModDimensions.MOD_DIMENSIONS.register(modEventBus);
        ModEffects.POTIONS.register(modEventBus);
        ModEntities.ENTITIES.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModParticles.PARTICLE_TYPES.register(modEventBus);
        ModRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        ModTileEntities.TILE_ENTITIES.register(modEventBus);
        ModWorldgen.FEATURES.register(modEventBus);
        ModWorldgen.SURFACE_BUILDERS.register(modEventBus);
        ModWorldgen.WORLD_CARVERS.register(modEventBus);

        final Pair<ModGaiaConfig.ClientConfig, ForgeConfigSpec> specPairC = new ForgeConfigSpec.Builder().configure(ModGaiaConfig.ClientConfig::new);
        final Pair<ModGaiaConfig.ServerConfig, ForgeConfigSpec> specPairS = new ForgeConfigSpec.Builder().configure(ModGaiaConfig.ServerConfig::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, specPairC.getRight());
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, specPairS.getRight());
        clientConfig = specPairC.getLeft();
        serverConfig = specPairS.getLeft();
    }

    public void setup(FMLCommonSetupEvent event) {
        ModBlocks.addPlants();
        ModEntities.registerSpawnPlacement();
        ModBiomes.addBiomeTypes();
        ModBiomes.addBiomeFeatures();
    }

    public void clientSetup(FMLClientSetupEvent event) {
        DistExecutor.runWhenOn(Dist.CLIENT, () -> ModContainers::registerScreens);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> ModEntities::registerEntityRender);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> ModParticles::forgeClassLoadingIsFuckedThisShouldntBeHereButHereItIs);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> ClientEvents::registerBlockColors);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> ClientEvents::registerItemColors);
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEventBus {
        @SubscribeEvent
        public static void registerModDimension(final RegisterDimensionsEvent e) {
            ResourceLocation gaia = new ResourceLocation(GaiaDimensionMod.MODID, "gaia");

            if (DimensionType.byName(gaia) == null) {
                gaia_dimension = DimensionManager.registerDimension(gaia, GAIA.get(), new PacketBuffer(Unpooled.buffer()), true);
                DimensionManager.keepLoaded(gaia_dimension, false);
            } else {
                gaia_dimension = DimensionType.byName(gaia);
            }

            GaiaDimensionMod.LOGGER.info("We are set for the world of Gaia.");
        }

        @SubscribeEvent
        public static void onWorldLoad(WorldEvent.Load e) {
            if (!(e.getWorld() instanceof ServerWorld)) return;

            ServerWorld world = (ServerWorld)e.getWorld();
            if (world.dimension.getType() == DimensionType.OVERWORLD || world.dimension.getType() == GaiaDimensionMod.gaia_dimension) {
                world.customTeleporters.add(gaiaTeleporter = new GaiaTeleporter(world));
            }
        }
    }
}