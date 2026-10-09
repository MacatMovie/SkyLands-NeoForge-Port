package net.mcreator.flyingstuff.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.entity.SkyAutomatonBruteEntity;

public class SkyAutomatonBruteModel extends GeoModel<SkyAutomatonBruteEntity> {
	@Override
	public ResourceLocation getAnimationResource(SkyAutomatonBruteEntity entity) {
		return new ResourceLocation("flying_stuff", "animations/automaton_brute.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SkyAutomatonBruteEntity entity) {
		return new ResourceLocation("flying_stuff", "geo/automaton_brute.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SkyAutomatonBruteEntity entity) {
		return new ResourceLocation("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(SkyAutomatonBruteEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
