
package net.mcreator.flyingstuff.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.flyingstuff.entity.AridSkyAutomatonEntity;
import net.mcreator.flyingstuff.client.model.ModelAutomatondesert;

public class AridSkyAutomatonRenderer extends MobRenderer<AridSkyAutomatonEntity, ModelAutomatondesert<AridSkyAutomatonEntity>> {
	public AridSkyAutomatonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAutomatondesert(context.bakeLayer(ModelAutomatondesert.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AridSkyAutomatonEntity entity) {
		return new ResourceLocation("flying_stuff:textures/entities/desertic_sky_automaton.png");
	}
}
