package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.LavicSkyLvl1ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.LavicSkyLvl1ChestTileEntity;

public class LavicSkyLvl1ChestTileRenderer extends GeoBlockRenderer<LavicSkyLvl1ChestTileEntity> {
	public LavicSkyLvl1ChestTileRenderer() {
		super(new LavicSkyLvl1ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(LavicSkyLvl1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
