package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel1ChestTileEntity;

public class OpenGlaciatedSkyLevel1ChestBlockModel extends GeoModel<OpenGlaciatedSkyLevel1ChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(OpenGlaciatedSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenGlaciatedSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenGlaciatedSkyLevel1ChestTileEntity animatable) {
		return new ResourceLocation("flying_stuff", "textures/block/glaciated_chest0_open.png");
	}
}
