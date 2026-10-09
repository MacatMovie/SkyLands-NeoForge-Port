package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenAridSkyLevel0ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.OpenAridSkyLevel0ChestDisplayItem;

public class OpenAridSkyLevel0ChestDisplayItemRenderer extends GeoItemRenderer<OpenAridSkyLevel0ChestDisplayItem> {
	public OpenAridSkyLevel0ChestDisplayItemRenderer() {
		super(new OpenAridSkyLevel0ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(OpenAridSkyLevel0ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
