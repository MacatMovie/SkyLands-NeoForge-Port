package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.OpenGoldenSkyLevel1ChestDisplayItem;

public class OpenGoldenSkyLevel1ChestDisplayModel extends GeoModel<OpenGoldenSkyLevel1ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OpenGoldenSkyLevel1ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenGoldenSkyLevel1ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenGoldenSkyLevel1ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/chest_active.png");
	}
}
