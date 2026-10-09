package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.GoldenSkyLevel1ChestDisplayItem;

public class GoldenSkyLevel1ChestDisplayModel extends GeoModel<GoldenSkyLevel1ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GoldenSkyLevel1ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoldenSkyLevel1ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoldenSkyLevel1ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/chest.png");
	}
}
