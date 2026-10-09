package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.AridSkyLevel2ChestDisplayItem;

public class AridSkyLevel2ChestDisplayModel extends GeoModel<AridSkyLevel2ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AridSkyLevel2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AridSkyLevel2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AridSkyLevel2ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/arid_chest_1.png");
	}
}
