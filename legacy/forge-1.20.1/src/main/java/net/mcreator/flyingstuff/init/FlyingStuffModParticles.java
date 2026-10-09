
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.flyingstuff.client.particle.WindParticle;
import net.mcreator.flyingstuff.client.particle.TempFireParticleParticle;
import net.mcreator.flyingstuff.client.particle.Snowfall0Particle;
import net.mcreator.flyingstuff.client.particle.ItemBreakParticle;
import net.mcreator.flyingstuff.client.particle.IceParticle;
import net.mcreator.flyingstuff.client.particle.FireflyParticle;
import net.mcreator.flyingstuff.client.particle.FireLeafParticle;
import net.mcreator.flyingstuff.client.particle.FastParticle;
import net.mcreator.flyingstuff.client.particle.EmptyParticle;
import net.mcreator.flyingstuff.client.particle.CloudSmokeParticle;
import net.mcreator.flyingstuff.client.particle.CloudSmoke1Particle;
import net.mcreator.flyingstuff.client.particle.CloudParticle;
import net.mcreator.flyingstuff.client.particle.CloudDetailedParticle;
import net.mcreator.flyingstuff.client.particle.CloudBig2Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier4Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier3Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier2Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier1Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier0Particle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD.get(), CloudParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.FIRE_LEAF.get(), FireLeafParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_DETAILED.get(), CloudDetailedParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_BIG_2.get(), CloudBig2Particle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.FAST.get(), FastParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.SNOWFALL_0.get(), Snowfall0Particle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.EMPTY.get(), EmptyParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_SMOKE.get(), CloudSmokeParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_SMOKE_1.get(), CloudSmoke1Particle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_BARRIER_0.get(), CloudBarrier0Particle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_BARRIER_1.get(), CloudBarrier1Particle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_BARRIER_2.get(), CloudBarrier2Particle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_BARRIER_3.get(), CloudBarrier3Particle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.CLOUD_BARRIER_4.get(), CloudBarrier4Particle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.ICE.get(), IceParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.TEMP_FIRE_PARTICLE.get(), TempFireParticleParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.WIND.get(), WindParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.FIREFLY.get(), FireflyParticle::provider);
		event.registerSpriteSet(FlyingStuffModParticleTypes.ITEM_BREAK.get(), ItemBreakParticle::provider);
	}
}
