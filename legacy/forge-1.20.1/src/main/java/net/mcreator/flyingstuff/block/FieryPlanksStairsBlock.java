
package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class FieryPlanksStairsBlock extends StairBlock {
	public FieryPlanksStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(1.1f, 11f).dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 11f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}
}
