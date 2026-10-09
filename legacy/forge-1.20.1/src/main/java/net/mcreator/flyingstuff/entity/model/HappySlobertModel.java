package net.mcreator.flyingstuff.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.entity.HappySlobertEntity;

public class HappySlobertModel extends GeoModel<HappySlobertEntity> {
	@Override
	public ResourceLocation getAnimationResource(HappySlobertEntity entity) {
		return new ResourceLocation("flying_stuff", "animations/blob.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HappySlobertEntity entity) {
		return new ResourceLocation("flying_stuff", "geo/blob.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HappySlobertEntity entity) {
		return new ResourceLocation("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
	}

}
