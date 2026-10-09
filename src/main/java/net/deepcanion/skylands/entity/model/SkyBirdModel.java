package net.deepcanion.skylands.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.deepcanion.skylands.entity.SkyBirdEntity;

public class SkyBirdModel extends GeoModel<SkyBirdEntity> {
	@Override
	public ResourceLocation getAnimationResource(SkyBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/sky_bird.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SkyBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/sky_bird.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SkyBirdEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(SkyBirdEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
