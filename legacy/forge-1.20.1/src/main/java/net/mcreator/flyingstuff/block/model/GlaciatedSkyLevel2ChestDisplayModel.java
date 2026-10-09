package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.GlaciatedSkyLevel2ChestDisplayItem;

public class GlaciatedSkyLevel2ChestDisplayModel extends GeoModel<GlaciatedSkyLevel2ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GlaciatedSkyLevel2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GlaciatedSkyLevel2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GlaciatedSkyLevel2ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/glaciated_chest.png");
	}
}
