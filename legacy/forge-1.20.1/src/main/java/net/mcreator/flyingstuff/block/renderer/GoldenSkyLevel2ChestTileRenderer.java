package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GoldenSkyLevel2ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel2ChestTileEntity;

public class GoldenSkyLevel2ChestTileRenderer extends GeoBlockRenderer<GoldenSkyLevel2ChestTileEntity> {
	public GoldenSkyLevel2ChestTileRenderer() {
		super(new GoldenSkyLevel2ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(GoldenSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
