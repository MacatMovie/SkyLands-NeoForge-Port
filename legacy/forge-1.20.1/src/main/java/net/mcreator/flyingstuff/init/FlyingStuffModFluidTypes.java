
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.flyingstuff.fluid.types.MoltenMetalFluidType;
import net.mcreator.flyingstuff.FlyingStuffMod;

public class FlyingStuffModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, FlyingStuffMod.MODID);
	public static final RegistryObject<FluidType> MOLTEN_METAL_TYPE = REGISTRY.register("molten_metal", () -> new MoltenMetalFluidType());
}
