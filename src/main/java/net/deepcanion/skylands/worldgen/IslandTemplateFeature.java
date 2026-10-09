package net.deepcanion.skylands.worldgen;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

/** Data-driven island placement with explicit world-height and writable-region guards. */
public final class IslandTemplateFeature extends Feature<TemplateFeatureConfiguration> {
    public IslandTemplateFeature() { super(TemplateFeatureConfiguration.CODEC); }
    @Override public boolean place(FeaturePlaceContext<TemplateFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        TemplateFeatureConfiguration config = context.config();
        RandomSource random = context.random();
        Optional<StructureTemplate> loaded = level.getLevel().getServer().getStructureManager().get(config.structure());
        if (loaded.isEmpty()) return false;
        StructureTemplate template = loaded.get();
        if (template.getSize().getX() == 0 || template.getSize().getY() == 0 || template.getSize().getZ() == 0) return false;
        Rotation rotation = config.randomRotation() ? Rotation.getRandom(random) : Rotation.NONE;
        Mirror mirror = config.randomMirror() ? Mirror.values()[random.nextInt(Mirror.values().length)] : Mirror.NONE;
        StructurePlaceSettings settings = new StructurePlaceSettings().setRotation(rotation).setMirror(mirror)
                .setRandom(random).setIgnoreEntities(true)
                .addProcessor(new BlockIgnoreProcessor(config.ignoredBlocks().stream().map(Holder::value).toList()))
                .addProcessor(JigsawReplacementProcessor.INSTANCE);
        BlockPos origin = context.origin().offset(config.offset());
        BoundingBox bounds = template.getBoundingBox(settings, origin);
        BlockPos placement = origin.offset(origin.getX() - (bounds.minX() + bounds.maxX()) / 2,
                0, origin.getZ() - (bounds.minZ() + bounds.maxZ()) / 2);
        bounds = template.getBoundingBox(settings, placement);
        if (bounds.minY() < level.getMinBuildHeight() || bounds.maxY() >= level.getMaxBuildHeight()) return false;
        if (!level.ensureCanWrite(new BlockPos(bounds.minX(), bounds.minY(), bounds.minZ()))
                || !level.ensureCanWrite(new BlockPos(bounds.maxX(), bounds.maxY(), bounds.maxZ()))
                || !level.ensureCanWrite(new BlockPos(bounds.minX(), bounds.minY(), bounds.maxZ()))
                || !level.ensureCanWrite(new BlockPos(bounds.maxX(), bounds.maxY(), bounds.minZ()))) return false;
        return template.placeInWorld(level, placement, placement, settings, random, Block.UPDATE_CLIENTS);
    }
}
