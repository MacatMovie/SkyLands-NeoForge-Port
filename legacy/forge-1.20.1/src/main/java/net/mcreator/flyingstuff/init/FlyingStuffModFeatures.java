
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.flyingstuff.world.features.LAUNCHER01FeatureFeature;
import net.mcreator.flyingstuff.FlyingStuffMod;

@Mod.EventBusSubscriber
public class FlyingStuffModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, FlyingStuffMod.MODID);
	public static final RegistryObject<Feature<?>> LAUNCHER_01_FEATURE = REGISTRY.register("launcher_01_feature", LAUNCHER01FeatureFeature::new);
}
