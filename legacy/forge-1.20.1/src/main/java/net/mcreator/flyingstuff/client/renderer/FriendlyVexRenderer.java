
package net.mcreator.flyingstuff.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.flyingstuff.entity.FriendlyVexEntity;
import net.mcreator.flyingstuff.client.model.Modelfvex;

public class FriendlyVexRenderer extends MobRenderer<FriendlyVexEntity, Modelfvex<FriendlyVexEntity>> {
	public FriendlyVexRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfvex(context.bakeLayer(Modelfvex.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FriendlyVexEntity entity) {
		return new ResourceLocation("flying_stuff:textures/entities/friendlyvex.png");
	}
}
