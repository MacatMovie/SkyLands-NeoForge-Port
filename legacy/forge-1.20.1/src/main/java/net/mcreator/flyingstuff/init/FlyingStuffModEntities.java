
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.flyingstuff.entity.SmokeFlowerProjEntity;
import net.mcreator.flyingstuff.entity.SkyPharaohEntity;
import net.mcreator.flyingstuff.entity.SkyBirdEntity;
import net.mcreator.flyingstuff.entity.SkyAutomatonEntity;
import net.mcreator.flyingstuff.entity.SkyAutomatonBruteEntity;
import net.mcreator.flyingstuff.entity.SkyAutomatonBossEntity;
import net.mcreator.flyingstuff.entity.MagmaSlobertEntity;
import net.mcreator.flyingstuff.entity.LavicSkyAutomatonEntity;
import net.mcreator.flyingstuff.entity.IgneoRoboFelineEntity;
import net.mcreator.flyingstuff.entity.IcebombEntity;
import net.mcreator.flyingstuff.entity.IceBlobEntity;
import net.mcreator.flyingstuff.entity.IceArrowEntity;
import net.mcreator.flyingstuff.entity.HappySlobertEntity;
import net.mcreator.flyingstuff.entity.GlaciatedSkyAutomatonEntity;
import net.mcreator.flyingstuff.entity.GlaciatedDragonEntity;
import net.mcreator.flyingstuff.entity.FriendlyVexEntity;
import net.mcreator.flyingstuff.entity.FloatGrapeProjEntity;
import net.mcreator.flyingstuff.entity.FireWaveEntity;
import net.mcreator.flyingstuff.entity.EyeOftsProjectileEntity;
import net.mcreator.flyingstuff.entity.AutomatonDroneEntity;
import net.mcreator.flyingstuff.entity.ArtificialAracnidEntity;
import net.mcreator.flyingstuff.entity.AridSkyAutomatonEntity;
import net.mcreator.flyingstuff.FlyingStuffMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlyingStuffModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FlyingStuffMod.MODID);
	public static final RegistryObject<EntityType<SkyAutomatonEntity>> SKY_AUTOMATON = register("sky_automaton",
			EntityType.Builder.<SkyAutomatonEntity>of(SkyAutomatonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SkyAutomatonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SkyAutomatonBossEntity>> SKY_AUTOMATON_BOSS = register("sky_automaton_boss",
			EntityType.Builder.<SkyAutomatonBossEntity>of(SkyAutomatonBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SkyAutomatonBossEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SmokeFlowerProjEntity>> SMOKE_FLOWER_PROJ = register("smoke_flower_proj", EntityType.Builder.<SmokeFlowerProjEntity>of(SmokeFlowerProjEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SmokeFlowerProjEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AutomatonDroneEntity>> AUTOMATON_DRONE = register("automaton_drone",
			EntityType.Builder.<AutomatonDroneEntity>of(AutomatonDroneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(72).setUpdateInterval(3).setCustomClientFactory(AutomatonDroneEntity::new)

					.sized(0.6f, 1.2f));
	public static final RegistryObject<EntityType<FloatGrapeProjEntity>> FLOAT_GRAPE_PROJ = register("float_grape_proj",
			EntityType.Builder.<FloatGrapeProjEntity>of(FloatGrapeProjEntity::new, MobCategory.MISC).setCustomClientFactory(FloatGrapeProjEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IceArrowEntity>> ICE_ARROW = register("ice_arrow",
			EntityType.Builder.<IceArrowEntity>of(IceArrowEntity::new, MobCategory.MISC).setCustomClientFactory(IceArrowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GlaciatedSkyAutomatonEntity>> GLACIATED_SKY_AUTOMATON = register("glaciated_sky_automaton",
			EntityType.Builder.<GlaciatedSkyAutomatonEntity>of(GlaciatedSkyAutomatonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(GlaciatedSkyAutomatonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GlaciatedDragonEntity>> GLACIATED_DRAGON = register("glaciated_dragon",
			EntityType.Builder.<GlaciatedDragonEntity>of(GlaciatedDragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(GlaciatedDragonEntity::new)

					.sized(2.7f, 3.8f));
	public static final RegistryObject<EntityType<IcebombEntity>> ICEBOMB = register("icebomb",
			EntityType.Builder.<IcebombEntity>of(IcebombEntity::new, MobCategory.MISC).setCustomClientFactory(IcebombEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SkyAutomatonBruteEntity>> SKY_AUTOMATON_BRUTE = register("sky_automaton_brute",
			EntityType.Builder.<SkyAutomatonBruteEntity>of(SkyAutomatonBruteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SkyAutomatonBruteEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IceBlobEntity>> ICE_BLOB = register("ice_blob",
			EntityType.Builder.<IceBlobEntity>of(IceBlobEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(72).setUpdateInterval(3).setCustomClientFactory(IceBlobEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<MagmaSlobertEntity>> MAGMA_SLOBERT = register("magma_slobert", EntityType.Builder.<MagmaSlobertEntity>of(MagmaSlobertEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(72).setUpdateInterval(3).setCustomClientFactory(MagmaSlobertEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<LavicSkyAutomatonEntity>> LAVIC_SKY_AUTOMATON = register("lavic_sky_automaton", EntityType.Builder.<LavicSkyAutomatonEntity>of(LavicSkyAutomatonEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LavicSkyAutomatonEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FireWaveEntity>> FIRE_WAVE = register("fire_wave",
			EntityType.Builder.<FireWaveEntity>of(FireWaveEntity::new, MobCategory.MISC).setCustomClientFactory(FireWaveEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IgneoRoboFelineEntity>> IGNEO_ROBO_FELINE = register("igneo_robo_feline", EntityType.Builder.<IgneoRoboFelineEntity>of(IgneoRoboFelineEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IgneoRoboFelineEntity::new).fireImmune().sized(1.3f, 2.4f));
	public static final RegistryObject<EntityType<SkyBirdEntity>> SKY_BIRD = register("sky_bird",
			EntityType.Builder.<SkyBirdEntity>of(SkyBirdEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SkyBirdEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AridSkyAutomatonEntity>> ARID_SKY_AUTOMATON = register("arid_sky_automaton",
			EntityType.Builder.<AridSkyAutomatonEntity>of(AridSkyAutomatonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AridSkyAutomatonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SkyPharaohEntity>> SKY_PHARAOH = register("sky_pharaoh",
			EntityType.Builder.<SkyPharaohEntity>of(SkyPharaohEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SkyPharaohEntity::new)

					.sized(1.2f, 3f));
	public static final RegistryObject<EntityType<FriendlyVexEntity>> FRIENDLY_VEX = register("friendly_vex",
			EntityType.Builder.<FriendlyVexEntity>of(FriendlyVexEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FriendlyVexEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HappySlobertEntity>> HAPPY_SLOBERT = register("happy_slobert",
			EntityType.Builder.<HappySlobertEntity>of(HappySlobertEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(72).setUpdateInterval(3).setCustomClientFactory(HappySlobertEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<ArtificialAracnidEntity>> ARTIFICIAL_ARACNID = register("artificial_aracnid",
			EntityType.Builder.<ArtificialAracnidEntity>of(ArtificialAracnidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3).setCustomClientFactory(ArtificialAracnidEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EyeOftsProjectileEntity>> EYE_OFTS_PROJECTILE = register("eye_ofts_projectile", EntityType.Builder.<EyeOftsProjectileEntity>of(EyeOftsProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(EyeOftsProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SkyAutomatonEntity.init();
			SkyAutomatonBossEntity.init();
			AutomatonDroneEntity.init();
			GlaciatedSkyAutomatonEntity.init();
			GlaciatedDragonEntity.init();
			SkyAutomatonBruteEntity.init();
			IceBlobEntity.init();
			MagmaSlobertEntity.init();
			LavicSkyAutomatonEntity.init();
			IgneoRoboFelineEntity.init();
			SkyBirdEntity.init();
			AridSkyAutomatonEntity.init();
			SkyPharaohEntity.init();
			FriendlyVexEntity.init();
			HappySlobertEntity.init();
			ArtificialAracnidEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SKY_AUTOMATON.get(), SkyAutomatonEntity.createAttributes().build());
		event.put(SKY_AUTOMATON_BOSS.get(), SkyAutomatonBossEntity.createAttributes().build());
		event.put(AUTOMATON_DRONE.get(), AutomatonDroneEntity.createAttributes().build());
		event.put(GLACIATED_SKY_AUTOMATON.get(), GlaciatedSkyAutomatonEntity.createAttributes().build());
		event.put(GLACIATED_DRAGON.get(), GlaciatedDragonEntity.createAttributes().build());
		event.put(SKY_AUTOMATON_BRUTE.get(), SkyAutomatonBruteEntity.createAttributes().build());
		event.put(ICE_BLOB.get(), IceBlobEntity.createAttributes().build());
		event.put(MAGMA_SLOBERT.get(), MagmaSlobertEntity.createAttributes().build());
		event.put(LAVIC_SKY_AUTOMATON.get(), LavicSkyAutomatonEntity.createAttributes().build());
		event.put(IGNEO_ROBO_FELINE.get(), IgneoRoboFelineEntity.createAttributes().build());
		event.put(SKY_BIRD.get(), SkyBirdEntity.createAttributes().build());
		event.put(ARID_SKY_AUTOMATON.get(), AridSkyAutomatonEntity.createAttributes().build());
		event.put(SKY_PHARAOH.get(), SkyPharaohEntity.createAttributes().build());
		event.put(FRIENDLY_VEX.get(), FriendlyVexEntity.createAttributes().build());
		event.put(HAPPY_SLOBERT.get(), HappySlobertEntity.createAttributes().build());
		event.put(ARTIFICIAL_ARACNID.get(), ArtificialAracnidEntity.createAttributes().build());
	}
}
