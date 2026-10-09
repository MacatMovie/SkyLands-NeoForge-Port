
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.flyingstuff.block.entity.WalkableAbyssalDoorTileEntity;
import net.mcreator.flyingstuff.block.entity.ProtoChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenLavicSkyLvl1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLvl2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel0ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.LavicSkyLvl2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.LavicSkyLvl1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.LavicRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.GoldenRewardDispencerTileEntity;
import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.GlaciatedRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.entity.AridSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.AridSkyLevel0ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.AridRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.entity.AbyssalDoorTileEntity;
import net.mcreator.flyingstuff.FlyingStuffMod;

public class FlyingStuffModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FlyingStuffMod.MODID);
	public static final RegistryObject<BlockEntityType<GoldenSkyLevel1ChestTileEntity>> GOLDEN_SKY_LEVEL_1_CHEST = REGISTRY.register("golden_sky_level_1_chest",
			() -> BlockEntityType.Builder.of(GoldenSkyLevel1ChestTileEntity::new, FlyingStuffModBlocks.GOLDEN_SKY_LEVEL_1_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<OpenGoldenSkyLevel1ChestTileEntity>> OPEN_GOLDEN_SKY_LEVEL_1_CHEST = REGISTRY.register("open_golden_sky_level_1_chest",
			() -> BlockEntityType.Builder.of(OpenGoldenSkyLevel1ChestTileEntity::new, FlyingStuffModBlocks.OPEN_GOLDEN_SKY_LEVEL_1_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<GoldenSkyLevel2ChestTileEntity>> GOLDEN_SKY_LEVEL_2_CHEST = REGISTRY.register("golden_sky_level_2_chest",
			() -> BlockEntityType.Builder.of(GoldenSkyLevel2ChestTileEntity::new, FlyingStuffModBlocks.GOLDEN_SKY_LEVEL_2_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<OpenGoldenSkyLevel2ChestTileEntity>> OPEN_GOLDEN_SKY_LEVEL_2_CHEST = REGISTRY.register("open_golden_sky_level_2_chest",
			() -> BlockEntityType.Builder.of(OpenGoldenSkyLevel2ChestTileEntity::new, FlyingStuffModBlocks.OPEN_GOLDEN_SKY_LEVEL_2_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<GlaciatedSkyLevel1ChestTileEntity>> GLACIATED_SKY_LEVEL_1_CHEST = REGISTRY.register("glaciated_sky_level_1_chest",
			() -> BlockEntityType.Builder.of(GlaciatedSkyLevel1ChestTileEntity::new, FlyingStuffModBlocks.GLACIATED_SKY_LEVEL_1_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<OpenGlaciatedSkyLevel1ChestTileEntity>> OPEN_GLACIATED_SKY_LEVEL_1_CHEST = REGISTRY.register("open_glaciated_sky_level_1_chest",
			() -> BlockEntityType.Builder.of(OpenGlaciatedSkyLevel1ChestTileEntity::new, FlyingStuffModBlocks.OPEN_GLACIATED_SKY_LEVEL_1_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<GlaciatedSkyLevel2ChestTileEntity>> GLACIATED_SKY_LEVEL_2_CHEST = REGISTRY.register("glaciated_sky_level_2_chest",
			() -> BlockEntityType.Builder.of(GlaciatedSkyLevel2ChestTileEntity::new, FlyingStuffModBlocks.GLACIATED_SKY_LEVEL_2_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<OpenGlaciatedSkyLevel2ChestTileEntity>> OPEN_GLACIATED_SKY_LEVEL_2_CHEST = REGISTRY.register("open_glaciated_sky_level_2_chest",
			() -> BlockEntityType.Builder.of(OpenGlaciatedSkyLevel2ChestTileEntity::new, FlyingStuffModBlocks.OPEN_GLACIATED_SKY_LEVEL_2_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<LavicSkyLvl1ChestTileEntity>> LAVIC_SKY_LVL_1_CHEST = REGISTRY.register("lavic_sky_lvl_1_chest",
			() -> BlockEntityType.Builder.of(LavicSkyLvl1ChestTileEntity::new, FlyingStuffModBlocks.LAVIC_SKY_LVL_1_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<OpenLavicSkyLvl1ChestTileEntity>> OPEN_LAVIC_SKY_LVL_1_CHEST = REGISTRY.register("open_lavic_sky_lvl_1_chest",
			() -> BlockEntityType.Builder.of(OpenLavicSkyLvl1ChestTileEntity::new, FlyingStuffModBlocks.OPEN_LAVIC_SKY_LVL_1_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<LavicSkyLvl2ChestTileEntity>> LAVIC_SKY_LVL_2_CHEST = REGISTRY.register("lavic_sky_lvl_2_chest",
			() -> BlockEntityType.Builder.of(LavicSkyLvl2ChestTileEntity::new, FlyingStuffModBlocks.LAVIC_SKY_LVL_2_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<OpenGlaciatedSkyLvl2ChestTileEntity>> OPEN_LAVIC_SKY_LVL_2_CHEST = REGISTRY.register("open_lavic_sky_lvl_2_chest",
			() -> BlockEntityType.Builder.of(OpenGlaciatedSkyLvl2ChestTileEntity::new, FlyingStuffModBlocks.OPEN_LAVIC_SKY_LVL_2_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<AridSkyLevel0ChestTileEntity>> ARID_SKY_LEVEL_0_CHEST = REGISTRY.register("arid_sky_level_0_chest",
			() -> BlockEntityType.Builder.of(AridSkyLevel0ChestTileEntity::new, FlyingStuffModBlocks.ARID_SKY_LEVEL_0_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<OpenAridSkyLevel0ChestTileEntity>> OPEN_ARID_SKY_LEVEL_0_CHEST = REGISTRY.register("open_arid_sky_level_0_chest",
			() -> BlockEntityType.Builder.of(OpenAridSkyLevel0ChestTileEntity::new, FlyingStuffModBlocks.OPEN_ARID_SKY_LEVEL_0_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<AridSkyLevel2ChestTileEntity>> ARID_SKY_LEVEL_2_CHEST = REGISTRY.register("arid_sky_level_2_chest",
			() -> BlockEntityType.Builder.of(AridSkyLevel2ChestTileEntity::new, FlyingStuffModBlocks.ARID_SKY_LEVEL_2_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<OpenAridSkyLevel2ChestTileEntity>> OPEN_ARID_SKY_LEVEL_2_CHEST = REGISTRY.register("open_arid_sky_level_2_chest",
			() -> BlockEntityType.Builder.of(OpenAridSkyLevel2ChestTileEntity::new, FlyingStuffModBlocks.OPEN_ARID_SKY_LEVEL_2_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<GoldenRewardDispencerTileEntity>> GOLDEN_REWARD_DISPENCER = REGISTRY.register("golden_reward_dispencer",
			() -> BlockEntityType.Builder.of(GoldenRewardDispencerTileEntity::new, FlyingStuffModBlocks.GOLDEN_REWARD_DISPENCER.get()).build(null));
	public static final RegistryObject<BlockEntityType<GlaciatedRewardDispenserTileEntity>> GLACIATED_REWARD_DISPENSER = REGISTRY.register("glaciated_reward_dispenser",
			() -> BlockEntityType.Builder.of(GlaciatedRewardDispenserTileEntity::new, FlyingStuffModBlocks.GLACIATED_REWARD_DISPENSER.get()).build(null));
	public static final RegistryObject<BlockEntityType<LavicRewardDispenserTileEntity>> LAVIC_REWARD_DISPENSER = REGISTRY.register("lavic_reward_dispenser",
			() -> BlockEntityType.Builder.of(LavicRewardDispenserTileEntity::new, FlyingStuffModBlocks.LAVIC_REWARD_DISPENSER.get()).build(null));
	public static final RegistryObject<BlockEntityType<AridRewardDispenserTileEntity>> ARID_REWARD_DISPENSER = REGISTRY.register("arid_reward_dispenser",
			() -> BlockEntityType.Builder.of(AridRewardDispenserTileEntity::new, FlyingStuffModBlocks.ARID_REWARD_DISPENSER.get()).build(null));
	public static final RegistryObject<BlockEntityType<AbyssalDoorTileEntity>> ABYSSAL_DOOR = REGISTRY.register("abyssal_door", () -> BlockEntityType.Builder.of(AbyssalDoorTileEntity::new, FlyingStuffModBlocks.ABYSSAL_DOOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<WalkableAbyssalDoorTileEntity>> WALKABLE_ABYSSAL_DOOR = REGISTRY.register("walkable_abyssal_door",
			() -> BlockEntityType.Builder.of(WalkableAbyssalDoorTileEntity::new, FlyingStuffModBlocks.WALKABLE_ABYSSAL_DOOR.get()).build(null));
	public static final RegistryObject<BlockEntityType<ProtoChestTileEntity>> PROTO_CHEST = REGISTRY.register("proto_chest", () -> BlockEntityType.Builder.of(ProtoChestTileEntity::new, FlyingStuffModBlocks.PROTO_CHEST.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
