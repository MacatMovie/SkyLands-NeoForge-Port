package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenGoldenSkyLevel2ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel2ChestTileEntity;

public class OpenGoldenSkyLevel2ChestTileRenderer extends GeoBlockRenderer<OpenGoldenSkyLevel2ChestTileEntity> {
	public OpenGoldenSkyLevel2ChestTileRenderer() {
		super(new OpenGoldenSkyLevel2ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(OpenGoldenSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
