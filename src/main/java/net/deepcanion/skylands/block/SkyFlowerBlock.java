package net.deepcanion.skylands.block;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public final class SkyFlowerBlock extends FlowerBlock {
    public SkyFlowerBlock(Holder<MobEffect> effect, int durationTicks, Properties properties) {
        super(new SuspiciousStewEffects(List.of(new SuspiciousStewEffects.Entry(effect, durationTicks))), properties);
    }
    @Override protected boolean mayPlaceOn(BlockState soil, BlockGetter level, BlockPos pos) {
        return soil.is(PlantSupport.SOILS) || super.mayPlaceOn(soil, level, pos);
    }
}
