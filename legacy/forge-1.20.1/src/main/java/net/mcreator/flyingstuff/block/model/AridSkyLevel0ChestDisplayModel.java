package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.AridSkyLevel0ChestDisplayItem;

public class AridSkyLevel0ChestDisplayModel extends GeoModel<AridSkyLevel0ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AridSkyLevel0ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AridSkyLevel0ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AridSkyLevel0ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/arid_chest_0.png");
	}
}
