package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GlaciatedSkyLevel2ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel2ChestTileEntity;

public class GlaciatedSkyLevel2ChestTileRenderer extends GeoBlockRenderer<GlaciatedSkyLevel2ChestTileEntity> {
	public GlaciatedSkyLevel2ChestTileRenderer() {
		super(new GlaciatedSkyLevel2ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(GlaciatedSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
