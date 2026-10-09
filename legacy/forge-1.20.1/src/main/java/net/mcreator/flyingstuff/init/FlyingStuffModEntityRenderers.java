
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.flyingstuff.client.renderer.SkyPharaohRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyBirdRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyAutomatonRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyAutomatonBruteRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyAutomatonBossRenderer;
import net.mcreator.flyingstuff.client.renderer.MagmaSlobertRenderer;
import net.mcreator.flyingstuff.client.renderer.LavicSkyAutomatonRenderer;
import net.mcreator.flyingstuff.client.renderer.IgneoRoboFelineRenderer;
import net.mcreator.flyingstuff.client.renderer.IceBlobRenderer;
import net.mcreator.flyingstuff.client.renderer.HappySlobertRenderer;
import net.mcreator.flyingstuff.client.renderer.GlaciatedSkyAutomatonRenderer;
import net.mcreator.flyingstuff.client.renderer.GlaciatedDragonRenderer;
import net.mcreator.flyingstuff.client.renderer.FriendlyVexRenderer;
import net.mcreator.flyingstuff.client.renderer.AutomatonDroneRenderer;
import net.mcreator.flyingstuff.client.renderer.ArtificialAracnidRenderer;
import net.mcreator.flyingstuff.client.renderer.AridSkyAutomatonRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FlyingStuffModEntities.SKY_AUTOMATON.get(), SkyAutomatonRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.SKY_AUTOMATON_BOSS.get(), SkyAutomatonBossRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.SMOKE_FLOWER_PROJ.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.AUTOMATON_DRONE.get(), AutomatonDroneRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.FLOAT_GRAPE_PROJ.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.ICE_ARROW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.GLACIATED_SKY_AUTOMATON.get(), GlaciatedSkyAutomatonRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.GLACIATED_DRAGON.get(), GlaciatedDragonRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.ICEBOMB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.SKY_AUTOMATON_BRUTE.get(), SkyAutomatonBruteRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.ICE_BLOB.get(), IceBlobRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.MAGMA_SLOBERT.get(), MagmaSlobertRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.LAVIC_SKY_AUTOMATON.get(), LavicSkyAutomatonRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.FIRE_WAVE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.IGNEO_ROBO_FELINE.get(), IgneoRoboFelineRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.SKY_BIRD.get(), SkyBirdRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.ARID_SKY_AUTOMATON.get(), AridSkyAutomatonRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.SKY_PHARAOH.get(), SkyPharaohRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.FRIENDLY_VEX.get(), FriendlyVexRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.HAPPY_SLOBERT.get(), HappySlobertRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.ARTIFICIAL_ARACNID.get(), ArtificialAracnidRenderer::new);
		event.registerEntityRenderer(FlyingStuffModEntities.EYE_OFTS_PROJECTILE.get(), ThrownItemRenderer::new);
	}
}
