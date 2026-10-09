package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.AridRewardDispenserDisplayModel;
import net.mcreator.flyingstuff.block.display.AridRewardDispenserDisplayItem;

public class AridRewardDispenserDisplayItemRenderer extends GeoItemRenderer<AridRewardDispenserDisplayItem> {
	public AridRewardDispenserDisplayItemRenderer() {
		super(new AridRewardDispenserDisplayModel());
	}

	@Override
	public RenderType getRenderType(AridRewardDispenserDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
