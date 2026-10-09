package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.AridSkyLevel2ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.AridSkyLevel2ChestTileEntity;

public class AridSkyLevel2ChestTileRenderer extends GeoBlockRenderer<AridSkyLevel2ChestTileEntity> {
	public AridSkyLevel2ChestTileRenderer() {
		super(new AridSkyLevel2ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(AridSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
