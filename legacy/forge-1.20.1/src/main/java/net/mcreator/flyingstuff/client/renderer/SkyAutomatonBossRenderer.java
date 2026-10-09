
package net.mcreator.flyingstuff.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.flyingstuff.entity.SkyAutomatonBossEntity;
import net.mcreator.flyingstuff.client.model.Modelsky_boss0;

public class SkyAutomatonBossRenderer extends MobRenderer<SkyAutomatonBossEntity, Modelsky_boss0<SkyAutomatonBossEntity>> {
	public SkyAutomatonBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsky_boss0(context.bakeLayer(Modelsky_boss0.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkyAutomatonBossEntity entity) {
		return new ResourceLocation("flying_stuff:textures/entities/boss.png");
	}
}
