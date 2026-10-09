package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.flyingstuff.init.FlyingStuffModMobEffects;

public class WarmthPotionPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(FlyingStuffModMobEffects.WARMTH.get(), 1000, 1));
	}
}
