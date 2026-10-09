package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.LavicSkyLvl1ChestDisplayItem;

public class LavicSkyLvl1ChestDisplayModel extends GeoModel<LavicSkyLvl1ChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(LavicSkyLvl1ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LavicSkyLvl1ChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LavicSkyLvl1ChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/lavic_lvl1_chest.png");
	}
}
