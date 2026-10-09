package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GoldenSkyLevel1ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.GoldenSkyLevel1ChestDisplayItem;

public class GoldenSkyLevel1ChestDisplayItemRenderer extends GeoItemRenderer<GoldenSkyLevel1ChestDisplayItem> {
	public GoldenSkyLevel1ChestDisplayItemRenderer() {
		super(new GoldenSkyLevel1ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(GoldenSkyLevel1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
