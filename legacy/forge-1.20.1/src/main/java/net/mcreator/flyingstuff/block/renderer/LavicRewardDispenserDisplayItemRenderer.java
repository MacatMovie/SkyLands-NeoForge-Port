package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.LavicRewardDispenserDisplayModel;
import net.mcreator.flyingstuff.block.display.LavicRewardDispenserDisplayItem;

public class LavicRewardDispenserDisplayItemRenderer extends GeoItemRenderer<LavicRewardDispenserDisplayItem> {
	public LavicRewardDispenserDisplayItemRenderer() {
		super(new LavicRewardDispenserDisplayModel());
	}

	@Override
	public RenderType getRenderType(LavicRewardDispenserDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
