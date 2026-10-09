
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.flyingstuff.FlyingStuffMod;

public class FlyingStuffModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, FlyingStuffMod.MODID);
	public static final RegistryObject<PaintingVariant> GOLDEN_SKY = REGISTRY.register("golden_sky", () -> new PaintingVariant(16, 32));
	public static final RegistryObject<PaintingVariant> MOD_LOGO_PAINTING = REGISTRY.register("mod_logo_painting", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> GLACIATED_SKY_PAINTING = REGISTRY.register("glaciated_sky_painting", () -> new PaintingVariant(32, 16));
}
