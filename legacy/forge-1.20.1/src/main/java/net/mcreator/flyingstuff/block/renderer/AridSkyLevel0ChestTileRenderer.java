package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.AridSkyLevel0ChestBlockModel;
import net.mcreator.flyingstuff.block.entity.AridSkyLevel0ChestTileEntity;

public class AridSkyLevel0ChestTileRenderer extends GeoBlockRenderer<AridSkyLevel0ChestTileEntity> {
	public AridSkyLevel0ChestTileRenderer() {
		super(new AridSkyLevel0ChestBlockModel());
	}

	@Override
	public RenderType getRenderType(AridSkyLevel0ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
