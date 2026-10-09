package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.AridSkyLevel0ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.AridSkyLevel0ChestDisplayItem;

public class AridSkyLevel0ChestDisplayItemRenderer extends GeoItemRenderer<AridSkyLevel0ChestDisplayItem> {
	public AridSkyLevel0ChestDisplayItemRenderer() {
		super(new AridSkyLevel0ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(AridSkyLevel0ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
