package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenGoldenSkyLevel1ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.OpenGoldenSkyLevel1ChestDisplayItem;

public class OpenGoldenSkyLevel1ChestDisplayItemRenderer extends GeoItemRenderer<OpenGoldenSkyLevel1ChestDisplayItem> {
	public OpenGoldenSkyLevel1ChestDisplayItemRenderer() {
		super(new OpenGoldenSkyLevel1ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(OpenGoldenSkyLevel1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
