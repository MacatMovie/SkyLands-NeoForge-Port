package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.GoldenRewardDispencerTileEntity;

public class GoldenRewardDispencerBlockModel extends GeoModel<GoldenRewardDispencerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoldenRewardDispencerTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/gambling_machine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoldenRewardDispencerTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/gambling_machine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoldenRewardDispencerTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/gambling_machine.png");
	}
}
