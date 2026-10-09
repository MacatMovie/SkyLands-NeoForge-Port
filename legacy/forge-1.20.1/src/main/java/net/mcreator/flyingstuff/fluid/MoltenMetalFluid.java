
package net.mcreator.flyingstuff.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.mcreator.flyingstuff.init.FlyingStuffModFluids;
import net.mcreator.flyingstuff.init.FlyingStuffModFluidTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;

public abstract class MoltenMetalFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> FlyingStuffModFluidTypes.MOLTEN_METAL_TYPE.get(), () -> FlyingStuffModFluids.MOLTEN_METAL.get(),
			() -> FlyingStuffModFluids.FLOWING_MOLTEN_METAL.get()).explosionResistance(100f).tickRate(8).slopeFindDistance(8).bucket(() -> FlyingStuffModItems.MOLTEN_METAL_BUCKET.get())
			.block(() -> (LiquidBlock) FlyingStuffModBlocks.MOLTEN_METAL.get());

	private MoltenMetalFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MoltenMetalFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MoltenMetalFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
