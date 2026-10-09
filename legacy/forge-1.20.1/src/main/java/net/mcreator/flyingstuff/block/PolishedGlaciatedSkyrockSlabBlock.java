
package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class PolishedGlaciatedSkyrockSlabBlock extends SlabBlock {
	public PolishedGlaciatedSkyrockSlabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.1f, 11f).requiresCorrectToolForDrops().dynamicShape());
	}
}
