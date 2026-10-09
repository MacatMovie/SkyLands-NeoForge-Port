package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenGoldenSkyLevel1ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel1ChestTileEntity;

public class OpenGoldenSkyLevel1ChestTileRenderer extends GeoBlockRenderer<OpenGoldenSkyLevel1ChestTileEntity> {
	public OpenGoldenSkyLevel1ChestTileRenderer() {
		super(new OpenGoldenSkyLevel1ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(OpenGoldenSkyLevel1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
