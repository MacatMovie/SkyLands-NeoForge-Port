package net.mcreator.flyingstuff.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.entity.GlaciatedDragonEntity;

public class GlaciatedDragonModel extends GeoModel<GlaciatedDragonEntity> {
	@Override
	public ResourceLocation getAnimationResource(GlaciatedDragonEntity entity) {
		return new ResourceLocation("flying_stuff", "animations/icedragon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GlaciatedDragonEntity entity) {
		return new ResourceLocation("flying_stuff", "geo/icedragon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GlaciatedDragonEntity entity) {
		return new ResourceLocation("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(GlaciatedDragonEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
