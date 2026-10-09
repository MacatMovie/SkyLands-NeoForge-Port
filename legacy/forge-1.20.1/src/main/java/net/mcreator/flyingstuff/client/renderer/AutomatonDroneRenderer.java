
package net.mcreator.flyingstuff.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.flyingstuff.entity.AutomatonDroneEntity;
import net.mcreator.flyingstuff.client.model.Modelhovering_automaton;

public class AutomatonDroneRenderer extends MobRenderer<AutomatonDroneEntity, Modelhovering_automaton<AutomatonDroneEntity>> {
	public AutomatonDroneRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelhovering_automaton(context.bakeLayer(Modelhovering_automaton.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(AutomatonDroneEntity entity) {
		return new ResourceLocation("flying_stuff:textures/entities/drone_automaton.png");
	}
}
