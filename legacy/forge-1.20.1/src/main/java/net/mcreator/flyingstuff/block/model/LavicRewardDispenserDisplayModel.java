package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.LavicRewardDispenserDisplayItem;

public class LavicRewardDispenserDisplayModel extends GeoModel<LavicRewardDispenserDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(LavicRewardDispenserDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/gambling_machine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LavicRewardDispenserDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/gambling_machine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LavicRewardDispenserDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/gambling_machine_lavic.png");
	}
}
