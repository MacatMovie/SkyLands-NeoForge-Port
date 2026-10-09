/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.flyingstuff as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.flyingstuff;

import net.custom.flyingstuff.entity.client.ModModelLayers;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;

import net.mcreator.flyingstuff.FlyingStuffModSigns;
import net.custom.flyingstuff.entity.client.ModBoatRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class FlyingStuffModBoatRenderingInit {

	@SubscribeEvent
	public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModModelLayers.GOLDENLEAVES_BOAT_LAYER, BoatModel::createBodyModel);
		event.registerLayerDefinition(ModModelLayers.GOLDENLEAVES_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

		event.registerLayerDefinition(ModModelLayers.GLACIATED_BOAT_LAYER, BoatModel::createBodyModel);
		event.registerLayerDefinition(ModModelLayers.GLACIATED_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

		event.registerLayerDefinition(ModModelLayers.LAVIC_BOAT_LAYER, BoatModel::createBodyModel);
		event.registerLayerDefinition(ModModelLayers.LAVIC_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

		event.registerLayerDefinition(ModModelLayers.INKY_BOAT_LAYER, BoatModel::createBodyModel);
		event.registerLayerDefinition(ModModelLayers.INKY_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
	}



	@SubscribeEvent
	public static void onclientSetup(FMLClientSetupEvent event) {
		EntityRenderers.register(FlyingStuffModSigns.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
		EntityRenderers.register(FlyingStuffModSigns.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
	}

}
