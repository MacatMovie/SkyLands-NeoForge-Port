package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GlaciatedRewardDispenserBlockModel;
import net.mcreator.flyingstuff.block.entity.GlaciatedRewardDispenserTileEntity;

public class GlaciatedRewardDispenserTileRenderer extends GeoBlockRenderer<GlaciatedRewardDispenserTileEntity> {
	public GlaciatedRewardDispenserTileRenderer() {
		super(new GlaciatedRewardDispenserBlockModel());
	}

	@Override
	public RenderType getRenderType(GlaciatedRewardDispenserTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
