package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.AridRewardDispenserBlockModel;
import net.mcreator.flyingstuff.block.entity.AridRewardDispenserTileEntity;

public class AridRewardDispenserTileRenderer extends GeoBlockRenderer<AridRewardDispenserTileEntity> {
	public AridRewardDispenserTileRenderer() {
		super(new AridRewardDispenserBlockModel());
	}

	@Override
	public RenderType getRenderType(AridRewardDispenserTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
