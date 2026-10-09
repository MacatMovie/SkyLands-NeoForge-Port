package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.ProtoChestBlockModel;
import net.mcreator.flyingstuff.block.entity.ProtoChestTileEntity;

public class ProtoChestTileRenderer extends GeoBlockRenderer<ProtoChestTileEntity> {
	public ProtoChestTileRenderer() {
		super(new ProtoChestBlockModel());
	}

	@Override
	public RenderType getRenderType(ProtoChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
