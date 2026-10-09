package net.deepcanion.skylands.block;
import net.deepcanion.skylands.registry.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
public final class MechanicalGeyserBlock extends Block {
    public MechanicalGeyserBlock() {
        super(BlockBehaviour.Properties.of().sound(SoundType.ANVIL).strength(1.5F, 15F).lightLevel(s -> 5)
                .requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((s, l, p) -> false));
    }
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        level.addParticle(ModParticles.CLOUD.get(), pos.getX() + random.nextDouble(), pos.getY() + 0.5, pos.getZ() + random.nextDouble(), 0, 1, 0);
    }
}
