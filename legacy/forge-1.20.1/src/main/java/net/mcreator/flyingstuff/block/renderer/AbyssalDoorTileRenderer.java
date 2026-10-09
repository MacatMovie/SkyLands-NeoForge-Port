package net.mcreator.flyingstuff.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.flyingstuff.block.model.AbyssalDoorBlockModel;
import net.mcreator.flyingstuff.block.entity.AbyssalDoorTileEntity;

public class AbyssalDoorTileRenderer extends GeoBlockRenderer<AbyssalDoorTileEntity> {
	public AbyssalDoorTileRenderer() {
		super(new AbyssalDoorBlockModel());
	}

	@Override
	public RenderType getRenderType(AbyssalDoorTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
