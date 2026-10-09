package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.AbyssalDoorDisplayModel;
import net.mcreator.flyingstuff.block.display.AbyssalDoorDisplayItem;

public class AbyssalDoorDisplayItemRenderer extends GeoItemRenderer<AbyssalDoorDisplayItem> {
	public AbyssalDoorDisplayItemRenderer() {
		super(new AbyssalDoorDisplayModel());
	}

	@Override
	public RenderType getRenderType(AbyssalDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
