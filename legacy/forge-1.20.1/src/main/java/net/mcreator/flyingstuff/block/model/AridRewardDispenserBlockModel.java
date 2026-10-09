package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.AridRewardDispenserTileEntity;

public class AridRewardDispenserBlockModel extends GeoModel<AridRewardDispenserTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AridRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/gambling_machine.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AridRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/gambling_machine.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AridRewardDispenserTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/gambling_machine_arid.png");
	}
}
