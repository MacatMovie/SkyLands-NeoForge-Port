package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel1ChestTileEntity;

public class GlaciatedSkyLevel1ChestBlockModel extends GeoModel<GlaciatedSkyLevel1ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GlaciatedSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GlaciatedSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GlaciatedSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/glaciated_chest0.png");
	}
}
