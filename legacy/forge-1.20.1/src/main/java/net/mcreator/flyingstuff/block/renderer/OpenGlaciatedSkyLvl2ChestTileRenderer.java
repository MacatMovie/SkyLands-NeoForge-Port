package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLvl2ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLvl2ChestTileEntity;

public class OpenGlaciatedSkyLvl2ChestTileRenderer extends GeoBlockRenderer<OpenGlaciatedSkyLvl2ChestTileEntity> {
	public OpenGlaciatedSkyLvl2ChestTileRenderer() {
		super(new OpenGlaciatedSkyLvl2ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(OpenGlaciatedSkyLvl2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
