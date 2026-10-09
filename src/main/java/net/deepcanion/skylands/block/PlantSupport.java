package net.deepcanion.skylands.block;

import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

final class PlantSupport {
    static final TagKey<Block> SOILS = TagKey.create(Registries.BLOCK, SkyLands.id("plant_support"));
    private PlantSupport() { }
}
