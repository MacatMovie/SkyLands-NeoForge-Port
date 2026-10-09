package net.deepcanion.skylands.block;

import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

final class SkyCactusGrowth {
    private static final TagKey<Block> SEGMENTS = TagKey.create(Registries.BLOCK, SkyLands.id("sky_cacti"));
    static void grow(ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.3F || pos.getY() + 1 >= level.getMaxBuildHeight() || !level.isEmptyBlock(pos.above())) return;
        int height = 1;
        while (height < 8 && level.getBlockState(pos.below(height)).is(SEGMENTS)) height++;
        if (height >= 8) return;
        float choice = random.nextFloat();
        BlockState next;
        if (choice < 0.36F) {
            next = ModBlocks.SKY_CACTUS_BRANCH.get().defaultBlockState()
                    .setValue(FacingBlock.FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random));
        } else if (choice < 0.616F) {
            next = ModBlocks.SKY_CACTUS.get().defaultBlockState();
        } else {
            next = ModBlocks.SKY_CACTUS_TOP.get().defaultBlockState()
                    .setValue(FacingBlock.FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random));
        }
        level.setBlock(pos.above(), next, Block.UPDATE_ALL);
    }
    private SkyCactusGrowth() { }
}
