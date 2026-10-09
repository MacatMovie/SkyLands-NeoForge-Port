
package net.deepcanion.skylands.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.deepcanion.skylands.entity.GlaciatedSkyAutomatonEntity;
import net.deepcanion.skylands.client.model.ModelAutomaton_boss;

public class GlaciatedSkyAutomatonRenderer extends MobRenderer<GlaciatedSkyAutomatonEntity, ModelAutomaton_boss<GlaciatedSkyAutomatonEntity>> {
	public GlaciatedSkyAutomatonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAutomaton_boss(context.bakeLayer(ModelAutomaton_boss.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GlaciatedSkyAutomatonEntity entity) {
		return ResourceLocation.parse("flying_stuff:textures/entities/sky_automaton_ice.png");
	}
}
