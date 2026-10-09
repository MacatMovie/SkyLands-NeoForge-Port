package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.WalkableAbyssalDoorDisplayModel;
import net.mcreator.flyingstuff.block.display.WalkableAbyssalDoorDisplayItem;

public class WalkableAbyssalDoorDisplayItemRenderer extends GeoItemRenderer<WalkableAbyssalDoorDisplayItem> {
	public WalkableAbyssalDoorDisplayItemRenderer() {
		super(new WalkableAbyssalDoorDisplayModel());
	}

	@Override
	public RenderType getRenderType(WalkableAbyssalDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
