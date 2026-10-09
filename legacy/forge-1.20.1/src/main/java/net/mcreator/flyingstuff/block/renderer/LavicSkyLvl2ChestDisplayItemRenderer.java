package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.LavicSkyLvl2ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.LavicSkyLvl2ChestDisplayItem;

public class LavicSkyLvl2ChestDisplayItemRenderer extends GeoItemRenderer<LavicSkyLvl2ChestDisplayItem> {
	public LavicSkyLvl2ChestDisplayItemRenderer() {
		super(new LavicSkyLvl2ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(LavicSkyLvl2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
