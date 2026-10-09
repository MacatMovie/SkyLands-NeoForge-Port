package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.GoldenRewardDispencerDisplayItem;

public class GoldenRewardDispencerDisplayModel extends GeoModel<GoldenRewardDispencerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GoldenRewardDispencerDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/gambling_machine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoldenRewardDispencerDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/gambling_machine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoldenRewardDispencerDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/gambling_machine.png");
	}
}
