package net.custom.flyingstuff.blocks;

import java.util.Properties;

import net.minecraft.core.BlockPos;
import net.custom.flyingstuff.blocks.signs.ModHangingSignBlockEntity;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.WoodType;

public class mHangingSignBlock extends CeilingHangingSignBlock {
    public mHangingSignBlock(Properties pProperties, WoodType pType){
        super(pProperties, pType);
    }
    
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModHangingSignBlockEntity(pPos, pState);
    }
}