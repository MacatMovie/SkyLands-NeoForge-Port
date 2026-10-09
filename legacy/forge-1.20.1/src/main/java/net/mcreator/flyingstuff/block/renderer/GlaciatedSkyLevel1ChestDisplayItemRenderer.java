package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GlaciatedSkyLevel1ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.GlaciatedSkyLevel1ChestDisplayItem;

public class GlaciatedSkyLevel1ChestDisplayItemRenderer extends GeoItemRenderer<GlaciatedSkyLevel1ChestDisplayItem> {
	public GlaciatedSkyLevel1ChestDisplayItemRenderer() {
		super(new GlaciatedSkyLevel1ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(GlaciatedSkyLevel1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
