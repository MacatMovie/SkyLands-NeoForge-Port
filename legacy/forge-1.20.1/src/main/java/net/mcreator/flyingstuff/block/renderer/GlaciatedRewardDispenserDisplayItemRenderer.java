package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.GlaciatedRewardDispenserDisplayModel;
import net.mcreator.flyingstuff.block.display.GlaciatedRewardDispenserDisplayItem;

public class GlaciatedRewardDispenserDisplayItemRenderer extends GeoItemRenderer<GlaciatedRewardDispenserDisplayItem> {
	public GlaciatedRewardDispenserDisplayItemRenderer() {
		super(new GlaciatedRewardDispenserDisplayModel());
	}

	@Override
	public RenderType getRenderType(GlaciatedRewardDispenserDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
