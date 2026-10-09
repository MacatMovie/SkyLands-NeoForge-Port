package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.WalkableAbyssalDoorDisplayItem;

public class WalkableAbyssalDoorDisplayModel extends GeoModel<WalkableAbyssalDoorDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(WalkableAbyssalDoorDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/abyssal_door.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WalkableAbyssalDoorDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/abyssal_door.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WalkableAbyssalDoorDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/abyssal_door.png");
	}
}
