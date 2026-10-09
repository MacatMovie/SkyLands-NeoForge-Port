package net.custom.flyingstuff.blocks.signs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.mcreator.flyingstuff.FlyingStuffModSigns;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super( FlyingStuffModSigns.MOD_SIGN.get() ,pPos, pBlockState);
    }
     
    @Override
    public BlockEntityType<?> getType() {
        return FlyingStuffModSigns.MOD_SIGN.get();
    }
}