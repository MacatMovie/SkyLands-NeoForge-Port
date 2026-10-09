package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.WalkableAbyssalDoorTileEntity;

public class WalkableAbyssalDoorBlockModel extends GeoModel<WalkableAbyssalDoorTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(WalkableAbyssalDoorTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/abyssal_door.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WalkableAbyssalDoorTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/abyssal_door.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WalkableAbyssalDoorTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/abyssal_door.png");
	}
}
