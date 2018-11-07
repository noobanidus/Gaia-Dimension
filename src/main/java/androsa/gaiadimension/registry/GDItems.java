package androsa.gaiadimension.registry;

import androsa.gaiadimension.GaiaDimension;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(GaiaDimension.MODID)
@SuppressWarnings("unused")
public class GDItems {

    public static ItemArmor.ArmorMaterial ARMOR_SUGILITE = EnumHelper.addArmorMaterial("SUGILITE", "sugilite", 1000, new int[]{1, 4, 6, 1}, 5, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F);
    public static ItemArmor.ArmorMaterial ARMOR_PROUSTITE = EnumHelper.addArmorMaterial("PROUSTITE", "proustite", 1500, new int[]{1, 4, 6, 1}, 5, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F);
    public static ItemArmor.ArmorMaterial ARMOR_LEUCITE = EnumHelper.addArmorMaterial("LEUCITE", "leucite", 1300, new int[]{1, 4, 6, 1}, 5, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 1.0F);
    public static ItemArmor.ArmorMaterial ARMOR_CARNELIAN = EnumHelper.addArmorMaterial("CARNELIAN", "carnelian", 2500, new int[]{2, 5, 7, 2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static ItemArmor.ArmorMaterial ARMOR_DIOPSIDE = EnumHelper.addArmorMaterial("DIOPSIDE", "diopside", 2300, new int[]{2, 5, 7, 2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
    public static ItemArmor.ArmorMaterial ARMOR_CHALCEDONY = EnumHelper.addArmorMaterial("CHALCEDONY", "chalcedony", 3000, new int[]{3, 6, 8, 3}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
    public static ItemArmor.ArmorMaterial ARMOR_MALACHITE = EnumHelper.addArmorMaterial("MALACHITE", "malachite_guard", 5120, new int[]{2, 5, 7, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F);
    public static ItemArmor.ArmorMaterial ARMOR_TIGER_EYE = EnumHelper.addArmorMaterial("TIGER_EYE", "apex_predator", 4096, new int[]{2, 5, 7, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static ItemArmor.ArmorMaterial ARMOR_SPINEL = EnumHelper.addArmorMaterial("SPINEL", "spinel_princess", 5120, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);
    public static ItemArmor.ArmorMaterial ARMOR_ZIRCON = EnumHelper.addArmorMaterial("ZIRCON", "zircon_prince", 6144, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);
    public static ItemArmor.ArmorMaterial ARMOR_CORRUPT = EnumHelper.addArmorMaterial("CORRUPT", "corrupt_warrior", -1, new int[]{4, 7, 9, 4}, 30, SoundEvents.ENTITY_BLAZE_HURT, 4.0F);
    public static ItemArmor.ArmorMaterial ARMOR_BIXBITE = EnumHelper.addArmorMaterial("BIXBITE", "gaia_duchess", 8192, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F);
    public static ItemArmor.ArmorMaterial ARMOR_TSVAROVITE = EnumHelper.addArmorMaterial("TSVAROVITE", "gaia_baron", 9216, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.5F);
    public static ItemArmor.ArmorMaterial ARMOR_LARVIKITE = EnumHelper.addArmorMaterial("LARVAKITE", "gaia_duke", 10240, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F);
    public static ItemArmor.ArmorMaterial ARMOR_GAIA_CHAMP = EnumHelper.addArmorMaterial("GAIA_CHAMP", "gaia_champion", -1, new int[]{4, 7, 9, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);

    public static Item.ToolMaterial TOOL_AGATE = EnumHelper.addToolMaterial("AGATE", 0, 150, 2.5F, 1.0F, 5);
    public static Item.ToolMaterial TOOL_SUGILITE = EnumHelper.addToolMaterial("SUGILITE", 1, 800, 3.0F, 1.5F, 10);
    public static Item.ToolMaterial TOOL_IXIOLITE = EnumHelper.addToolMaterial("IXIOLITE", 2, 1500, 4.0F, 2.0F, 10);
    public static Item.ToolMaterial TOOL_EUCLASE = EnumHelper.addToolMaterial("EUCLASE", 2, 3000, 4.0F, 2.0F, 10);
    public static Item.ToolMaterial TOOL_CARNELIAN = EnumHelper.addToolMaterial("CARNELIAN", 3, 2500, 5.0F, 3.0F, 10);
    public static Item.ToolMaterial TOOL_BENITOITE = EnumHelper.addToolMaterial("BENITOITE", 3, 3500, 5.0F, 3.0F, 10);
    public static Item.ToolMaterial TOOL_CHALCEDONY = EnumHelper.addToolMaterial("CHALCEDONY", 4, 4000, 6.0F, 4.0F, 10);
    public static Item.ToolMaterial TOOL_MALACHITE = EnumHelper.addToolMaterial("MALACHITE", 3, 5120, 8.0F, 4.0F, 10);
    public static Item.ToolMaterial TOOL_TIGER_EYE = EnumHelper.addToolMaterial("TIGER_EYE", 3, 4096, 8.0F, 5.0F, 10);
    public static Item.ToolMaterial TOOL_SPINEL = EnumHelper.addToolMaterial("SPINEL", 3, 5120, 8.0F, 4.0F, 15);
    public static Item.ToolMaterial TOOL_ZIRCON = EnumHelper.addToolMaterial("ZIRCON", 3, 6144, 8.0F, 5.0F, 15);
    public static Item.ToolMaterial TOOL_CORRUPT = EnumHelper.addToolMaterial("CORRUPT", 4, -1, 10.0F, 21.0F, 25);
    public static Item.ToolMaterial TOOL_BIXBITE = EnumHelper.addToolMaterial("BIXBITE", 3,8192, 8.0F, 1.5F, 20);
    public static Item.ToolMaterial TOOL_TSVAROVITE = EnumHelper.addToolMaterial("TSVAROVITE", 3, 9216, 8.0F, 1.0F, 20);
    public static Item.ToolMaterial TOOL_LARVIKITE = EnumHelper.addToolMaterial("LARVIKITE", 3, 10240, 8.0F, 5.0F, 20);
    public static Item.ToolMaterial TOOL_GAIA_CHAMP = EnumHelper.addToolMaterial("GAIA_CHAMP", 4, -1, 10.0F, 16.0F, 25);


    public static final Item crystallized_redstone = null;
    public static final Item crystallized_lapis_lazuli = null;
    public static final Item glint_and_gold = null;
    public static final Item agate_stick = null;
    public static final Item hot_dust = null;
    public static final Item goldstone_dust = null;
    public static final Item fine_dust = null;
    public static final Item cloudy_shard = null;
    public static final Item goldstone_residue = null;
    public static final Item agate_cup = null;
    public static final Item scaynyx_ingot = null;
    public static final Item sweet_muckball = null;
    public static final Item sugar_crystals = null;
    public static final Item sugar_cluster = null;
    public static final Item shiny_bone = null;
    public static final Item fine_thread = null;
    public static final Item twined_thread = null;

    public static final Item pink_geode = null;
    public static final Item blue_geode = null;
    public static final Item green_geode = null;
    public static final Item purple_geode = null;
    public static final Item pink_geode_slice = null;
    public static final Item blue_geode_slice = null;
    public static final Item green_geode_slice = null;
    public static final Item purple_geode_slice = null;
    public static final Item pink_geode_juice = null;
    public static final Item blue_geode_tea = null;
    public static final Item green_geode_ale = null;
    public static final Item purple_geode_soda = null;
    public static final Item pearly_geode_elixir = null;
    public static final Item lurmorus_meat = null;
    public static final Item lurmorus_steak = null;
    public static final Item small_tentacle = null;
    public static final Item small_calamari = null;
    public static final Item large_tentacle = null;
    public static final Item large_calamari = null;
    public static final Item markuzar_mint = null;
    public static final Item luggeroth_chop = null;
    public static final Item cooked_luggeroth_chop = null;

    public static final Item hematite_powder = null;
    public static final Item pyrite_powder = null;
    public static final Item labradorite_powder = null;
    public static final Item moonstone_powder = null;
    public static final Item cinnabar_powder = null;
    public static final Item red_opal_powder = null;
    public static final Item blue_opal_powder = null;
    public static final Item green_opal_powder = null;
    public static final Item white_opal_grit = null;

    public static final Item sugilite = null;
    public static final Item hematite = null;
    public static final Item pyrite = null;
    public static final Item labradorite = null;
    public static final Item moonstone = null;
    public static final Item cinnabar = null;
    public static final Item red_opal = null;
    public static final Item blue_opal = null;
    public static final Item green_opal = null;
    public static final Item white_opal = null;
    public static final Item ixiolite = null;
    public static final Item proustite = null;
    public static final Item euclase = null;
    public static final Item leucite = null;
    public static final Item carnelian = null;
    public static final Item benitoite = null;
    public static final Item diopside = null;
    public static final Item chalcedony = null;
    public static final Item black_residue = null;
    public static final Item tektite = null;
    public static final Item goldstone = null;

    public static final Item sugilite_helmet = null;
    public static final Item sugilite_chestplate = null;
    public static final Item sugilite_legs = null;
    public static final Item sugilite_boots = null;
    public static final Item proustite_helmet = null;
    public static final Item proustite_chestplate = null;
    public static final Item proustite_legs = null;
    public static final Item proustite_boots = null;
    public static final Item leucite_helmet = null;
    public static final Item leucite_chestplate = null;
    public static final Item leucite_legs = null;
    public static final Item leucite_boots = null;
    public static final Item carnelian_helmet = null;
    public static final Item carnelian_chestplate = null;
    public static final Item carnelian_legs = null;
    public static final Item carnelian_boots = null;
    public static final Item diopside_helmet = null;
    public static final Item diopside_chestplate = null;
    public static final Item diopside_legs = null;
    public static final Item diopside_boots = null;
    public static final Item chalcedony_helmet = null;
    public static final Item chalcedony_chestplate = null;
    public static final Item chalcedony_legs = null;
    public static final Item chalcedony_boots = null;

    public static final Item malachite_guard_headgear = null;
    public static final Item malachite_guard_brace = null;
    public static final Item malachite_guard_gear = null;
    public static final Item malachite_guard_boots = null;
    public static final Item apex_predator_hood = null;
    public static final Item apex_predator_jacket = null;
    public static final Item apex_predator_trousers = null;
    public static final Item apex_predator_boots = null;
    public static final Item spinel_princess_cowl = null;
    public static final Item spinel_princess_cloak = null;
    public static final Item spinel_princess_dress = null;
    public static final Item spinel_princess_heels = null;
    public static final Item zircon_prince_crown = null;
    public static final Item zircon_prince_chestpiece = null;
    public static final Item zircon_prince_gear = null;
    public static final Item zircon_prince_boots = null;
    public static final Item corrupt_warrior_helm = null;
    public static final Item corrupt_warrior_guard = null;
    public static final Item corrupt_warrior_greaves = null;
    public static final Item corrupt_warrior_boots = null;
    public static final Item gaia_duchess_helm = null;
    public static final Item gaia_duchess_guard = null;
    public static final Item gaia_duchess_greaves = null;
    public static final Item gaia_duchess_boots = null;
    public static final Item gaia_baron_mask = null;
    public static final Item gaia_baron_tuxedo = null;
    public static final Item gaia_baron_pants = null;
    public static final Item gaia_baron_shoes = null;
    public static final Item gaia_duke_helm = null;
    public static final Item gaia_duke_guard = null;
    public static final Item gaia_duke_greaves = null;
    public static final Item gaia_duke_boots = null;
    public static final Item gaia_champion_helm = null;
    public static final Item gaia_champion_guard = null;
    public static final Item gaia_champion_greaves = null;
    public static final Item gaia_champion_boots = null;

    public static final Item agate_sword = null;
    public static final Item agate_pickaxe = null;
    public static final Item agate_axe = null;
    public static final Item agate_shovel = null;
    public static final Item sugilite_sword = null;
    public static final Item sugilite_pickaxe = null;
    public static final Item sugilite_axe = null;
    public static final Item sugilite_shovel = null;
    public static final Item ixiolite_sword = null;
    public static final Item ixiolite_pickaxe = null;
    public static final Item ixiolite_axe = null;
    public static final Item ixiolite_shovel = null;
    public static final Item euclase_sword = null;
    public static final Item euclase_pickaxe = null;
    public static final Item euclase_axe = null;
    public static final Item euclase_shovel = null;
    public static final Item carnelian_sword = null;
    public static final Item carnelian_pickaxe = null;
    public static final Item carnelian_axe = null;
    public static final Item carnelian_shovel = null;
    public static final Item benitoite_sword = null;
    public static final Item benitoite_pickaxe = null;
    public static final Item benitoite_axe = null;
    public static final Item benitoite_shovel = null;
    public static final Item chalcedony_sword = null;
    public static final Item chalcedony_pickaxe = null;
    public static final Item chalcedony_axe = null;
    public static final Item chalcedony_shovel = null;
    public static final Item old_bow = null;

    public static final Item malachite_guard_baton = null;
    public static final Item apex_predator_mace = null;
    public static final Item spinel_princess_flamberge = null;
    public static final Item zircon_prince_razor = null;
    public static final Item corrupt_warrior_sword = null;
    public static final Item gaia_duchess_khopesh = null;
    public static final Item gaia_baron_dagger = null;
    public static final Item gaia_duke_blade = null;
    public static final Item gaia_champion_sword = null;

    public static ItemStack mineral_water_bucket_item;
    public static ItemStack superhot_magma_bucket_item;
    public static ItemStack sweet_muck_bucket_item;
}
