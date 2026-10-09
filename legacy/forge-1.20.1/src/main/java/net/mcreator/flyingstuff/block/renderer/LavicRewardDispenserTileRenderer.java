package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.LavicRewardDispenserBlockModel;
import net.mcreator.flyingstuff.block.entity.LavicRewardDispenserTileEntity;

public class LavicRewardDispenserTileRenderer extends GeoBlockRenderer<LavicRewardDispenserTileEntity> {
	public LavicRewardDispenserTileRenderer() {
		super(new LavicRewardDispenserBlockModel());
	}

	@Override
	public RenderType getRenderType(LavicRewardDispenserTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
