package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.AridSkyLevel2ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.AridSkyLevel2ChestDisplayItem;

public class AridSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<AridSkyLevel2ChestDisplayItem> {
	public AridSkyLevel2ChestDisplayItemRenderer() {
		super(new AridSkyLevel2ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(AridSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
