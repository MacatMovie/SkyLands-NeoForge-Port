package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel2ChestTileEntity;

public class OpenGlaciatedSkyLevel2ChestBlockModel extends GeoModel<OpenGlaciatedSkyLevel2ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OpenGlaciatedSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenGlaciatedSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenGlaciatedSkyLevel2ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/glaciated_chest_open.png");
	}
}
