package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenGoldenSkyLevel2ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.OpenGoldenSkyLevel2ChestDisplayItem;

public class OpenGoldenSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<OpenGoldenSkyLevel2ChestDisplayItem> {
	public OpenGoldenSkyLevel2ChestDisplayItemRenderer() {
		super(new OpenGoldenSkyLevel2ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(OpenGoldenSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
