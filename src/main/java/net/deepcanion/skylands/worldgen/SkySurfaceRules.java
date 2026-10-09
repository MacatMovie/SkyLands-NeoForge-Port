package net.deepcanion.skylands.worldgen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public final class SkySurfaceRules {
    public static SurfaceRules.RuleSource create() {
        return SurfaceRules.sequence(
                surface(SkyBiomes.GOLDEN, Blocks.TUFF, Blocks.TUFF, Blocks.STONE),
                surface(SkyBiomes.GLACIATED, Blocks.DIORITE, Blocks.DIORITE, Blocks.DIORITE),
                surface(SkyBiomes.LAVIC, Blocks.MUD, Blocks.BLACKSTONE, Blocks.BLACKSTONE),
                surface(SkyBiomes.ARID, Blocks.SAND, Blocks.SANDSTONE, Blocks.SAND),
                surface(SkyBiomes.CHERRY, Blocks.TUFF, Blocks.TUFF, Blocks.TUFF),
                surface(SkyBiomes.SWAMP, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.DIRT));
    }
    private static SurfaceRules.RuleSource surface(ResourceKey<Biome> biome, Block top, Block under, Block underwater) {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(biome), SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),
                                        SurfaceRules.state(top.defaultBlockState())), SurfaceRules.state(underwater.defaultBlockState()))),
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(under.defaultBlockState())))));
    }
    private SkySurfaceRules() { }
}
