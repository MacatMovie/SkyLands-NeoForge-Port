package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.OpenLavicSkyLvl1ChestTileEntity;

public class OpenLavicSkyLvl1ChestBlockModel extends GeoModel<OpenLavicSkyLvl1ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OpenLavicSkyLvl1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenLavicSkyLvl1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenLavicSkyLvl1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/lavic_lvl1_chest_open.png");
	}
}
