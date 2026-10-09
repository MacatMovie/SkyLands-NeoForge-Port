package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GoldenSkyLevel1ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel1ChestTileEntity;

public class GoldenSkyLevel1ChestTileRenderer extends GeoBlockRenderer<GoldenSkyLevel1ChestTileEntity> {
	public GoldenSkyLevel1ChestTileRenderer() {
		super(new GoldenSkyLevel1ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(GoldenSkyLevel1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
