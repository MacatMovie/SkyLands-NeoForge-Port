package net.deepcanion.skylands.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.deepcanion.skylands.entity.HappySlobertEntity;

public class HappySlobertModel extends GeoModel<HappySlobertEntity> {
	@Override
	public ResourceLocation getAnimationResource(HappySlobertEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/blob.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HappySlobertEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/blob.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HappySlobertEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
	}

}
