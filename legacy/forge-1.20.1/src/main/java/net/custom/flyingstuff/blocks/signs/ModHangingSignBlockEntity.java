package net.custom.flyingstuff.blocks.signs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.mcreator.flyingstuff.FlyingStuffModSigns;

public class ModHangingSignBlockEntity extends SignBlockEntity {
    public ModHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super( FlyingStuffModSigns.MOD_HANGING_SIGN.get() ,pPos, pBlockState);
    }
     
    @Override
    public BlockEntityType<?> getType() {
        return FlyingStuffModSigns.MOD_HANGING_SIGN.get();
    }
}