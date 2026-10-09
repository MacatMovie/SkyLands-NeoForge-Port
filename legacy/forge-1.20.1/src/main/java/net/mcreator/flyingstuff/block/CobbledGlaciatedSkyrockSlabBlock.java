
package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class CobbledGlaciatedSkyrockSlabBlock extends SlabBlock {
	public CobbledGlaciatedSkyrockSlabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.05f, 10.5f).requiresCorrectToolForDrops().dynamicShape());
	}
}
