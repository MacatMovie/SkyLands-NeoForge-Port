package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.GlaciatedRewardDispenserTileEntity;

public class GlaciatedRewardDispenserBlockModel extends GeoModel<GlaciatedRewardDispenserTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GlaciatedRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/gambling_machine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GlaciatedRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/gambling_machine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GlaciatedRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/gambling_machine_ice.png");
	}
}
