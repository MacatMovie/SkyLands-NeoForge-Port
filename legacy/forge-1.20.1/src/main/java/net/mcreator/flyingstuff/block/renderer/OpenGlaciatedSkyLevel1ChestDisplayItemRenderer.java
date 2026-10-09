package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLevel1ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLevel1ChestDisplayItem;

public class OpenGlaciatedSkyLevel1ChestDisplayItemRenderer extends GeoItemRenderer<OpenGlaciatedSkyLevel1ChestDisplayItem> {
	public OpenGlaciatedSkyLevel1ChestDisplayItemRenderer() {
		super(new OpenGlaciatedSkyLevel1ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(OpenGlaciatedSkyLevel1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
