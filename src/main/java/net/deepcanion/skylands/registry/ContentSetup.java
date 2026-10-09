package net.deepcanion.skylands.registry;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

/** One common-thread setup pass replaces per-block generated fire overrides. */
public final class ContentSetup {
    public static void registerFireBehavior() {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(ModBlocks.FIERY_LEAVES.get(), 30, 60);
        fire.setFlammable(ModBlocks.GLACIATED_LEAVES.get(), 30, 60);
        fire.setFlammable(ModBlocks.SWAMPY_BUSH.get(), 60, 50);
        fire.setFlammable(ModBlocks.FIERY_GRASS.get(), 60, 100);
        fire.setFlammable(ModBlocks.FIERY_SHORT_GRASS.get(), 60, 100);
        fire.setFlammable(ModBlocks.SHORT_GLACIATED_GRASS.get(), 60, 50);
        fire.setFlammable(ModBlocks.TALL_GLACIATED_GRASS.get(), 60, 50);
        fire.setFlammable(ModBlocks.BLOW_FLOWER.get(), 60, 100);
        fire.setFlammable(ModBlocks.SMOKE_FLOWER_PLANT_GROW_STAGE.get(), 60, 100);
        fire.setFlammable(ModBlocks.SHORT_LAVIC_GRASS.get(), 60, 100);
        fire.setFlammable(ModBlocks.METALLIC_SHORTER_GRASS.get(), 60, 100);
        fire.setFlammable(ModBlocks.ARID_GRASS.get(), 60, 100);
        fire.setFlammable(ModBlocks.SMALL_ARID_BUSH.get(), 60, 100);
        fire.setFlammable(ModBlocks.SMALL_SKY_CACTUS.get(), 60, 100);
        fire.setFlammable(ModBlocks.ABYSS_GRASS.get(), 60, 100);
        fire.setFlammable(ModBlocks.GOLDEN_FERN.get(), 60, 100);
        fire.setFlammable(ModBlocks.LAVIC_MUSHROOMS.get(), 60, 100);
        fire.setFlammable(ModBlocks.GLACIATED_FERN.get(), 60, 50);
        fire.setFlammable(ModBlocks.CHERRY_GRASS.get(), 60, 100);
        fire.setFlammable(ModBlocks.CHERRY_SHORT_GRASS.get(), 60, 100);
        fire.setFlammable(ModBlocks.SWAMPY_GRASS.get(), 60, 50);
        fire.setFlammable(ModBlocks.METALLIC_SILK_BLOCK.get(), 2, 5);
        fire.setFlammable(ModBlocks.SHORT_ABYSS_GRASS.get(), 60, 100);
    }
    private ContentSetup() { }
}
