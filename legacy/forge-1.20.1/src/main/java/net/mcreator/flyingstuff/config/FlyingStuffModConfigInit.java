package net.mcreator.flyingstuff.config;

import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.Level;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory;

import net.mcreator.flyingstuff.FlyingStuffMod;

import java.util.Map;
import java.util.HashMap;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(modid = "flying_stuff", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModConfigInit {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> ModLoadingContext.get().registerExtensionPoint(ConfigScreenFactory.class, () -> new ConfigScreenFactory((client, screen) -> FlyingStuffModConfig.getConfigBuilder().setParentScreen(screen).build())));
	}

	@SubscribeEvent
	public static void clientSetup(FMLCommonSetupEvent event) {
		Map<String, Object> entries = FlyingStuffModConfig.serializer.deserialize();
		FlyingStuffModConfig.entries = entries == null ? new HashMap<>() : entries;
		FlyingStuffModConfig.getConfigBuilder();
		FlyingStuffModConfig.serializer.serialize(FlyingStuffModConfig.entries);
		FlyingStuffMod.LOGGER.atLevel(Level.DEBUG).withMarker(MarkerManager.getMarker("CONFIG")).log(FlyingStuffModConfig.serializer.getMessage());
	}
}
