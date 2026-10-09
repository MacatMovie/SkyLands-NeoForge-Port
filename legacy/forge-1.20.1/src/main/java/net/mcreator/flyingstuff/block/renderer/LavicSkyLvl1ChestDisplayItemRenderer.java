package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.LavicSkyLvl1ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.LavicSkyLvl1ChestDisplayItem;

public class LavicSkyLvl1ChestDisplayItemRenderer extends GeoItemRenderer<LavicSkyLvl1ChestDisplayItem> {
	public LavicSkyLvl1ChestDisplayItemRenderer() {
		super(new LavicSkyLvl1ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(LavicSkyLvl1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
