package net.deepcanion.skylands.worldgen;

import java.util.Optional;
import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public final class SkyTreeGrowers {
    public static final TreeGrower FIERY = grower("flying_islands_tree");
    public static final TreeGrower GLACIATED = grower("glaciated_floating_islands_tree");
    public static final TreeGrower LAVIC = grower("lavic_sapling_tree");
    private static TreeGrower grower(String id) {
        ResourceKey<ConfiguredFeature<?, ?>> feature = ResourceKey.create(Registries.CONFIGURED_FEATURE, SkyLands.id(id));
        return new TreeGrower(SkyLands.MOD_ID + ":" + id, Optional.empty(), Optional.of(feature), Optional.empty());
    }
    private SkyTreeGrowers() { }
}
