
package net.mcreator.flyingstuff.client.particle;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;

@OnlyIn(Dist.CLIENT)
public class CloudBarrier3Particle extends TextureSheetParticle {
	public static CloudBarrier3ParticleProvider provider(SpriteSet spriteSet) {
		return new CloudBarrier3ParticleProvider(spriteSet);
	}

	public static class CloudBarrier3ParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public CloudBarrier3ParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new CloudBarrier3Particle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected CloudBarrier3Particle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(80f, 80f);
		this.quadSize *= 86f;
		this.lifetime = Math.max(1, 1000 + (this.random.nextInt(10) - 5));
		this.friction = 0.995f;
		this.gravity = 0f;
		this.hasPhysics = false;
		this.alpha = 0.0f;
		this.xd = vx * 1;
		this.yd = vy * 1;
		this.zd = vz * 1;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
		super.tick();
		this.alpha = Mth.clamp(((float)this.age / (float)this.lifetime) * 2.0f - 0.1f, 0.0f, 1.0f) * (1.0f - Mth.clamp(((float)this.age / (float)this.lifetime) * 2.0f, 0.0f, 1.0f)) * 3.5f; 
	}
}
