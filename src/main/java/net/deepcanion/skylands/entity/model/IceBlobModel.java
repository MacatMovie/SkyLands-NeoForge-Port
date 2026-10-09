package net.deepcanion.skylands.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.deepcanion.skylands.entity.IceBlobEntity;

public class IceBlobModel extends GeoModel<IceBlobEntity> {
	@Override
	public ResourceLocation getAnimationResource(IceBlobEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/blob.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IceBlobEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/blob.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IceBlobEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
	}

}
