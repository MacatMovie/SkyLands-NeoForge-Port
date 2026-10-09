package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GlaciatedSkyLevel1ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel1ChestTileEntity;

public class GlaciatedSkyLevel1ChestTileRenderer extends GeoBlockRenderer<GlaciatedSkyLevel1ChestTileEntity> {
	public GlaciatedSkyLevel1ChestTileRenderer() {
		super(new GlaciatedSkyLevel1ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(GlaciatedSkyLevel1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
