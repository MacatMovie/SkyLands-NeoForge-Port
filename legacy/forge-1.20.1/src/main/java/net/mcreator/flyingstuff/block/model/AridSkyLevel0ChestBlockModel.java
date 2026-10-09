package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.AridSkyLevel0ChestTileEntity;

public class AridSkyLevel0ChestBlockModel extends GeoModel<AridSkyLevel0ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AridSkyLevel0ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AridSkyLevel0ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AridSkyLevel0ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/arid_chest_0.png");
	}
}
