package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.OpenAridSkyLevel0ChestDisplayItem;

public class OpenAridSkyLevel0ChestDisplayModel extends GeoModel<OpenAridSkyLevel0ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OpenAridSkyLevel0ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenAridSkyLevel0ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenAridSkyLevel0ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/arid_chest_0_open.png");
	}
}
