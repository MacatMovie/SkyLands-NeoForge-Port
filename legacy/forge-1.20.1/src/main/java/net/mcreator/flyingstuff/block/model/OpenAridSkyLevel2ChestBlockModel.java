package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel2ChestTileEntity;

public class OpenAridSkyLevel2ChestBlockModel extends GeoModel<OpenAridSkyLevel2ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OpenAridSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenAridSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenAridSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/arid_chest_1_open.png");
	}
}
