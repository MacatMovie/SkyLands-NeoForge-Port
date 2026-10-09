
package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CobbledGlaciatedSkyrockwallBlock extends WallBlock {
	public CobbledGlaciatedSkyrockwallBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.05f, 10.5f).requiresCorrectToolForDrops().dynamicShape().forceSolidOn());
	}
}
