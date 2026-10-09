
package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class LavicPressurePlateBlock extends PressurePlateBlock {
	public LavicPressurePlateBlock() {
		super(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(1.1f, 11f).dynamicShape().forceSolidOn(), BlockSetType.OAK);
	}
}
