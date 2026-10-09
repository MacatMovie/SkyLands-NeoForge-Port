package net.mcreator.flyingstuff.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.entity.IgneoRoboFelineEntity;

public class IgneoRoboFelineModel extends GeoModel<IgneoRoboFelineEntity> {
	@Override
	public ResourceLocation getAnimationResource(IgneoRoboFelineEntity entity) {
		return new ResourceLocation("flying_stuff", "animations/robot_lion.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IgneoRoboFelineEntity entity) {
		return new ResourceLocation("flying_stuff", "geo/robot_lion.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IgneoRoboFelineEntity entity) {
		return new ResourceLocation("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(IgneoRoboFelineEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
