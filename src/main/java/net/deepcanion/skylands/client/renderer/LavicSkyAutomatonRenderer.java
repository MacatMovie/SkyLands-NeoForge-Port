
package net.deepcanion.skylands.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.deepcanion.skylands.entity.LavicSkyAutomatonEntity;
import net.deepcanion.skylands.client.model.ModelAutomaton;

public class LavicSkyAutomatonRenderer extends MobRenderer<LavicSkyAutomatonEntity, ModelAutomaton<LavicSkyAutomatonEntity>> {
	public LavicSkyAutomatonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAutomaton<>(context.bakeLayer(ModelAutomaton.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LavicSkyAutomatonEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/lavic_sky_automaton.png");
	}
}
