package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.OpenLavicSkyLvl1ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.OpenLavicSkyLvl1ChestTileEntity;

public class OpenLavicSkyLvl1ChestTileRenderer extends GeoBlockRenderer<OpenLavicSkyLvl1ChestTileEntity> {
	public OpenLavicSkyLvl1ChestTileRenderer() {
		super(new OpenLavicSkyLvl1ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(OpenLavicSkyLvl1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
