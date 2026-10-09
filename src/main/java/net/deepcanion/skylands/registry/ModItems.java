package net.deepcanion.skylands.registry;

import java.util.List;
import java.util.ArrayList;
import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.deepcanion.skylands.item.MaterialItem;
import net.deepcanion.skylands.item.GliderItem;
import net.deepcanion.skylands.item.SkyArmorTrimTemplateItem;
import net.deepcanion.skylands.item.SkyToolTier;
import net.deepcanion.skylands.item.SkySwordItem;
import net.deepcanion.skylands.item.SkyInfusedSwordItem;
import net.deepcanion.skylands.item.IgneusWarAxeItem;
import net.deepcanion.skylands.item.AutomatonSwordItem;
import net.deepcanion.skylands.item.IceBowItem;
import net.deepcanion.skylands.item.SkyThrowableItem;
import net.deepcanion.skylands.item.IgneusLaserBladeItem;
import net.deepcanion.skylands.entity.*;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.minecraft.world.item.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.core.component.DataComponents;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SkyLands.MOD_ID);
    public static final List<DeferredItem<BlockItem>> BLOCK_ITEMS = registerBlockItems();

    public static final DeferredItem<AutomatonSwordItem> AUTOMATON_SWORD = ITEMS.register("automaton_sword", AutomatonSwordItem::new);
    public static final DeferredItem<DeferredSpawnEggItem> SKY_AUTOMATON_SPAWN_EGG = ITEMS.register("sky_automaton_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SKY_AUTOMATON, -9543603, -13369447, new Item.Properties()));
    public static final DeferredItem<DeferredSpawnEggItem> ARID_SKY_AUTOMATON_SPAWN_EGG = ITEMS.register("arid_sky_automaton_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.ARID_SKY_AUTOMATON, -3817044, -16316665, new Item.Properties()));
    public static final DeferredItem<DeferredSpawnEggItem> LAVIC_SKY_AUTOMATON_SPAWN_EGG = ITEMS.register("lavic_sky_automaton_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.LAVIC_SKY_AUTOMATON, -13434880, -13108, new Item.Properties()));

    public static final DeferredItem<Item> BROCKEN_SKY_AUTOMATON_SWORD = ITEMS.register("brocken_sky_automaton_sword", () -> new MaterialItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), "", false));
    public static final DeferredItem<Item> CELESTIUM = ITEMS.register("celestium", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> GOLDENLEVEL_1_KEY = ITEMS.register("goldenlevel_1_key", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> AUTOMATON_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("automaton_armor_trim_smithing_template", () -> new SkyArmorTrimTemplateItem("automaton"));
    public static final DeferredItem<Item> GOLDEN_LEVEL_2_KEY = ITEMS.register("golden_level_2_key", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> AMBER_CELESTIUM = ITEMS.register("amber_celestium", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> DRAGON_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("dragon_armor_trim_smithing_template", () -> new SkyArmorTrimTemplateItem("dragon"));
    public static final DeferredItem<Item> HEADSET_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("headset_armor_trim_smithing_template", () -> new SkyArmorTrimTemplateItem("headset"));
    public static final DeferredItem<Item> DIAMOND_LEVEL_1_KEY = ITEMS.register("diamond_level_1_key", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> DIAMOND_LEVEL_2KEY = ITEMS.register("diamond_level_2key", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> PALE_CELESTIUM = ITEMS.register("pale_celestium", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> ALPHA_GLIDER_DESIGN = ITEMS.register("alpha_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.alpha_glider_design.tooltip", false));
    public static final DeferredItem<Item> ISLAND_GLIDER_DESIGN = ITEMS.register("island_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.island_glider_design.tooltip", false));
    public static final DeferredItem<Item> CREEPER_GLIDER_DESIGN = ITEMS.register("creeper_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.creeper_glider_design.tooltip", false));
    public static final DeferredItem<Item> LOGO_GLIDER_DESIGN = ITEMS.register("logo_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.logo_glider_design.tooltip", false));
    public static final DeferredItem<Item> CRAFTING_GLIDER_DESIGN = ITEMS.register("crafting_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.crafting_glider_design.tooltip", false));
    public static final DeferredItem<Item> DARK_GLIDER_DESIGN = ITEMS.register("dark_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.dark_glider_design.tooltip", false));
    public static final DeferredItem<Item> CLOUD_GLIDER_DESIGN = ITEMS.register("cloud_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.cloud_glider_design.tooltip", false));
    public static final DeferredItem<Item> COLD_GLIDER_DESIGN = ITEMS.register("cold_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.cold_glider_design.tooltip", false));
    public static final DeferredItem<Item> GLACIATED_GLIDER_DESIGN = ITEMS.register("glaciated_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.glaciated_glider_design.tooltip", false));
    public static final DeferredItem<Item> MOJANG_GLIDER_DESIGN = ITEMS.register("mojang_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.mojang_glider_design.tooltip", false));
    public static final DeferredItem<Item> LAVIC_LEVEL_1_KEY = ITEMS.register("lavic_level_1_key", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> LAVIC_LEVEL_2_KEY = ITEMS.register("lavic_level_2_key", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> FERRET_GLIDER_DESIGN = ITEMS.register("ferret_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.ferret_glider_design.tooltip", false));
    public static final DeferredItem<Item> RUSTED_GLIDER_DESIGN = ITEMS.register("rusted_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.rusted_glider_design.tooltip", false));
    public static final DeferredItem<Item> LAVIC_GLIDER_DESIGN = ITEMS.register("lavic_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.lavic_glider_design.tooltip", false));
    public static final DeferredItem<Item> LIGHTLY_WEATHERED_CUT_COPPER_STAIRS_GLIDER_DESIGN = ITEMS.register("lightly_weathered_cut_copper_stairs_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.lightly_weathered_cut_copper_stairs_glider_design.tooltip", false));
    public static final DeferredItem<Item> RIPTIDE_GLIDER_DESIGN = ITEMS.register("riptide_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.riptide_glider_design.tooltip", false));
    public static final DeferredItem<Item> NIGHT_GLIDER_DESIGN = ITEMS.register("night_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.night_glider_design.tooltip", false));
    public static final DeferredItem<Item> DAY_GLIDER_DESIGN = ITEMS.register("day_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.day_glider_design.tooltip", false));
    public static final DeferredItem<Item> GEOMETRY_GLIDER_DESIGN = ITEMS.register("geometry_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.geometry_glider_design.tooltip", false));
    public static final DeferredItem<Item> MECHANIC_GLIDER_DESIGN = ITEMS.register("mechanic_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.mechanic_glider_design.tooltip", false));
    public static final DeferredItem<Item> EYE_GLIDER_DESIGN = ITEMS.register("eye_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.eye_glider_design.tooltip", false));
    public static final DeferredItem<Item> CHAIN_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("chain_armor_trim_smithing_template", () -> new SkyArmorTrimTemplateItem("chain"));
    public static final DeferredItem<Item> RUNE_GLIDER_DESIGN = ITEMS.register("rune_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.rune_glider_design.tooltip", false));
    public static final DeferredItem<Item> RAW_TUC_TUC_WING = ITEMS.register("raw_tuc_tuc_wing", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.2f).build()), "", false));
    public static final DeferredItem<Item> COOKED_TUC_TUC_WING = ITEMS.register("cooked_tuc_tuc_wing", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(7).saturationModifier(0.6f).build()), "", false));
    public static final DeferredItem<Item> ISLANDS_GLIDER_DESIGN = ITEMS.register("islands_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.islands_glider_design.tooltip", false));
    public static final DeferredItem<Item> INKY_CELESTIUM = ITEMS.register("inky_celestium", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> ARID_LEVEL_1_KEY = ITEMS.register("arid_level_1_key", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> ARID_LEVEL_2_KEY = ITEMS.register("arid_level_2_key", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), "", false));
    public static final DeferredItem<Item> FURNACE_GLIDER_DESIGN = ITEMS.register("furnace_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.furnace_glider_design.tooltip", false));
    public static final DeferredItem<Item> ARID_GLIDER_DESIGN = ITEMS.register("arid_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.arid_glider_design.tooltip", false));
    public static final DeferredItem<Item> PYRAMID_GLIDER_DESIGN = ITEMS.register("pyramid_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.pyramid_glider_design.tooltip", false));
    public static final DeferredItem<Item> NAISSANCEE_GLIDER_DESIGN = ITEMS.register("naissancee_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.naissancee_glider_design.tooltip", false));
    public static final DeferredItem<Item> CYCLOPS_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("cyclops_armor_trim_smithing_template", () -> new SkyArmorTrimTemplateItem("cyclops"));
    public static final DeferredItem<Item> COPPER_GLIDER_DESIGN = ITEMS.register("copper_glider_design", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "item.flying_stuff.copper_glider_design.tooltip", false));
    public static final DeferredItem<Item> CELESTIUM_CORE = ITEMS.register("celestium_core", () -> new MaterialItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true), "item.flying_stuff.celestium_core.tooltip", false));
    public static final DeferredItem<Item> AMBER_CELESTIUM_CORE = ITEMS.register("amber_celestium_core", () -> new MaterialItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true), "item.flying_stuff.amber_celestium_core.tooltip", false));
    public static final DeferredItem<Item> PALE_CELESTIUM_CORE = ITEMS.register("pale_celestium_core", () -> new MaterialItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true), "item.flying_stuff.pale_celestium_core.tooltip", false));
    public static final DeferredItem<Item> INKY_CELESTIUM_CORE = ITEMS.register("inky_celestium_core", () -> new MaterialItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true), "item.flying_stuff.inky_celestium_core.tooltip", false));
    public static final DeferredItem<Item> MASTER_KEY = ITEMS.register("master_key", () -> new MaterialItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true), "item.flying_stuff.master_key.tooltip", false));
    public static final DeferredItem<Item> SMITHING_TEMPLATE_UPGRADE_OF_THE_SKY = ITEMS.register("smithing_template_upgrade_of_the_sky", () -> new MaterialItem(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC), "item.flying_stuff.smithing_template_upgrade_of_the_sky.tooltip", true));
    public static final DeferredItem<Item> CELESTINE_CRYSTAL = ITEMS.register("celestine_crystal", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON), "", false));
    public static final DeferredItem<Item> INGOT_OF_THE_SKY = ITEMS.register("ingot_of_the_sky", () -> new MaterialItem(new Item.Properties().stacksTo(64).rarity(Rarity.RARE), "", false));
    public static final DeferredItem<Item> ARACNID_ARMOR_TRIM_SMITHING_TEMPLATE = ITEMS.register("aracnid_armor_trim_smithing_template", () -> new SkyArmorTrimTemplateItem("aracnid"));

    public static final DeferredItem<SkySwordItem> SWORD_OF_THE_SKY = ITEMS.register("sword_of_the_sky", SkySwordItem::new);
    public static final DeferredItem<PickaxeItem> PICKAXE_OF_THE_SKY = ITEMS.register("pickaxe_of_the_sky", () -> new PickaxeItem(SkyToolTier.TOOL, new Item.Properties().fireResistant().attributes(DiggerItem.createAttributes(SkyToolTier.TOOL, 1, -3F))));
    public static final DeferredItem<AxeItem> AXE_OF_THE_SKY = ITEMS.register("axe_of_the_sky", () -> new AxeItem(SkyToolTier.TOOL, new Item.Properties().fireResistant().attributes(DiggerItem.createAttributes(SkyToolTier.TOOL, 1, -3F))));
    public static final DeferredItem<ShovelItem> SHOVEL_OF_THE_SKY = ITEMS.register("shovel_of_the_sky", () -> new ShovelItem(SkyToolTier.TOOL, new Item.Properties().fireResistant().attributes(DiggerItem.createAttributes(SkyToolTier.TOOL, 1, -3F))));
    public static final DeferredItem<SkyInfusedSwordItem> VERDANT_SWORD_OF_THE_SKY = ITEMS.register("verdant_sword_of_the_sky", () -> new SkyInfusedSwordItem(SkyInfusedSwordItem.Infusion.VERDANT));
    public static final DeferredItem<SkyInfusedSwordItem> PEARLECENT_SWORD_OF_THE_SKY = ITEMS.register("pearlecent_sword_of_the_sky", () -> new SkyInfusedSwordItem(SkyInfusedSwordItem.Infusion.PEARLECENT));
    public static final DeferredItem<SkyInfusedSwordItem> INKY_SWORD_OF_THE_SKY = ITEMS.register("inky_sword_of_the_sky", () -> new SkyInfusedSwordItem(SkyInfusedSwordItem.Infusion.INKY));
    public static final DeferredItem<SkyInfusedSwordItem> PALE_SWORD_OF_THE_SKY = ITEMS.register("pale_sword_of_the_sky", () -> new SkyInfusedSwordItem(SkyInfusedSwordItem.Infusion.PALE));
    public static final DeferredItem<IgneusWarAxeItem> IGNEUS_WAR_AXE = ITEMS.register("igneus_war_axe", IgneusWarAxeItem::new);


    // Native 1.21.1 song components replace the removed RecordItem class.
    public static final DeferredItem<Item> COLD_DESERT_MUSIC_DISC = ITEMS.register("cold_desert_music_disc", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, SkyLands.id("cold_desert_music_disc")))));
    public static final DeferredItem<Item> FACTORY_MUSIC_DISK = ITEMS.register("factory_music_disk", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, SkyLands.id("factory_music_disk")))));
    public static final DeferredItem<Item> SKY_RIVER_MUSIC_DISK = ITEMS.register("sky_river_music_disk", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, SkyLands.id("sky_river_music_disk")))));
    public static final DeferredItem<Item> SKY_WATERFALL_MUSIC_DISC = ITEMS.register("sky_waterfall_music_disc", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, SkyLands.id("sky_waterfall_music_disc")))));
    public static final DeferredItem<Item> SPIKE_MUSIC_DISK = ITEMS.register("spike_music_disk", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, SkyLands.id("spike_music_disk")))));
    public static final DeferredItem<Item> TEARS_OF_MOOGCITY = ITEMS.register("tears_of_moogcity", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, SkyLands.id("tears_of_moogcity")))));
    public static final DeferredItem<Item> UNDERGROUND_MUSIC_DISK = ITEMS.register("underground_music_disk", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, SkyLands.id("underground_music_disk")))));

    public static final DeferredItem<net.deepcanion.skylands.item.WarmthFoodItem> WARMTH_RADISH = ITEMS.register("warmth_radish", () -> new net.deepcanion.skylands.item.WarmthFoodItem(false));
    public static final DeferredItem<net.deepcanion.skylands.item.WarmthFoodItem> WARMTH_POTION = ITEMS.register("warmth_potion", () -> new net.deepcanion.skylands.item.WarmthFoodItem(true));

    public static final DeferredItem<net.minecraft.world.item.BucketItem> MOLTEN_METAL_BUCKET = ITEMS.register("molten_metal_bucket", () -> new net.minecraft.world.item.BucketItem(ModFluids.MOLTEN_METAL.get(), new Item.Properties().craftRemainder(net.minecraft.world.item.Items.BUCKET).stacksTo(1)));

    public static final DeferredItem<net.deepcanion.skylands.item.StarterGuideItem> STARTER_GUIDE = ITEMS.register("sky_lands_starter_guide", net.deepcanion.skylands.item.StarterGuideItem::new);
    public static final DeferredItem<GliderItem> GLIDER = ITEMS.register("glider", GliderItem::new);

    private static List<DeferredItem<BlockItem>> registerBlockItems() {
        List<DeferredItem<BlockItem>> items = new ArrayList<>();
        ModBlocks.BLOCKS.getEntries().forEach(block -> {
            // Double plants must place both halves, just like vanilla tall plants.
            String id = block.getId().getPath();
            if (id.equals("temporary_fire") || id.equals("molten_metal")) return;
            items.add(ITEMS.<BlockItem>register(id, () -> block.get() instanceof net.minecraft.world.level.block.DoublePlantBlock
                    ? new DoubleHighBlockItem(block.get(), new Item.Properties())
                    : new BlockItem(block.get(), new Item.Properties())));
        });
        return List.copyOf(items);
    }

    public static final DeferredItem<DeferredSpawnEggItem> SKY_AUTOMATON_BOSS_SPAWN_EGG = ITEMS.register("sky_automaton_boss_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SKY_AUTOMATON_BOSS, -8817840, -537560, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> AUTOMATON_DRONE_SPAWN_EGG = ITEMS.register("automaton_drone_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.AUTOMATON_DRONE, -8357532, -16737946, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> GLACIATED_SKY_AUTOMATON_SPAWN_EGG = ITEMS.register("glaciated_sky_automaton_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GLACIATED_SKY_AUTOMATON, -6710887, -10092289, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> GLACIATED_DRAGON_SPAWN_EGG = ITEMS.register("glaciated_dragon_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.GLACIATED_DRAGON, -10092340, -13312, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> SKY_AUTOMATON_BRUTE_SPAWN_EGG = ITEMS.register("sky_automaton_brute_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SKY_AUTOMATON_BRUTE, -11910350, -8400836, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> ICE_BLOB_SPAWN_EGG = ITEMS.register("ice_blob_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.ICE_BLOB, -10040065, -6723841, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> MAGMA_SLOBERT_SPAWN_EGG = ITEMS.register("magma_slobert_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.MAGMA_SLOBERT, -52429, -13108, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> IGNEO_ROBO_FELINE_SPAWN_EGG = ITEMS.register("igneo_robo_feline_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.IGNEO_ROBO_FELINE, -9361111, -1455070, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> SKY_BIRD_SPAWN_EGG = ITEMS.register("sky_bird_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SKY_BIRD, -1977174, -4816600, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> SKY_PHARAOH_SPAWN_EGG = ITEMS.register("sky_pharaoh_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.SKY_PHARAOH, -3296696, -11313211, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> FRIENDLY_VEX_SPAWN_EGG = ITEMS.register("friendly_vex_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.FRIENDLY_VEX, -5730707, -2972316, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> HAPPY_SLOBERT_SPAWN_EGG = ITEMS.register("happy_slobert_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.HAPPY_SLOBERT, -16737946, -6507352, new Item.Properties()));

    public static final DeferredItem<DeferredSpawnEggItem> ARTIFICIAL_ARACNID_SPAWN_EGG = ITEMS.register("artificial_aracnid_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.ARTIFICIAL_ARACNID, -14606048, -1250068, new Item.Properties()));

    public static final DeferredItem<IceBowItem> ICE_BOW = ITEMS.register("ice_bow", IceBowItem::new);
    public static final DeferredItem<IgneusLaserBladeItem> IGNEUS_LASER_BLADE = ITEMS.register("igneus_laser_blade", IgneusLaserBladeItem::new);
    public static final DeferredItem<SkyThrowableItem> SMOKE_FLOWER = ITEMS.register("smoke_flower", () -> new SkyThrowableItem(new Item.Properties().rarity(Rarity.UNCOMMON), 60, (world, user) -> SmokeFlowerProjEntity.shoot(world, user, world.getRandom())));
    public static final DeferredItem<SkyThrowableItem> FLOAT_GRAPE = ITEMS.register("float_grape", () -> new SkyThrowableItem(new Item.Properties(), 50, (world, user) -> FloatGrapeProjEntity.shoot(world, user, world.getRandom())));
    public static final DeferredItem<SkyThrowableItem> EYE_OF_THE_SKY = ITEMS.register("eye_of_the_sky", () -> new SkyThrowableItem(new Item.Properties().fireResistant().rarity(Rarity.RARE), 20, (world, user) -> EyeOftsProjectileEntity.shoot(world, user, world.getRandom())));

    public static final DeferredItem<net.deepcanion.skylands.item.IceStaffItem> ICE_STAFF = ITEMS.register("ice_staff", net.deepcanion.skylands.item.IceStaffItem::new);
    public static final DeferredItem<net.deepcanion.skylands.item.PharaohStaffItem> PHARAOH_STAFF = ITEMS.register("pharaoh_staff", net.deepcanion.skylands.item.PharaohStaffItem::new);

    private ModItems() { }
}
