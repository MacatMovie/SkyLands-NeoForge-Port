package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.AridRewardDispenserDisplayItem;

public class AridRewardDispenserDisplayModel extends GeoModel<AridRewardDispenserDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AridRewardDispenserDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/gambling_machine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AridRewardDispenserDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/gambling_machine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AridRewardDispenserDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/gambling_machine_arid.png");
	}
}
