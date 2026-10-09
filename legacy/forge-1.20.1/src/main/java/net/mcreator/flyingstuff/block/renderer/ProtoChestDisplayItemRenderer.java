package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.ProtoChestDisplayModel;
import net.mcreator.flyingstuff.block.display.ProtoChestDisplayItem;

public class ProtoChestDisplayItemRenderer extends GeoItemRenderer<ProtoChestDisplayItem> {
	public ProtoChestDisplayItemRenderer() {
		super(new ProtoChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(ProtoChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
