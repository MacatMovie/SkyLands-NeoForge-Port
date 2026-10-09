package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.OpenGoldenSkyLevel2ChestDisplayItem;

public class OpenGoldenSkyLevel2ChestDisplayModel extends GeoModel<OpenGoldenSkyLevel2ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OpenGoldenSkyLevel2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenGoldenSkyLevel2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenGoldenSkyLevel2ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/level2chest_open.png");
	}
}
