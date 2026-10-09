package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GoldenRewardDispencerBlockModel;
import net.mcreator.flyingstuff.block.entity.GoldenRewardDispencerTileEntity;

public class GoldenRewardDispencerTileRenderer extends GeoBlockRenderer<GoldenRewardDispencerTileEntity> {
	public GoldenRewardDispencerTileRenderer() {
		super(new GoldenRewardDispencerBlockModel());
	}

	@Override
	public RenderType getRenderType(GoldenRewardDispencerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
