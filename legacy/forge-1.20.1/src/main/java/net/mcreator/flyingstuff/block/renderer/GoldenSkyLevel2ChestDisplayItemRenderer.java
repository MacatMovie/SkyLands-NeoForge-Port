package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GoldenSkyLevel2ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.GoldenSkyLevel2ChestDisplayItem;

public class GoldenSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<GoldenSkyLevel2ChestDisplayItem> {
	public GoldenSkyLevel2ChestDisplayItemRenderer() {
		super(new GoldenSkyLevel2ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(GoldenSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
