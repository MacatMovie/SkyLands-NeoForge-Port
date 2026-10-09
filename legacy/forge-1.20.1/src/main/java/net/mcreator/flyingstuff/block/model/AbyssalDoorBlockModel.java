package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.AbyssalDoorTileEntity;

public class AbyssalDoorBlockModel extends GeoModel<AbyssalDoorTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AbyssalDoorTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/abyssal_door.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AbyssalDoorTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/abyssal_door.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AbyssalDoorTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/abyssal_door.png");
	}
}
