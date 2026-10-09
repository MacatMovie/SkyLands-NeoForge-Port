package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GlaciatedSkyLevel2ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.GlaciatedSkyLevel2ChestDisplayItem;

public class GlaciatedSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<GlaciatedSkyLevel2ChestDisplayItem> {
	public GlaciatedSkyLevel2ChestDisplayItemRenderer() {
		super(new GlaciatedSkyLevel2ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(GlaciatedSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
