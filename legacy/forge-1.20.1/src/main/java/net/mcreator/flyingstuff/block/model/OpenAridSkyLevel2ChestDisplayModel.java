package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.OpenAridSkyLevel2ChestDisplayItem;

public class OpenAridSkyLevel2ChestDisplayModel extends GeoModel<OpenAridSkyLevel2ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OpenAridSkyLevel2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenAridSkyLevel2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenAridSkyLevel2ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/arid_chest_1_open.png");
	}
}
