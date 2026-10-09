package net.deepcanion.skylands.worldgen;

import java.util.function.Consumer;
import com.mojang.datafixers.util.Pair;
import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.*;
import terrablender.api.Region;
import terrablender.api.RegionType;

/** One low-weight Overworld region, preserving the original biome replacement map. */
public final class SkyLandsRegion extends Region {
    public SkyLandsRegion() { super(SkyLands.id("overworld"), RegionType.OVERWORLD, 1); }
    @Override public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(Biomes.PLAINS, SkyBiomes.GOLDEN);
            builder.replaceBiome(Biomes.FOREST, SkyBiomes.GOLDEN);
            builder.replaceBiome(Biomes.BIRCH_FOREST, SkyBiomes.GOLDEN);
            builder.replaceBiome(Biomes.SNOWY_PLAINS, SkyBiomes.GLACIATED);
            builder.replaceBiome(Biomes.GROVE, SkyBiomes.GLACIATED);
            builder.replaceBiome(Biomes.ERODED_BADLANDS, SkyBiomes.LAVIC);
            builder.replaceBiome(Biomes.SAVANNA_PLATEAU, SkyBiomes.LAVIC);
            builder.replaceBiome(Biomes.DESERT, SkyBiomes.ARID);
            builder.replaceBiome(Biomes.JUNGLE, SkyBiomes.ARID);
            builder.replaceBiome(Biomes.CHERRY_GROVE, SkyBiomes.CHERRY);
            builder.replaceBiome(Biomes.MEADOW, SkyBiomes.CHERRY);
            builder.replaceBiome(Biomes.SWAMP, SkyBiomes.SWAMP);
            builder.replaceBiome(Biomes.MANGROVE_SWAMP, SkyBiomes.SWAMP);
        });
    }
}
