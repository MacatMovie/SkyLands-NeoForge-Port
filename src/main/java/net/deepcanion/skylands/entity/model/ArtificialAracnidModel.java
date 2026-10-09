package net.deepcanion.skylands.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.deepcanion.skylands.entity.ArtificialAracnidEntity;

public class ArtificialAracnidModel extends GeoModel<ArtificialAracnidEntity> {
	@Override
	public ResourceLocation getAnimationResource(ArtificialAracnidEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/artificialaracnid.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArtificialAracnidEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/artificialaracnid.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArtificialAracnidEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ArtificialAracnidEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
