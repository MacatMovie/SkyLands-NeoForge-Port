package net.deepcanion.skylands.worldgen;

import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public final class SkyBiomes {
    public static final ResourceKey<Biome> GOLDEN = key("flying_islands");
    public static final ResourceKey<Biome> GLACIATED = key("glaciated_floating_islands");
    public static final ResourceKey<Biome> LAVIC = key("lavic_floating_islands");
    public static final ResourceKey<Biome> ARID = key("arid_floating_islands");
    public static final ResourceKey<Biome> CHERRY = key("floating_cherry_grove");
    public static final ResourceKey<Biome> SWAMP = key("floating_swamp");
    private static ResourceKey<Biome> key(String id) { return ResourceKey.create(Registries.BIOME, SkyLands.id(id)); }
    private SkyBiomes() { }
}
