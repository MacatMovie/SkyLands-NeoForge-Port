
package net.mcreator.flyingstuff.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.flyingstuff.entity.SkyAutomatonEntity;
import net.mcreator.flyingstuff.client.model.ModelAutomaton;

public class SkyAutomatonRenderer extends MobRenderer<SkyAutomatonEntity, ModelAutomaton<SkyAutomatonEntity>> {
	public SkyAutomatonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAutomaton(context.bakeLayer(ModelAutomaton.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkyAutomatonEntity entity) {
		return new ResourceLocation("flying_stuff:textures/entities/sky_automaton.png");
	}
}
