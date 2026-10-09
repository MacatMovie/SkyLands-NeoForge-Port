
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.flyingstuff.client.model.Modelsky_boss0;
import net.mcreator.flyingstuff.client.model.Modelhovering_automaton;
import net.mcreator.flyingstuff.client.model.Modelfvex;
import net.mcreator.flyingstuff.client.model.ModelAutomatondesert;
import net.mcreator.flyingstuff.client.model.ModelAutomaton_boss;
import net.mcreator.flyingstuff.client.model.ModelAutomaton;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class FlyingStuffModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelfvex.LAYER_LOCATION, Modelfvex::createBodyLayer);
		event.registerLayerDefinition(ModelAutomatondesert.LAYER_LOCATION, ModelAutomatondesert::createBodyLayer);
		event.registerLayerDefinition(ModelAutomaton_boss.LAYER_LOCATION, ModelAutomaton_boss::createBodyLayer);
		event.registerLayerDefinition(Modelhovering_automaton.LAYER_LOCATION, Modelhovering_automaton::createBodyLayer);
		event.registerLayerDefinition(ModelAutomaton.LAYER_LOCATION, ModelAutomaton::createBodyLayer);
		event.registerLayerDefinition(Modelsky_boss0.LAYER_LOCATION, Modelsky_boss0::createBodyLayer);
	}
}
