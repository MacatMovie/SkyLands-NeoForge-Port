package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel1ChestTileEntity;

public class GoldenSkyLevel1ChestBlockModel extends GeoModel<GoldenSkyLevel1ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoldenSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoldenSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoldenSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/chest.png");
	}
}
