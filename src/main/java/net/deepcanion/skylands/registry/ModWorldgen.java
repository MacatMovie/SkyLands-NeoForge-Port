package net.deepcanion.skylands.registry;

import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.worldgen.IslandTemplateFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModWorldgen {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, SkyLands.MOD_ID);
    public static final DeferredHolder<Feature<?>, IslandTemplateFeature> STRUCTURE_FEATURE = FEATURES.register("structure_feature", IslandTemplateFeature::new);
    private ModWorldgen() { }
}
