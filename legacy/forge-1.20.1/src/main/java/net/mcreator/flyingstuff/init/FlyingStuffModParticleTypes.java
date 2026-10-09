
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.flyingstuff.FlyingStuffMod;

public class FlyingStuffModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, FlyingStuffMod.MODID);
	public static final RegistryObject<SimpleParticleType> CLOUD = REGISTRY.register("cloud", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FIRE_LEAF = REGISTRY.register("fire_leaf", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CLOUD_DETAILED = REGISTRY.register("cloud_detailed", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CLOUD_BIG_2 = REGISTRY.register("cloud_big_2", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> FAST = REGISTRY.register("fast", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SNOWFALL_0 = REGISTRY.register("snowfall_0", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> EMPTY = REGISTRY.register("empty", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CLOUD_SMOKE = REGISTRY.register("cloud_smoke", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CLOUD_SMOKE_1 = REGISTRY.register("cloud_smoke_1", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CLOUD_BARRIER_0 = REGISTRY.register("cloud_barrier_0", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CLOUD_BARRIER_1 = REGISTRY.register("cloud_barrier_1", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CLOUD_BARRIER_2 = REGISTRY.register("cloud_barrier_2", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CLOUD_BARRIER_3 = REGISTRY.register("cloud_barrier_3", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CLOUD_BARRIER_4 = REGISTRY.register("cloud_barrier_4", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ICE = REGISTRY.register("ice", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> TEMP_FIRE_PARTICLE = REGISTRY.register("temp_fire_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> WIND = REGISTRY.register("wind", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FIREFLY = REGISTRY.register("firefly", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ITEM_BREAK = REGISTRY.register("item_break", () -> new SimpleParticleType(true));
}
