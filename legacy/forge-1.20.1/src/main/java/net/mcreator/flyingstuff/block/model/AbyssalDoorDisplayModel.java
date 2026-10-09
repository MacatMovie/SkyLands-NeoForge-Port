package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.AbyssalDoorDisplayItem;

public class AbyssalDoorDisplayModel extends GeoModel<AbyssalDoorDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AbyssalDoorDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/abyssal_door.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AbyssalDoorDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/abyssal_door.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AbyssalDoorDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/abyssal_door.png");
	}
}
