package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.WalkableAbyssalDoorBlockModel;
import net.mcreator.flyingstuff.block.entity.WalkableAbyssalDoorTileEntity;

public class WalkableAbyssalDoorTileRenderer extends GeoBlockRenderer<WalkableAbyssalDoorTileEntity> {
	public WalkableAbyssalDoorTileRenderer() {
		super(new WalkableAbyssalDoorBlockModel());
	}

	@Override
	public RenderType getRenderType(WalkableAbyssalDoorTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
