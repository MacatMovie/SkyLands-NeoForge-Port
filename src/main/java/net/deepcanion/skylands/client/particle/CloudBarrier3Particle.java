package net.deepcanion.skylands.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;

/** Original large cloud artwork and drift, with a fade across its entire lifetime. */
public final class CloudBarrier3Particle extends TextureSheetParticle {
    private boolean skyBiome;
    private final long spawnTick;

    public static ParticleProvider<SimpleParticleType> provider(SpriteSet sprites) {
        return (type, level, x, y, z, vx, vy, vz) -> new CloudBarrier3Particle(level, x, y, z, vx, vy, vz, sprites);
    }

    private CloudBarrier3Particle(ClientLevel level, double x, double y, double z,
                                  double vx, double vy, double vz, SpriteSet sprites) {
        super(level, x, y, z);
        setSize(80F, 80F);
        quadSize *= 86F;
        lifetime = 995 + random.nextInt(10);
        friction = 0.995F;
        gravity = 0F;
        hasPhysics = false;
        alpha = 0F;
        xd = vx;
        yd = vy;
        zd = vz;
        spawnTick = level.getGameTime();
        pickSprite(sprites);
    }

    public void setSkyBiome(boolean skyBiome) { this.skyBiome = skyBiome; }
    public boolean isSkyBiome() { return skyBiome; }
    public double height() { return y; }
    public long spawnTick() { return spawnTick; }
    public double horizontalDistanceSqr(double px, double pz) {
        double dx = x - px, dz = z - pz;
        return dx * dx + dz * dz;
    }

    @Override public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    /**
     * Treat clouds as exposed to the sky, regardless of island ceilings.
     * FULL_SKY has zero block light: the normal lightmap still dims with the
     * day/night cycle instead of keeping these cosmetic clouds emissive.
     */
    @Override public int getLightColor(float partialTick) {
        return net.minecraft.client.renderer.LightTexture.FULL_SKY;
    }

    @Override public void tick() {
        super.tick();
        alpha = 0.85F * Math.min(Mth.clamp(age / 80F, 0F, 1F),
                Mth.clamp((lifetime - age) / 120F, 0F, 1F));
    }
}
