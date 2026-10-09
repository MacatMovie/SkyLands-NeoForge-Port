package net.custom.flyingstuff.world;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;




import java.util.List;
import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class GoldenRegion extends Region
{
    public GoldenRegion(ResourceLocation name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {

            builder.replaceBiome(Biomes.PLAINS,ResourceKey.create(Registries.BIOME,  new ResourceLocation("flying_stuff", "flying_islands")));
            builder.replaceBiome(Biomes.FOREST,ResourceKey.create(Registries.BIOME,  new ResourceLocation("flying_stuff", "flying_islands")));
            builder.replaceBiome(Biomes.BIRCH_FOREST, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "flying_islands")));

            builder.replaceBiome(Biomes.SNOWY_PLAINS, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "glaciated_floating_islands")));
            builder.replaceBiome(Biomes.GROVE, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "glaciated_floating_islands")));
            
            builder.replaceBiome(Biomes.ERODED_BADLANDS, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "lavic_floating_islands")));
            builder.replaceBiome(Biomes.SAVANNA_PLATEAU, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "lavic_floating_islands")));

			builder.replaceBiome(Biomes.DESERT, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "arid_floating_islands")));
            builder.replaceBiome(Biomes.JUNGLE, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "arid_floating_islands")));

            builder.replaceBiome(Biomes.CHERRY_GROVE, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "floating_cherry_grove")));
            builder.replaceBiome(Biomes.MEADOW, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "floating_cherry_grove")));

			builder.replaceBiome(Biomes.SWAMP, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "floating_swamp")));
   			builder.replaceBiome(Biomes.MANGROVE_SWAMP, ResourceKey.create(Registries.BIOME, new ResourceLocation("flying_stuff", "floating_swamp")));         
        });
    }
}