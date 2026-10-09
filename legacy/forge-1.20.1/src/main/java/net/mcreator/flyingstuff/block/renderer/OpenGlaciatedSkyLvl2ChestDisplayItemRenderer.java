package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLvl2ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLvl2ChestDisplayItem;

public class OpenGlaciatedSkyLvl2ChestDisplayItemRenderer extends GeoItemRenderer<OpenGlaciatedSkyLvl2ChestDisplayItem> {
	public OpenGlaciatedSkyLvl2ChestDisplayItemRenderer() {
		super(new OpenGlaciatedSkyLvl2ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(OpenGlaciatedSkyLvl2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
