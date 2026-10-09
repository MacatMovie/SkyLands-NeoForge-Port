package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GoldenRewardDispencerDisplayModel;
import net.mcreator.flyingstuff.block.display.GoldenRewardDispencerDisplayItem;

public class GoldenRewardDispencerDisplayItemRenderer extends GeoItemRenderer<GoldenRewardDispencerDisplayItem> {
	public GoldenRewardDispencerDisplayItemRenderer() {
		super(new GoldenRewardDispencerDisplayModel());
	}

	@Override
	public RenderType getRenderType(GoldenRewardDispencerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
