package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenLavicSkyLvl1ChestDisplayModel;
import net.mcreator.flyingstuff.block.display.OpenLavicSkyLvl1ChestDisplayItem;

public class OpenLavicSkyLvl1ChestDisplayItemRenderer extends GeoItemRenderer<OpenLavicSkyLvl1ChestDisplayItem> {
	public OpenLavicSkyLvl1ChestDisplayItemRenderer() {
		super(new OpenLavicSkyLvl1ChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(OpenLavicSkyLvl1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
