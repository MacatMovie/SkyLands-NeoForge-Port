package net.mcreator.flyingstuff;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.flyingstuff.world.features.StructureFeature;
import net.mcreator.flyingstuff.init.FlyingStuffModVillagerProfessions;
import net.mcreator.flyingstuff.init.FlyingStuffModTabs;
import net.mcreator.flyingstuff.init.FlyingStuffModSounds;
import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModPaintings;
import net.mcreator.flyingstuff.init.FlyingStuffModMobEffects;
import net.mcreator.flyingstuff.init.FlyingStuffModMenus;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.mcreator.flyingstuff.init.FlyingStuffModFluids;
import net.mcreator.flyingstuff.init.FlyingStuffModFluidTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModFeatures;
import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModEnchantments;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("flying_stuff")
public class FlyingStuffMod {
	public static final Logger LOGGER = LogManager.getLogger(FlyingStuffMod.class);
	public static final String MODID = "flying_stuff";

	public FlyingStuffMod() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		FlyingStuffModSounds.REGISTRY.register(bus);
		FlyingStuffModBlocks.REGISTRY.register(bus);
		FlyingStuffModBlockEntities.REGISTRY.register(bus);
		FlyingStuffModItems.REGISTRY.register(bus);
		FlyingStuffModEntities.REGISTRY.register(bus);
		FlyingStuffModEnchantments.REGISTRY.register(bus);
		FlyingStuffModTabs.REGISTRY.register(bus);
		FlyingStuffModFeatures.REGISTRY.register(bus);
		StructureFeature.REGISTRY.register(bus);
		FlyingStuffModMobEffects.REGISTRY.register(bus);

		FlyingStuffModPaintings.REGISTRY.register(bus);
		FlyingStuffModParticleTypes.REGISTRY.register(bus);
		FlyingStuffModVillagerProfessions.PROFESSIONS.register(bus);
		FlyingStuffModMenus.REGISTRY.register(bus);
		FlyingStuffModFluids.REGISTRY.register(bus);
		FlyingStuffModFluidTypes.REGISTRY.register(bus);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
