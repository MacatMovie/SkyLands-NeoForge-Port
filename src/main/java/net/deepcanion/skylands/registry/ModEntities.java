package net.deepcanion.skylands.registry;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, SkyLands.MOD_ID);
    public static final DeferredHolder<EntityType<?>, EntityType<SkyAutomatonEntity>> SKY_AUTOMATON = ENTITIES.register("sky_automaton",
            () -> EntityType.Builder.<SkyAutomatonEntity>of(SkyAutomatonEntity::new, MobCategory.MONSTER).sized(0.6f, 1.8f).clientTrackingRange(8).updateInterval(3).build("flying_stuff:sky_automaton"));
    public static final DeferredHolder<EntityType<?>, EntityType<SkyAutomatonBossEntity>> SKY_AUTOMATON_BOSS = ENTITIES.register("sky_automaton_boss",
            () -> EntityType.Builder.<SkyAutomatonBossEntity>of(SkyAutomatonBossEntity::new, MobCategory.MONSTER).sized(0.6f, 1.8f).clientTrackingRange(8).updateInterval(3).build("flying_stuff:sky_automaton_boss"));
    public static final DeferredHolder<EntityType<?>, EntityType<SmokeFlowerProjEntity>> SMOKE_FLOWER_PROJ = ENTITIES.register("smoke_flower_proj",
            () -> EntityType.Builder.<SmokeFlowerProjEntity>of(SmokeFlowerProjEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(8).updateInterval(1).build("flying_stuff:smoke_flower_proj"));
    public static final DeferredHolder<EntityType<?>, EntityType<AutomatonDroneEntity>> AUTOMATON_DRONE = ENTITIES.register("automaton_drone",
            () -> EntityType.Builder.<AutomatonDroneEntity>of(AutomatonDroneEntity::new, MobCategory.MONSTER).sized(0.6f, 1.2f).clientTrackingRange(9).updateInterval(3).build("flying_stuff:automaton_drone"));
    public static final DeferredHolder<EntityType<?>, EntityType<FloatGrapeProjEntity>> FLOAT_GRAPE_PROJ = ENTITIES.register("float_grape_proj",
            () -> EntityType.Builder.<FloatGrapeProjEntity>of(FloatGrapeProjEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(8).updateInterval(1).build("flying_stuff:float_grape_proj"));
    public static final DeferredHolder<EntityType<?>, EntityType<IceArrowEntity>> ICE_ARROW = ENTITIES.register("ice_arrow",
            () -> EntityType.Builder.<IceArrowEntity>of(IceArrowEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(8).updateInterval(1).build("flying_stuff:ice_arrow"));
    public static final DeferredHolder<EntityType<?>, EntityType<GlaciatedSkyAutomatonEntity>> GLACIATED_SKY_AUTOMATON = ENTITIES.register("glaciated_sky_automaton",
            () -> EntityType.Builder.<GlaciatedSkyAutomatonEntity>of(GlaciatedSkyAutomatonEntity::new, MobCategory.MONSTER).sized(0.6f, 1.8f).clientTrackingRange(8).updateInterval(3).build("flying_stuff:glaciated_sky_automaton"));
    public static final DeferredHolder<EntityType<?>, EntityType<GlaciatedDragonEntity>> GLACIATED_DRAGON = ENTITIES.register("glaciated_dragon",
            () -> EntityType.Builder.<GlaciatedDragonEntity>of(GlaciatedDragonEntity::new, MobCategory.MONSTER).sized(2.7f, 3.8f).clientTrackingRange(13).updateInterval(3).build("flying_stuff:glaciated_dragon"));
    public static final DeferredHolder<EntityType<?>, EntityType<IcebombEntity>> ICEBOMB = ENTITIES.register("icebomb",
            () -> EntityType.Builder.<IcebombEntity>of(IcebombEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(8).updateInterval(1).build("flying_stuff:icebomb"));
    public static final DeferredHolder<EntityType<?>, EntityType<SkyAutomatonBruteEntity>> SKY_AUTOMATON_BRUTE = ENTITIES.register("sky_automaton_brute",
            () -> EntityType.Builder.<SkyAutomatonBruteEntity>of(SkyAutomatonBruteEntity::new, MobCategory.MONSTER).sized(0.6f, 1.8f).clientTrackingRange(8).updateInterval(3).build("flying_stuff:sky_automaton_brute"));
    public static final DeferredHolder<EntityType<?>, EntityType<IceBlobEntity>> ICE_BLOB = ENTITIES.register("ice_blob",
            () -> EntityType.Builder.<IceBlobEntity>of(IceBlobEntity::new, MobCategory.MONSTER).sized(1f, 1f).clientTrackingRange(9).updateInterval(3).build("flying_stuff:ice_blob"));
    public static final DeferredHolder<EntityType<?>, EntityType<MagmaSlobertEntity>> MAGMA_SLOBERT = ENTITIES.register("magma_slobert",
            () -> EntityType.Builder.<MagmaSlobertEntity>of(MagmaSlobertEntity::new, MobCategory.MONSTER).sized(1f, 1f).fireImmune().clientTrackingRange(9).updateInterval(3).build("flying_stuff:magma_slobert"));
    public static final DeferredHolder<EntityType<?>, EntityType<LavicSkyAutomatonEntity>> LAVIC_SKY_AUTOMATON = ENTITIES.register("lavic_sky_automaton",
            () -> EntityType.Builder.<LavicSkyAutomatonEntity>of(LavicSkyAutomatonEntity::new, MobCategory.MONSTER).sized(0.6f, 1.8f).fireImmune().clientTrackingRange(8).updateInterval(3).build("flying_stuff:lavic_sky_automaton"));
    public static final DeferredHolder<EntityType<?>, EntityType<FireWaveEntity>> FIRE_WAVE = ENTITIES.register("fire_wave",
            () -> EntityType.Builder.<FireWaveEntity>of(FireWaveEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(8).updateInterval(1).build("flying_stuff:fire_wave"));
    public static final DeferredHolder<EntityType<?>, EntityType<IgneoRoboFelineEntity>> IGNEO_ROBO_FELINE = ENTITIES.register("igneo_robo_feline",
            () -> EntityType.Builder.<IgneoRoboFelineEntity>of(IgneoRoboFelineEntity::new, MobCategory.MONSTER).sized(1.3f, 2.4f).fireImmune().clientTrackingRange(8).updateInterval(3).build("flying_stuff:igneo_robo_feline"));
    public static final DeferredHolder<EntityType<?>, EntityType<SkyBirdEntity>> SKY_BIRD = ENTITIES.register("sky_bird",
            () -> EntityType.Builder.<SkyBirdEntity>of(SkyBirdEntity::new, MobCategory.CREATURE).sized(0.6f, 1.8f).clientTrackingRange(8).updateInterval(3).build("flying_stuff:sky_bird"));
    public static final DeferredHolder<EntityType<?>, EntityType<AridSkyAutomatonEntity>> ARID_SKY_AUTOMATON = ENTITIES.register("arid_sky_automaton",
            () -> EntityType.Builder.<AridSkyAutomatonEntity>of(AridSkyAutomatonEntity::new, MobCategory.MONSTER).sized(0.6f, 1.8f).clientTrackingRange(8).updateInterval(3).build("flying_stuff:arid_sky_automaton"));
    public static final DeferredHolder<EntityType<?>, EntityType<SkyPharaohEntity>> SKY_PHARAOH = ENTITIES.register("sky_pharaoh",
            () -> EntityType.Builder.<SkyPharaohEntity>of(SkyPharaohEntity::new, MobCategory.MONSTER).sized(1.2f, 3f).eyeHeight(2F).clientTrackingRange(8).updateInterval(3).build("flying_stuff:sky_pharaoh"));
    public static final DeferredHolder<EntityType<?>, EntityType<FriendlyVexEntity>> FRIENDLY_VEX = ENTITIES.register("friendly_vex",
            () -> EntityType.Builder.<FriendlyVexEntity>of(FriendlyVexEntity::new, MobCategory.MONSTER).sized(0.5f, 0.5f).clientTrackingRange(8).updateInterval(3).build("flying_stuff:friendly_vex"));
    public static final DeferredHolder<EntityType<?>, EntityType<HappySlobertEntity>> HAPPY_SLOBERT = ENTITIES.register("happy_slobert",
            () -> EntityType.Builder.<HappySlobertEntity>of(HappySlobertEntity::new, MobCategory.CREATURE).sized(1f, 1f).clientTrackingRange(9).updateInterval(3).build("flying_stuff:happy_slobert"));
    public static final DeferredHolder<EntityType<?>, EntityType<ArtificialAracnidEntity>> ARTIFICIAL_ARACNID = ENTITIES.register("artificial_aracnid",
            () -> EntityType.Builder.<ArtificialAracnidEntity>of(ArtificialAracnidEntity::new, MobCategory.MONSTER).sized(0.6f, 1.8f).clientTrackingRange(12).updateInterval(3).build("flying_stuff:artificial_aracnid"));
    public static final DeferredHolder<EntityType<?>, EntityType<EyeOftsProjectileEntity>> EYE_OFTS_PROJECTILE = ENTITIES.register("eye_ofts_projectile",
            () -> EntityType.Builder.<EyeOftsProjectileEntity>of(EyeOftsProjectileEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(8).updateInterval(1).build("flying_stuff:eye_ofts_projectile"));
    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
        bus.addListener(ModEntities::attributes);
        bus.addListener(ModEntities::placements);
    }
    private static void attributes(EntityAttributeCreationEvent event) {
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
    private static void placements(RegisterSpawnPlacementsEvent event) {
        event.register(SKY_AUTOMATON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(SKY_AUTOMATON_BOSS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(AUTOMATON_DRONE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(GLACIATED_SKY_AUTOMATON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(GLACIATED_DRAGON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(SKY_AUTOMATON_BRUTE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ICE_BLOB.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MAGMA_SLOBERT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(LAVIC_SKY_AUTOMATON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(IGNEO_ROBO_FELINE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(SKY_BIRD.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> pos.getY() > 169 && net.minecraft.world.entity.Mob.checkMobSpawnRules(type, world, reason, pos, random), RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ARID_SKY_AUTOMATON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(SKY_PHARAOH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(FRIENDLY_VEX.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(HAPPY_SLOBERT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, world, reason, pos, random) -> pos.getY() > 200 && net.minecraft.world.entity.Mob.checkMobSpawnRules(type, world, reason, pos, random), RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ARTIFICIAL_ARACNID.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
    private ModEntities() { }
}
