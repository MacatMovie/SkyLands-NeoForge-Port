package net.mcreator.flyingstuff.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;
import net.mcreator.flyingstuff.block.renderer.WalkableAbyssalDoorTileRenderer;
import net.mcreator.flyingstuff.block.renderer.ProtoChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenLavicSkyLvl1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGoldenSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGoldenSkyLevel1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGlaciatedSkyLvl2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGlaciatedSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGlaciatedSkyLevel1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenAridSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenAridSkyLevel0ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.LavicSkyLvl2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.LavicSkyLvl1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.LavicRewardDispenserTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GoldenSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GoldenSkyLevel1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GoldenRewardDispencerTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GlaciatedSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GlaciatedSkyLevel1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GlaciatedRewardDispenserTileRenderer;
import net.mcreator.flyingstuff.block.renderer.AridSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.AridSkyLevel0ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.AridRewardDispenserTileRenderer;
import net.mcreator.flyingstuff.block.renderer.AbyssalDoorTileRenderer;
import net.mcreator.flyingstuff.FlyingStuffMod;

@Mod.EventBusSubscriber(modid = FlyingStuffMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.GOLDEN_SKY_LEVEL_1_CHEST.get(), context -> new GoldenSkyLevel1ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.OPEN_GOLDEN_SKY_LEVEL_1_CHEST.get(), context -> new OpenGoldenSkyLevel1ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.GOLDEN_SKY_LEVEL_2_CHEST.get(), context -> new GoldenSkyLevel2ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.OPEN_GOLDEN_SKY_LEVEL_2_CHEST.get(), context -> new OpenGoldenSkyLevel2ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.GLACIATED_SKY_LEVEL_1_CHEST.get(), context -> new GlaciatedSkyLevel1ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.OPEN_GLACIATED_SKY_LEVEL_1_CHEST.get(), context -> new OpenGlaciatedSkyLevel1ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.GLACIATED_SKY_LEVEL_2_CHEST.get(), context -> new GlaciatedSkyLevel2ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.OPEN_GLACIATED_SKY_LEVEL_2_CHEST.get(), context -> new OpenGlaciatedSkyLevel2ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.LAVIC_SKY_LVL_1_CHEST.get(), context -> new LavicSkyLvl1ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.OPEN_LAVIC_SKY_LVL_1_CHEST.get(), context -> new OpenLavicSkyLvl1ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.LAVIC_SKY_LVL_2_CHEST.get(), context -> new LavicSkyLvl2ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.OPEN_LAVIC_SKY_LVL_2_CHEST.get(), context -> new OpenGlaciatedSkyLvl2ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.ARID_SKY_LEVEL_0_CHEST.get(), context -> new AridSkyLevel0ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.OPEN_ARID_SKY_LEVEL_0_CHEST.get(), context -> new OpenAridSkyLevel0ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.ARID_SKY_LEVEL_2_CHEST.get(), context -> new AridSkyLevel2ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.OPEN_ARID_SKY_LEVEL_2_CHEST.get(), context -> new OpenAridSkyLevel2ChestTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.GOLDEN_REWARD_DISPENCER.get(), context -> new GoldenRewardDispencerTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.GLACIATED_REWARD_DISPENSER.get(), context -> new GlaciatedRewardDispenserTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.LAVIC_REWARD_DISPENSER.get(), context -> new LavicRewardDispenserTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.ARID_REWARD_DISPENSER.get(), context -> new AridRewardDispenserTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.ABYSSAL_DOOR.get(), context -> new AbyssalDoorTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.WALKABLE_ABYSSAL_DOOR.get(), context -> new WalkableAbyssalDoorTileRenderer());
		event.registerBlockEntityRenderer(FlyingStuffModBlockEntities.PROTO_CHEST.get(), context -> new ProtoChestTileRenderer());
	}
}
