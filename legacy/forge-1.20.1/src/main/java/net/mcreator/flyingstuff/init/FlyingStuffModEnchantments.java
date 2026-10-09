
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.flyingstuff.enchantment.LightweightEnchantment;
import net.mcreator.flyingstuff.FlyingStuffMod;

public class FlyingStuffModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, FlyingStuffMod.MODID);
	public static final RegistryObject<Enchantment> LIGHTWEIGHT = REGISTRY.register("lightweight", () -> new LightweightEnchantment());
}
