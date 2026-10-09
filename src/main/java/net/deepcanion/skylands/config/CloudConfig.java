package net.deepcanion.skylands.config;

import net.neoforged.neoforge.common.ModConfigSpec;

/** Client preferences only; contains no client classes so servers can load the mod. */
public final class CloudConfig {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.BooleanValue SKY_BIOME_CLOUDS;
    public static final ModConfigSpec.BooleanValue OUTSIDE_CLOUDS;
    public static final ModConfigSpec.BooleanValue CLOUD_BLOCK_PARTICLES;
    public static final ModConfigSpec.IntValue CLOUD_DISTANCE;
    public static final ModConfigSpec.DoubleValue CLOUD_DENSITY;
    public static final ModConfigSpec.IntValue MAX_CLOUD_PARTICLES;

    public static final ModConfigSpec.IntValue SKY_CLOUD_MIN_Y;
    public static final ModConfigSpec.IntValue SKY_CLOUD_MAX_Y;
    public static final ModConfigSpec.IntValue OUTSIDE_CLOUD_MIN_Y;
    public static final ModConfigSpec.IntValue OUTSIDE_CLOUD_MAX_Y;

    public static final ModConfigSpec.BooleanValue HIGH_ALTITUDE_WIND;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.push("clouds");
        SKY_BIOME_CLOUDS = builder.comment("Show drifting clouds over Sky Lands biomes.")
                .translation("flying_stuff.configuration.skyBiomeClouds").define("skyBiomeClouds", true);
        OUTSIDE_CLOUDS = builder.comment("Show drifting clouds over other Overworld biomes. Independent of the Sky biome setting.")
                .translation("flying_stuff.configuration.outsideClouds").define("outsideClouds", true);
        CLOUD_DISTANCE = builder.comment("Horizontal cloud range in blocks. Spawning is limited to loaded chunks and your render distance.")
                .translation("flying_stuff.configuration.cloudDistance").defineInRange("cloudDistance", 256, 64, 2048);
        SKY_CLOUD_MIN_Y = builder.comment("Minimum possible Sky biome cloud Y. Default 100 avoids low ground/underground clouds. Noise distribution is not uniform. Reversed min/max values are treated as swapped.")
                .translation("flying_stuff.configuration.skyCloudMinY").defineInRange("skyCloudMinY", 100, -2048, 2048);
        SKY_CLOUD_MAX_Y = builder.comment("Maximum possible Sky biome cloud Y. Default 660 preserves the original upper bound; cosmetic particles can appear above the build ceiling.")
                .translation("flying_stuff.configuration.skyCloudMaxY").defineInRange("skyCloudMaxY", 660, -2048, 2048);
        OUTSIDE_CLOUD_MIN_Y = builder.comment("Minimum possible cloud Y outside Sky biomes. Default 190 preserves the original 310 + noise * 120 formula.")
                .translation("flying_stuff.configuration.outsideCloudMinY").defineInRange("outsideCloudMinY", 190, -2048, 2048);
        OUTSIDE_CLOUD_MAX_Y = builder.comment("Maximum possible cloud Y outside Sky biomes. Default 430 preserves the original formula. Equal endpoints make a single cloud layer.")
                .translation("flying_stuff.configuration.outsideCloudMaxY").defineInRange("outsideCloudMaxY", 430, -2048, 2048);
        CLOUD_DENSITY = builder.comment("Clouds per cluster relative to the default. The particle limit still applies.")
                .translation("flying_stuff.configuration.cloudDensity").defineInRange("cloudDensity", 1.0, 0.25, 2.0);
        MAX_CLOUD_PARTICLES = builder.comment("Maximum ambient Sky Lands cloud particles tracked by this client. Lower this to reduce rendering cost.")
                .translation("flying_stuff.configuration.maxCloudParticles").defineInRange("maxCloudParticles", 192, 32, 512);
        CLOUD_BLOCK_PARTICLES = builder.comment("Show small puffs emitted by Cloud Blocks. Existing puffs fade naturally when disabled.")
                .translation("flying_stuff.configuration.cloudBlockParticles").define("cloudBlockParticles", true);
        builder.pop();
        builder.push("ambientEffects");
        HIGH_ALTITUDE_WIND = builder.comment("Show the original lightweight wind streaks above Y=195 in the Overworld. Disable if you prefer another mod's wind visuals.")
                .translation("flying_stuff.configuration.highAltitudeWind").define("highAltitudeWind", true);
        builder.pop();
        SPEC = builder.build();
    }

    private CloudConfig() { }
}
