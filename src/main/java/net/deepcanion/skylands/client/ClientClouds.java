package net.deepcanion.skylands.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.client.particle.CloudBarrier3Particle;
import net.deepcanion.skylands.config.CloudConfig;
import net.deepcanion.skylands.registry.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import net.neoforged.neoforge.client.event.ClientTickEvent;

/** One bounded cosmetic cloud field per client, independent of server/player count. */
public final class ClientClouds {
    private static final TagKey<Biome> CLOUD_BIOMES = TagKey.create(Registries.BIOME, SkyLands.id("custom_clouds"));
    // Legacy changed the permutation each player tick. Cache a bank once and select
    // one per cluster to retain vertical variation without per-tick construction.
    private static final SimplexNoise[] NOISE_FIELDS = createNoiseFields();
    private static final List<CloudBarrier3Particle> CLOUDS = new ArrayList<>();
    private static ClientLevel previousLevel;
    private static long lastSpawnTick = Long.MIN_VALUE;

    public static void tick(ClientTickEvent.Post event) {
        Minecraft client = Minecraft.getInstance();
        ClientLevel level = client.level;
        if (level != previousLevel) {
            clear();
            previousLevel = level;
            lastSpawnTick = Long.MIN_VALUE;
        }
        if (level == null || client.player == null || !CloudConfig.SPEC.isLoaded()) return;
        if (!Level.OVERWORLD.equals(level.dimension())) {
            clear();
            return;
        }
        if (client.isPaused()) return;
        boolean skyEnabled = CloudConfig.SKY_BIOME_CLOUDS.get();
        boolean outsideEnabled = CloudConfig.OUTSIDE_CLOUDS.get();
        int distance = CloudConfig.CLOUD_DISTANCE.get();
        int maximum = CloudConfig.MAX_CLOUD_PARTICLES.get();
        int skyMin = Math.min(CloudConfig.SKY_CLOUD_MIN_Y.get(), CloudConfig.SKY_CLOUD_MAX_Y.get());
        int skyMax = Math.max(CloudConfig.SKY_CLOUD_MIN_Y.get(), CloudConfig.SKY_CLOUD_MAX_Y.get());
        int outsideMin = Math.min(CloudConfig.OUTSIDE_CLOUD_MIN_Y.get(), CloudConfig.OUTSIDE_CLOUD_MAX_Y.get());
        int outsideMax = Math.max(CloudConfig.OUTSIDE_CLOUD_MIN_Y.get(), CloudConfig.OUTSIDE_CLOUD_MAX_Y.get());
        double px = client.player.getX(), pz = client.player.getZ();
        long now = level.getGameTime();
        Iterator<CloudBarrier3Particle> iterator = CLOUDS.iterator();
        while (iterator.hasNext()) {
            CloudBarrier3Particle cloud = iterator.next();
            int minY = cloud.isSkyBiome() ? skyMin : outsideMin;
            int maxY = cloud.isSkyBiome() ? skyMax : outsideMax;
            if (cloud.height() < minY || cloud.height() > maxY || !cloud.isAlive() || now - cloud.spawnTick() > 1200
                    || cloud.horizontalDistanceSqr(px, pz) > (double) distance * distance
                    || !(cloud.isSkyBiome() ? skyEnabled : outsideEnabled)) {
                cloud.remove();
                iterator.remove();
            }
        }
        while (CLOUDS.size() > maximum) CLOUDS.remove(0).remove();
        if ((!skyEnabled && !outsideEnabled) || CLOUDS.size() >= maximum) return;
        if (lastSpawnTick != Long.MIN_VALUE && now - lastSpawnTick < 20) return;
        lastSpawnTick = now;
        double range = Math.min(distance, client.options.getEffectiveRenderDistance() * 16.0);
        RandomSource random = level.random;
        double centerX = px + (random.nextDouble() * 2 - 1) * range * 0.75;
        double centerZ = pz + (random.nextDouble() * 2 - 1) * range * 0.75;
        int sampleY = client.player.getBlockY();
        BlockPos center = BlockPos.containing(centerX, sampleY, centerZ);
        if (!level.hasChunkAt(center)) return;
        boolean skyBiome = level.getBiome(center).is(CLOUD_BIOMES);
        if (skyBiome ? !skyEnabled : !outsideEnabled || random.nextFloat() >= 0.35F) return;
        SimplexNoise noise = NOISE_FIELDS[random.nextInt(NOISE_FIELDS.length)];
        int clusterSize = Math.max(1, (int) Math.round(8 * CloudConfig.CLOUD_DENSITY.get()));
        for (int i = 0; i < clusterSize && CLOUDS.size() < maximum; i++) {
            double x = centerX + (random.nextDouble() * 2 - 1) * (skyBiome ? 35 : 32);
            double z = centerZ + (random.nextDouble() * 2 - 1) * (skyBiome ? 22 : 20);
            if ((x - px) * (x - px) + (z - pz) * (z - pz) > range * range) continue;
            BlockPos sample = BlockPos.containing(x, sampleY, z);
            if (!level.hasChunkAt(sample)) continue;
            // At biome borders, do not emit into a category that the user has disabled.
            boolean localSky = level.getBiome(sample).is(CLOUD_BIOMES);
            if (!(localSky ? skyEnabled : outsideEnabled)) continue;
            double noiseValue = noise.getValue(x / (localSky ? 12000.0 : 11000.0), z / 16000.0);
            int minY = localSky ? skyMin : outsideMin;
            int maxY = localSky ? skyMax : outsideMax;
            double y = (minY + maxY) / 2.0 + net.minecraft.util.Mth.clamp(noiseValue, -1.0, 1.0) * (maxY - minY) / 2.0;
            // Direct creation avoids vanilla's short particle spawn-distance limit.
            Particle particle = client.particleEngine.createParticle(ModParticles.CLOUD_BARRIER_3.get(), x, y, z, 0.1, 0, 0.06);
            if (particle instanceof CloudBarrier3Particle cloud) {
                cloud.setSkyBiome(localSky);
                CLOUDS.add(cloud);
            }
        }
    }

    private static SimplexNoise[] createNoiseFields() {
        RandomSource source = RandomSource.create(0x534b594c414e4453L);
        SimplexNoise[] fields = new SimplexNoise[64];
        for (int i = 0; i < fields.length; i++) fields[i] = new SimplexNoise(source);
        return fields;
    }

    private static void clear() {
        CLOUDS.forEach(CloudBarrier3Particle::remove);
        CLOUDS.clear();
    }

    private ClientClouds() { }
}
