package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenAridSkyLevel2ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel2ChestTileEntity;

public class OpenAridSkyLevel2ChestTileRenderer extends GeoBlockRenderer<OpenAridSkyLevel2ChestTileEntity> {
	public OpenAridSkyLevel2ChestTileRenderer() {
		super(new OpenAridSkyLevel2ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(OpenAridSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
