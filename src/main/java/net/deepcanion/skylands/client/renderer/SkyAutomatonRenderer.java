
package net.deepcanion.skylands.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.deepcanion.skylands.entity.SkyAutomatonEntity;
import net.deepcanion.skylands.client.model.ModelAutomaton;

public class SkyAutomatonRenderer extends MobRenderer<SkyAutomatonEntity, ModelAutomaton<SkyAutomatonEntity>> {
	public SkyAutomatonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAutomaton<>(context.bakeLayer(ModelAutomaton.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkyAutomatonEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/sky_automaton.png");
	}
}
