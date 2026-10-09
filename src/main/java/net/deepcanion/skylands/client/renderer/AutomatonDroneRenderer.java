
package net.deepcanion.skylands.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.deepcanion.skylands.entity.AutomatonDroneEntity;
import net.deepcanion.skylands.client.model.Modelhovering_automaton;

public class AutomatonDroneRenderer extends MobRenderer<AutomatonDroneEntity, Modelhovering_automaton<AutomatonDroneEntity>> {
	public AutomatonDroneRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelhovering_automaton(context.bakeLayer(Modelhovering_automaton.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(AutomatonDroneEntity entity) {
		return ResourceLocation.parse("flying_stuff:textures/entities/drone_automaton.png");
	}
}
