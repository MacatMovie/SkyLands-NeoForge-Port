
package net.mcreator.flyingstuff.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class CristalizediceBlock extends Block {
	public CristalizediceBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST).strength(0.6f, 4f).lightLevel(s -> 3).requiresCorrectToolForDrops().friction(0.9f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 13;
	}
}
