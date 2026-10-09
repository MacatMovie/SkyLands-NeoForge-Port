
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
public class CloudParticle extends TextureSheetParticle {
	public static CloudParticleProvider provider(SpriteSet spriteSet) {
		return new CloudParticleProvider(spriteSet);
	}

	public static class CloudParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public CloudParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new CloudParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected CloudParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(4f, 4f);
		this.quadSize *= 8f;
		this.lifetime = (int) Math.max(1, 360 + (this.random.nextInt(360) - 180));
		this.gravity = 0f;
		this.alpha = 0.0f;
		this.hasPhysics = false;
		this.xd = vx * 0.02;
		this.yd = vy * 0.02;
		this.zd = vz * 0.02;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
		super.tick();
		this.alpha = Mth.clamp(((float)this.age / (float)this.lifetime) * 2.0f - 0.1f, 0.0f, 1.0f) * (1.0f - Mth.clamp(((float)this.age / (float)this.lifetime) * 2.0f, 0.0f, 1.0f)) * 4.0f;
	}
}
