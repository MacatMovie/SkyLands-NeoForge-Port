package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel2ChestTileEntity;

public class OpenGoldenSkyLevel2ChestBlockModel extends GeoModel<OpenGoldenSkyLevel2ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OpenGoldenSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenGoldenSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenGoldenSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/level2chest_open.png");
	}
}
