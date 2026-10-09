package net.custom.flyingstuff.blocks;

import java.util.Properties;

import net.minecraft.core.BlockPos;
import net.custom.flyingstuff.blocks.signs.ModSignBlockEntity;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.WoodType;

public class mStandingSignBlock extends StandingSignBlock {
    public mStandingSignBlock(Properties pProperties, WoodType pType){
        super(pProperties, pType);
    }
    
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModSignBlockEntity(pPos, pState);
    }
}