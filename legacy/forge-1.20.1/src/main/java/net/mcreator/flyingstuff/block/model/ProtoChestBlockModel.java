package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.ProtoChestTileEntity;

public class ProtoChestBlockModel extends GeoModel<ProtoChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(ProtoChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/proto_chest.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ProtoChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/proto_chest.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ProtoChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/protochest.png");
	}
}
