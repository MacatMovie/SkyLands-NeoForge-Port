package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel2ChestTileEntity;

public class GoldenSkyLevel2ChestBlockModel extends GeoModel<GoldenSkyLevel2ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoldenSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoldenSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoldenSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/level2chest.png");
	}
}
