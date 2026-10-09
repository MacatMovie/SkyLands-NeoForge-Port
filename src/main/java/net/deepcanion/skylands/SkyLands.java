package net.deepcanion.skylands;

import com.mojang.logging.LogUtils;
import net.deepcanion.skylands.registry.ModBlocks;
import net.deepcanion.skylands.registry.ModEntities;
import net.deepcanion.skylands.registry.ModEffects;
import net.deepcanion.skylands.registry.ModParticles;
import net.deepcanion.skylands.entity.CombatEvents;
import net.deepcanion.skylands.registry.ModWorldgen;
import net.deepcanion.skylands.registry.ModSounds;
import net.deepcanion.skylands.worldgen.SkyWorldgenSetup;
import net.deepcanion.skylands.registry.ContentSetup;
import net.deepcanion.skylands.registry.ModCreativeTabs;
import net.deepcanion.skylands.registry.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import org.slf4j.Logger;

/** Common entry point. Never references a client class or an inactive subsystem. */
@Mod(SkyLands.MOD_ID)
public final class SkyLands {
    public static final String MOD_ID = "flying_stuff";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SkyLands(IEventBus modBus, net.neoforged.fml.ModContainer container) {
        container.registerConfig(net.neoforged.fml.config.ModConfig.Type.CLIENT,
                net.deepcanion.skylands.config.CloudConfig.SPEC);
        net.deepcanion.skylands.registry.ModFluids.TYPES.register(modBus);
        net.deepcanion.skylands.registry.ModFluids.FLUIDS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        net.deepcanion.skylands.registry.ModBlockEntities.TYPES.register(modBus);
        net.deepcanion.skylands.registry.ModMenus.MENUS.register(modBus);
        modBus.addListener(net.deepcanion.skylands.registry.ModBlockEntities::capabilities);
        ModEntities.register(modBus);
        ModEffects.EFFECTS.register(modBus);
        ModParticles.PARTICLES.register(modBus);
        NeoForge.EVENT_BUS.addListener(CombatEvents::target);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.item.SkySwordRecovery::broken);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.item.SkySwordRecovery::tick);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.item.SkySwordRecovery::logout);
        ModItems.ITEMS.register(modBus);
        net.deepcanion.skylands.registry.ModVillagers.POI_TYPES.register(modBus);
        net.deepcanion.skylands.registry.ModVillagers.PROFESSIONS.register(modBus);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.registry.ModVillagers::trades);
        ModCreativeTabs.TABS.register(modBus);
        ModWorldgen.FEATURES.register(modBus);
        ModSounds.SOUNDS.register(modBus);
        modBus.addListener(net.deepcanion.skylands.glider.FlightAnimationPayload::register);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.glider.FlightAnimationState::tracking);
        modBus.addListener(net.deepcanion.skylands.glider.FreefallPayload::register);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.glider.FreefallFlight::login);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.glider.FreefallFlight::respawn);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.glider.FreefallFlight::dimensionChange);
        modBus.addListener(net.deepcanion.skylands.glider.GliderPayload::register);
        NeoForge.EVENT_BUS.addListener(net.deepcanion.skylands.glider.GliderFlight::tick);
        modBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.addListener(this::serverStarted);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ContentSetup.registerFireBehavior();
            SkyWorldgenSetup.register();
        });
        LOGGER.info("[Sky Lands] Unofficial Port v0.9.0 common setup complete: {} blocks, {} items. Overworld worldgen active; dimension port pending.",
                ModBlocks.BLOCKS.getEntries().size(), ModItems.ITEMS.getEntries().size());
    }

    private void serverStarted(ServerStartedEvent event) {
        LOGGER.info("[Sky Lands] Unofficial Port v0.9.0 server started.");
    }
}
