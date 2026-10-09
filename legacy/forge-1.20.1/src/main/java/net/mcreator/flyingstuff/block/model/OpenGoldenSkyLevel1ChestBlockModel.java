package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel1ChestTileEntity;

public class OpenGoldenSkyLevel1ChestBlockModel extends GeoModel<OpenGoldenSkyLevel1ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OpenGoldenSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenGoldenSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenGoldenSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/chest_active.png");
	}
}
