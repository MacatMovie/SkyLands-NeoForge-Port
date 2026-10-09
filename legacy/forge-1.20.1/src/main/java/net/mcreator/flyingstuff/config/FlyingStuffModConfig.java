package net.mcreator.flyingstuff.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.mcreator.flyingstuff.config.serializer.GsonSerializer;

import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigBuilder;

import java.util.Map;
import java.util.HashMap;

public class FlyingStuffModConfig {
	public static final GsonSerializer serializer = new GsonSerializer("SkyLands-ClientConfig");
	public static Map<String, Object> entries = new HashMap<>();

	public static ConfigBuilder getConfigBuilder() {
		ConfigBuilder builder = ConfigBuilder.create().setTitle(Component.literal("FlyingStuffMod Config"));
		ConfigEntryBuilder entryBuilder = builder.entryBuilder();
		builder.setTitle(Component.literal("Sky Lands Configuration"));
		builder.setDefaultBackgroundTexture(new ResourceLocation("flying_stuff", "textures/block/skyrock.png"));
		builder.setShouldTabsSmoothScroll(true);
		builder.setShouldTabsSmoothScroll(true);
		ConfigCategory Clouds = builder.getOrCreateCategory(Component.literal("Clouds"));
		entries.putIfAbsent("CloudActiveBolean", true);
		FlyingStuffModVariables.CloudActiveBolean = entryBuilder.startBooleanToggle(Component.literal("Show The Custom Biome Clouds"), (boolean) entries.get("CloudActiveBolean")).setDefaultValue(true)
				.setTooltip(Component.literal("Could take some time for the cloud particles to despawn")).setSaveConsumer(newValue -> entries.put("CloudActiveBolean", newValue)).build();
		Clouds.addEntry(FlyingStuffModVariables.CloudActiveBolean);
		entries.putIfAbsent("CloudActiveOutside", true);
		FlyingStuffModVariables.CloudActiveOutside = entryBuilder.startBooleanToggle(Component.literal("Show The Custom Clouds Outside Sky Biomes"), (boolean) entries.get("CloudActiveOutside")).setDefaultValue(true)
				.setTooltip(Component.literal("Could take some time for the cloud particles to despawn")).setSaveConsumer(newValue -> entries.put("CloudActiveOutside", newValue)).build();
		Clouds.addEntry(FlyingStuffModVariables.CloudActiveOutside);
		entries.putIfAbsent("CloudDist", /*@int*/256);
		FlyingStuffModVariables.CloudDist = entryBuilder.startIntSlider(Component.literal("Custom Cloud Render Distance (In blocks)"), Double.valueOf(String.valueOf(entries.get("CloudDist"))).intValue(), /*@int*/64, /*@int*/2048)
				.setDefaultValue(/*@int*/256).setSaveConsumer(newValue -> entries.put("CloudDist", newValue)).build();
		Clouds.addEntry(FlyingStuffModVariables.CloudDist);
		entries.putIfAbsent("CloudBlockActive", true);
		FlyingStuffModVariables.CloudBlockActive = entryBuilder.startBooleanToggle(Component.literal("Show The Cloud Block Particles"), (boolean) entries.get("CloudBlockActive")).setDefaultValue(true)
				.setSaveConsumer(newValue -> entries.put("CloudBlockActive", newValue)).build();
		Clouds.addEntry(FlyingStuffModVariables.CloudBlockActive);
		builder.setSavingRunnable(() -> serializer.serialize(entries));
		return builder;
	}

	public static void setValue(String key, Object newValue) {
		entries.put(key, newValue);
		getConfigBuilder();
		serializer.serialize(entries);
	}
}
