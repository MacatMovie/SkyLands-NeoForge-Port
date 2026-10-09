package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLevel1ChestDisplayItem;

public class OpenGlaciatedSkyLevel1ChestDisplayModel extends GeoModel<OpenGlaciatedSkyLevel1ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(OpenGlaciatedSkyLevel1ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OpenGlaciatedSkyLevel1ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpenGlaciatedSkyLevel1ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/glaciated_chest0_open.png");
	}
}
