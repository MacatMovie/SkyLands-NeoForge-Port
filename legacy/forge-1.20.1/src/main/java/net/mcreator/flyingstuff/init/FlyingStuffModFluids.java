
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.flyingstuff.fluid.MoltenMetalFluid;
import net.mcreator.flyingstuff.FlyingStuffMod;

public class FlyingStuffModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, FlyingStuffMod.MODID);
	public static final RegistryObject<FlowingFluid> MOLTEN_METAL = REGISTRY.register("molten_metal", () -> new MoltenMetalFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_METAL = REGISTRY.register("flowing_molten_metal", () -> new MoltenMetalFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(MOLTEN_METAL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MOLTEN_METAL.get(), RenderType.translucent());
		}
	}
}
