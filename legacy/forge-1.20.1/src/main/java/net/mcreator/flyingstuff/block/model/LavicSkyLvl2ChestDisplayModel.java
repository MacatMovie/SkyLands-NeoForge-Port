package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.LavicSkyLvl2ChestDisplayItem;

public class LavicSkyLvl2ChestDisplayModel extends GeoModel<LavicSkyLvl2ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(LavicSkyLvl2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LavicSkyLvl2ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LavicSkyLvl2ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/lavic_lvl2_chest.png");
	}
}
