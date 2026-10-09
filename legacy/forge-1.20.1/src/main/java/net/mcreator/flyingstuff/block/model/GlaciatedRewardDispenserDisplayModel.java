package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.GlaciatedRewardDispenserDisplayItem;

public class GlaciatedRewardDispenserDisplayModel extends GeoModel<GlaciatedRewardDispenserDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GlaciatedRewardDispenserDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/gambling_machine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GlaciatedRewardDispenserDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/gambling_machine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GlaciatedRewardDispenserDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/gambling_machine_ice.png");
	}
}
