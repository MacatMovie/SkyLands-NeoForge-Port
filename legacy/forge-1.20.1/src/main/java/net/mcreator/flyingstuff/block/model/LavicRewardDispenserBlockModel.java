package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.LavicRewardDispenserTileEntity;

public class LavicRewardDispenserBlockModel extends GeoModel<LavicRewardDispenserTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(LavicRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/gambling_machine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LavicRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/gambling_machine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LavicRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/gambling_machine_lavic.png");
	}
}
